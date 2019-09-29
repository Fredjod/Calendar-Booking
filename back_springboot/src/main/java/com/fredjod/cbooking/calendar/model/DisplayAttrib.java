package com.fredjod.cbooking.calendar.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DisplayAttrib {
	String stock_class;

	public DisplayAttrib(String stock_class) {
		this.stock_class = stock_class;
	}
}
