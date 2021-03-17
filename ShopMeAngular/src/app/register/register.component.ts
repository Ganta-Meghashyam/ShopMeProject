import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ShopmeService } from '../shopme.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: any;

  constructor(public service: ShopmeService, public router: Router, public toastr: ToastrService) {  //dependency injection for UserService
    this.user = { Name: '', EmailId: '', billingAddress: '', shippingAddress: '', PhoneNumber: '', Username: '', password: '' };
  }

  ngOnInit(): void {
  }
  registrationSubmit(): void {
    console.log("userData");
    console.log(this.user.Name);
    console.log(this.user.EmailId);
    console.log(this.user.billingAddress);
    console.log(this.user.shippingAddress);
    console.log(this.user.PhoneNumber);
    console.log(this.user.Username);
    console.log(this.user.Password);
  }
  submitRegistrationForm(regForm: any): void {
    console.log("User Registration Details:");
    console.log(regForm);

    this.service.register(regForm).subscribe((result: any) => console.log(result));
    this.toastr.success('Registration Sucess','sucess',{ closeButton: true })
        this.router.navigate(['login']);
  }
}

