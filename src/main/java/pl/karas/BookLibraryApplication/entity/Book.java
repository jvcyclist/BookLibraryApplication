package pl.karas.BookLibraryApplication.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * @author patryk
 *
 */


@JsonPropertyOrder({ "isbn", "volumeInfo" })
public class Book
{
	private String id;
	
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private VolumeInfo volumeInfo;

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	@JsonGetter("isbn")
	public String getId() {
		return id;
	}

	@JsonSetter("id")
	public void setId(String id) { 
 
		this.id = id;
	}

	public void setIsbn(){
		if(volumeInfo.getISBN13()!=null) {
		this.id = volumeInfo.getISBN13();}
	}

	@Override
	public String toString() {

		return
				"-------------------------------------------------------------------\n\n"+
				"Book id: " + id + "\n " +
				"Book title: " + volumeInfo.getTitle() + "\n " +
				"Book subtitle: " + volumeInfo.getSubtitle() + "\n " +
				"Book publisher: " + volumeInfo.getPublisher() + "\n " +
				"Book publishedDate: " + volumeInfo.getPublishedDate() + "\n " +
				"Book description: " + volumeInfo.getDescription() + "\n " +
				"Book pageCount: " + volumeInfo.getPageCount()+ "\n " +
				"Book thumbnailUrl: " + volumeInfo.getImageLinks().getThumbnail() + "\n " +
				"Book langauge: " + volumeInfo.getLanguage() + "\n " +
				"Book previewLink: " + volumeInfo.getPreviewLink() + "\n " +
				"Book averageRating: " + volumeInfo.getAverageRating() + "\n " +
				"Book authors: " + Arrays.toString(volumeInfo.getAuthors()) + "\n " +
				"Book categories: " + Arrays.toString(volumeInfo.getCategories()) + "\n " +
				"-------------------------------------------------------------------\n\n\n"
				;
		
	}

	
}