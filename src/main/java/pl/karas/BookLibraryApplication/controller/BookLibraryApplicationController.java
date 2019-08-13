package pl.karas.BookLibraryApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pl.karas.BookLibraryApplication.BookResponse;
import pl.karas.BookLibraryApplication.entity.AuthorRating;
import pl.karas.BookLibraryApplication.entity.BookToSerialize;

@RestController
@RequestMapping("/api")
public class BookLibraryApplicationController {

	private BookResponse bookResponse;

	@RequestMapping("/book/{isbn}")
	public List<BookToSerialize> getBookByIsbn(@PathVariable("isbn") String isbn) {

		bookResponse = new BookResponse();
		
		if (!(StringUtils.isEmpty(isbn))) {

			bookResponse.setResponse(new ArrayList<BookToSerialize>(bookResponse.filter.filterByISBN(isbn)));
			if (bookResponse.getResponse().isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
			} else {
				bookResponse.getResponse();
			}
		}

		return bookResponse.getResponse();

	}

	@RequestMapping("/books/{category}")
	public List<BookToSerialize> getBooksByCategory(@PathVariable("category") String category) {

		bookResponse = new BookResponse();
		
		if (!(StringUtils.isEmpty(category))) {
			bookResponse.setResponse(new ArrayList<BookToSerialize>(bookResponse.filter.filterByCategory(category)));
			return bookResponse.getResponse();
		}

		return bookResponse.getResponse();

	}

	@RequestMapping("/allbooks")
	public List<BookToSerialize> getBookByIsbn() {

		bookResponse = new BookResponse();
		
		return bookResponse.getResponse();

	}

	@RequestMapping("/ratings")
	public List<AuthorRating> getAuthorsRatings() {
		
		bookResponse = new BookResponse();
		
		return bookResponse.authorRatings;
	}

}
