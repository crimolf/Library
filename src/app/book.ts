
export class Book {
  id: number;
  testo: string;
  titolo: string;
  numberBookInStock: number;
  numberBooksOut: number;


  constructor() {
    this.id =0;
    this.testo = '';
    this.titolo = '';
    this.numberBookInStock = 0;
    this.numberBooksOut = 0;

  }
}
