package gr.iti.mklab.framework.common.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class Cluster implements JSONable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7926531925761955502L;


	public Cluster(String id) {
		this.id = id;
	}
	
	// Unique id of a Media cluster
	private String id;

	private Set<String> members = new HashSet<String>();
	
	private int count = 0;
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Set<String> getMembers() {
        return members;
    }

    public void addMembers(Set<String> members) {
        this.members.addAll(members);
        this.count = this.members.size();
    }
    
    public void addMember(String member) {
        this.members.add(member);
        this.count = this.members.size();
    }
    
    public int getCount() {
        return count;
    }
	
}
