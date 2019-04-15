package pl.karas.BookLibraryApplication.entity;

import java.util.Arrays;

/**
 * @author patryk
 *
 */

public class Book
{
    private VolumeInfo volumeInfo;

    private String id;

	public VolumeInfo getVolumeInfo() {
		return volumeInfo;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo) {
		this.volumeInfo = volumeInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) { 
	
		this.id = id;
	}

	
	public void setISBN() {
		if(volumeInfo.getISBN13()!=null) {
			this.id = volumeInfo.getISBN13();
			}
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