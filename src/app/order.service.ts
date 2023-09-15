import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "./order";


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8080/orders';

  constructor(private http: HttpClient) { }

  getOrder(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createOrder(order: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, order);
  }

  updateOrder(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteOrder(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getOrdersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
