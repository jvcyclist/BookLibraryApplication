package pl.karas.BookLibraryApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pl.karas.BookLibraryApplication.BookResponse;
import pl.karas.BookLibraryApplication.entity.AuthorRating;
import pl.karas.BookLibraryApplication.entity.BookToSerialize;

@RestController
@RequestMapping("/api")
public class BookLibraryApplicationController {

	private BookResponse bookResponse;


	@RequestMapping("/books")
	public List<BookToSerialize> getBooks(@RequestParam(name = "category", defaultValue = "") String category,@RequestParam(name = "isbn", defaultValue = "") String isbn) {

		bookResponse = new BookResponse();

		if (!(category.isEmpty())){
			bookResponse.setResponse(new ArrayList<BookToSerialize>(bookResponse.filter.filterByCategory(category)));
		}

		if (!(isbn.isEmpty())) {
			bookResponse.setResponse(new ArrayList<BookToSerialize>(bookResponse.filter.filterByISBN(isbn)));
		}
		if (bookResponse.getResponse().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
		}
		else {
			return bookResponse.getResponse();
		}

	}

	@RequestMapping("/booksratings")
	public List<AuthorRating> getAuthorsRatings() {
		
		bookResponse = new BookResponse();
		
		return bookResponse.authorRatings;
	}

}
