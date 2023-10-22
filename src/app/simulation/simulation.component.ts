import { Component, OnInit } from '@angular/core';
import { Investissement } from '../shared/investissement';
import { InvestService } from '../services/invest.service';
import { EstimatePriceResponse } from '../shared/price-estimation';

@Component({
  selector: 'app-simulation',
  templateUrl: './simulation.component.html',
  styleUrls: ['./simulation.component.css']
})
export class SimulationComponent implements OnInit {
  Propertyprice!: number;
  loanTermInYears!: number;
  autoFinanced!: number;
  monthlyPayment!: number;
  top3Investments!: any[];
  showPredictionForm = false;
  showSimulationForm = false;
  investisment: Investissement = new Investissement();
  result!: string;
  maxPrice!: number;
  minPrice!: number;
  averagePrice!: number;
  formSubmitted = false;
  formValid = false;


  constructor(private simService:InvestService) { 
  }

  ngOnInit(): void {
   
  }

  calculateLoan() {
    if (this.Propertyprice && this.loanTermInYears && this.autoFinanced && this.autoFinanced <= this.Propertyprice) {
      this.formValid = true;
      this.simService.simulationCalcule(this.Propertyprice, this.loanTermInYears, this.autoFinanced)
      .subscribe(data => {
        this.monthlyPayment = data.monthlyPayment;
        this.top3Investments = data.top3Investments;
      }); 
    }
    this.formSubmitted = true;
  }





   

  showSimulation() {
    this.showPredictionForm = false;
    this.showSimulationForm = true;
  }

  showPrediction() {
    this.showPredictionForm = true;
    this.showSimulationForm = false;
  }

  estimatePrice(inv: Investissement){
    this.simService.estimatePrice(inv).subscribe( (data: EstimatePriceResponse) => {
      this.maxPrice = data.maxPrice;
      this.minPrice = data.minPrice;
      this.averagePrice = data.averagePrice;
    }, (error) => {
      console.error('Error fetching estimate price: ', error);
    });
  }
 

}
