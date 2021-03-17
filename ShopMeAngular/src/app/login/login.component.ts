import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShopmeService } from '../shopme.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any;
  customer: any;
  userName: any;
  password: any;
  constructor(public router: Router, public shopmeService: ShopmeService ,private toastr: ToastrService) {
    this.user = { userName: '', password: '' };
  }

  ngOnInit(): void {
  }
  loginSubmit(): void {
    console.log("userData:");
    console.log(this.user.userName);
    console.log(this.user.password);

  }
  async submitLoginForm(loginForm: any) {
    console.log("LoginForm Object Data is :");
    console.log(loginForm);

    if (loginForm.userName === 'admin' && loginForm.password === 'admin') {

      this.shopmeService.setUserLoggedIn();

      this.router.navigate(['admin']);
    } else {
      await this.shopmeService.getCustomer(loginForm.userName, loginForm.password).
        toPromise().then((data: any) => { console.log(data), this.customer = data; });

      if (this.customer) {
        localStorage.setItem('customer', JSON.stringify(this.customer));
        this.toastr.success('login sucess','sucess', { closeButton: true });
        this.shopmeService.setUserLoggedIn();
        this.router.navigate(['myaccount']);
      }else{
        this.toastr.error('login failed','failed',{ closeButton: true });
        this.router.navigate(['login']);
      }
    }
  }

}
