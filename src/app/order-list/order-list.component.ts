import { Observable } from "rxjs";
import { OrderService } from "./../order.service";
import { Order } from "./../order";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-order-list",
  templateUrl: "./order-list.component.html",
  styleUrls: ["./order-list.component.css"]
})
export class OrderListComponent implements OnInit {
  orders: Observable<Order[]>;

  constructor(private orderService: OrderService) {
    // @ts-ignore
    this.orders = this.orderService.getOrder();
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.orders = this.orderService.getOrdersList();
  }

  public deleteOrder(id: number) {
    this.orderService.deleteOrder(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
