package com.hbe.HotelBookingEngine.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hbe.HotelBookingEngine.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
