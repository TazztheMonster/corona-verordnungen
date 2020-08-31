import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loginwindow',
  templateUrl: './loginwindow.component.html',
  styleUrls: ['./loginwindow.component.css']
})

export class LoginwindowComponent implements OnInit {
  constructor() {
  }
  
  ngOnInit(): void {
    let account = { accountname: "admin", accountpw: "password"};
  }
  
  isViewable: boolean = false;
  accountName: String = '';
  accountPW: String = '';
  
}
