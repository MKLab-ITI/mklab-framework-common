package gr.iti.mklab.framework.common.influencers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gr.iti.mklab.framework.common.domain.JSONable;
import gr.iti.mklab.framework.common.domain.Keyword;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stzoannos
 */
public class InfluencerKeywordsPair implements JSONable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9077297268724393582L;
	
	@Expose
    @SerializedName(value = "influencer")
    private String influencer;
    @Expose
    @SerializedName(value = "keywords")
    private List<Keyword> keywords = new ArrayList<Keyword>();

    public InfluencerKeywordsPair() {
    }

    public InfluencerKeywordsPair(String influencer, List<Keyword> keywords) {
        this.influencer = influencer;
        this.keywords = keywords;
    }

    public String getInfluencer() {
        return influencer;
    }

    public void setInfluencer(String influencer) {
        this.influencer = influencer;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

  
    @Override
    public String toJSONString() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

}
