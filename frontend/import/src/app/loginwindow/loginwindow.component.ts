import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loginwindow',
  templateUrl: './loginwindow.component.html',
  styleUrls: ['./loginwindow.component.css']
})

export class LoginwindowComponent implements OnInit {
  hide: boolean = true;
  isViewable: boolean = false;
  enteredAccountName: String = '';
  enteredAccountPW: String = '';
  accountName: String = 'admin';
  accountPW: String = 'admin'; 
  
  constructor() {
  }
  
  ngOnInit(): void {
  }
  checkLoginData(): void{
    if(this.enteredAccountName == this.accountName && this.enteredAccountPW == this.accountPW){
      this.isViewable = true;
    }
  }
}
