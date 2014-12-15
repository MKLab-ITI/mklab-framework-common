package gr.iti.mklab.framework.common.factories;


import org.mongodb.morphia.Morphia;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class ObjectFactory {

	private static Morphia morphia = new Morphia();
	
	public static <K> K toObject(String json, Class<K> clazz) {
		synchronized(morphia) {
			DBObject obj = (DBObject) JSON.parse(json);
			return morphia.fromDBObject(clazz, obj);
		}
	}
}
