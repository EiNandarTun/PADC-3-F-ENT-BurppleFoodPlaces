package xyz.einandartun.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by einandartun on 1/12/18.
 */

class BurpplePromotionShopVO {

    @SerializedName("burpple-shop-id")
    private String burppleShopId;

    @SerializedName("burpple-shop-name")
    private String burppleShopName;

    @SerializedName("burpple-shop-area")
    private String burppleShopArea;

    public String getBurppleShopId() {
        return burppleShopId;
    }

    public String getBurppleShopName() {
        return burppleShopName;
    }

    public String getBurppleShopArea() {
        return burppleShopArea;
    }
}
