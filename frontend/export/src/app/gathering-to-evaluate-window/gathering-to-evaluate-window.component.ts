import { Component, OnInit } from '@angular/core';
import { Province } from '../models/province';
import { ProvinceService } from '../province.service';

@Component({
  selector: 'app-gathering-to-evaluate-window',
  templateUrl: './gathering-to-evaluate-window.component.html',
  styleUrls: ['./gathering-to-evaluate-window.component.css']
})
export class GatheringToEvaluateWindowComponent implements OnInit {

  provinceToCompare: Province;
  numberOfPersons: number;
  numberOfHouseholds: number;
  inside: boolean;
  sizeOfGatheringPlace: number;
  isValid: boolean;
  notCalculatedYet: boolean = true;

  constructor(private provinceData: ProvinceService) { }

  ngOnInit(): void {  
      this.provinceData.currentProvince.subscribe(province => this.provinceToCompare = province);  
  }

  validateGathering(): void{
    this.notCalculatedYet = false;
    // HIER RECHNEN
    if (this.inside) { //Inside
      if (this.numberOfPersons > this.provinceToCompare.personsIndoor || this.numberOfHouseholds > this.provinceToCompare.householdsIndoor || (this.sizeOfGatheringPlace != 0 && this.numberOfPersons/this.sizeOfGatheringPlace > this.provinceToCompare.personsPsmIndoor)) {
          this.isValid = false;
      } else {
        this.isValid = true;
      }
    } else { //Outside
      if (this.numberOfPersons > this.provinceToCompare.personsOutdoor || this.numberOfHouseholds > this.provinceToCompare.householdsOutdoor || (this.sizeOfGatheringPlace != 0 && this.numberOfPersons/this.sizeOfGatheringPlace > this.provinceToCompare.personsPsmOutdoor)) {
        this.isValid = false;
    } else {
      this.isValid = true;
    }
    }
  }
  resetStyling(): void{
    this.notCalculatedYet = true;
  }

}
