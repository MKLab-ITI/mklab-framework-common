package gr.iti.mklab.framework.common.domain.feeds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class KeywordsFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054548274586004413L;

	private List<String> keywords = new ArrayList<String>();
	
	public KeywordsFeed(String keyword, Date since, String id) {
		super(since, Feed.FeedType.KEYWORDS);
		this.keywords.add(keyword);
		this.id = id;
	}
	
	public KeywordsFeed(List<String> keywords, Date since, String id) {
		super(since, Feed.FeedType.KEYWORDS);
		this.keywords.addAll(keywords);
		this.id = id;
	}
	
	public List<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(List<String> keywords) {
		this.keywords.clear();
		this.keywords.addAll(keywords);
	}
	
	public void addKeywords(List<String> keywords) {
		this.keywords.addAll(keywords);
	}
	
	public void addKeyword(String keyword) {
		this.keywords.add(keyword);
	}
}
