package pl.karas.BookLibraryApplication.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonInclude(Include.NON_NULL)
public class VolumeInfo {
	private String title;

	private String subtitle;

	private String publisher;

	@JsonInclude(Include.NON_DEFAULT)
	private long publishedDate;

	private String description;
	
	@JsonInclude(Include.NON_DEFAULT)
	private int pageCount;

	@JsonProperty(access = Access.WRITE_ONLY)
	private IndustryIdentifiers[] industryIdentifiers;

	@JsonUnwrapped
	@JsonProperty("imageLinks")
	private ImageLinks imageLinks;

	private String language;

	private String previewLink;

	@JsonInclude(Include.NON_DEFAULT)
	private double averageRating;

	private String[] authors;

	private String[] categories;
	
	long unixTime = 0;

	public IndustryIdentifiers[] getIndustryIdentifiers() {
		return industryIdentifiers;
	}

	public void setIndustryIdentifiers(IndustryIdentifiers[] industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ImageLinks getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(ImageLinks imageLinks) {
		this.imageLinks = imageLinks;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public long getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = parseToUnix(publishedDate);
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getISBN13() {
		for (IndustryIdentifiers ii : industryIdentifiers) {
			if (ii.isIBN13()) {
				return ii.getIdentifier();
			}
		}
		return null;
	}
	
	public long parseToUnix(String input) {
		
		DateFormat dateFormat;

		Date date = null;
		if(input==null) {
	
		}
		if (input.length()==4) {
			dateFormat = new SimpleDateFormat("yyyy");
		}
		else {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
	    
		try {
			date = dateFormat.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return unixTime = (long) date.getTime();
	}

}