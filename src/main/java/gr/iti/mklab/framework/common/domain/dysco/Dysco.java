package gr.iti.mklab.framework.common.domain.dysco;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mongodb.morphia.annotations.Entity;

import gr.iti.mklab.framework.common.domain.Item;
import gr.iti.mklab.framework.common.domain.JSONable;
import gr.iti.mklab.framework.common.domain.Location;
import gr.iti.mklab.framework.common.domain.NamedEntity;
import gr.iti.mklab.framework.common.domain.Query;

/**
 * This class specifies a representation of the DySCO model, as defined by
 * SocialSensor consortium. The main content of a DySCO object is a set of
 * social network items (tweets, facebook status updates etc) It can also
 * contain several dimensions (Semantic, Social, Authority etc). A DySCO object
 * can be associated with other DySCOs based on community or content.
 *
 * @author etzoannos - e.tzoannos@atc.gr
 *
 */

@Entity(noClassnameStored = true)
public class Dysco implements JSONable {

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
    protected String id;
    
    //The creation date of the dysco
    protected Date creationDate;
    
    //The title of the dysco
    protected String title;
    
    //The score that shows how trending the dysco is
    protected Double score;

    //Fields holding the information about the main context 
    //of the items that constitute the dysco
    //The extracted entities from items' content
    protected List<NamedEntity> entities = new ArrayList<NamedEntity>();
    
    //The users that contribute in social networks to dysco's topic
    protected List<String> contributors = new ArrayList<String>();
    
    //The extracted keywords from items' content with their assigned weights
    protected Map<String, Double> keywords = new HashMap<String, Double>();
    
    //The extracted hashtags from items' content with their assigned weights
    protected Map<String, Double> hashtags = new HashMap<String, Double>();

    //The query that will be used for retrieving relevant content to the Dysco from Solr
    protected String solrQueryString = null;
    
    //The query that will be used for retrieving relevant author content to the Dysco from Solr
    protected String solrQueryAuthorString = null;

    protected List<Query> solrQueries = new ArrayList<Query>();

    //The date that the dysco was last created (updated because similar dyscos existed in the past)
    protected Date updateDate;

    protected Map<String, Double> links = new HashMap<String, Double>();

    protected int itemsCount = 0;
    
    protected String author = null;

    private List<Location> nearLocations = new ArrayList<Location>();

    private List<String> wordsToAvoid = new ArrayList<String>();
    
    //List of the items that compose the Dysco - serve for dysco's formulation, 
    //therefore they are stored temporarily in memory
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    public Map<String, Double> getHashtags() {
        return hashtags;
    }

    /**
     * Sets the hashtags of the dysco with their assigned weights
     *
     * @param hashtags
     */
    public void setHashtags(Map<String, Double> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * Adds a hashtag and its corresponding weight to the list of hashtags of
     * the dysco
     *
     * @param hashtag
     * @param weight
     */
    public void addHashtag(String hashtag, Double weight) {
        this.hashtags.put(hashtag, weight);
    }

    /**
     * Returns the query as a string for the retrieval of relevant content to
     * the dysco from solr
     *
     * @return String
     */
    public String getSolrQueryString() {
        return solrQueryString;
    }

    /**
     * Sets the solr query as a string for the retrieval of relevant content
     *
     * @param solrQuery
     */
    public void setSolrQueryString(String solrQueryString) {
        this.solrQueryString = solrQueryString;

    }

    /**
     * Returns the solr queries for the retrieval of relevant content to the
     * dysco from solr
     *
     * @return String
     */
    public List<Query> getSolrQueries() {
        return solrQueries;
    }

    /**
     * Sets the solr query for the retrieval of relevant content
     *
     * @param solrQuery
     */
    public void setSolrQueries(List<Query> solrQueries) {
        this.solrQueries = solrQueries;

    }

    /**
     * Returns the query as a string for the retrieval of relevant author
     * content to the dysco from solr
     *
     * @return String
     */
    public String getSolrQueryAuthorString() {
        return solrQueryAuthorString;
    }

    /**
     * Sets the solr query as a string for the retrieval of relevant author
     * content
     *
     * @param solrQuery
     */
    public void setSolrAuthorQuery(String solrQueryAuthorString) {
        this.solrQueryAuthorString = solrQueryAuthorString;

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
    
    public void setWordsToAvoid(List<String> wordsToAvoid) {
        this.wordsToAvoid = wordsToAvoid;
    }

    public List<String> getWordsToAvoid() {
        return this.wordsToAvoid;
    }

    public String toString() {
        String dyscoString = "Id: " + id + "\n";
        dyscoString += "Creation date: " + creationDate + "\n";
        dyscoString += "Score: " + score + "\n";
        dyscoString += "Items: \n";
        for (Item item : items) {
            dyscoString += item.getId() + ":" + item.getTitle() + "\n";
        }
        dyscoString += "Entities: \n";
        for (NamedEntity entity : entities) {
            dyscoString += entity.getName() + "@@@" + entity.getType().toString() + ":" + entity.getCount() + "\n";
        }
        dyscoString += "Tags: \n";
        Iterator<Entry<String, Double>> iteratorHashtags = hashtags.entrySet().iterator();
        while (iteratorHashtags.hasNext()) {
            Entry<String, Double> hashtag = iteratorHashtags.next();
            dyscoString += hashtag.getKey() + ":" + hashtag.getValue() + "\n";
        }
        dyscoString += "Keywords: \n";
        Iterator<Entry<String, Double>> iteratorKeywords = keywords.entrySet().iterator();
        while (iteratorKeywords.hasNext()) {
            Entry<String, Double> keyword = iteratorKeywords.next();
            dyscoString += keyword.getKey() + ":" + keyword.getValue() + "\n";
        }
        dyscoString += "SolrQuery : " + solrQueryString + "\n";

        return dyscoString;
    }
}
