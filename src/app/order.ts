
export class Order {
  id: number;
  description: string;
  currentOrderStatus: string;
  creationDate:Date;
  lastUpdateDate: Date;


  constructor() {
    this.id =0;
    this.description = '';
    currentOrderStatus: 'NOLEGGIATO';
    this.creationDate = new Date();
    this.lastUpdateDate = new Date();

  }
}
