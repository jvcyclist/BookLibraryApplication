package pl.karas.BookLibraryApplication;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BookLibraryApplicationTests {

	@LocalServerPort
	private int port = 8080;
	
	@Before
	public void setUp() throws Exception {
	    RestAssured.port = port;
	}
	
	@Test
	public void contextLoads() {
		
	}

	 @Test
	 public void isBookReturn200() {
		 given().when()
		 			.get("/book")
		 		.then().statusCode(200);
	 }
	 
	 @Test
	 public void isWrongIsbnReturn404() {
		 given().when()
		 			.get("/book?isbn=3455")
		 		.then().statusCode(404);
	 }
	 
	 @Test
	 public void isWrongCategoryReturn200() {
		 given().when()
		 			.get("/book?category=xxaaxx")
		 		.then().statusCode(200);
	 }
	 
	 @Test
	 public void isRatingsReturn400() {
		 given().when()
		 			.get("/ratings")
		 		.then().statusCode(200);
	 }
	 
	 @Test
	 public void isBookReturn200WithExpectedIsbnAndTitle() {
		 given().when()
		 			.get("/book?=isbn=9780080568782")
		 		.then().statusCode(200)
		 		.body("title", hasItems("TCP/IP Sockets in Java"));
	 }	 

}
