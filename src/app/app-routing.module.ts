import { CreateBookComponent } from './create-book/create-book.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import {CreateOrderComponent} from "./create-order/create-order.component";
import {OrderListComponent} from "./order-list/order-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'book', pathMatch: 'full' },
  { path: 'books', component: BookListComponent },
  { path: 'orders', component: OrderListComponent },
  { path: 'addBooks', component: CreateBookComponent },
  { path: 'addOrders', component: CreateOrderComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
