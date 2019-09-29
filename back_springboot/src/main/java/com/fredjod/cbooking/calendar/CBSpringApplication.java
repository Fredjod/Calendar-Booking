package com.fredjod.cbooking.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fredjod.cbooking.calendar.model.BDay;

@SpringBootApplication
public class CBSpringApplication implements CommandLineRunner {

	@Autowired
	private BDayRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CBSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Booking day events found with findByid('06/01/19'):");
		System.out.println("--------------------------------");
		for (BDay bday : repository.findByid("06/01/19")) {
			System.out.println(bday);
		}

	}	
	
	
}
