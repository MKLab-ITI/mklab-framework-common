package gr.iti.mklab.framework.common.domain;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Transient;

/**
 * Represents a single social media post and acts as an envelop for the native object.
 *
 * @author 	Manos Schinas
 * @email	manosetro@iti.gr
 * 
 */

@Entity(noClassnameStored = true)
@Indexes({
	@Index("id, "), 
	@Index("-publicationTime"),
	@Index("uid, -publicationTime")
})
public class Item extends JSONable {

    /**
     *
     */
    private static final long serialVersionUID = -7934442049449016087L;

    public Item() {
    	
    }

    // Unique id of an instance with the following structure: StreamName#internalId
    @Id
    @Property("_id")
    protected ObjectId oid;
    
    @Property("id")
    protected String id;
    
    // The id of the original Item
    protected String reference;
    
    // The name of the stream that an Item comes from
    protected String source;
    
    // The title of an Item. It will be used just for searching and sentiment analysis. 
    protected String title;
    
    // A short description of an Item
    protected String description;
    
    // A set of tags associated with an Item
    protected String[] tags;
    
    // The SocialSensor internal id of the user => StreamName#userInternalId
    protected String uid;
    
    // A set of labels that indicate the feeds that are associated with this item
    protected List<String> labels;
    
    // A detailed instance of the user of an Item
    // This is not exposed in mongodb
    @Transient
    @Embedded
    protected StreamUser streamUser;
    
    // A set of user ids for the mentioned users
    protected String[] mentions;
    
    // If an Item is a reply to another Item this field
    // keeps the id of the user of the first Item
    protected String inReply;
    
    // The user id of the original Item
    protected String referencedUserId;
    
    // A list of URLs contained in the Item
    protected URL[] links;
    
    // The id of the original Item
    protected String url;
    
    
    // A set of WebPages contained in the Item
    // WebPage is a more detailed representation of URLs
    @Transient
    protected List<WebPage> webPages;
    
    // The publication time of an Item
    protected long publicationTime;
    
    // The last time this Item has been updated
    protected Date lastUpdated;
    
    // The time this Item has been inserted in the system
    protected long insertionTime;

    // The location associated with an Item.
    // Usually this field indicated the origin of the Item
    @Embedded
    protected Location location;
    
    // The text associated with an Item
    protected String text;
    
    // A list of media items contained in an Item
    // This is not exposed in mongodb 
    @Transient
    protected List<MediaItem> mediaItems = new ArrayList<MediaItem>();
    
    // A list of ids of the contained media items 
    protected List<String> mediaIds = new ArrayList<String>();
    
    // The sentiment of an Item
    protected String sentiment;
    
    // A list of representative keywords extracted from an Item
    protected List<String> keywords = new ArrayList<String>();
    
    // A list of named entities extracted from an Item
    @Embedded
    protected List<NamedEntity> entities;
    
    // The language of an Item
    protected String language;
    
    // An indicator whether an Item id original or a shared instance of a previous Item
    protected boolean original = true;
    
    // Popularity values 
    
    // Number of likes
    protected Long likes = 0L;
    
    // Number of the times an Item has been shared
    protected Long shares = 0L;
    
    // The Comments associated with an Item
    protected Long comments;
    
    // Getters  & Setters for the fields of this class
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getUserId() {
        return uid;
    }

    public void setUserId(String uid) {
        this.uid = uid;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
    	this.labels = new ArrayList<String>();
        this.labels.addAll(Arrays.asList(labels));
    }

    public void setLabel(String label) {
    	labels = new ArrayList<String>();
        labels.add(label);
    }
    
    public StreamUser getStreamUser() {
        return streamUser;
    }

    public void setStreamUser(StreamUser streamUser) {
        this.streamUser = streamUser;
    }

    public String[] getMentions() {
        return mentions;
    }

    public void setMentions(String[] mentions) {
        this.mentions = mentions;
    }

    public String getInReply() {
        return inReply;
    }

    public void setInReply(String inReply) {
        this.inReply = inReply;
    }

    public String getReferencedUserId() {
        return referencedUserId;
    }

    public void setReferencedUserId(String referencedUserId) {
        this.referencedUserId = referencedUserId;
    }

    public URL[] getLinks() {
        return links;
    }

    public void setLinks(URL[] links) {
        this.links = links;
    }

    public List<WebPage> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<WebPage> webPages) {
        this.webPages = webPages;
    }

    public long getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(long publicationTime) {
        this.publicationTime = publicationTime;
    }

    public long getInsertionTime() {
        return insertionTime;
    }

    public void setInsertionTime(long insertionTime) {
        this.insertionTime = insertionTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public List<String> getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(List<String> mediaIds) {
        this.mediaIds = mediaIds;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<NamedEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<NamedEntity> entities) {
        this.entities = entities;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getLatitude() {
        if (location == null) {
            return null;
        }
        return location.getLatitude();
    }

    public Double getLongitude() {
        if (location == null) {
            return null;
        }
        return location.getLongitude();
    }

    public String getLocationName() {
        if (location == null) {
            return null;
        }
        return location.getName();
    }

    public String getCountryName() {
        if (location == null) {
            return null;
        }
        return location.getCountryName();
    }

}
