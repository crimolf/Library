import { BookService } from '../book.service';
import { Book } from '../book';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();
  submitted = false;

  constructor(private bookService: BookService,
              private router: Router,
              private snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  newBook(): void {
    this.submitted = false;
    this.book = new Book();
  }

  save() {
    this.bookService.createBook(this.book)
      .subscribe(data => {
        console.log(data);
        this.snackBar.open('Book created successfully!', 'Close', {
          duration: 10000,
        });
        this.router.navigate(['/books']);
      }, error => console.log(error));
    this.book = new Book();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
