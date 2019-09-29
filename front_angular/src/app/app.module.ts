import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatToolbarModule, MatBadgeModule, MatGridListModule, MatSelectModule } from '@angular/material';
import { MatIconModule } from '@angular/material/icon';
import { MatExpansionModule, MatInputModule} from '@angular/material';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatListModule } from '@angular/material/list';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PlanningComponent } from './components/planning/planning.component';
import { BasketComponent } from './components/basket/basket.component';
import { ConfirmationComponent } from './components/confirmation/confirmation.component';
import { AboutComponent } from './components/about/about.component';

import {LOCALE_ID} from '@angular/core';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { HomeComponent } from './components/home/home.component';
registerLocaleData(localeFr, 'fr');

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PlanningComponent,
    BasketComponent,
    ConfirmationComponent,
    AboutComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule, MatToolbarModule, MatBadgeModule, MatGridListModule, MatSelectModule,
    MatExpansionModule, MatInputModule, MatCheckboxModule, MatIconModule, MatListModule,
    FormsModule, ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
     { provide: LOCALE_ID, useValue: 'fr-fr' },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
