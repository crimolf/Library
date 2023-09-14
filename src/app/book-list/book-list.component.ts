import { Observable } from "rxjs";
import { BookService } from "./../book.service";
import { Book } from "./../book";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-book-list",
  templateUrl: "./book-list.component.html",
  styleUrls: ["./book-list.component.css"]
})
export class BookListComponent implements OnInit {
  books: Observable<Book[]>;

  constructor(private bookService: BookService) {
    // @ts-ignore
    this.books = this.bookService.getBook();
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.books = this.bookService.getBooksList();
  }

  public deleteBook(id: number) {
    this.bookService.deleteBook(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
