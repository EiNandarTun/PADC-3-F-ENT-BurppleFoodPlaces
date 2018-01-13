package xyz.einandartun.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by einandartun on 1/12/18.
 */

public class PromotionsVO {
    @SerializedName("burpple-promotion-id")
    private String burpplePromotionId;

    @SerializedName("burpple-promotion-image")
    private String burpplePromotionImage;

    @SerializedName("burpple-promotion-title")
    private String burpplePromotionTittle;

    @SerializedName("burpple-promotion-until")
    private String burpplePromotionUntil;

    @SerializedName("burpple-promotion-shop")
    private BurpplePromotionShopVO burpplePromotionShop;

    @SerializedName("is-burpple-exclusive")
    private boolean isBurppleExclusive;

    @SerializedName("burpple-promotion-terms")
    private List<String> burpplePromotionTerms;

    public String getBurpplePromotionId() {
        return burpplePromotionId;
    }

    public String getBurpplePromotionImage() {
        return burpplePromotionImage;
    }

    public String getBurpplePromotionTittle() {
        return burpplePromotionTittle;
    }

    public String getBurpplePromotionUntil() {
        return burpplePromotionUntil;
    }

    public BurpplePromotionShopVO getBurpplePromotionShop() {
        return burpplePromotionShop;
    }

    public boolean isBurppleExclusive() {
        return isBurppleExclusive;
    }

    public List<String> getBurpplePromotionTerms() {
        return burpplePromotionTerms;
    }
}
