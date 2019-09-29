import { Component, OnInit } from '@angular/core';
import { FormControl } from "@angular/forms";
import { Validators} from '@angular/forms';
import { BasketService } from '../basket.service';
import { EventPlanningClass } from '../event-planning.class';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  constructor( public basket: BasketService ) { }
  ngOnInit() { }


  deleteItem(item: EventPlanningClass) {
    this.basket.removeFromBasket (item);
   }

   emailFormControl = new FormControl('', [
      Validators.required,
      Validators.email,
  ]);



}
