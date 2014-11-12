package gr.iti.mklab.framework.common.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import gr.iti.mklab.framework.common.domain.DyscoRequest;
import gr.iti.mklab.framework.common.domain.Expert;
import gr.iti.mklab.framework.common.domain.Feed;
import gr.iti.mklab.framework.common.domain.Item;
import gr.iti.mklab.framework.common.domain.Keyword;
import gr.iti.mklab.framework.common.domain.MediaCluster;
import gr.iti.mklab.framework.common.domain.MediaItem;
import gr.iti.mklab.framework.common.domain.MediaShare;
import gr.iti.mklab.framework.common.domain.PlatformUser;
import gr.iti.mklab.framework.common.domain.Source;
import gr.iti.mklab.framework.common.domain.StreamUser;
import gr.iti.mklab.framework.common.domain.Topic;
import gr.iti.mklab.framework.common.domain.Vote;
import gr.iti.mklab.framework.common.domain.WebPage;
import gr.iti.mklab.framework.common.influencers.Influencer;
import gr.iti.mklab.framework.common.influencers.InfluencerKeywordsPair;
import gr.iti.mklab.framework.common.influencers.KeywordInfluencersPair;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    public static MediaCluster createMediaCluster(String json) {
        synchronized (gson) {
        	MediaCluster mediaCluster = gson.fromJson(json, MediaCluster.class);
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

    public static synchronized DyscoRequest createDyscoRequest(String json) {
        synchronized (gson) {
            DyscoRequest request = gson.fromJson(json, DyscoRequest.class);
            return request;
        }
    }

    public static synchronized Influencer createInfluencer(String json) {
        synchronized (gson) {
            Influencer influencer = gson.fromJson(json, Influencer.class);
            return influencer;
        }
    }

    public static synchronized KeywordInfluencersPair createKeywordInfluencersPair(String json) {
    	synchronized (gson) {
    		KeywordInfluencersPair pair = gson.fromJson(json, KeywordInfluencersPair.class);
    		return pair;
    	}
    }
    
    public static synchronized InfluencerKeywordsPair createInfluencerKeywordsPair(String json) {
        synchronized (gson) {
            InfluencerKeywordsPair pair = gson.fromJson(json, InfluencerKeywordsPair.class);
            return pair;
        }
    }
    
    public static synchronized Keyword createKeyword(String json) {
        synchronized (gson) {
            Keyword keyword = gson.fromJson(json, Keyword.class);
            return keyword;
        }
    }

    public static synchronized Source createSource(String json) {
        synchronized (gson) {
            Source source = gson.fromJson(json, Source.class);
            return source;
        }
    }

    public static synchronized Topic createTopic(String json) {
    	synchronized (gson) {
    		Topic topic = gson.fromJson(json, Topic.class);
    		return topic;
    	}
    }
    
    public static synchronized Expert createExpert(String json) {
        synchronized (gson) {
        	Expert expert = gson.fromJson(json, Expert.class);
            return expert;
        }
    }
    
    public static synchronized PlatformUser createPlatformUser(String json) {
        synchronized (gson) {
            PlatformUser user = gson.fromJson(json, PlatformUser.class);
            return user;
        }
    }
    
    public static synchronized List<Vote> createVoteList(String json) {
        synchronized (gson) {


            Type listType = new TypeToken<ArrayList<Vote>>() {
            }.getType();

            List<Vote> voteList = gson.fromJson(json, listType);

            if (voteList == null) {
                voteList = new ArrayList<Vote>();
            }
            return voteList;
        }
    }

}
