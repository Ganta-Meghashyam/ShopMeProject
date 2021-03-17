import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule,Routes } from '@angular/router';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import { MyaccountComponent } from './myaccount/myaccount.component';
import { EditcustomerdetailsComponent } from './editcustomerdetails/editcustomerdetails.component';
import { CartComponent } from './cart/cart.component';
import { AuthGuard } from './auth.guard';
import { CommonModule } from '@angular/common';
import { MenshirtsComponent } from './menshirts/menshirts.component';
import { OrderComponent } from './order/order.component';
import { AdminComponent } from './admin/admin.component';
import { PurchasepageComponent } from './purchasepage/purchasepage.component';
import { NgxPayPalModule } from 'ngx-paypal';

const appRoot: Routes = [

  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'myaccount', canActivate:[AuthGuard],component:  MyaccountComponent},
  {path:'menshirts',component:  MenshirtsComponent},
  {path:'editcustomerdetails',component:  EditcustomerdetailsComponent},
  {path:'admin',component:  AdminComponent},
  {path:'PurchasePage',component:  PurchasepageComponent},
  {path:'Cart',component:  CartComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    MyaccountComponent,
    EditcustomerdetailsComponent,
    CartComponent,
    MenshirtsComponent,
    OrderComponent,
    AdminComponent,
    PurchasepageComponent,
   
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(appRoot),
    HttpClientModule,
    ToastrModule.forRoot(),

    NgxPayPalModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
