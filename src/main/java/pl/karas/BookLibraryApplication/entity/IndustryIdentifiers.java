package pl.karas.BookLibraryApplication.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonInclude(Include.NON_NULL)
public class IndustryIdentifiers
{
	
	@JsonProperty(access = Access.WRITE_ONLY)
    private String identifier;


	@JsonProperty(access = Access.WRITE_ONLY)
    private String type;


    public String getIdentifier ()
    {
        return identifier;
    }
    
    public void setIdentifier (String identifier)
    {
        this.identifier = identifier;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public boolean isIBN13() {
    	if (this.getType().equals("ISBN_13")){
    		return true;
    	}
    	return false;
    	
    }
    
}