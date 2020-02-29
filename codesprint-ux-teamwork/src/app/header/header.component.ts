import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  template:`<app-logo></app-logo>
            <app-nav-bar></app-nav-bar>
            <app-side-bar></app-side-bar>`,
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
