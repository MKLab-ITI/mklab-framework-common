package gr.iti.mklab.framework.common.domain;

import gr.iti.mklab.framework.common.domain.JSONable;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class Collection extends JSONable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4281954626238656052L;
	
	private List<JSONable> results = new ArrayList<JSONable>();
	
	public <K extends JSONable> void addResults(List<K> results) {
		this.results.addAll(results);
	}
}
