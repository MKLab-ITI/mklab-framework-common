package gr.iti.mklab.framework.common.domain;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

/**
 *
 * @author 	Manos Schinas
 * @email	manosetro@iti.gr
 */

@Entity(noClassnameStored = true)
@Indexes(@Index("url"))
public class WebPage extends JSONable {

    /**
     *
     */
    private static final long serialVersionUID = -8783341713025378581L;

    // The URL of a WebPage. This is usually a short URL
    private String url;

    // The expanded version of URL
    private String expandedUrl;

    // The expanded version of URL
    private String domain;

    // The title extracted from the WebPage
    private String title;

    // The textual content of the web page
    private String text;

    // A flag that indicates whether this web page contains an article
    private boolean article;

    // Number of media contained in this web page
    private int media = 0;

    // Number of media contained in this web page
    private String[] mediaIds;

    // A representative mediaThumbnail
    private String mediaThumbnail;

    // The title extracted from the WebPage
    private String[] keywords;

    // The date that a web page shared for the first time
    private Date date;

    // The id of the Item that share a web page for the forst time
    private String reference;

    // The stream of the Item that the web page comes from 
    private String source;

    // The number of times a web page has been shared
    private int shares = 0;

    public WebPage(String url, String reference) {
        this.url = url;
        this.reference = reference;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpandedUrl() {
        return this.expandedUrl;
    }

    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isArticle() {
        return article;
    }

    public void setArticle(Boolean article) {
        this.article = article;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public String[] getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(String[] mediaIds) {
        this.mediaIds = mediaIds;
    }

    public String getMediaThumbnail() {
        return mediaThumbnail;
    }

    public void setMediaThumbnail(String mediaThumbnail) {
        this.mediaThumbnail = mediaThumbnail;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
