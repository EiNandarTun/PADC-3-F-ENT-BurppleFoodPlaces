package xyz.einandartun.burpplefoodplaces.events;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.FavFoodPlacesVO;
import xyz.einandartun.burpplefoodplaces.data.vo.FavFoodVO;
import xyz.einandartun.burpplefoodplaces.data.vo.LoginUserVO;

/**
 * Created by einandartun on 1/27/18.
 */

public class SuccessLoginEvent {

    private LoginUserVO loginUser;

    private List<FavFoodVO> favFoodList;

    private List<FavFoodPlacesVO> favFoodPlacesList;

    public SuccessLoginEvent(LoginUserVO loginUser, List<FavFoodVO> favFoodList, List<FavFoodPlacesVO> favFoodPlacesList) {
        this.loginUser = loginUser;
        this.favFoodList = favFoodList;
        this.favFoodPlacesList = favFoodPlacesList;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public List<FavFoodVO> getFavFoodList() {
        return favFoodList;
    }

    public List<FavFoodPlacesVO> getFavFoodPlacesList() {
        return favFoodPlacesList;
    }
}
