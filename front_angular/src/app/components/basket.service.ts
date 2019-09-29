import { Injectable } from '@angular/core';
import { EventPlanningClass } from './event-planning.class';

/* export interface IHash {
    [key: string] : PlanningEvent;
};
*/

function isNotUndefined  (element, index, array) { 
   return (typeof element !== 'undefined'); 
} 

@Injectable({
  providedIn: 'root'
})

export class BasketService {
  
	items:EventPlanningClass[] = new Array();

	addToBasket(item:EventPlanningClass) {
      this.items.push(item);
      console.log("basket content add: ", this.items);
  	}

  	removeFromBasket(item:EventPlanningClass) {
     this.items[this.items.findIndex( (eventItem: EventPlanningClass) => {
          return item.equals(eventItem);
        }
        )] = undefined;
     this.items = this.items.filter(isNotUndefined);
     console.log("basket content remove: ", this.items);
  	}

    isIntoBasket(item:EventPlanningClass): Boolean {
      if (
       this.items.findIndex( (eventItem: EventPlanningClass) => {return item.equals(eventItem);} )
         != -1) {
        return true;
      }
      else { return false; }
    }

  	getItems() {
    	return this.items;
  	}

  	clearBasket() {
    	this.items = new Array();
    	console.log("basket cleared!");
    	return this.items;
  	}

  	getItemsNumber() {
    	return this.items.length;
  	}

  constructor() { }
}
