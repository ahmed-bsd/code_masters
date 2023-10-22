import { Component } from '@angular/core';
import { Annonce } from '../shared/Annonce';
import { AnnonceServiceService } from '../services/annonce-service.service';

@Component({
  selector: 'app-annonce-list',
  templateUrl: './annonce-list.component.html',
  styleUrls: ['./annonce-list.component.css']
})
export class AnnonceListComponent {
  annonces :Annonce[] = [];

  annonce = new Annonce();
  listAnnonce : Annonce[] = [];
  searchCriteria: Annonce = new Annonce();
  constructor(private annonceService: AnnonceServiceService) { }
  ngOnInit(): void {
    this.affiche();
  }
//Afficher les annonces 
  getAnnouncement(): void {
    this.annonceService.getAllAnnouncement().subscribe(annonces => this.annonces = annonces,
      error => console.log(error));
  }

  ajoutannonce(){
   this.annonceService.addAnnouncement(this.annonce).subscribe(() => {
      console.log('Annonce ajoutée avec succès !');
      // Effectuer d'autres actions après l'ajout de l'annonce
    });
  }

  affiche():void {
    this.annonceService.afficheAnnonce().subscribe(listAnnonce=>this.listAnnonce=listAnnonce);
  }
search(): void {
    this.annonceService.findByCriteria(this.searchCriteria).subscribe(
      (annonces) => {
        this.annonces = annonces;
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
 


