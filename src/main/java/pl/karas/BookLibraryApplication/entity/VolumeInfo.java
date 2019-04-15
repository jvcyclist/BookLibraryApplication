package pl.karas.BookLibraryApplication.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VolumeInfo
{
    private IndustryIdentifiers[] industryIdentifiers;

    private String pageCount;

    private String previewLink;

    private String language;

    private String title;

    private ImageLinks imageLinks;

    private String subtitle;

    private String publishedDate;
    
    private String publisher;
    
    private String description;

    private String[] categories;

    private String[] authors;
    
    private double averageRating;

	public IndustryIdentifiers[] getIndustryIdentifiers() {
		return industryIdentifiers;
	}

	public void setIndustryIdentifiers(IndustryIdentifiers[] industryIdentifiers) {
		this.industryIdentifiers = industryIdentifiers;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
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

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
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
	
	public String getISBN13(){
		
		for(IndustryIdentifiers ii : industryIdentifiers) {
			
			if(ii.getType().equals("ISBN_13")) {
				return ii.getIdentifier();
			}
			
		}

		return null;
		
	}
	
	
	

}