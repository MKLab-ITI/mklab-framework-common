package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;
import org.mongodb.morphia.annotations.Entity;


import gr.iti.mklab.framework.common.domain.Account;

@Entity(noClassnameStored = true)
public class AccountFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865708239941324229L;
	
	private Account account = null;
	
	public AccountFeed(Account account, Date since, String id) {
		super(since, Feed.FeedType.ACCOUNT);
		this.id = id;
		this.account = account;
	}

	public Account getAccount() {
		return this.account;
	}
	
	public void setAccount(Account source) {
		this.account = source;
	}

}
