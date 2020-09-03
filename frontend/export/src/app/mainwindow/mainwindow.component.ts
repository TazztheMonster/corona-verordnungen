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
  allProvinces: String[] = ['BERLIN', 'BRANDENBURG', 'SAXONY_ANHALT', 'SAXONY', 'THURINGA', 'MECKLENBURG_WEST_POMERANIA', 'SCHLESWIG_HOLSTEIN', 'LOWER_SAXONY',  'HAMBURG', 'BREMEN', 'HESSEN', 'RHINELAND_PALATINATE', 'BADEN_WURTTEMBERG', 'SAARLAND', 'BAVARIA', 'NORTH_RHINE_WESTPHALIA'];
  
  constructor(private http: HttpClient, private provinceData: ProvinceService) { }


  
  ngOnInit(): void {
    this.provinceData.currentProvince.subscribe(province => this.loadedProvince = province);
  }

  loadProvince(): void{
    console.log(this.selectedProvince);
    this.http.get<Province>(this.baseURL + this.provinceExtension + this.selectedProvince).subscribe(
      (data) => {
      this.loadedProvince = new Province(data);
      }
    ) 
    console.log(this.loadedProvince);
    this.provinceData.changeProvince(this.loadedProvince);   
}
}