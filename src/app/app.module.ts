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
import { FormsAnnonceComponent } from './forms-annonce/forms-annonce.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { FeatureSectionComponent } from './feature-section/feature-section.component';
import { SearchSectionComponent } from './search-section/search-section.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponentComponent,
    AnnonceListComponent,
    DetailAnnonceComponent,
    FormsAnnonceComponent,
    HomeComponentComponent,
    FeatureSectionComponent,
    SearchSectionComponent,
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
