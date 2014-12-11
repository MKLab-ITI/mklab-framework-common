
package gr.iti.mklab.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author etzoannos - e.tzoannos@atc.gr
 */

public class Keyword implements JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7993097182905827296L;

	@Expose
	@SerializedName(value = "keyword")
	private String keyword;

	@Expose
	@SerializedName(value = "label")
	private String label;
	
	public Keyword() {        
	 
	}
    
	public Keyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getName() {
		return keyword;
	}

	public void setName(String keyword) {
		this.keyword = keyword;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
        	.create();
		return gson.toJson(this);
	}  

}
