package xyz.einandartun.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.FeaturedVO;
import xyz.einandartun.burpplefoodplaces.data.vo.PromotionsVO;

/**
 * Created by einandartun on 1/13/18.
 */

public class GetPromotionResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("promotions")
    private List<PromotionsVO> foodPromotion;

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

    public List<PromotionsVO> getFoodPromotion() {
        return foodPromotion;
    }
}
