package gr.iti.mklab.framework.common.domain;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class Message extends JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4667070758908298510L;

	private String id;

	private Action action;
	
	public Message() {
		
	}
	
	public enum Action {
		NEW, UPDATE, DELETE
	}

	public String getId(){
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Action getAction() {
		return action;
	}
	
	public void setAction(Action action) {
		this.action = action;
	}

}
