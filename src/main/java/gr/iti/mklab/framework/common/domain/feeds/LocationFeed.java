package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;


import gr.iti.mklab.framework.common.domain.Location;

@Entity(noClassnameStored = true)
public class LocationFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6371051856398652350L;
	
	private Location location;
	
	public LocationFeed(Location location, Date since, String id) {
		super(since, Feed.FeedType.LOCATION);
		this.location = location;
		this.id = id;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
