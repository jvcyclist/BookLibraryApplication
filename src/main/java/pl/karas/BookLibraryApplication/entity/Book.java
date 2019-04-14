package pl.karas.BookLibraryApplication.entity;
public class Book{
    private SaleInfo saleInfo;

    private String kind;

    private VolumeInfo volumeInfo;

    private String etag;

    private String id;

    private AccessInfo accessInfo;

    private String selfLink;

    public SaleInfo getSaleInfo ()
    {
        return saleInfo;
    }

    public void setSaleInfo (SaleInfo saleInfo)
    {
        this.saleInfo = saleInfo;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public VolumeInfo getVolumeInfo ()
    {
        return volumeInfo;
    }

    public void setVolumeInfo (VolumeInfo volumeInfo)
    {
        this.volumeInfo = volumeInfo;
    }

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public AccessInfo getAccessInfo ()
    {
        return accessInfo;
    }

    public void setAccessInfo (AccessInfo accessInfo)
    {
        this.accessInfo = accessInfo;
    }

    public String getSelfLink ()
    {
        return selfLink;
    }

    public void setSelfLink (String selfLink)
    {
        this.selfLink = selfLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [saleInfo = "+saleInfo+", kind = "+kind+", volumeInfo = "+volumeInfo+", etag = "+etag+", id = "+id+", accessInfo = "+accessInfo+", selfLink = "+selfLink+"]";
    }
}
