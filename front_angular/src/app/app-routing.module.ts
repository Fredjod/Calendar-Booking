import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PlanningComponent } from './components/planning/planning.component';
import { BasketComponent } from './components/basket/basket.component';
import { ConfirmationComponent } from './components/confirmation/confirmation.component';
import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
	  { path: '', component: HomeComponent },
      { path: 'planning', component: PlanningComponent },
      { path: 'basket', component: BasketComponent },
      { path: 'confirmation', component: ConfirmationComponent },
      { path: 'about', component: AboutComponent },
     
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
