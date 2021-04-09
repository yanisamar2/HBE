package com.hbe.HotelBookingEngine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hbe.HotelBookingEngine.domain.Customer;
import com.hbe.HotelBookingEngine.domain.Reservation;
import com.hbe.HotelBookingEngine.repositories.CustomerRepository;
import com.hbe.HotelBookingEngine.repositories.ReservationRepository;

@SpringBootApplication
public class HotelBookingEngineApplication {

	public static void main(String[] args) {
		//Customer customerExample = new Customer(new Customer.CustomerBuilder().name("Yanis", "Amar"));
		SpringApplication.run(HotelBookingEngineApplication.class, args);
	}

	   @Bean
	    CommandLineRunner init(CustomerRepository customerRepository,ReservationRepository reservationRepository) {
	        return args -> {
	            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel")
	            .forEach(name -> {
	                Customer customer = new Customer(name, name, name);
	                customer.setMail(name+"@gmail.com");
	                Reservation reservation = new Reservation(LocalDateTime.now(),customer,LocalDate.now(),LocalDate.now().plusDays(2));
	                customerRepository.save(customer);
	                reservationRepository.save(reservation);
	            });
	            customerRepository.findAll().forEach(System.out::println);
	            reservationRepository.findAll().forEach(System.out::println);
	        };
	    }
}
