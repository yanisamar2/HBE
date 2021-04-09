package com.hbe.HotelBookingEngine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	private long id;
	private String firstName;
	private String lastName;
	private String mail;
	private String phone;
	private String address;
	private String city;
	private String area;
	private String country;

	
	
	
	
 public Customer() {
		super();
	}

public Customer(String firstName, String lastName, String mail) {
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.mail = mail;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
	    return id;
	}
	
    public void setId(long id) {
        this.id = id;
    }
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	@Column(name = "mail", nullable = false)
	public String getMail() {
		return mail;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		return "Customer [id ="+id+"   firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + ", phone=" + phone
				+ ", address=" + address + ", city=" + city + ", area=" + area + ", country=" + country + "]";
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
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
