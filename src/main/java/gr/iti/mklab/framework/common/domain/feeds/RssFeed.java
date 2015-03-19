package gr.iti.mklab.framework.common.domain.feeds;


public class RssFeed extends Feed {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6084756784860676248L;

	private String url = null;
	
	public RssFeed() {
		
	}
	
	public RssFeed(String id, String url, long since, String source) {
		super(id, since, source);
		
		this.url = url;
	}

	public String getURL() {
		return this.url;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
}
