import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookListComponent } from './book-list/book-list.component';
import { HttpClientModule } from '@angular/common/http';
import {CreateOrderComponent} from "./create-order/create-order.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";
import {OrderListComponent} from "./order-list/order-list.component";
import { UpdateOrderComponent } from './update-order/update-order.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from "@angular/material/dialog";
import {MatIconModule} from "@angular/material/icon";

@NgModule({
  declarations: [
    AppComponent,
    CreateBookComponent,
    BookDetailsComponent,
    BookListComponent,
    CreateOrderComponent,

    OrderDetailsComponent,
    OrderListComponent,
    BookDetailsComponent,
    BookListComponent,
    UpdateOrderComponent,
    UpdateBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatDialogModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
