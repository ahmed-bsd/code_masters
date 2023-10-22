import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Investissement } from '../shared/investissement';
import { EstimatePriceResponse } from '../shared/price-estimation';


@Injectable({
  providedIn: 'root'
})
export class InvestService {
  private apiUrl = 'http://localhost:8088/api/public/investisement';


  constructor(private http: HttpClient) { }
  
  simulationCalcule(Propertyprice: number, loanTermInYears: number, autoFinanced: number):Observable<any>  {
    return this.http.get<number>(`${this.apiUrl+"/simulateurFin"}?Propertyprice=${Propertyprice}&loanTermInYears=${loanTermInYears}&autoFinanced=${autoFinanced}`);
    }

    estimatePrice(investisment: Investissement): Observable<EstimatePriceResponse>{
      return this.http.post<EstimatePriceResponse>(this.apiUrl+"/estimation", investisment);
    }
}
