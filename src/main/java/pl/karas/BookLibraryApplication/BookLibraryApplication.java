package pl.karas.BookLibraryApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.karas.BookLibraryApplication.entity.Book;
import pl.karas.BookLibraryApplication.entity.JsonMain;

@SpringBootApplication
public class BookLibraryApplication {

	static ObjectMapper mapper = new ObjectMapper();

	//@JsonProperty("items")
	static List<JsonMain> items = new ArrayList<JsonMain>();

	static String pathJsonRead = System.getProperty("user.dir") + "/src/main/resources/books.json";
	
	static String pathJsonSave = System.getProperty("user.dir") + "/src/main/resources/books2.json";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		      .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		items = mapper.readValue(new File(pathJsonRead), new TypeReference<ArrayList<JsonMain>>(){});
		
		
		
		
		
		for(JsonMain i:items) {
			i.setISBN();
			i.printBooks();
		}
		
		 //for test Json save
		mapper.writeValue(new File(pathJsonSave), items);

		
		SpringApplication.run(BookLibraryApplication.class, args);
	}

}
