package gr.iti.mklab.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message implements JSONable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4667070758908298510L;

	@Expose
	@SerializedName(value = "id")
	String id;
	
	@Expose
	@SerializedName(value = "action")
	Action action;
	
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
	
    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

}
