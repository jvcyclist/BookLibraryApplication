package pl.karas.BookLibraryApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.karas.BookLibraryApplication.entity.AuthorRating;
import pl.karas.BookLibraryApplication.entity.Book;
import pl.karas.BookLibraryApplication.entity.BookToSerialize;
import pl.karas.BookLibraryApplication.entity.JsonMain;
import pl.karas.BookLibraryApplication.filter.BookFilter;

public class BookResponse {

	static ObjectMapper mapper = new ObjectMapper();

	public BookFilter filter = new BookFilter();

	private List<JsonMain> items = new ArrayList<JsonMain>();

	private List<BookToSerialize> response = new ArrayList<BookToSerialize>();

	static String pathJsonRead = System.getProperty("user.dir") + "/src/main/resources/books.json";

	public List<AuthorRating> authorRatings = new ArrayList<AuthorRating>();

	public List<BookToSerialize> getResponse() {
		return response;
	}

	public void setResponse(List<BookToSerialize> response) {
		this.response = response;
	}

	public List<AuthorRating> getAuthorRatings() {
		return authorRatings;
	}

	public void setAuthorRatings(List<AuthorRating> authorRatings) {
		this.authorRatings = authorRatings;
	}

	public BookResponse() {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		try {
			items = mapper.readValue(new File(pathJsonRead), new TypeReference<ArrayList<JsonMain>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		setIsbnOfBooks();
		mappingInputBookToOutput();

		filter.setBooks(response);

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
			response.add(new BookToSerialize(b));
		}

	}

    public void mappingBookSerializeToAuthors() {

		for (BookToSerialize b : response) {

			if ((b.hasAuthors()) && (b.hasRating())) {

				for (int i = 0; i < b.getAuthors().length; i++) {
					authorRatings.add(new AuthorRating(b.getAuthors()[i], b.getAverageRating()));
				}

			}

		}

	}

	public void sortAuthorRatings() {
		authorRatings = authorRatings.stream()
				.sorted(Comparator.comparing(AuthorRating::getAverageRating, Comparator.reverseOrder()))
				.collect(Collectors.toList());
	}

}
