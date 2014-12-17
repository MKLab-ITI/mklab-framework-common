
package gr.iti.mklab.framework.common.domain;

import java.io.Serializable;

import org.mongodb.morphia.Morphia;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;


/**
 * 
 * @author etzoannos - e.tzoannos@atc.gr
 */

public class JSONable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3056665779688434226L;
	
	private static Morphia morphia = new Morphia();

	@Override
	public String toString() {
		synchronized(morphia) {
			DBObject obj = morphia.toDBObject(this);
			return obj.toString();
		}
	}
    
	public static <K> K toObject(String json, Class<K> clazz) {
		synchronized(morphia) {
			DBObject obj = (DBObject) JSON.parse(json);
			return morphia.fromDBObject(clazz, obj);
		}
	}
	
}