package gr.iti.mklab.framework.common.domain;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;

/**
*
* @author cmartin - email: c.j.martin-dancausa@rgu.ac.uk
*/

@Entity(noClassnameStored = true)
public class NamedEntity implements Serializable, JSONable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8567813006640515534L;
	
    private String name;
    
    private Double count;
    
    private Type type;

    public NamedEntity(String name, double count, Type type) {
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
    public double getCount() {
        return count;
    }

    /**
     * @param cont the cont to set
     */
    public void setCount(double count) {
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

    public String toString() {
        return name + ": " + count;
    }

    public enum Type {

        PERSON, LOCATION, ORGANIZATION
    }

}
