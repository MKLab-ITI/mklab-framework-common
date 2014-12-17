package gr.iti.mklab.framework.common.domain;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored = true)
public class Location extends JSONable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -333964331364087658L;

	protected Coordinates coordinates = null;
	
	protected Double radius = null;
	
	protected String name = null;
	
	protected String city = null;
	
	protected String country = null;
	
	protected Double bbox[][] = null;
	
	protected Boolean inferred = false;
	
	public Location() {
		
	}
	
	public Location(String name) {
		this.name = name;
	}
	
	public Location(Double latitude, Double longitude) {
		coordinates = new Coordinates();
		coordinates.latitude = latitude;
		coordinates.longitude = longitude;
	}
	
	public Location(Double latitude, Double longitude, Double radius) {
		coordinates = new Coordinates();
		coordinates.latitude = latitude;
		coordinates.longitude = longitude;
		this.radius = radius;
	}
	
	public Location(Double latitude, Double longitude, String name) {
		coordinates = new Coordinates(latitude, longitude);
		this.name = name;
	}
	
	public Location(Double[][] bbox, String name) {
		if(bbox.length != 2 && bbox[0].length != 2){
			return;
		}
		this.name = name;
		this.bbox = bbox;
	
	}
	
	public void setLatitude(Double latitude) {
		if(coordinates==null)
			coordinates = new Coordinates();
		coordinates.latitude = latitude;
	}
	
	public void setLongitude(Double longitude) {
		if(coordinates==null)
			coordinates = new Coordinates();
		coordinates.longitude = longitude;
	}
	
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	public  void setName(String name) {
		this.name = name;
	}

	public  void setCityName(String city) {
		this.city = city;
	}
	
	public  void setCountryName(String country) {
		this.country = country;
	}
	
	public Double getLatitude() {
		if(coordinates==null)
			return null;
		return coordinates.latitude;
	}
	
	public Double getLongitude() {
		if(coordinates==null)
			return null;
		return coordinates.longitude;
	}
	
	public Double getRadius() {
		return radius;
	}
	
	public Double[][] getbbox() {
		return bbox;
	}
	
	public  String getName(){
		return name;
	}

	public  String getCityName(){
		return city;
	}
	
	public  String getCountryName(){
		return country;
	}
	
	@Entity(noClassnameStored = true)
	private static class Coordinates implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4394908733076702633L;
		
		public Coordinates() {
			
		}
		
		public Coordinates(Double latitude, Double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;
		}

		protected Double latitude = null;

		protected Double longitude = null;
	}
	

}
