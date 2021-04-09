package com.hbe.HotelBookingEngine.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbe.HotelBookingEngine.domain.Reservation;
import com.hbe.HotelBookingEngine.repositories.ReservationRepository;

import exceptions.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")


public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@GetMapping("/reservations")
	public List<Reservation> getAllCustomers(){
		return reservationRepository.findAll();
	}
	
	@GetMapping("/reservations/{id}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable(value= "id") Long reservationId) throws ResourceNotFoundException
	{
		Reservation reservation= reservationRepository.findById(reservationId)
				.orElseThrow( () -> new ResourceNotFoundException("reservation not found for this id :"+ reservationId));
		return ResponseEntity.ok().body(reservation);
		
	}
	
	@PostMapping("/reservations")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		System.out.println("Creating reservation : + "+reservation);
		return reservationRepository.save(reservation);
	}
	
	@PutMapping("reservations/{id}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") long reservationId, Reservation reservationDetails) throws ResourceNotFoundException
	{
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reservation not found for this id :"+ reservationId));
		

		reservation.setBookedOn(reservationDetails.getBookedOn());
		reservation.setBooker(reservationDetails.getBooker());
		reservation.setCheckin(reservationDetails.getCheckin());
		reservation.setCheckout(reservationDetails.getCheckout());
		
		
		final Reservation updatedReservation = reservationRepository.save(reservation);
		return ResponseEntity.ok(updatedReservation);
	}
	
	@DeleteMapping("/reservations/{id}")
	public Map<String, Boolean> deleteReservation(@PathVariable(value="id") long reservationId) throws ResourceNotFoundException
	{
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :"+ reservationId));
		
		reservationRepository.delete(reservation);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
	
	
	
}
