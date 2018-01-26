package xyz.einandartun.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.FavFoodPlacesVO;
import xyz.einandartun.burpplefoodplaces.data.vo.FavFoodVO;
import xyz.einandartun.burpplefoodplaces.data.vo.LoginUserVO;

/**
 * Created by einandartun on 1/27/18.
 */

public class LoginResponse {
    private int code;
    private String message;
    @SerializedName("login_user")
    private LoginUserVO loginUserVO;

    @SerializedName("fav_foods")
    private List<FavFoodVO> favFoodList;

    @SerializedName("fav_food_places")
    private List<FavFoodPlacesVO> favFoodPlacesList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUserVO() {
        return loginUserVO;
    }

    public List<FavFoodVO> getFavFoodList() {
        return favFoodList;
    }

    public List<FavFoodPlacesVO> getFavFoodPlacesList() {
        return favFoodPlacesList;
    }
}
