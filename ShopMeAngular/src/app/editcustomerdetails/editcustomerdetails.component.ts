import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShopmeService } from '../shopme.service';

@Component({
  selector: 'app-editcustomerdetails',
  templateUrl: './editcustomerdetails.component.html',
  styleUrls: ['./editcustomerdetails.component.css']
})
export class EditcustomerdetailsComponent implements OnInit {

  customerDetails:any;
  editCustomer:any;
  constructor(public service: ShopmeService , public router: Router) {
    this.customerDetails= JSON.parse(<any>localStorage.getItem('customer'));
    console.log(this.customerDetails);
   }

  ngOnInit(): void {
  }

  updateCustomer(): void {
    this.editCustomer = this.customerDetails;
    this.service.updateCustomer(this.editCustomer).subscribe();
    this.router.navigate(['login']);
  }

}
