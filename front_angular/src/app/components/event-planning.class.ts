// import { Injectable } from '@angular/core';

export interface EventPlanning {
        type: string;
        day: string;
        schedule: string;
        teacher: string;
        description: string;
        stock: number;
}; 

/* @Injectable({
  providedIn: 'root'
})
*/

export class EventPlanningClass implements EventPlanning {

    type: string;
    day: string;
    schedule: string;
    teacher: string;
    description: string;
    stock: number;

    equals(obj: EventPlanningClass): boolean {
    	return this.day === obj.day 
    		&& this.schedule === obj.schedule
    		&& this.teacher === obj.teacher;
  }

  constructor(ep: EventPlanning) { 
	this.type = ep.type;
	this.day = ep.day;
	this.schedule = ep.schedule;
	this.teacher = ep.teacher;
	this.description = ep.description;
	this.stock = ep.stock;
  }
}

