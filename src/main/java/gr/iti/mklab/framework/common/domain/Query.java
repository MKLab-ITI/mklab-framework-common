package gr.iti.mklab.framework.common.domain;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class Query implements JSONable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7635308767990413659L;

	public Query() {
		
	}
	
	public Query(String name,Double score) {
		this.name = name;
		this.score = score;
	}
	
    protected String name;

    protected Double score;
	
    protected Type type;
	
    protected Double[] coords;

    protected boolean fromExpansion = false;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setLocationCoords(Double[] coords){
		this.coords = coords;
	}
	
	public Double[] getLocationCoords() {
		return this.coords;
	}
	
	public void setIsFromExpansion(boolean fromExpansion) {
		this.fromExpansion = fromExpansion;
	}
	
	public boolean getIsFromExpansion() {
		return this.fromExpansion;
	}
	
 	
 	public enum Type {
 		Keywords, TwitterUsers, TwitterMentions, TwitterList, Location, URL, Contributors
 	}

}
