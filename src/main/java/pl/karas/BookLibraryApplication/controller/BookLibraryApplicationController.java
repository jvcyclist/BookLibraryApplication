package pl.karas.BookLibraryApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pl.karas.BookLibraryApplication.BookSupport;
import pl.karas.BookLibraryApplication.entity.AuthorRating;
import pl.karas.BookLibraryApplication.entity.BookToSerialize;

@RestController
public class BookLibraryApplicationController {

	private BookSupport bookSupport = new BookSupport();

	@RequestMapping("/book")
	public List<BookToSerialize> getBook(@RequestParam(value = "isbn", defaultValue = "") String isbn,
			@RequestParam(value = "category", defaultValue = "") String category) {

		if (isbn.equals("") && category.equals("")) {
			return BookSupport.books;
		}

		if (!(isbn.equals(""))) {

			BookSupport.books = new ArrayList<BookToSerialize>(BookSupport.filter.filterByISBN(isbn));
			if (BookSupport.books.isEmpty()) {
				throw new ResponseStatusException(
						  HttpStatus.NOT_FOUND, "Book not found"
						);
			} else {
				return BookSupport.books;
			}
		}

		if (!(category.equals(""))) {
			BookSupport.books = new ArrayList<BookToSerialize>(BookSupport.filter.filterByCategory(category));
			return BookSupport.books;
		}
		
		return BookSupport.books;

	}

	@RequestMapping("/ratings")
	public List<AuthorRating> getAuthorsRatings() {
		return bookSupport.authorRatings;
	}

}
