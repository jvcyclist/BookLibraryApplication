package pl.karas.BookLibraryApplication.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import pl.karas.BookLibraryApplication.BookSupport;
import pl.karas.BookLibraryApplication.entity.AuthorRating;
import pl.karas.BookLibraryApplication.entity.BookSerialize;

@RestController
public class BookLibraryApplicationController {
	
	private BookSupport books = new BookSupport();
	
	@RequestMapping("/book")
	public List<BookSerialize> getBook(@RequestParam(value="isbn", defaultValue="") String isbn,@RequestParam(value="title", defaultValue="") String title, @RequestParam(value="category", defaultValue="") String category) {
		
		if(!(isbn.equals(""))) {
			return BookSupport.books = new ArrayList<BookSerialize>(BookSupport.filter.filterByISBN(isbn));	
		}

		if (BookSupport.books.isEmpty()){
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}

			return books.books = new ArrayList<BookSerialize>(books.filter.filterByCategory(category.toLowerCase()));
		//return books.books = new ArrayList<BookSerialize>(books.filter.filterByTitle(title));
	}
	
	@RequestMapping("/ratings")
	public List<AuthorRating> getAuthorsRatings(){
		
		return books.authorRatings;
	}
	
}
