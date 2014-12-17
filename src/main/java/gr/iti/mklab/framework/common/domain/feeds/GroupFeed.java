package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

public class GroupFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876101187566475910L;
	
	private String groupId;
	private String groupCreator;
	
	public GroupFeed(String url, Date since, String id) {
		super(since, Feed.FeedType.GROUP);
		this.id = id;
		
		String twitterRegex = "https://twitter.com/";
		String restString = url.replace(twitterRegex, "");
		int index = restString.indexOf("/");
	
		this.groupCreator = restString.substring(0, index);
	
		String creatorRegex = groupCreator+"/lists/";
	
		this.id = restString.replace(creatorRegex, "");
		
	}

	public GroupFeed(String groupCreator, String groupId, Date since, String id) {
		super(since, Feed.FeedType.GROUP);
		this.id = id;
		this.groupCreator = groupCreator;
		this.groupId = groupId;
	}

	public String getGroupCreator() {
		return groupCreator;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
}
