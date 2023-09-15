import { Order } from './../order';
import { Component, OnInit, Input } from '@angular/core';
import { OrderService } from '../order.service';
import { OrderListComponent } from '../order-list/order-list.component';
@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  @Input() order: Order | undefined;

  constructor(private orderService: OrderService, private listComponent: OrderListComponent) { }

  ngOnInit() {
  }

}
