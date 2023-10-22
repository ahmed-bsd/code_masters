import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnnonceListComponent } from './annonce-list/annonce-list.component';
import {HttpClientModule} from  '@angular/common/http';
import { NavbarComponentComponent } from './navbar-component/navbar-component.component';
import { FootbarComponentComponent } from './footbar-component/footbar-component.component';
import { FormsModule } from '@angular/forms';
import { DetailAnnonceComponent } from './detail-annonce/detail-annonce.component';
import { SimulationComponent } from './simulation/simulation.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponentComponent,
    AnnonceListComponent,
    DetailAnnonceComponent,
    SimulationComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
