import { Component, Input, OnInit } from '@angular/core';
import { ShopmeService } from '../shopme.service';

@Component({
  selector: 'app-menshirts',
  templateUrl: './menshirts.component.html',
  styleUrls: ['./menshirts.component.css']
})
export class MenshirtsComponent implements OnInit {

  @Input() item :any;
  products:any;

  constructor(public service:ShopmeService) {
    // this.menShirts = [
    //   { itemId:'1',shirtName: 'HERE&NOW', shirtPrice: 628,  imagePath: 'assets/Images/shirt1.jpg'},
    //   { itemId:'2',shirtName: 'LOCOMOTIVE',shirtPrice: 450, imagePath: 'assets/Images/shirt2.jpg'},
    //   { itemId:'3',shirtName: 'Nautica', shirtPrice: 445,  imagePath: 'assets/Images/shirt3.jpg'},
    //   { itemId:'4',shirtName: 'HIGHLANDER', shirtPrice: 370,  imagePath: 'assets/Images/shirt4.jpg'},
    //   { itemId:'5',shirtName: 'Roadster', shirtPrice: 570,  imagePath: 'assets/Images/shirt5.jpg'},
    //   { itemId:'6',shirtName: 'WROGN', shirtPrice: 750,  imagePath: 'assets/Images/shirt6.jpg'},
    //   { itemId:'7',shirtName: 'LEE', shirtPrice: 1999.99,  imagePath: 'assets/Images/shirt7.jpg'},
    //   { itemId:'8',shirtName: 'PepeJeans', shirtPrice: 1999.99,  imagePath: 'assets/Images/shirt8.jpg'}  
    // ];


    this.service.getAllProducts().subscribe((data:any) => {console.log(data),this.products=data;});
   }

  ngOnInit(): void {
  }

  addToCart(product: any){
    this.service.setItemInCart(product);
  }
}
