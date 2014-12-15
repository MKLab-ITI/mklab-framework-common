package gr.iti.mklab.framework.common.domain.dysco;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import gr.iti.mklab.framework.common.domain.Account;
import gr.iti.mklab.framework.common.domain.Item;
import gr.iti.mklab.framework.common.domain.JSONable;
import gr.iti.mklab.framework.common.domain.Location;
import gr.iti.mklab.framework.common.domain.NamedEntity;
/**
 * @author	Manos Schinas
 * @email	manosetro@iti.gr
 *
 */
@Entity(noClassnameStored = true)
public class Dysco extends JSONable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8830711950312367090L;

	public Dysco() {

    }

    public Dysco(String id, Date date) {
        this.id = id;
        this.creationDate = date;
    }

    //The id of the dysco
    @Id
    protected String id;
    
    //The creation date of the dysco
    protected Date creationDate;

    //The date that the dysco was last updated)
    protected Date updateDate;

    //The title of the dysco
    protected String title;

    protected List<String> words = new ArrayList<String>();
    
    protected List<Account> accounts = new ArrayList<Account>();

    private List<Location> nearLocations = new ArrayList<Location>();

    private List<String> wordsToExclude = new ArrayList<String>();

    
    //Fields holding the information about the main context of the items that constitute the dysco
    //These fields are derived from the collected items that are associated with the specific dysco
    //and are updated dynamically as the dysco evolved over time
    
    //The extracted entities from items' content
    protected List<NamedEntity> entities = new ArrayList<NamedEntity>();
    //The users that contribute in social networks to dysco's topic
    protected List<String> contributors = new ArrayList<String>();
    //The extracted keywords from items' content with their assigned weights
    protected Map<String, Double> keywords = new HashMap<String, Double>();
    //The extracted tags from items' content with their assigned weights
    protected Map<String, Double> tags = new HashMap<String, Double>();
    //The extracted links from items' content with their assigned weights
    protected Map<String, Double> links = new HashMap<String, Double>();
    //The score that shows how trending the dysco is
    protected Double score;
    //The total number of items that constitute the dysco
    protected int itemsCount = 0;
    //List of the representative items that compose the Dysco
    protected List<Item> items = new ArrayList<Item>();
    
    /**
     * Returns the id of the dysco
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the dysco
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the creation date of the dysco
     *
     * @return Date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the dysco
     *
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the title of the dysco
     *
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the dysco
     *
     * @param Title
     */
    public void setTitle(String Title) {
        this.title = Title;
    }

    /**
     * Returns the score of the dysco
     *
     * @return Double
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the score of the dysco
     *
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * Returns the list of the dysco's entities
     *
     * @return List of Entity
     */
    public List<NamedEntity> getEntities() {
        return entities;
    }

    /**
     * Sets the entities of the dysco
     *
     * @param entities
     */
    public void setEntities(List<NamedEntity> entities) {
        this.entities = entities;
    }

    /**
     * Adds an entity to the dysco's list of entities
     *
     * @param entity
     */
    public void addEntity(NamedEntity entity) {
        entities.add(entity);
    }

    /**
     * Returns the list of contributors for the dysco
     *
     * @return List of String
     */
    public List<String> getContributors() {
        return contributors;
    }

    /**
     * Sets the contributors for the dysco
     *
     * @param contributors
     */
    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }

    /**
     * Returns the dysco's keywords with their assigned weights
     *
     * @return Map of String to Double
     */
    public Map<String, Double> getKeywords() {
        return keywords;
    }

    /**
     * Sets the keywords of the dysco with their assigned weights
     *
     * @param keywords
     */
    public void setKeywords(Map<String, Double> keywords) {
        this.keywords = keywords;
    }

    /**
     * Adds a keyword and its corresponding weight to the list of keywords of
     * the dysco
     *
     * @param keyword
     * @param weight
     */
    public void addKeyword(String keyword, Double weight) {
        this.keywords.put(keyword, weight);
    }

    /**
     * Return the dysco's hashtags with their assigned weights
     *
     * @return Map of String to Double
     */
    public Map<String, Double> getTags() {
        return tags;
    }

    /**
     * Sets the hashtags of the dysco with their assigned weights
     *
     * @param hashtags
     */
    public void setHashtags(Map<String, Double> tags) {
        this.tags = tags;
    }

    /**
     * Adds a hashtag and its corresponding weight to the list of hashtags of
     * the dysco
     *
     * @param hashtag
     * @param weight
     */
    public void addHashtag(String tag, Double weight) {
        this.tags.put(tag, weight);
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    
    /**
     * Return the list of items that compose the dysco
     *
     * @return
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the items that compose the dysco
     *
     * @param items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Adds an item to the list of items that compose the dysco
     *
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
    }

    /**
     * Returns the date that dysco was last updated.
     *
     * @return
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the date that dysco was last updated.
     *
     * @return
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Map<String, Double> getLinks() {
        return links;
    }

    public void setLinks(Map<String, Double> links) {
        this.links = links;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public List<Location> getNearLocations() {
        return nearLocations;
    }

    public void setNearLocations(List<Location> nearLocations) {
        this.nearLocations = nearLocations;
    }
    
    public void setWordsToExclude(List<String> wordsToExclude) {
        this.wordsToExclude = wordsToExclude;
    }

    public List<String> getWordsToExclude() {
        return this.wordsToExclude;
    }
    
}
