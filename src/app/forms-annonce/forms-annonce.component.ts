import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AnnonceServiceService } from '../services/annonce-service.service';
import { Annonce } from '../shared/Annonce';

@Component({
  selector: 'app-forms-annonce',
  templateUrl: './forms-annonce.component.html',
  styleUrls: ['./forms-annonce.component.css']
})
export class FormsAnnonceComponent implements OnInit {

  annonces :Annonce[] = [];
  a:Annonce = new Annonce();
  
  constructor(private  annonceService: AnnonceServiceService , private router:Router , private ac:ActivatedRoute) { }

  ngOnInit(): void {
  this.getAnnouncement();
   
  }

  getAnnouncement(): void {
    this.annonceService.getAllAnnouncement().subscribe(annonces => this.annonces = annonces,
      error => console.log(error));
  }

  addAnnonce = () => {
    
    this.annonceService.addAnnouncement(this.a)
    .subscribe (res => { this.router.navigateByUrl('/annonce')
    console.log('annonce created!');
    this.getAnnouncement();})
  }

}
