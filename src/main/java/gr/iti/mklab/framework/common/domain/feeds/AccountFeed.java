package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

public class AccountFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865708239941324229L;
	
	private String username = null;
	
	public AccountFeed() {
		
	}
	
	public AccountFeed(String id, String username, Date since) {
		super(id, since);

		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

}
