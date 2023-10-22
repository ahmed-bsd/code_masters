import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnnonceListComponent } from './annonce-list/annonce-list.component';
import { DetailAnnonceComponent } from './detail-annonce/detail-annonce.component';
import { SimulationComponent } from './simulation/simulation.component';
import { FormsAnnonceComponent } from './forms-annonce/forms-annonce.component';
import { HomeComponentComponent } from './home-component/home-component.component';

const routes: Routes = [
  {path:"home", component:HomeComponentComponent},
  {path:"annonce", component:AnnonceListComponent},
  {path:"detailannoncedashbord/:id", component:DetailAnnonceComponent},
  {path:"simulation", component:SimulationComponent},
  {path:"addannonce", component:FormsAnnonceComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
