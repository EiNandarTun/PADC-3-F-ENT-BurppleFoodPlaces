package xyz.einandartun.burpplefoodplaces.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by einandartun on 1/12/18.
 */

public class FeaturedVO {

    private String burppleFeaturedId;

    @SerializedName("burpple-featured-image")
    private String burppleFeaturedImage;

    @SerializedName("burpple-featured-title")
    private String burppleFeaturedtittle;
    private String burppleFeaturedDesc;
    private String burppleFeaturedTag;

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
}
