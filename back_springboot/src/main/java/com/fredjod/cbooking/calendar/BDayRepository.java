package com.fredjod.cbooking.calendar;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fredjod.cbooking.calendar.model.BDay;


public interface BDayRepository extends MongoRepository<BDay, String> {
	
	 @Query("{'_id' : { '$eq' : ?0 }}")
	 public List<BDay> findByid(Date dt);

}
