package pl.karas.BookLibraryApplication.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.karas.BookLibraryApplication.entity.Book;
import pl.karas.BookLibraryApplication.entity.BookSerialize;
import pl.karas.BookLibraryApplication.entity.JsonMain;
import pl.karas.BookLibraryApplication.filter.BookFilter;

@RestController
public class BookLibraryApplicationController {
	
static ObjectMapper mapper = new ObjectMapper();
	
	static BookFilter filter = new BookFilter();

	static List<JsonMain> items = new ArrayList<JsonMain>();
	
	static List<BookSerialize> books = new ArrayList<BookSerialize>();

	static String pathJsonRead = System.getProperty("user.dir") + "/src/main/resources/books.json";
	
	//static String pathJsonSave = System.getProperty("user.dir") + "/src/main/resources/books2.json";

	public BookLibraryApplicationController() throws JsonParseException, JsonMappingException, IOException {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		      .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		items = mapper.readValue(new File(pathJsonRead), new TypeReference<ArrayList<JsonMain>>(){});

		for(JsonMain i: items) {
			i.setISBN();
		}
		
		for(Book b: items.get(0).getBooks()) {
			books.add(new BookSerialize(b));
		}
		
		filter.setBooks(books);
	
	}
	
	@RequestMapping("/book")
	public List<BookSerialize> getBook(@RequestParam(value="isbn", defaultValue="") String isbn) {

		return books = new ArrayList<BookSerialize>(filter.filterByISBN(isbn));
	}

}
