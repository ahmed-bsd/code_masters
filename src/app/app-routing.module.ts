import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponentComponent } from './home-component/home-component.component';
import { SimulationComponent } from './Components/Front/simulation/simulation.component';

const routes: Routes = [
  {path:"home", component:HomeComponentComponent},
  {path:"simulation", component:SimulationComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
