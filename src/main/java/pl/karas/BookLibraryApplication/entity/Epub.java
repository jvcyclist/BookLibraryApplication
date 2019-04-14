package pl.karas.BookLibraryApplication.entity;

public class Epub
{
    private String isAvailable;

    private String acsTokenLink;

    public String getIsAvailable ()
    {
        return isAvailable;
    }

    public void setIsAvailable (String isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink ()
    {
        return acsTokenLink;
    }

    public void setAcsTokenLink (String acsTokenLink)
    {
        this.acsTokenLink = acsTokenLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [isAvailable = "+isAvailable+", acsTokenLink = "+acsTokenLink+"]";
    }
}
			
		