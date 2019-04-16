package pl.karas.BookLibraryApplication.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonInclude(Include.NON_NULL)
public class BookSerialize {
	
	private Book book;

	private String isbn;
	
	private String title;

	private String subtitle;

	private String publisher;

	@JsonInclude(Include.NON_DEFAULT)
	private long publishedDate;

	private String description;
	
	@JsonInclude(Include.NON_DEFAULT)
	private int pageCount;

	@JsonUnwrapped
	@JsonProperty("imageLinks")
	private String thumbnailUrl;

	private String language;

	private String previewLink;

	@JsonInclude(Include.NON_DEFAULT)
	private double averageRating;

	private String[] authors;

	private String[] categories;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(long publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public BookSerialize(Book book) {
		super();
		this.isbn = book.getId();
		this.title = book.getVolumeInfo().getTitle();
		this.subtitle = book.getVolumeInfo().getSubtitle();
		this.publisher = book.getVolumeInfo().getPublisher();
		this.publishedDate = book.getVolumeInfo().getPublishedDate();
		this.description = book.getVolumeInfo().getDescription();
		this.pageCount = book.getVolumeInfo().getPageCount();
		this.thumbnailUrl = book.getVolumeInfo().getImageLinks().getThumbnail();
		this.language = book.getVolumeInfo().getLanguage();
		this.previewLink = book.getVolumeInfo().getPreviewLink();
		this.averageRating = book.getVolumeInfo().getAverageRating();
		this.authors = book.getVolumeInfo().getAuthors();
		this.categories = book.getVolumeInfo().getCategories();
	}
	
	public boolean isFromCategory(String category) {
		
		if(category.isEmpty()) {return false;}
		
		if(Arrays.asList(categories).contains(category)) {return true;}
	
		else {
		return false;}       
	}
	
	
	
	
}
