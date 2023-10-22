import { Injectable } from '@angular/core';
import { Annonce } from '../shared/Annonce';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnnonceServiceService {

  private apiUrl = 'http://localhost:8081/MicroService/annonce';
  constructor(private http: HttpClient) { }
  //affichage liste des annonces 

afficheAnnonce(): Observable<Annonce[]> {
    return this.http.get<Annonce[]>(this.apiUrl+"/all/annonce");
  }
  //méthode add 
addAnnouncement (annonce: Annonce): Observable<Annonce> {
  return this.http.post<Annonce>("http://localhost:8081/annonce/add/annonce", annonce);}
//affichage liste des annonces 
getAllAnnouncement(): Observable<Annonce[]> {
  return this.http.get<Annonce[]>(this.apiUrl+"/all/annonce"); }

findByCriteria(announcement: Annonce): Observable<Annonce[]> {
    return this.http.post<Annonce[]>(`${this.apiUrl}/criteria`, announcement);
  }
//méthode getbyId 
getAnnoncebyId(id:number):Observable<Annonce>{  
  return this.http.get<Annonce>(this.apiUrl+"/find/annonce/"+id)
  }




}
