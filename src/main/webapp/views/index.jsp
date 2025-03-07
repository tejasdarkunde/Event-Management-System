<jsp:include page="includes/header.jsp" />  

<jsp:include page="includes/homeNav.jsp"/>
<style>
  .carousel-item {
  height: 90vh;
  min-height: 250px;
  background: no-repeat center center scroll;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</style>

<header style="margin-top: -40px;">
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <div class="carousel-item active" style="background-image: url('../assets/images/hotels/1.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Celebrato</h3>
          <p class="text-white">The Perfect Planner</p>
        </div>
      </div>
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/2.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Main Hall</h3>
          <p class="text-white">Comfortable halls with all facility</p>
        </div>
      </div>
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/3.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Reception</h3>
          <p class="text-white">A warm welcome with seamless service.</p>
        </div>
      </div>
       <div class="carousel-item" style="background-image: url('../assets/images/catering/1.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Catering Bufe</h3>
          <p class="text-white" >Delicious spreads for every occasion.</p>
        </div>
      </div>
       <div class="carousel-item" style="background-image: url('../assets/images/catering/2.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Dulex And SuperDulex</h3>
          <p class="text-white">Elegance and comfort in every detail. | Luxury redefined for the perfect experience.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</header>

<section id="service-section" class="mt-5 mb-5 pr-3">
		 <div class="container marketing text-center">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4 ">
            <img class="rounded-circle" src='../assets/images/Hall.jpg' alt="Generic placeholder image" width="200" height="200">
            <h2>HALLS</h2>
            <p>Our spacious and well-equipped halls provide a comfortable setting for weddings, meetings, and celebrations. With modern amenities, elegant décor, and customizable seating arrangements, we ensure a seamless event experience.</p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src='../assets/images/Catering.jpg' alt="Generic placeholder image" width="200" height="200">
            <h2>CATERING</h2>
            <p>We offer a wide range of catering services with delicious multi-cuisine menus, buffet setups, and personalized meal options. From traditional feasts to gourmet dishes, we cater to all tastes and preferences.</p>
          </div>
          <div class="col-lg-4">
            <img class="rounded-circle" src='../assets/images/Vendor.png' alt="Generic placeholder image" width="200" height="200">
            <h2>Hotel</h2>
            <p>Our hotel network provides high-quality accommodations, catering, banquet halls, and hospitality services. Whether it’s luxury suites, event spaces, or customized dining experiences, we ensure everything is handled professionally.</p>
          </div>
         </div>
</section>

<!-- footer-section -->
  <section class="footer-section">
    <footer class="footer">
        <p class="footer_title">Contact us</p>
            <div class="footer_social">
                <a href="https://www.facebook.com/share/18PsGEJazo/" class="footer_icon"><i class="fab fa-facebook-f"></i></a>
                <a href="https://www.instagram.com/tejas.darkunde?igsh=MW9jbWdvcjNkYnM3Mg==" class="footer_icon"><i class="fab fa-instagram"></i></a>
                <a href="https://youtube.com/@tejasdarkunde?si=GnKa1v6PM7yGjKgw" class="footer_icon"><i class="fab fa-youtube"></i></a>
                <a href="https://www.linkedin.com/in/tejasdarkunde?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app" class="footer_icon"><i class="fab fa-linkedin"></i></a>
            </div>
        <p>&#169; 2025 copyright all right reserved By Tejas Darkunde</p>
    </footer>
</section>
<jsp:include page="includes/footer.jsp" />  