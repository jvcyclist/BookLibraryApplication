package pl.karas.BookLibraryApplication.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonInclude(Include.NON_NULL)
public class ImageLinks
{
    private String thumbnail;

    @JsonGetter("thumbnailUrl")
    public String getThumbnail ()
    {
        return thumbnail;
    }

    @JsonSetter("thumbnail")
    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }



}