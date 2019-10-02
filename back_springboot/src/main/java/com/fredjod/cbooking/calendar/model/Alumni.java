package com.fredjod.cbooking.calendar.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Alumni {
	
    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELED,
        UNKNOWN;
    }
    
    @Id
	String id;
	BookingStatus status;

	public Alumni(BookingStatus status) {
		this.status= status;
	}
	
	
}
