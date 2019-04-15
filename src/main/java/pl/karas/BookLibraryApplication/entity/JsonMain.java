package pl.karas.BookLibraryApplication.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMain {
	
	@JsonProperty("items")
	private Book[] books;

	private int counter=0;
	
    private String requestedUrl;

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
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
		
		for(Book b:books) {
			b.setISBN();
		}
		
	}
	
	
	
}
    



