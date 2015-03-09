package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

public class GroupFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876101187566475910L;
	
	private String groupId;
	private String groupCreator;

	public GroupFeed() {
		
	}
	
	public GroupFeed(String groupCreator, String groupId, Date since, String source) {
		super(groupCreator + "|" + groupId, since, source);
		
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
