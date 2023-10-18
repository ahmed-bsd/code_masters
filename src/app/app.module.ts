import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponentComponent } from './navbar-component/navbar-component.component';
import { FootbarComponentComponent } from './footbar-component/footbar-component.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { NavbarCompnentBackComponent } from './navbar-compnent-back/navbar-compnent-back.component';
import { SidebarCompnentBackComponent } from './sidebar-compnent-back/sidebar-compnent-back.component';
import { HttpClientModule } from '@angular/common/http';
import { HeroSectionComponent } from './hero-section/hero-section.component';
import { SearchSectionComponent } from './search-section/search-section.component';
import { PropertySectionComponent } from './property-section/property-section.component';
import { FeatureSectionComponent } from './feature-section/feature-section.component';
import { TeamSectionComponent } from './team-section/team-section.component';
import { TestimonialSectionComponent } from './testimonial-section/testimonial-section.component';
import { LogoSectionComponent } from './logo-section/logo-section.component';
import { FormsModule } from '@angular/forms';
import { SimulationComponent } from './Components/Front/simulation/simulation.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponentComponent,
    FootbarComponentComponent,
    HomeComponentComponent,
    NavbarCompnentBackComponent,
    SidebarCompnentBackComponent,
    HeroSectionComponent,
    SearchSectionComponent,
    PropertySectionComponent,
    FeatureSectionComponent,
    TeamSectionComponent,
    TestimonialSectionComponent,
    LogoSectionComponent,
    SimulationComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
