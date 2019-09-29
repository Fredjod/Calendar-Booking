package com.fredjod.cbooking.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fredjod.cbooking.calendar.model.*;

@RestController
public class CalendarControler {

	@Autowired
	private BDayRepository repository;
	
	@CrossOrigin
	@RequestMapping("/calendar")
    public List<BDay> calendar(@RequestParam(value="name", defaultValue="World") String name) {
		System.out.println("REST Calendar requested. name: "+name);
        return repository.findAll();
	}
	
}
