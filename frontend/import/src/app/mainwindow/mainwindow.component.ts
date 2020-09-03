import { Component, OnInit } from '@angular/core';
import { Province } from '../models/province'
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Component({
  selector: 'app-mainwindow',
  templateUrl: './mainwindow.component.html',
  styleUrls: ['./mainwindow.component.css']
})
export class MainwindowComponent implements OnInit {

  baseURL: string = 'http://localhost:8082'
  provinceExtension: string = '/province';
  buildingTypeExtension: string = '/buildingType';

  selectedProvince: Province = null;

  provinces: Province[] = [
    {province: 'BERLIN', personsIndoor: 10, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 1, personsPsmOutdoor: 2, other:''},
    {province: 'BRANDENBURG', personsIndoor: 8, personsOutdoor:40, householdsIndoor: 4, householdsOutdoor: 8, maskMandatory: false, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 2, personsPsmOutdoor: 5, other:''},
    {province: 'SAXONY_ANHALT', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'SAXONY', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'THURINGA', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'MECKLENBURG_WEST_POMERANIA', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'SCHLESWIG_HOLSTEIN', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'LOWER_SAXONY', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'HAMBURG', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'BREMEN', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'HESSEN', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'RHINELAND_PALATINATE', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'BADEN_WURTTEMBERG', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'SAARLAND', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'BAVARIA', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''},
    {province: 'NORTH_RHINE_WESTPHALIA', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:[{buildingType : 'Schulen'}], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:''}


  ];

  buildingTypes: string[] = ["Restaurants", "Schulen", "Sporthallen", "Büros", "Biergärten"];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  updateProvince(): void{
    if(this.selectedProvince != null){
      this.http.put(this.baseURL + this.provinceExtension, this.selectedProvince).toPromise();
    }
  }
  updateAllProvinces(): void{
    this.provinces.forEach(element => {
      this.http.put(this.baseURL + this.provinceExtension, element).toPromise();
      console.log(element);
    });

    this.buildingTypes.forEach(element => {
      this.http.post(this.baseURL + this.buildingTypeExtension, element).toPromise();
    })
  }
}

