package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gr.iti.mklab.framework.common.domain.JSONable;

public class Feed implements JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8972611573430977057L;

	
	@Expose
    @SerializedName(value = "id")
	protected String id = null;
	
	@Expose
    @SerializedName(value = "dateToRetrieve")
	protected Date dateToRetrieve = null;
	
	@Expose
    @SerializedName(value = "totalNumberOfItems")
	protected Integer totalNumberOfItems = 0;
	
	@Expose
    @SerializedName(value = "feedType")
	protected FeedType feedType;
	
	@Expose
    @SerializedName(value = "label")
	protected String label;
	
	public Feed(Date date, FeedType feedType) {
		this.dateToRetrieve = date;
		this.feedType = feedType;
		
	}
	
	public  FeedType getFeedtype() {
		return feedType;
	}
	
	public  void setFeedType(FeedType feedType) {
		this.feedType = feedType;
	}
	
	public  String getId() {
		return id;
	}
	
	public  void setId(String id) {
		this.id = id;
	}
	
	public  String getLabel() {
		return label;
	}
	
	public  void setLabel(String label) {
		this.label = label;
	}
	
	public Date getDateToRetrieve() {
		return dateToRetrieve;
	}
	
	public void setDateToRetrieve(Date dateToRetrieve) {
		this.dateToRetrieve = dateToRetrieve;
	}
	
	public  Integer getTotalNumberOfItems() {
		return this.totalNumberOfItems;
	}
	
	public  void setTotalNumberOfItems(Integer totalNumberOfItems) {
		this.totalNumberOfItems += totalNumberOfItems;
	}
	
	@Override
	public String toJSONString() {
        Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
        return gson.toJson(this);
	}
	
	public enum FeedType {
		LOCATION, KEYWORDS, ACCOUNT, URL, LIST
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}
		
        return ((Feed) obj).id.equals(id);
    }
}
