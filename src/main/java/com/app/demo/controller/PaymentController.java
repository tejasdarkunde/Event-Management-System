package com.app.demo.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private JavaMailSender mailSender; // Inject JavaMailSender

    private int booking_id;
    private int u_id;
    
    @RequestMapping(value="/paytmuser")
    public String paytm(@RequestParam(name="booking_id") int bookingId, 
                        @RequestParam(name="booking_userid") int u_id, 
                        @RequestParam(name="total_amt") long amt, 
                        ModelMap model, 
                        HttpSession session) {
        this.booking_id = bookingId;
        this.u_id = u_id;
        model.addAttribute("order_id", bookingId);
        model.addAttribute("user_id", u_id);
        model.addAttribute("amt", amt);
        return "paytmuser";
    }
    
    @PostMapping(value = "/pgredirect")
    public String processPayment(HttpSession session) {
        try {
            User userDetail = userservice.findById(u_id);
            
            session.setAttribute("User_firstname", userDetail.getFirstName());
            session.setAttribute("User_lastname", userDetail.getLastName());
            session.setAttribute("User_email", userDetail.getEmail());
            session.setAttribute("User_phone", userDetail.getContactno());
            session.setAttribute("User_address", userDetail.getAddress());
            session.setAttribute("User_gender", userDetail.getGender());
            session.setAttribute("User_id", userDetail.getId());
            session.setAttribute("User_cpassword", userDetail.getConfirmPassword());
            session.setAttribute("User_password", userDetail.getPassword());
            session.setAttribute("User_role", userDetail.getRole());
            
            bookingservice.bookingPayment(booking_id);
            
            sendPaymentConfirmationEmail(userDetail.getEmail(), userDetail.getFirstName(), booking_id);

            return "Paymentsuccess";
        } catch (Exception e) {
            return "Paymentfail";
        }
    }

    private void sendPaymentConfirmationEmail(String toEmail, String userName, int bookingId) {
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