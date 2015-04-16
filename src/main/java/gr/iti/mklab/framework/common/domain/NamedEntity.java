package gr.iti.mklab.framework.common.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
*
* @author Manos Schinas - manosetro@iti.gr
* 
*/
@Entity(noClassnameStored = true)
@Embedded
public class NamedEntity extends JSONable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8567813006640515534L;
	
    private String name;
    private Integer count = 1;
    private Type type;

    public NamedEntity() {
    	
    }
    
    public NamedEntity(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public NamedEntity(String name, int count, Type type) {
        this.name = name;
        this.count = count;
        this.type = type;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cont
     */
    public int getCount() {
        return count;
    }

    /**
     * @param cont the cont to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        PERSON, LOCATION, ORGANIZATION
    }

}
