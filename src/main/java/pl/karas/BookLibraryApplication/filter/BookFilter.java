package pl.karas.BookLibraryApplication.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.karas.BookLibraryApplication.entity.BookToSerialize;

public class BookFilter {

	private List<BookToSerialize> books = new ArrayList<BookToSerialize>();

	private List<BookToSerialize> filteredBooks = new ArrayList<BookToSerialize>();

	public List<BookToSerialize> filterByCategory(String category) {

		this.filteredBooks = books.stream().filter(x -> x.isFromCategory(category.toLowerCase()))
								  .collect(Collectors.toList());

		return this.filteredBooks;
	}

	public List<BookToSerialize> filterByISBN(String isbn) {

		this.filteredBooks = books.stream().filter(x -> x.getIsbn().toLowerCase().contains(isbn.toLowerCase()))
								  .collect(Collectors.toList());

		return this.filteredBooks;
	}

	public List<BookToSerialize> getBooks() {
		return books;
	}

	public void setBooks(List<BookToSerialize> books) {
		this.books = books;
	}

	public List<BookToSerialize> getFilteredBooks() {
		return filteredBooks;
	}

	public void setFilteredBooks(List<BookToSerialize> filteredBooks) {
		this.filteredBooks = filteredBooks;
	}

}
