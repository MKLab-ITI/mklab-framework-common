package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gr.iti.mklab.framework.common.domain.Account;

public class AccountFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865708239941324229L;
	
	@Expose
    @SerializedName(value = "account")
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
