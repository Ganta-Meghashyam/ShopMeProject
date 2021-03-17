import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShopmeService } from '../shopme.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  totalPrice=0;
  cartData: any;

  constructor(public service:ShopmeService, public router:Router) {}

  ngOnInit(): void {
    this.service.itemsInCart$.subscribe(data => {
      this.cartData = data;
      
      this.totalPrice = this.addPrice()
     })
  }

  addPrice(){
    var totalPrice=0;
    var orderLength = this.cartData.length
    for(var i=0;i<orderLength;i++){
      totalPrice+=this.cartData[i].price* parseInt(this.cartData[i].count);
    }
    return totalPrice;
  }

  updatePrices() {
    console.log(this.cartData);
    this.totalPrice = this.addPrice();
  }

  gotoPurchasePage(){
    this.router.navigate(['PurchasePage']);
    this.service.deletecartdata();
  }
}
