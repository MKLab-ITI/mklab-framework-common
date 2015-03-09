package gr.iti.mklab.framework.common.domain.feeds;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import gr.iti.mklab.framework.common.domain.JSONable;


@Entity(value="feeds", noClassnameStored=false)
public class Feed extends JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8972611573430977057L;

	@Id
	protected String id = null;

	protected Date since = null;

	protected String source = null;
	
	protected String label;
	
	public Feed() {
		
	}
	
	public Feed(String id, Date since, String source) {
		this.id = id;
		this.since = since;
		this.source = source;
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
	
	public Date getSinceDate() {
		return since;
	}
	
	public void setSinceDate(Date since) {
		this.since = since;
	}
	
	public  String getSource() {
		return source;
	}
	
	public  void setSource(String source) {
		this.source = source;
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
