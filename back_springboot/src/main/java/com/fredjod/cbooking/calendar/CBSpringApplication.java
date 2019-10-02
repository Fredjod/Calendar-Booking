package com.fredjod.cbooking.calendar;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse("2019-06-03", dtf);   
		Date dt = Date.from(localDate.atStartOfDay().toInstant(ZoneOffset.UTC));
		System.out.println("Booking day events found with findByid('"+dt+"'):");
		System.out.println("------------------------------------------------------------------------");
		for (BDay bday : repository.findByid(dt)) {
			System.out.println(bday);
		}

	}	
	
	
}