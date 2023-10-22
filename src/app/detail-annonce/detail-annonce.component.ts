import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { AnnonceServiceService } from '../services/annonce-service.service';
import { Annonce } from '../shared/Annonce';

@Component({
  selector: 'app-detail-annonce',
  templateUrl: './detail-annonce.component.html',
  styleUrls: ['./detail-annonce.component.css']
})
export class DetailAnnonceComponent implements OnInit {

  a:Annonce = new Annonce();
 /* v:Visite = new Visite();
  visites: Visite[] = [];*/
   
  constructor(private annonceService: AnnonceServiceService, private router:Router , private ac:ActivatedRoute ) { }
  ngOnInit(): void {
    this.getbyId();
    //this.getvisitebyIdannonce();
   }
      
  getbyId(){
        let id=this.ac.snapshot.params['id'];
        this.annonceService.getAnnoncebyId(id).subscribe(res=>this.a=res)}
  
 /**  getvisitebyIdannonce(){
    //pour recupérrer l'id du path
          let id=this.ac.snapshot.params['id'];
          this.visiteService.getVisitebyAnnonceId(id).subscribe(res=>this.visites=res)
  } */
/*  
  like(announcement: Announcement) {
      this.annonceService.LikeAnnonce(announcement).subscribe(() => {
        console.log('Le post a été liké avec succès !');
       //this.announcementService.getAnnoncebyId(id).subscribe(res=>this.a=res); 
       this.getbyId();
          });
       }
  
  dislike(announcement: Announcement) {
    this.annonceService.disLikeAnnonce(announcement).subscribe(() => {
          console.log('Le post a été disliké avec succès !');
         //this.announcementService.getAnnoncebyId(id).subscribe(res=>this.a=res); 
         this.getbyId();
            });
         }*/

}
