import { Book } from './../book';
import { Component, OnInit, Input } from '@angular/core';
import { BookService } from '../book.service';
import { BookListComponent } from '../book-list/book-list.component';
@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  @Input() book: Book | undefined;

  constructor(private bookService: BookService, private listComponent: BookListComponent) { }

  ngOnInit() {
  }

}
