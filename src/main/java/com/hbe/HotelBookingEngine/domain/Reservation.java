package com.hbe.HotelBookingEngine.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="reservations")
public class Reservation {

	private long id;
	
	private LocalDate checkin;
	private LocalDate checkout;

	

	
	private Customer booker;
	
	private Customer guest;

	
	private int guestCount;
	
	private double totalPrice;
	private double payableCommission;
	
	private LocalDateTime bookedOn;
	private LocalDateTime modifiedOn;

	private String partnerId;
	private String reservationRemarks;
	private String guaranteeInformation;
	
	private String mealPlan;

			
 public Reservation() {
		super();
	}

public Reservation(LocalDateTime bookedOn, Customer booker, LocalDate checkin, LocalDate checkout) {
	 this.booker=booker;
	 this.bookedOn = bookedOn;
	 this.checkin = checkin;
	 this.checkout = checkout;
 }
	
//	public Customer(CustomerBuilder builder){
//		this.firstName = builder.firstName;
//		this.lastName = builder.lastName;
//		this.mail = builder.mail;
//		this.phone = builder.phone;
//		this.address = builder.address;
//		this.city = builder.city;
//		this.area = builder.area;
//		this.country = builder.country;
//		this.id = builder.id;
//	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
	    return id;
	}
	
    public void setId(long id) {
        this.id = id;
    }
	

    @Column(name = "checkin", nullable = false)
	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	@Column(name = "checkout", nullable = false)
	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	

	
	@OneToOne(cascade = CascadeType.MERGE , targetEntity = Customer.class)
	@JoinColumn(name="id")
	public Customer getBooker() {
		return booker;
	}

	public void setBooker(Customer booker) {
		this.booker = booker;
	}
	
	
	@OneToOne(cascade = CascadeType.MERGE , targetEntity = Customer.class)
	@JoinColumn(name="id")
	 public Customer getGuest() {
		return guest;
	}

	public void setGuest(Customer guest) {
		this.guest = guest;
	}
	
	@Column(name="guestCount")
	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	@Column(name="totalPrice")
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name="payableCommission")
	public double getPayableCommission() {
		return payableCommission;
	}

	public void setPayableCommission(double payableCommission) {
		this.payableCommission = payableCommission;
	}

	@Column(name="bookedOn")
	public LocalDateTime getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(LocalDateTime bookedOn) {
		this.bookedOn = bookedOn;
	}
	
	@Column(name="modifiedOn")
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@Column(name = "reservationRemarks")
	public String getReservationRemarks() {
		return reservationRemarks;
	}

	public void setReservationRemarks(String reservationRemarks) {
		this.reservationRemarks = reservationRemarks;
	}

	@Column(name = "guaranteeInformation")
	public String getGuaranteeInformation() {
		return guaranteeInformation;
	}

	public void setGuaranteeInformation(String guaranteeInformation) {
		this.guaranteeInformation = guaranteeInformation;
	}

	@Column(name = "mealPlan")
	public String getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(String mealPlan) {
		this.mealPlan = mealPlan;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkin=" + checkin + ", checkout=" + checkout + ", booker=" + booker
				+ ", guest=" + guest + ", guestCount=" + guestCount + ", totalPrice=" + totalPrice
				+ ", payableCommission=" + payableCommission + ", bookedOn=" + bookedOn + ", partnerId=" + partnerId
				+ ", reservationRemarks=" + reservationRemarks + ", guaranteeInformation=" + guaranteeInformation
				+ ", mealPlan=" + mealPlan + "]";
	}
	

	/*
	 * public static class CustomerBuilder{
	 * 
	 * private String firstName; private String lastName; private String mail;
	 * private String phone; private String address; private String city; private
	 * String area; private String country; private Long id;
	 * 
	 * 
	 * public CustomerBuilder id(Long id) { this.id = id; return this; }
	 * 
	 * public CustomerBuilder name(String firstName, String lastName) {
	 * this.firstName = firstName; this.lastName = lastName; return this; }
	 * 
	 * public CustomerBuilder mail(String mail) { this.mail = mail; return this; }
	 * 
	 * public CustomerBuilder phone(String phone) { this.phone = phone; return this;
	 * } public CustomerBuilder address(String address) { this.address = address;
	 * return this; } public CustomerBuilder city(String city) { this.city = city;
	 * return this; } public CustomerBuilder area(String area) { this.area = area;
	 * return this; } public CustomerBuilder country(String country) { this.country
	 * = country; return this; }
	 * 
	 * 
	 * public Customer build() { Customer customer = new Customer(this);
	 * validateUserObject(customer); return customer; } private void
	 * validateUserObject(Customer customer) { //Do some basic validations to check
	 * }
	 * 
	 * public CustomerBuilder fromUser(Customer existingCustomer) { return new
	 * Customer.CustomerBuilder() .name(existingCustomer.getFirstName(),
	 * existingCustomer.getLastName()) .phone(existingCustomer.getPhone())
	 * .mail(existingCustomer.getMail()) .country(existingCustomer.getCountry())
	 * .city(existingCustomer.getCity()) .address(existingCustomer.getAddress())
	 * .area(existingCustomer.getArea()); }
	 * 
	 * }
	 */
}
