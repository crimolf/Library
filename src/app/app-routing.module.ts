import { CreateBookComponent } from './create-book/create-book.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import {CreateOrderComponent} from "./create-order/create-order.component";
import {OrderListComponent} from "./order-list/order-list.component";
import {UpdateOrderComponent} from "./update-order/update-order.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";
import {UpdateBookComponent} from "./update-book/update-book.component";
import {BookDetailsComponent} from "./book-details/book-details.component";

const routes: Routes = [
  { path: '', redirectTo: 'book', pathMatch: 'full' },
  { path: 'books', component: BookListComponent },
  { path: 'orders', component: OrderListComponent },
  { path: 'addBook', component: CreateBookComponent },
  { path: 'addOrder', component: CreateOrderComponent },
  { path: 'returnOrder', component: CreateOrderComponent },
  { path: 'cancelOrder', component: CreateOrderComponent },

  { path: 'update/:id', component: UpdateOrderComponent },
  { path: 'update/:id', component: UpdateBookComponent },
  { path: 'orderDetails/:id', component: OrderDetailsComponent },
  { path: 'bookDetails/:id', component: BookDetailsComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
