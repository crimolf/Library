import { OrderService } from '../order.service';
import { Order } from '../order';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  order: Order = new Order();
  submitted = false;

  constructor(private orderService: OrderService,
              private router: Router,
              private snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  newOrder(): void {
    this.submitted = false;
    this.order = new Order();
  }

  save() {
    this.orderService.createOrder(this.order)
      .subscribe(data => {
        console.log(data);
        this.snackBar.open('Order created successfully!', 'Close', {
          duration: 10000,
        });
        this.router.navigate(['/orders']);
      }, error => console.log(error));
    this.order = new Order();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
