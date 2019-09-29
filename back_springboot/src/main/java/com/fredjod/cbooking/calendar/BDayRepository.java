package com.fredjod.cbooking.calendar;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fredjod.cbooking.calendar.model.BDay;


public interface BDayRepository extends MongoRepository<BDay, String> {
	 public List<BDay> findByid(String id);

}
