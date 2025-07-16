export class Book {
  id: number;
  title: string;
  author: string;
  description: string;
  stock: number;
  rented: number;

  constructor() {
    this.id = 0;
    this.title = '';
    this.author = '';
    this.description = '';
    this.stock = 0;
    this.rented = 0;
  }
}
