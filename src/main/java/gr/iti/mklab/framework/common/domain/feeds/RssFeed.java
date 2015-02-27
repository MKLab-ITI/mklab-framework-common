package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

public class RssFeed extends Feed {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6084756784860676248L;

	private String url = null;
	
	public RssFeed() {
		
	}
	
	public RssFeed(String id, String url, Date since) {
		super(since);
		
		this.id = id;
		this.url = url;
	}

	public String getURL() {
		return this.url;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
}
