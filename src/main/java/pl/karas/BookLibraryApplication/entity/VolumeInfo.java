package pl.karas.BookLibraryApplication.entity;

public class VolumeInfo
{
    private IndustryIdentifiers[] industryIdentifiers;

    private String printType;

    private ReadingModes readingModes;

    private String previewLink;

    private String canonicalVolumeLink;

    private String language;

    private String title;

    private ImageLinks imageLinks;

    private String publisher;

    private String maturityRating;

    private String allowAnonLogging;

    private String contentVersion;

    private String infoLink;

    public IndustryIdentifiers[] getIndustryIdentifiers ()
    {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers (IndustryIdentifiers[] industryIdentifiers)
    {
        this.industryIdentifiers = industryIdentifiers;
    }

    public String getPrintType ()
    {
        return printType;
    }

    public void setPrintType (String printType)
    {
        this.printType = printType;
    }

    public ReadingModes getReadingModes ()
    {
        return readingModes;
    }

    public void setReadingModes (ReadingModes readingModes)
    {
        this.readingModes = readingModes;
    }

    public String getPreviewLink ()
    {
        return previewLink;
    }

    public void setPreviewLink (String previewLink)
    {
        this.previewLink = previewLink;
    }

    public String getCanonicalVolumeLink ()
    {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink (String canonicalVolumeLink)
    {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public ImageLinks getImageLinks ()
    {
        return imageLinks;
    }

    public void setImageLinks (ImageLinks imageLinks)
    {
        this.imageLinks = imageLinks;
    }

    public String getPublisher ()
    {
        return publisher;
    }

    public void setPublisher (String publisher)
    {
        this.publisher = publisher;
    }

    public String getMaturityRating ()
    {
        return maturityRating;
    }

    public void setMaturityRating (String maturityRating)
    {
        this.maturityRating = maturityRating;
    }

    public String getAllowAnonLogging ()
    {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging (String allowAnonLogging)
    {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion ()
    {
        return contentVersion;
    }

    public void setContentVersion (String contentVersion)
    {
        this.contentVersion = contentVersion;
    }

    public String getInfoLink ()
    {
        return infoLink;
    }

    public void setInfoLink (String infoLink)
    {
        this.infoLink = infoLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [industryIdentifiers = "+industryIdentifiers+", printType = "+printType+", readingModes = "+readingModes+", previewLink = "+previewLink+", canonicalVolumeLink = "+canonicalVolumeLink+", language = "+language+", title = "+title+", imageLinks = "+imageLinks+", publisher = "+publisher+", maturityRating = "+maturityRating+", allowAnonLogging = "+allowAnonLogging+", contentVersion = "+contentVersion+", infoLink = "+infoLink+"]";
    }
}