import { Component, OnInit } from '@angular/core';
import { ShopmeService } from '../shopme.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public service:ShopmeService) { }

  ngOnInit(): void {
  }
  logout(){
    this.service.setUserLoggedOut();
  }

}
