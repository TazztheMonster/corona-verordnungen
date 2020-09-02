import { Component, OnInit } from '@angular/core';
import { Province } from '../models/province'
import { ProvinceData } from '../models/provinceData'
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Component({
  selector: 'app-mainwindow',
  templateUrl: './mainwindow.component.html',
  styleUrls: ['./mainwindow.component.css']
})
export class MainwindowComponent implements OnInit {

  baseURL: string = 'http://importbackend:8080'
  provinceExtension: string = '/province';
  buildingTypeExtension: string = '/buildingType';

  selectedProvince: Province = null;

  provinces: Province[] = [
    {name: 'Niedersachsen', personsIndoor: 10, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:["Schulen"], personsPsmIndoor: 1, personsPsmOutdoor: 2, other:''},
    {name: 'Nrw', personsIndoor: 8, personsOutdoor:40, householdsIndoor: 4, householdsOutdoor: 8, maskMandatory: false, buildingTypesClosed:["Schulen"], personsPsmIndoor: 2, personsPsmOutdoor: 5, other:''},
    {name: 'Bayern', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:["Biergärten"], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:'Kein Bier macht uns traurig'}
  ];

  buildingTypes: string[] = ["Restaurants", "Schulen", "Sporthallen", "Büros", "Biergärten"];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  updateProvince(): void{
    if(this.selectedProvince != null){
      this.http.put(this.baseURL + this.provinceExtension, this.selectedProvince);
    }
  }
  updateAllProvinces(): void{
    this.provinces.forEach(element => {
      this.http.put(this.baseURL + this.provinceExtension, element);
      console.log(element);
    });

    this.buildingTypes.forEach(element => {
      this.http.post(this.baseURL + this.buildingTypeExtension, element);
    })
  }
 
}

