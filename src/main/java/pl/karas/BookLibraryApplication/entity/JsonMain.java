package pl.karas.BookLibraryApplication.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonInclude(Include.NON_NULL)
public class JsonMain {

	@JsonProperty("items")
	private List<Book> books;

	private int counter=0;
	
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
	
	public void printBooks() {
		for(Book b:books) {
			System.out.println(counter);
			System.out.println(b.toString());
			counter++;
		}	
	}
	
	public void setISBN() {                   
		for(Book b : books) {
			b.setIsbn();
		}
	}
	
}
    



