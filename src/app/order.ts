import { OrderStatus } from './order-status.enum';

export class Order {
  id: number;
  description: string;
  status: OrderStatus;
  creationDate: Date;
  lastUpdateDate: Date;

  constructor() {
    this.id = 0;
    this.description = '';
    this.status = OrderStatus.RENTED;
    this.creationDate = new Date();
    this.lastUpdateDate = new Date();
  }
}
