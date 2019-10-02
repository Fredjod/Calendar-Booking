package com.fredjod.cbooking.calendar.model;

import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class BEvent implements Iterable<Alumni> {


	String type;
    String schedule;
    String teacher;
    String description;
    Integer capacity;
    Integer stock;
    DisplayAttrib display_attributes ;
   	List<Alumni> alumni;

	public Iterator<Alumni> iterator() {
		return alumni.iterator();
	}	

    public BEvent(
    	    String type, 
    	    String schedule,
    	    String teacher,
    	    String description,
    	    Integer capacity,
    	    DisplayAttrib display_attributes,
    	    List<Alumni> alumni
    	    ) {
        this.type = type;
        this.schedule = schedule;
        this.teacher = teacher;
        this.description = description;
        this.capacity = capacity;
        this.display_attributes = display_attributes;
        this.alumni = alumni;
                
        // Define the remaining stock of places for this event
        this.stock = this.capacity;
        if (this.alumni != null) {
        	Integer stock = this.capacity-this.alumni.size();
        	if (stock >= 0) { this.stock = stock; }
        }
    }
}
