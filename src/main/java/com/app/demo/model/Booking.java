	package com.app.demo.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="event_date")
	private Date event_date;
	
	@Column(name="event_start_time")
	private String start_at;
	
	@Column(name="max_total_hour")
	private String max_total_hour;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="no_of_guest")
	private String no_of_guest;
	
	@Column(name="bookedon")
	private String current_date;
	
	@Column(name="accept_status")
	private int accept_status;
	
	@Column(name="payment_status")
	private int payment_status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
    private User user;

	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "catering_id")
	private Catering catering;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getStart_at() {
		return start_at;
	}

	public void setStart_at(String start_at) {
		this.start_at = start_at;
	}

	public String getMax_total_hour() {
		return max_total_hour;
	}

	public void setMax_total_hour(String max_total_hour) {
		this.max_total_hour = max_total_hour;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNo_of_guest() {
		return no_of_guest;
	}

	public void setNo_of_guest(String no_of_guest) {
		this.no_of_guest = no_of_guest;
	}

	public String getCurrent_date() {
		return current_date;
	}

	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}

	public int getAccept_status() {
		return accept_status;
	}

	public void setAccept_status(int accept_status) {
		this.accept_status = accept_status;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Catering getCatering() {
		return catering;
	}

	public void setCatering(Catering catering) {
		this.catering = catering;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", event_date=" + event_date + ", start_at=" + start_at + ", max_total_hour="
				+ max_total_hour + ", amount=" + amount + ", no_of_guest=" + no_of_guest + ", current_date="
				+ current_date + ", accept_status=" + accept_status + ", payment_status=" + payment_status + ", user="
				+ user + ", hotel=" + hotel + ", catering=" + catering + ", event=" + event + "]";
	}	
	
}
