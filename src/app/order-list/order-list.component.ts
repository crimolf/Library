import { Observable } from "rxjs";
import { OrderService } from "../order.service";
import { Order } from "../order";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { OrderStatus } from "../order-status.enum";

@Component({
  selector: "app-order-list",
  templateUrl: "./order-list.component.html",
  styleUrls: ["./order-list.component.css"]
})
export class OrderListComponent implements OnInit {
  orders: Observable<Order[]>;

  constructor(private orderService: OrderService,
              private router: Router) {
    this.orders = new Observable<Order[]>();
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.orders = this.orderService.getOrdersList();
  }

  deleteOrder(id: number) {
    this.orderService.deleteOrder(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  orderDetails(id: number){
    this.router.navigate(['orderDetails', id]);
  }

  returnOrder(id: number) {
    this.orderService.updateOrderStatus(id, OrderStatus.RETURNED)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
