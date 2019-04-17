package pl.karas.BookLibraryApplication.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;


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

}