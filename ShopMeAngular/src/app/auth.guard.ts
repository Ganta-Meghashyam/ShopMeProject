import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { ShopmeService } from './shopme.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(public shopmeService: ShopmeService, public toastr: ToastrService){

  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.shopmeService.getUserLoggedIn() == true){
      return true;
    } else {
      this.toastr.error('you need to login first','failed',{ closeButton: true });
      return false;
    }
  }
  
}
