/**
 * 
 */
package com.fredjod.cbooking.calendar.model;

import java.util.*;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;


/**
 * @author home
 *
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class BDay implements Iterable<BEvent> {

	@Id
    String id;
	
	private List<BEvent> events;

	public Iterator<BEvent> iterator() {
		return events.iterator();
	}	
	
   public BDay() {}

    public BDay(List<BEvent> events) {
        this.events = events;
    }
	
    @Override
    public String toString() {
        return String.format(
                "BDay[id=%s], event[0].schedule='%s', event[0].teacher='%s', event[0].stock=%d",
                id, events.get(0).schedule, events.get(0).teacher, events.get(0).stock);
    }
	
}
