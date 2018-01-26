package xyz.einandartun.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by einandartun on 1/12/18.
 */

public class FeaturedVO {

    @SerializedName("burpple-featured-id")
    private String burppleFeaturedId;

    @SerializedName("burpple-featured-image")
    private String burppleFeaturedImage;

    @SerializedName("burpple-featured-title")
    private String burppleFeaturedtittle;

    @SerializedName("burpple-featured-desc")
    private String burppleFeaturedDesc;

    @SerializedName("burpple-featured-tag")
    private String burppleFeaturedTag;

    @SerializedName("burpple-promotion-shop")
    private BurpplePromotionShopVO burpplePromotionShop;

    public String getBurppleFeaturedId() {
        return burppleFeaturedId;
    }

    public String getBurppleFeaturedImage() {
        return burppleFeaturedImage;
    }

    public String getBurppleFeaturedtittle() {
        return burppleFeaturedtittle;
    }

    public String getBurppleFeaturedDesc() {
        return burppleFeaturedDesc;
    }

    public String getBurppleFeaturedTag() {
        return burppleFeaturedTag;
    }

    public BurpplePromotionShopVO getBurpplePromotionShop() {
        return burpplePromotionShop;
    }
}
