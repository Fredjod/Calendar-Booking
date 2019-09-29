import { Component, OnInit } from '@angular/core';
import { BasketService } from '../basket.service';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { EventPlanningClass, EventPlanning } from '../event-planning.class';
import { DataPlanningService } from '../data-planning.service';

export interface IEventDisplayAttributes {
      stock_class: string,
      event_class: string
}

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})

export class PlanningComponent implements OnInit {


  constructor(public planningData: DataPlanningService, public basket: BasketService ) { }

  ngOnInit() { }

  getStockValue (itemData: any, day: string, stock: number) {
    let eventData: EventPlanning = itemData;
    eventData.day = day;
    var eventObj= new EventPlanningClass(eventData);
    if (this.basket.isIntoBasket(eventObj)) {
      return stock-1;
    }
    else {
      return stock;
    }
  }

  isIntoBasket (itemData: any, day: string ) {
    let eventData: EventPlanning = itemData;
    eventData.day = day;
    var eventObj= new EventPlanningClass(eventData);
    return this.basket.isIntoBasket(eventObj);
  }

  onChange(obj: MatCheckboxChange, itemData: any, day: string) {
    let eventData: EventPlanning = itemData;
    eventData.day = day;
    var eventObj= new EventPlanningClass(eventData);
    if(obj.checked) {
      this.basket.addToBasket(eventObj);
    }
    else {
      this.basket.removeFromBasket(eventObj);
    }
  }

  isDisabledToggle (stock: number) {
    if (stock == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  getStockClass (displayAttrib: any, stock: number) {

    let attrib: IEventDisplayAttributes = displayAttrib;

    // console.log("Stock class: ", attrib.stock_class);
    if (stock == 0) {
      return "soldout_dot_stock";
    } else {
      return attrib.stock_class;
    }
  }

}
