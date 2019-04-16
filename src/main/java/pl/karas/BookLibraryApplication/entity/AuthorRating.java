package pl.karas.BookLibraryApplication.entity;

public class AuthorRating {
	
	private String author;
	
	private double averageRating;
	
	public AuthorRating(String author, double averageRating) {
		super();
		this.author = author;
		this.averageRating = averageRating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {                                                                                                                                                 	
		this.averageRating = averageRating;
	}

}
