package com.app.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.demo.model.Booking;
import com.app.demo.model.Catering;
import com.app.demo.model.Event;
import com.app.demo.model.Hotel;
import com.app.demo.model.User;
import com.app.demo.repository.CateringRepo;
import com.app.demo.repository.HotelRepo;
import com.app.demo.services.BookingServices;
import com.app.demo.services.CateringServices;
import com.app.demo.services.EventServices;
import com.app.demo.services.HotelServices;
import com.app.demo.services.UserServices;

@Controller
public class AdminController {
		
	@Autowired
	private HotelServices hotelservice;
	
	@Autowired
	private  UserServices userservice;

	@Autowired
	private CateringServices caterservice;
	
	@Autowired
	private EventServices eventservice;
	
	@Autowired
	private BookingServices bookingservice;
	

	//User Registration
	@RequestMapping(value="/adduserForm",method= RequestMethod.POST)
	public String UserRegister(@ModelAttribute("registerForm") User user,Model model)
	{
			model.addAttribute("user",user);
		
			userservice.save(user);
			
			return "redirect:/adminuserdetails";
		
	}
	
	//User Table
	@RequestMapping(value="/adminuserdetails",method=RequestMethod.GET)
	public String adminUserDetails(ModelMap model) {
		List<User> user=userservice.findAll();
		model.addAttribute("Userlist",user);
	    return "AdminUserDetails";  
	}
	
	@RequestMapping(value="/adminuserSearch",method=RequestMethod.POST)
	public String adminUserSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		
		if(searchkey.equals("")) {
			List<User> listuser=userservice.findAll();
			model.addAttribute("Userlist",listuser);
			return "AdminUserDetails"; 
			
		}
		else {
			model.addAttribute("user_keyword",searchkey);
			List<User> listuser=userservice.findBykey(searchkey);
			model.addAttribute("Userlist",listuser);
			return "AdminUserDetails";
		}
	}
	
	//User Table Delete
	@RequestMapping(value="/admindeleteuser/{email}",method=RequestMethod.GET)
	public String admindeleteUser(@PathVariable String email) {
		User user=userservice.findByEmail(email);
		if(user.getEmail()!=null) {
			userservice.deleteUser(user.getId());
			 return "redirect:/adminuserdetails";
		}
		
	    return "redirect:/adminuserdetails";  
	}
	
	//Model find and fill for User
		@RequestMapping(value="userfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> adminEditDetails(@PathVariable("id") int id) {
			try {
				return new ResponseEntity<User>(userservice.findById(id),HttpStatus.OK);
			}
		    catch(Exception e) {
		    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		    }
			
		}
	
		
		//Edit the user
		@RequestMapping(value="/EdituserForm",method=RequestMethod.POST)
		public String updateUser(@ModelAttribute("userEditForm") User user) {
			userservice.updateUserDetails(user.getEmail(),user.getFirstName(),user.getLastName(),user.getGender(),user.getContactno(),user.getAddress(),user.getRole(),user.getId());
			return "redirect:/adminuserdetails";
			
		}
		
	
	//Hotel Table
	@RequestMapping(value="/adminhoteldetails",method=RequestMethod.GET)
	public String adminHotelDetails(ModelMap model) {
		List<Hotel> hotel=hotelservice.findAll();
		model.addAttribute("Hotellist",hotel);
	    return "AdminHotelDetails"; 
		
	}
	
	@RequestMapping(value="/adminhotelSearch",method=RequestMethod.POST)
	public String adminHotelSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
		if(searchkey.equals("")) {
			List<Hotel> hotel=hotelservice.findAll();
			model.addAttribute("Hotellist",hotel);
				return "AdminHotelDetails"; 
		}
		else {
			model.addAttribute("hotel_keyword",searchkey);
			List<Hotel> hotel=hotelservice.findBykey(searchkey);
			model.addAttribute("Hotellist",hotel);
			return "AdminHotelDetails"; 
			
		}
	}
	//Hotel Table Delete
	@RequestMapping(value="/admindeletehotel/{id}")
	public String admindeleteHotel(@PathVariable int id)
	{
		Hotel hotel=hotelservice.findById(id);
		if(hotel.getHotelName()!=null) {
			hotelservice.deleteHotel(id);
			return "redirect:/adminhoteldetails";
		}
		return "redirect:/adminhoteldetails";
	}
	
	//Add Hotel 
	@RequestMapping(value="/addhotelForm")
	public String savehotel(@RequestParam("hotelName") String hotelname,@RequestParam("hotelDesc") String hotelDesc,@RequestParam("location") String hotelLoc,@RequestParam("price") int hotelPrice,@RequestParam("hotelImg1") MultipartFile file) {
		hotelservice.savehoteltoDB(file, hotelname, hotelDesc, hotelLoc, hotelPrice);
		return "redirect:/adminhoteldetails";
	}
	
	//Hotel find
	@RequestMapping(value="hotelfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> adminhoteEditDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Hotel>(hotelservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Hotel>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	//Edit hotel
	@RequestMapping(value="/EdithotelForm",method=RequestMethod.POST)
	public String updateHotel(@RequestParam("hotelName") String hotelname,@RequestParam("hotelDesc") String hotelDesc,@RequestParam("location") String hotelLoc,@RequestParam("price") int hotelPrice,@RequestParam("hotelImg1") MultipartFile file ,@RequestParam("id") int id)  {
		
		if(file.isEmpty())
		{
			hotelservice.updateHotelDetails(hotelname,hotelDesc,hotelLoc,hotelPrice,id);
		}
		else 
		{
			hotelservice.updateHotelDetailswithImage(hotelname,hotelDesc,hotelLoc,hotelPrice,file,id);
		}
		return "redirect:/adminhoteldetails";
	}
	
	
	
	//Catering Table
	@RequestMapping(value="/admincateringdetails",method=RequestMethod.GET)
	public String adminCateringDetails(Model model) {
		List<Catering> cater= caterservice.findAll();
		model.addAttribute("caterlist", cater);
	    return "AdminCateringDetails"; 
	}
	
	@RequestMapping(value="/admincateringSearch",method=RequestMethod.POST)
	public String admincaterSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {

		if(searchkey.equals("")) {
			List<Catering> cater= caterservice.findAll();
			model.addAttribute("caterlist", cater); 
		    
				return "AdminCateringDetails"; 
			
		}
		else {
			model.addAttribute("catering_keyword",searchkey);
			List<Catering> cater= caterservice.findBykey(searchkey);
			model.addAttribute("caterlist", cater);
			
				return "AdminCateringDetails"; 	
		}
	}
	
	//Delete Catering
	@RequestMapping(value="/admindeletecater/{id}")
	public String admindeleteCater(@PathVariable int id)
	{
		Catering c=caterservice.findById(id);
		if(c.getCatername()!=null) {
			caterservice.deletecater(id);
			return "redirect:/admincateringdetails";
		}
		return "redirect:/admincateringdetails";
	}
	
	//Add Catering
	@RequestMapping(value="/addcaterForm")
	public String saveCater(@RequestParam("catername") String catername,@RequestParam("cater_desc") String caterDesc,@RequestParam("cater_location") String caterLoc,@RequestParam("cater_price") int caterprice,@RequestParam("cater_img") MultipartFile file) {
		caterservice.savecatertoDB(file, catername, caterDesc, caterLoc, caterprice);
		return "redirect:/admincateringdetails";
	}
	
	@RequestMapping(value="caterfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Catering> admincaterEditDetails(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Catering>(caterservice.findById(id),HttpStatus.OK);
		}
	    catch(Exception e) {
	    	return new ResponseEntity<Catering>(HttpStatus.BAD_REQUEST);
	    }
		
	}
	
	@RequestMapping(value="/EditcaterForm",method=RequestMethod.POST)
	public String updateCater(@RequestParam("catername") String catername,@RequestParam("cater_desc") String caterdesc,@RequestParam("cater_location") String caterloc,@RequestParam("cater_price") int caterprice,@RequestParam("cater_img") MultipartFile file ,@RequestParam("id") int id)  {
		
		if(file.isEmpty())
		{
			caterservice.updateCaterDetails(catername,caterdesc,caterloc,caterprice,id);
		}
		else {
			caterservice.updateCaterDetailswithImage(catername,caterdesc,caterloc,caterprice,file,id);
		}
		return "redirect:/admincateringdetails";
	}
	
	//Booking details
	@RequestMapping(value="/adminbookingdetails",method=RequestMethod.GET)
	public String adminBookingDetails(ModelMap model) {
		List<Booking> booking=bookingservice.findAll();
		model.addAttribute("admin_booking",booking);
	    return "AdminBookingDetails";  
	}

	//Admin Account
	@RequestMapping(value="/adminaccount",method=RequestMethod.GET)
	public String adminAccount(HttpSession session) {
		System.out.println(session.getAttribute("Admin_email"));
	    return "AdminAccount";  
	}
	
	@RequestMapping(value="/editadminprofile",method=RequestMethod.POST)
	public String updateAdminProfile(@ModelAttribute("adminEditProfile") User admin ,HttpSession session) {
		
		userservice.updateUserProfile(admin.getEmail(),admin.getFirstName(),admin.getLastName(),admin.getGender(),admin.getContactno(),admin.getAddress(),admin.getRole(),admin.getPassword(),admin.getConfirmPassword(),admin.getId());
		session.setAttribute("Admin_firstname",admin.getFirstName());
		session.setAttribute("Admin_lastname", admin.getLastName());
		session.setAttribute("Admin_email", admin.getEmail());
		session.setAttribute("Admin_phone", admin.getContactno());
		session.setAttribute("Admin_address", admin.getAddress());
		session.setAttribute("Admin_gender", admin.getGender());
		session.setAttribute("Admin_id", admin.getId());
		session.setAttribute("Admin_role", admin.getRole());
		session.setAttribute("Admin_cpassword", admin.getConfirmPassword());
		session.setAttribute("Admin_password", admin.getPassword());
		return "redirect:/adminaccount";
		
	}
	
	
	//Event Table
		@RequestMapping(value="/admineventdetails",method=RequestMethod.GET)
		public String adminEventDetails(ModelMap model) {
			List<Event> event=eventservice.findAll();
			model.addAttribute("eventlist",event);
		    return "AdminEventDetails"; 
			
		}
		
		@RequestMapping(value="/admineventSearch",method=RequestMethod.POST)
		public String adminEventSearch(@RequestParam("valueToSearch") String searchkey,ModelMap model) {
			if(searchkey.equals("")) {
				List<Event> event=eventservice.findAll();
				model.addAttribute("eventlist",event);
				
					return "AdminEventDetails";      
			}
			else {
				model.addAttribute("event_keyword",searchkey);
				List<Event> event=eventservice.findBykey(searchkey);
				model.addAttribute("eventlist",event);
				
					return "AdminEventDetails";    
			}
		}
		
		@RequestMapping(value="/admindeleteevent/{id}")
		public String admindeleteEvent(@PathVariable int id ) {
			Event v =eventservice.findById(id);
			eventservice.deleteevent(id);
			return "redirect:/admineventdetails";
		}
		
		
	//Add event
	@RequestMapping(value="/addeventForm")
	public String saveevent(@RequestParam("eventname") String eventname,@RequestParam("event_desc") String eventDesc,@RequestParam("event_img") MultipartFile file) {
		eventservice.saveeventtoDB(file, eventname,eventDesc);
				return "redirect:/admineventdetails";
	}
		
	@RequestMapping(value="eventfind/{id}",method=RequestMethod.GET,produces =MimeTypeUtils.APPLICATION_JSON_VALUE)
		public ResponseEntity<Event> admineventEditDetails(@PathVariable("id") int id) {
			try {
				return new ResponseEntity<Event>(eventservice.findById(id),HttpStatus.OK);
			}
		    catch(Exception e) {
		    	return new ResponseEntity<Event>(HttpStatus.BAD_REQUEST);
		    }
			
		}
		
		@RequestMapping(value="/EditeventForm",method=RequestMethod.POST)
		public String updateevent(@RequestParam("eventname") String eventname,@RequestParam("event_desc") String eventdesc,@RequestParam("event_img") MultipartFile file ,@RequestParam("id") int id)  {
			
			if(file.isEmpty())
			{
				eventservice.updateeventDetails(eventname,eventdesc,id);
			}
			else {
				eventservice.updateeventDetailswithImage(eventname,eventdesc,file,id);
			}
				return "redirect:/admineventdetails";
	
		}
		
		
		
		@RequestMapping(value="/bookcancelbyadmin",method= RequestMethod.POST)
		public String UserBookingCancelAdmin(@RequestParam("booking_id") int booking_id)
		{
				bookingservice.bookingcancelByAdmin(booking_id);
				return "redirect:/adminbookingdetails";
		
		}
		
		
		@RequestMapping(value="/bookacceptbyadmin",method= RequestMethod.POST)
		public String UserBookingAcceptAdmin(@RequestParam("booking_id") int booking_id)
		{
				bookingservice.bookingacceptByAdmin(booking_id);
				return "redirect:/adminbookingdetails";
		
		}
		 
		 @RequestMapping(value="/adminlogout",method=RequestMethod.GET)
			public String adminlogout(HttpSession session) {
			    if (session != null) {
			        session.removeAttribute("Admin_firstname");
					session.removeAttribute("Admin_lastname");
					session.removeAttribute("Admin_email");
					session.removeAttribute("Admin_phone");
					session.removeAttribute("Admin_address");
					session.removeAttribute("Admin_gender");
					session.removeAttribute("Admin_id");
					session.removeAttribute("Admin_cpassword");
					session.removeAttribute("Admin_password");
					session.removeAttribute("Admin_role");
			    }
			    return "redirect:/signin"; 
			}

}
