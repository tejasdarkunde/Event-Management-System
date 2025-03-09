<%@ page import="java.util.UUID" %>
<%
    if (session.getAttribute("User_email") == null) {
        response.sendRedirect("/signin");
    } else {
%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="includes/header.jsp" />

    <script src="https://checkout.razorpay.com/v1/checkout.js"></script>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/userbookingdetails">
                <i class="fas fa-backward"></i> Back
            </a>
        </div>
    </nav>

    <section class="container">
        <div class="row align-items-center my-5">
            <div class="col-md-6">
                <h1>Welcome to Razorpay Payment</h1>
                <p class="font-italic text-muted mb-0">Complete your payment securely.</p>
            </div>

            <div class="col-md-6">
                <input type="hidden" id="order_id" value="${order_id}" />
                <input type="hidden" id="user_id" value="${user_id}" />
                <input type="hidden" id="amount" value="${amt}" />

                <button id="pay-button" class="btn btn-primary btn-lg">Pay with Razorpay</button>
            </div>
        </div>
    </section>

    <script>
        document.getElementById("pay-button").onclick = function () {
            var orderId = document.getElementById("order_id").value;
            var userId = document.getElementById("user_id").value;
            var amount = document.getElementById("amount").value * 100; // Convert to paisa

            var options = {
                "key": "rzp_test_n2jiWxEJXMEapY", 
                "amount": amount,
                "currency": "INR",
                "name": "Celebrato",
                "description": "Booking Payment",
                "order_id": "${razorpay_order}",
                "handler": function (response) {
                   console.log("Payment Successful: ", response);
                alert("Payment Successful! Redirecting...");
                
                setTimeout(function () {
                  window.location.href = "/pgredirect?" + 
    "razorpay_payment_id=" + encodeURIComponent(response.razorpay_payment_id) + 
    "&razorpay_order_id=" + encodeURIComponent(response.razorpay_order_id) + 
    "&razorpay_signature=" + encodeURIComponent(response.razorpay_signature);
  }, 2000); 
            },
                "theme": { "color": "#3399cc" }
            };

            var rzp1 = new Razorpay(options);
            rzp1.open();
        };
    </script>

    <jsp:include page="includes/footer.jsp" />
<% } %>
