package pl.karas.BookLibraryApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.karas.BookLibraryApplication.entity.AuthorRating;
import pl.karas.BookLibraryApplication.entity.Book;
import pl.karas.BookLibraryApplication.entity.BookSerialize;
import pl.karas.BookLibraryApplication.entity.JsonMain;
import pl.karas.BookLibraryApplication.filter.BookFilter;

public class BookSupport {
	
	static ObjectMapper mapper = new ObjectMapper();

	public static BookFilter filter = new BookFilter();

	static List<JsonMain> items = new ArrayList<JsonMain>();

	public static List<BookSerialize> books = new ArrayList<BookSerialize>();

	static String pathJsonRead = System.getProperty("user.dir") + "/src/main/resources/books.json";

	public static List<AuthorRating> authorRatings = new ArrayList<AuthorRating>();

	public BookSupport() {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		try {
			items = mapper.readValue(new File(pathJsonRead), new TypeReference<ArrayList<JsonMain>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIsbnOfBooks();
		mappingInputBookToOutput();

		filter.setBooks(books);

		mappingBookSerializeToAuthors();
		sortAuthorRatings();

	}

	private void setIsbnOfBooks() {
		for (JsonMain i : items) {
			i.setISBN();
		}
	}

	public void mappingInputBookToOutput() {

		for (Book b : items.get(0).getBooks()) {
			books.add(new BookSerialize(b));
		}
	}

	public void mappingBookSerializeToAuthors() {

		for (BookSerialize b : books) {

			if ((b.hasAuthors()) && (b.hasRating())) {

				for (int i = 0; i < b.getAuthors().length; i++) {
					authorRatings.add(new AuthorRating(b.getAuthors()[i], b.getAverageRating()));
				}

			}

		}

	}

	public void sortAuthorRatings() {

		authorRatings = authorRatings.stream().sorted(new Comparator<AuthorRating>() {

			@Override
			public int compare(AuthorRating a1, AuthorRating a2) {
				
				if(a1.getAverageRating() < a2.getAverageRating()) return -1;
				if(a1.getAverageRating() > a2.getAverageRating()) return 1;
				return 0;

			}

		}).collect(Collectors.toList());

	}

}
