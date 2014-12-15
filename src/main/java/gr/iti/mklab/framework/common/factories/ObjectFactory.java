package gr.iti.mklab.framework.common.factories;

import com .google.gson.Gson;
import com.google.gson.GsonBuilder;

import gr.iti.mklab.framework.common.domain.Item;
import gr.iti.mklab.framework.common.domain.Keyword;
import gr.iti.mklab.framework.common.domain.Cluster;
import gr.iti.mklab.framework.common.domain.MediaItem;
import gr.iti.mklab.framework.common.domain.MediaShare;
import gr.iti.mklab.framework.common.domain.Account;
import gr.iti.mklab.framework.common.domain.Message;
import gr.iti.mklab.framework.common.domain.StreamUser;
import gr.iti.mklab.framework.common.domain.WebPage;
import gr.iti.mklab.framework.common.domain.feeds.Feed;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class ObjectFactory {

    static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static synchronized Item create(String json) {
        synchronized (gson) {
            Item item = gson.fromJson(json, Item.class);
            return item;
        }
    }

    public static MediaItem createMediaItem(String json) {
        synchronized (gson) {
            MediaItem item = gson.fromJson(json, MediaItem.class);
            return item;
        }
    }

    public static Cluster createCluster(String json) {
        synchronized (gson) {
        	Cluster mediaCluster = gson.fromJson(json, Cluster.class);
            return mediaCluster;
        }
    }
    
    public static MediaShare createMediaShare(String json) {
        synchronized (gson) {
        	MediaShare mediaShare = gson.fromJson(json, MediaShare.class);
            return mediaShare;
        }
    }
    
    public static synchronized WebPage createWebPage(String json) {
    	synchronized (gson) {
    		WebPage webPage = gson.fromJson(json, WebPage.class);
    	    	return webPage;
    	}
    }
    
    public static synchronized StreamUser createUser(String json) {
        synchronized (gson) {
            StreamUser item = gson.fromJson(json, StreamUser.class);
            return item;
        }
    }

    public static synchronized Feed createFeed(String json) {
        synchronized (gson) {
            Feed feed = gson.fromJson(json, Feed.class);
            return feed;
        }
    }
  
    public static synchronized Keyword createKeyword(String json) {
        synchronized (gson) {
            Keyword keyword = gson.fromJson(json, Keyword.class);
            return keyword;
        }
    }

    public static synchronized Account createAccount(String json) {
        synchronized (gson) {
        	Account account = gson.fromJson(json, Account.class);
            return account;
        }
    }

    public static synchronized Message createMessage(String json) {
    	synchronized (gson) {
    		Message message = gson.fromJson(json, Message.class);
			return message;
    	}
	}
    
}
