package com.app.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.demo.model.User;
import com.app.demo.services.BookingServices;
import com.app.demo.services.UserServices;

@Controller
public class PaymentController {

    @Autowired
    private BookingServices bookingservice;

    @Autowired
    private UserServices userservice;

    @Autowired
    private JavaMailSender mailSender;

    private int booking_id;
    private int u_id;

    @RequestMapping(value = "/paytmuser")
    public String paytm(@RequestParam(name = "booking_id") int bookingId,
                        @RequestParam(name = "booking_userid") int u_id,
                        @RequestParam(name = "total_amt") long amt,
                        ModelMap model,
                        HttpSession session) {
        this.booking_id = bookingId;
        this.u_id = u_id;

        // Create Razorpay order and get the order ID
        String orderDetails = bookingservice.createPaymentOrder(bookingId, amt);
        if (orderDetails == null) {
            model.addAttribute("error", "Payment gateway error. Please try again.");
            return "Paymentfail";
        }

        model.addAttribute("order_id", bookingId);
        model.addAttribute("user_id", u_id);
        model.addAttribute("amt", amt);
        model.addAttribute("razorpay_order", orderDetails);

        return "paytmuser";  // This should match your frontend page for Razorpay payments
    }

    @RequestMapping(value = "/pgredirect", method = {RequestMethod.GET, RequestMethod.POST})

    public String processPayment(@RequestParam String razorpay_payment_id,
                                 @RequestParam String razorpay_order_id,
                                 @RequestParam String razorpay_signature,
                                 HttpSession session) {
        System.out.println("Received Payment ID: " + razorpay_payment_id);
        System.out.println("Received Order ID: " + razorpay_order_id);
        System.out.println("Received Signature: " + razorpay_signature);
        
        try {
            boolean isValid = bookingservice.verifyPayment(razorpay_payment_id, razorpay_order_id, razorpay_signature);
            if (!isValid) {
                return "Paymentfail";
            }

            // Payment successful, update booking status
            bookingservice.bookingPayment(booking_id);

            Object userIdObj = session.getAttribute("User_id");
            if (userIdObj == null) {
                System.out.println("Session attribute 'User_id' is missing!");
                return "Paymentfail";
            }

            int userId = Integer.parseInt(userIdObj.toString());
            User userDetail = userservice.findById(userId);

            sendPaymentConfirmationEmail(userDetail.getEmail(), userDetail.getFirstName(), razorpay_order_id); 

            return "redirect:/Paymentsuccess";
        } catch (Exception e) {
            System.out.println("Payment processing error: " + e.getMessage());
            return "Paymentfail";
        }

    }
    @RequestMapping("/Paymentsuccess")
    public String showPaymentSuccessPage() {
        return "Paymentsuccess";  // This should match the success page name
    }


    private void sendPaymentConfirmationEmail(String toEmail, String userName, String bookingId) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Payment Confirmation");
            message.setText("Dear " + userName + ",\n\nYour payment for booking ID " + bookingId + " has been successfully processed.\n\nThank you for your booking!\n\nBest Regards,\nYour Company Name\nCelebrato");

            mailSender.send(message);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
