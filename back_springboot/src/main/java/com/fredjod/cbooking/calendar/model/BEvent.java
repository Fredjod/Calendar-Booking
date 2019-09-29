package com.fredjod.cbooking.calendar.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class BEvent {

    String type;
    String schedule;
    String teacher;
    String description;
    Integer stock;
    DisplayAttrib display_attributes ;
   	String alumni[];

    public BEvent(
    	    String type, 
    	    String schedule,
    	    String teacher,
    	    String description,
    	    Integer stock,
    	    DisplayAttrib display_attributes,
    	    String alumni[]
    	    ) {
        this.type = type;
        this.schedule = schedule;
        this.teacher = teacher;
        this.description = description;
        this.stock = stock;
        this.display_attributes = display_attributes;
        this.alumni = alumni;
    }

}
