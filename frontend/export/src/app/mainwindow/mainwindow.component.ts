import { Component, OnInit } from '@angular/core';
import { Province } from '../models/province'
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-mainwindow',
  templateUrl: './mainwindow.component.html',
  styleUrls: ['./mainwindow.component.css']
})
export class MainwindowComponent implements OnInit {

  selectedProvince: String = null;
  allProvinces: String[] = ["Niedersachsen", "Nrw", "Bayern", "Hamburg"];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get('http://httpbin.org/get '+ this.selectedProvince).toPromise().then(data => {
      console.log(data);
    });
  }

  loadProvince(): void{
    this.http.get('http://httpbin.org/get '+ this.selectedProvince).toPromise().then(data => {
      console.log(data);
    });
  }

}
