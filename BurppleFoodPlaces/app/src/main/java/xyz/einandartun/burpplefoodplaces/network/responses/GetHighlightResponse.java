package xyz.einandartun.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.FeaturedVO;
import xyz.einandartun.burpplefoodplaces.data.vo.PromotionsVO;

/**
 * Created by einandartun on 1/13/18.
 */

public class GetHighlightResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("featured")
    private List<FeaturedVO> foodFeature;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<FeaturedVO> getFoodHighlight() {
        return foodFeature;
    }
}
