import { Component, OnInit } from '@angular/core';
import { Province } from '../models/province'
import { HttpClient } from '@angular/common/http';
import { ProvinceService } from '../province.service';

@Component({
  selector: 'app-mainwindow',
  templateUrl: './mainwindow.component.html',
  styleUrls: ['./mainwindow.component.css']
})
export class MainwindowComponent implements OnInit {

  baseURL: String = 'http://localhost:8083'
  provinceExtension: string = '/province/';
  buildingTypeExtension: string = '/buildingType';
  selectedProvince: String = null;
  loadedProvince: Province;
  allProvinces: String[] = ['Niedersachsen', 'Nrw', 'Bayern', 'Hamburg'];
  provinces: Province[] = [
    {name: 'Niedersachsen', personsIndoor: 10, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:["Schulen"], personsPsmIndoor: 1, personsPsmOutdoor: 2, other:''},
    {name: 'Nrw', personsIndoor: 8, personsOutdoor:40, householdsIndoor: 4, householdsOutdoor: 8, maskMandatory: false, buildingTypesClosed:["Schulen"], personsPsmIndoor: 2, personsPsmOutdoor: 5, other:''},
    {name: 'Bayern', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:["Biergärten"], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:'Kein Bier macht uns traurig'}
  ];

  constructor(private http: HttpClient, private provinceData: ProvinceService) { }

  ngOnInit(): void {
    this.provinceData.currentProvince.subscribe(province => this.loadedProvince = province);
    this.http.get(this.baseURL + this.provinceExtension + this.provinces[0]).toPromise().then(data => {
      console.log(data);
    });
    
  }

  loadProvince(): void{
    console.log(this.selectedProvince);
    this.loadedProvince = this.provinces.find(province => province.name == this.selectedProvince);
    console.log(this.loadedProvince);
    this.provinceData.changeProvince(this.loadedProvince);
    this.http.get(this.baseURL + this.provinceExtension + this.selectedProvince).toPromise().then(data => {
      console.log(data);
    });
  }

}
