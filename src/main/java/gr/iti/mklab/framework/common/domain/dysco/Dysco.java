package gr.iti.mklab.framework.common.domain.dysco;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import gr.iti.mklab.framework.common.domain.Account;
import gr.iti.mklab.framework.common.domain.JSONable;
import gr.iti.mklab.framework.common.domain.Location;
import gr.iti.mklab.framework.common.domain.feeds.AccountFeed;
import gr.iti.mklab.framework.common.domain.feeds.Feed;
import gr.iti.mklab.framework.common.domain.feeds.KeywordsFeed;
import gr.iti.mklab.framework.common.domain.feeds.LocationFeed;

/**
 * @author	Manos Schinas
 * 
 * @email	manosetro@iti.gr
 *
 */
@Entity(noClassnameStored = true)
public class Dysco extends JSONable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8830711950312367090L;

	public Dysco() {

    }

    public Dysco(String id, Date date) {
        this.id = id;
        this.creationDate = date;
        this.updateDate = date;
    }

    //The id of the dysco
    @Id
    protected String id;
    
    //The creation date of the dysco
    protected Date creationDate;

    //The date that the dysco was last updated)
    protected Date updateDate;
    
    //The title of the dysco, set by the user
    protected String title;

    // The user that created the dysco
    protected String ownerId;
    
    // Fields that used for collection and retrieval of items
    
    // Keywords used to collect items 
    protected Map<String, String> keywords = new HashMap<String, String>();
    
    // Accounts to follow
    protected List<Account> accounts = new ArrayList<Account>();

    // Locations that used for the collection of Items
    private List<Location> nearLocations = new ArrayList<Location>();

    // Exclude specific keywords from 
    private List<String> keywordsToExclude = new ArrayList<String>();

    // Retrieve items in time range [since- until]
    protected Date sinceDate;
    
    /**
     * Returns the id of the dysco
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the dysco
     *
     * @param id
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Returns the id of the dysco
     *
     * @return String
     */
    public String geOwnertId() {
        return ownerId;
    }

    /**
     * Sets the id of the dysco
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Returns the creation date of the dysco
     *
     * @return Date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the dysco
     *
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the since date of the dysco
     *
     * @return Date
     */
    public Date getSinceDate() {
        return sinceDate;
    }

    /**
     * Sets the since date of the dysco
     *
     * @param creationDate
     */
    public void setSinceDate(Date sinceDate) {
        this.sinceDate = sinceDate;
    }
    
    /**
     * Returns the title of the dysco
     *
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the dysco
     *
     * @param Title
     */
    public void setTitle(String Title) {
        this.title = Title;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Returns the date that dysco was last updated.
     *
     * @return
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the date that dysco was last updated.
     *
     * @return
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setKeywords(Map<String, String> keywords) {
        this.keywords = keywords;
    }

    public Map<String, String> getKeywords() {
        return this.keywords;
    }
    
    public List<Location> getNearLocations() {
        return nearLocations;
    }

    public void setNearLocations(List<Location> nearLocations) {
        this.nearLocations = nearLocations;
    }
    
    public void setKeywordsToExclude(List<String> keywordsToExclude) {
        this.keywordsToExclude = keywordsToExclude;
    }

    public List<String> getKeywordsToExclude() {
        return this.keywordsToExclude;
    }
    
    public List<Feed> getFeeds() {
    	List<Feed> feeds = new ArrayList<Feed>();
    	
    	for(Entry<String, String> keyword : keywords.entrySet()) {
    		String id = keyword.getValue() + "#" + keyword.getKey();
    		Feed feed = new KeywordsFeed(id, keyword.getKey(), sinceDate);
    		feed.setSource(keyword.getValue());
    		
    		feeds.add(feed);
    	}
    	
    	for(Account account : accounts) {
    		Feed feed = new AccountFeed(account.getId(), account.getName(), sinceDate);
    		feed.setSource(account.getSource().name());
    		
    		feeds.add(feed);
    	}
    	
    	for(Location location : nearLocations) {
    		Feed feed = new LocationFeed(null, location, sinceDate);
    		feeds.add(feed);
    	}
    	
    	return feeds;
    }
}
