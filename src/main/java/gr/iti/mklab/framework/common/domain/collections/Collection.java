package gr.iti.mklab.framework.common.domain.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.annotations.Entity;

import gr.iti.mklab.framework.common.domain.Account;
import gr.iti.mklab.framework.common.domain.JSONable;
import gr.iti.mklab.framework.common.domain.Location;
import gr.iti.mklab.framework.common.domain.Source;
import gr.iti.mklab.framework.common.domain.feeds.AccountFeed;
import gr.iti.mklab.framework.common.domain.feeds.Feed;
import gr.iti.mklab.framework.common.domain.feeds.KeywordsFeed;
import gr.iti.mklab.framework.common.domain.feeds.LocationFeed;
import gr.iti.mklab.framework.common.domain.feeds.RssFeed;

/**
 * @author	Manos Schinas - manosetro@iti.gr
 *
 */
@Entity(noClassnameStored = true)
public class Collection extends JSONable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8830711950312367090L;

	public Collection() {

    }

    public Collection(String id, Date date) {
        this.id = id;
        this.creationDate = date.getTime();
        this.updateDate = date.getTime();
    }
    
    // The creation date of the Topic
    protected Long creationDate;

    // The date that the Topic was last updated
    protected Long updateDate;
    
    //The title of the Topic, set by the user
    protected String title;

    // The user that created the Topic
    protected String ownerId;
    
    // The group id of the use that created the Topic
    protected String groupId;
    
    // The group id of the use that created the Topic
    protected String privacy = "private";	// private - protected - public
    
    protected Long lastRunningTime;
    
    // Fields that used for collection and retrieval of items
    
    // Keywords used to collect items 
    protected List<Keyword> keywords = new ArrayList<Keyword>();
    
    // Accounts to follow
    protected List<Account> accounts = new ArrayList<Account>();

    // Locations that used for the collection of Items
    private List<Location> nearLocations = new ArrayList<Location>();

    // Exclude specific keywords from the collection
    private List<String> keywordsToExclude = new ArrayList<String>();

    // Exclude specific items from the collection during retrieval
    private Set<String> itemsToExclude = new HashSet<String>();
    
    // Retrieve items in time range [since- until]
    protected long since;
    
    protected String status = "running";	//running/stopped

    public String getId() {
        return id;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String geOwnertId() {
        return ownerId;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Date getCreationDate() {
        return new Date(creationDate);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate.getTime();
    }

    public long getSinceDate() {
        return since;
    }

    public void setSinceDate(long sinceDate) {
        this.since = sinceDate;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Date getUpdateDate() {
        return new Date(updateDate);
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate.getTime();
    }

    public Long getLastRunningTime() {
        return lastRunningTime;
    }

    public void setLastRunningTime(Long lastRunningTime) {
        this.lastRunningTime = lastRunningTime;
    }
    
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<Keyword> getKeywords() {
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
	
	public Set<String> getItemsToExclude() {
		return itemsToExclude;
	}

	public void setItemsToExclude(Set<String> itemsToExclude) {
		this.itemsToExclude = itemsToExclude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
    public List<Feed> getFeeds() {
    	List<Feed> feeds = new ArrayList<Feed>();
    	
    	if(keywords != null) {
    		for(Keyword keyword : keywords) {
    			String[] sources = keyword.getSources();
    			if(sources == null) {
    				sources = Arrays.toString(Source.values()).replaceAll("^.|.$", "").split(", ");
    			}
    		
    			for(String source : sources) {
        			String id = source + "#" + keyword.getKeyword();
        			Feed feed = new KeywordsFeed(id, keyword.getKeyword(), since, source);
            		feeds.add(feed);
        		}
    		}
    	}
    	
    	if(accounts != null) {
    		for(Account account : accounts) {
    			String source = account.getSource().name();
    			if(source.equals("RSS")) {
    				RssFeed feed = new RssFeed(account.getId(), account.getUsername(), since);
    				feed.setName(account.getName());
    				feeds.add((Feed) feed);
    			}
    			else {
    				AccountFeed feed = new AccountFeed(account.getId(), account.getUsername(), since, source);
    				feeds.add((Feed) feed);
    			}
    		}
    	}
    	
    	if(nearLocations != null) {
    		for(Location location : nearLocations) {
    			Feed feed = new LocationFeed(null, location, since, null);
    			feeds.add(feed);
    		}
    	}
    	
    	return feeds;
    }
    
    public static void main(String[] args) {
    	Collection collection = new Collection();
    	
    	collection.setId("randomid_userid_timestamp");
    	collection.setCreationDate(new Date());
    	collection.setSinceDate(System.currentTimeMillis() - (7 * 24 * 3600 * 1000l));
    	
    	collection.setOwnerId("1234567890");
    	
    	collection.setTitle("ISIS Attacks");
    	
    	String[] sources = {"Twitter", "Youtube", "GooglePlus" };
    	
    	List<Keyword> k = new ArrayList<Keyword>();
    	k.add(new Keyword("isis", sources));
    	k.add(new Keyword("raqqa", sources));
    	k.add(new Keyword("paris attacks", sources));
    	
    	collection.setKeywords(k);
    	
    	List<Account> accounts = new ArrayList<Account>();
    	
    	Account a = new Account();
    	a.setId("xxxx");
    	a.setName("politico");
    	a.setSource("Twitter");
    	accounts.add(a);
    	
    	collection.setAccounts(accounts);
    	
    	System.out.println(collection.toString());
    }
    
    public static class Keyword {
    	
    	private String keyword;
    	private String[] sources;
    	
    	public Keyword() {
    		
    	}
    	
    	public Keyword(String keyword) {
    		this.keyword = keyword;
    	}
    	
    	public Keyword(String keyword, String[] sources) {
    		this.keyword = keyword;
    		this.sources = sources;
    	}
    	
		public String[] getSources() {
			return sources;
		}

		public void setSources(String[] sources) {
			this.sources = sources;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
    	
		public String toString() {
			return keyword;
		}
    }
}
