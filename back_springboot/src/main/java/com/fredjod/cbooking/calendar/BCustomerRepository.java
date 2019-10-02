package com.fredjod.cbooking.calendar;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fredjod.cbooking.calendar.model.BDay;
import com.fredjod.cbooking.customer.model.Customer;

public interface BCustomerRepository extends MongoRepository<BDay, String> {
	public Customer findByid(String id);

}
