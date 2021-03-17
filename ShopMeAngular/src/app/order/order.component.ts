import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  @Input() order:any;
  @Output() changeQuantity = new EventEmitter(); // creating event
  constructor() { }

  ngOnInit(): void {
  }

  quantityChange() {
    this.changeQuantity.emit(); // emitted event
  }

}
