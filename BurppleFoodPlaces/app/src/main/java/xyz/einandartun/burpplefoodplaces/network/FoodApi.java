package xyz.einandartun.burpplefoodplaces.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.einandartun.burpplefoodplaces.network.responses.GetFoodResponse;
import xyz.einandartun.burpplefoodplaces.network.responses.GetGuideResponse;
import xyz.einandartun.burpplefoodplaces.network.responses.GetPromotionResponse;

/**
 * Created by einandartun on 1/13/18.
 */

public interface FoodApi {
    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionResponse> getPromotionItems(@Field("page") int page,
                                            @Field("access_token") String accessToken);


    @FormUrlEncoded
    @POST("getGuides.php")
    Call<GetGuideResponse> getFoodtems(@Field("page") int page, @Field("access_token")String accessToken);
}
