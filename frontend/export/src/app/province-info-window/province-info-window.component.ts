import { Component, OnInit } from '@angular/core';
import { Province } from '../models/province';
import { ProvinceService } from '../province.service';

@Component({
  selector: 'app-province-info-window',
  templateUrl: './province-info-window.component.html',
  styleUrls: ['./province-info-window.component.css']
})
export class ProvinceInfoWindowComponent implements OnInit {

  provinceToDisplay: Province;

  constructor(private provinceData: ProvinceService) { }

  ngOnInit(): void {
    this.provinceData.currentProvince.subscribe(province => this.provinceToDisplay = province);
  }

  printProvince():void {
    console.log(this.provinceToDisplay);
  }

}
