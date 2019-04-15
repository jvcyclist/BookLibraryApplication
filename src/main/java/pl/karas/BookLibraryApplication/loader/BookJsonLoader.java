package pl.karas.BookLibraryApplication.loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.karas.BookLibraryApplication.entity.Book;

public class BookJsonLoader {

	ObjectMapper mapper = new ObjectMapper();
	
	List<Book> books = new ArrayList<Book>();
	
	String pathJson = System.getProperty("user.dir")+"/src/main/resources/books.json";
	
	public BookJsonLoader() throws JsonParseException, JsonMappingException, IOException {
		
		 books = (List<Book>) mapper.readValue(new File(pathJson), Book.class);
 			 
	}
	
	public void printBooks() {
		
		for(Book t : books) {
			System.out.println(t.toString());
			
		}
		
	}
	
	
	
	
}
