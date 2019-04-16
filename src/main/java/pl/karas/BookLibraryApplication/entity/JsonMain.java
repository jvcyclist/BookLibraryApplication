package pl.karas.BookLibraryApplication.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class JsonMain {

	@JsonProperty("items")
	private List<Book> books;
	
	@JsonIgnore
    private String requestedUrl;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getRequestedUrl() {
		return requestedUrl;
	}

	public void setRequestedUrl(String requestedUrl) {
		this.requestedUrl = requestedUrl;
	}
	
	public void setISBN() {                   
		for(Book b : books) {
			b.setIsbn();
		}
	}
	
}
    



