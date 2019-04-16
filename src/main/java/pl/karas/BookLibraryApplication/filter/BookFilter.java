package pl.karas.BookLibraryApplication.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.karas.BookLibraryApplication.entity.BookSerialize;

public class BookFilter {

	private List<BookSerialize> books = new ArrayList<BookSerialize>();

	private List<BookSerialize> filteredBooks = new ArrayList<BookSerialize>();

	public List<BookSerialize> filterByCategory(String category) {

		this.filteredBooks = books.stream().filter(x -> x.isFromCategory(category.toLowerCase()))
								  .collect(Collectors.toList());

		return this.filteredBooks;
	}

	public List<BookSerialize> filterByISBN(String isbn) {

		this.filteredBooks = books.stream().filter(x -> x.getIsbn().toLowerCase().contains(isbn.toLowerCase()))
								  .collect(Collectors.toList());

		return this.filteredBooks;
	}

	public List<BookSerialize> filterByTitle(String isbn) {

		this.filteredBooks = books.stream().filter(x -> x.getTitle().toLowerCase().contains(isbn.toLowerCase()))
								  .collect(Collectors.toList());

		return this.filteredBooks;
	}

	public List<BookSerialize> getBooks() {
		return books;
	}

	public void setBooks(List<BookSerialize> books) {
		this.books = books;
	}

	public List<BookSerialize> getFilteredBooks() {
		return filteredBooks;
	}

	public void setFilteredBooks(List<BookSerialize> filteredBooks) {
		this.filteredBooks = filteredBooks;
	}

}
