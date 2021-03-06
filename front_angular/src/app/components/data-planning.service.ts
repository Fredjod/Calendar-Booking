import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';
import { DOCUMENT } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class DataPlanningService {

  planningData: string [];

  getPlanningDataToDisplay() : string [] {
  	return this.planningData;
  }

  constructor(private httpService: HttpClient, @Inject(DOCUMENT) private document: Document) {
      this.httpService.get('http://'+this.document.location.hostname+':8080/calendar?name=C-Booking').subscribe(
        data => {
          this.planningData = data as string [];   // FILL THE ARRAY WITH DATA.
          console.log(this.planningData[0]);
        },
        (err: HttpErrorResponse) => {
          console.log (err.message);
        }
      );
  }
}
