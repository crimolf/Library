import { Observable } from "rxjs";
import { BookService } from "./../book.service";
import { Book } from "./../book";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-book-list",
  templateUrl: "./book-list.component.html",
  styleUrls: ["./book-list.component.css"]
})
export class BookListComponent implements OnInit {
  books: Observable<Book[]>;

  constructor(private bookService: BookService,
              private router: Router) {
    this.books = new Observable<Book[]>();
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.books = this.bookService.getBooksList();
  }

  bookDetails(id: number){
    this.router.navigate(['bookDetails', id]);
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
}
