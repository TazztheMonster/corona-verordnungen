import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Province } from './models/province';

@Injectable({
  providedIn: 'root'
})
export class ProvinceService {
  
  private provinceSource = new BehaviorSubject<Province>(new Province());
  currentProvince = this.provinceSource.asObservable();


  constructor() { }

  changeProvince(province: Province){
    this.provinceSource.next(province);
  }
}
