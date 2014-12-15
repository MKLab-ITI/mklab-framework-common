package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class URLFeed extends Feed {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6084756784860676248L;

	private String url = null;
	
	private String network = null;
	
	
	public URLFeed(String url, Date since, String id) {
		super(since, Feed.FeedType.URL);
		this.url = url;
		this.id = id;
	}

	public String getURL() {
		return this.url;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	public String getNetwork() {
		return this.network;
	}
	
	public void setNetwork(String network) {
		this.network = network;
	}
}
