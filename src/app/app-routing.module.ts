import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnnonceListComponent } from './annonce-list/annonce-list.component';
import { DetailAnnonceComponent } from './detail-annonce/detail-annonce.component';
import { SimulationComponent } from './simulation/simulation.component';

const routes: Routes = [
  {path:"annonce", component:AnnonceListComponent},
  {path:"detailannoncedashbord/:id", component:DetailAnnonceComponent},
  {path:"simulation", component:SimulationComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
