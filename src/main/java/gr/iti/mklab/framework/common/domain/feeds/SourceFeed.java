package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gr.iti.mklab.framework.common.domain.Account;

public class SourceFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865708239941324229L;
	
	@Expose
    @SerializedName(value = "source")
	private Account source = null;
	
	public SourceFeed(Account source, Date since, String id) {
		super(since, Feed.FeedType.SOURCE);
		this.source = source;
		this.id = id;
	}

	public Account getAccount() {
		return this.source;
	}
	
	public void setAccount(Account source) {
		this.source = source;
	}

}
