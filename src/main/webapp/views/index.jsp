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
</style>

<!-- <section id="Carousel-Section " style="margin-top: -40px;">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="../assets/images/hotels/1.jpeg"  alt="First slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"  src="../assets/images/hotels/2.jpeg"  alt="Second slide">
	   	 <div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"src="../assets/images/hotels/3.jpeg" alt="Third slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../assets/images/catering/1.jpeg" alt="Third slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
	  	</div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="../assets/images/catering/2.jpeg" alt="Third slide">
    	<div class="carousel-caption d-none d-md-block">
		    <h5>...</h5>
		    <p>...</p>
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
	
</section> -->


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
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('../assets/images/hotels/1.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Celebrato</h3>
          <p class="text-white">The Perfect Planner</p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/2.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Main Hall</h3>
          <p class="text-white">Comfortable halls with all facility</p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('../assets/images/hotels/3.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Reception</h3>
          <p class="text-white">A warm welcome with seamless service.</p>
        </div>
      </div>
       <!-- Slide four - Set the background image for this slide in the line below -->
       <div class="carousel-item" style="background-image: url('../assets/images/catering/1.jpeg')">
        <div class="carousel-caption d-none d-md-block">
          <h3>Catering Bufe</h3>
          <p class="text-white" >Delicious spreads for every occasion.</p>
        </div>
      </div>
       <!-- Slide five - Set the background image for this slide in the line below -->
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
            <!-- <p><a class="btn btn-warning" href="#" role="button">View details &raquo;</a></p> -->
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src='../assets/images/Catering.jpg' alt="Generic placeholder image" width="200" height="200">
            <h2>CATERING</h2>
            <p>We offer a wide range of catering services with delicious multi-cuisine menus, buffet setups, and personalized meal options. From traditional feasts to gourmet dishes, we cater to all tastes and preferences.</p>
            <!-- <p><a class="btn btn-warning" href="#" role="button">View details &raquo;</a></p> -->
          </div>
          <div class="col-lg-4">
            <img class="rounded-circle" src='../assets/images/Vendor.png' alt="Generic placeholder image" width="200" height="200">
            <h2>VENDORS</h2>
            <p>Our vendor network provides high-quality decorations, lighting, sound systems, and event essentials. Whether it’s floral arrangements, stage setups, or entertainment, we ensure everything is handled professionally.</p>
            <!-- <p><a class="btn btn-warning" href="#" role="button">View details &raquo;</a></p> -->
          </div>
         </div>
</section>


<!--
<hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">HALLS<p class="text-muted mt-2">It'll blow your mind.</p></h2>
            </div>
            <div class="mt-3">
              <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            </div>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto"  src="https://i.pinimg.com/originals/32/17/96/321796c217c3fa93013944de4772e7f8.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7 order-md-2">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">CATERING <p class="text-muted mt-2">The best memories are made around the dinner table</p></h2>
            </div>
              <div class="mt-3">
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
              </div>
           </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="https://arzfinefoods.com/wp-content/uploads/2018/11/Catering_Promo.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <div class="mt-1 text-center">
              <h2 class="featurette-heading mt-2">VENDORS <p class="text-muted mt-2">An artist is not paid for his Labor but for his vision.</p></h2>
            </div>
            <div class="mt-3">
              <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            </div>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="https://image.freepik.com/free-vector/various-street-food-vendor-flat-illustration_2482-381.jpg" alt="Generic placeholder image">
          </div>
        </div>

-->

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