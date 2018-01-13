package xyz.einandartun.burpplefoodplaces.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.einandartun.burpplefoodplaces.events.LoadedFeaturedItemsEvent;
import xyz.einandartun.burpplefoodplaces.events.LoadedFoodGuideItemsEvent;
import xyz.einandartun.burpplefoodplaces.network.responses.GetGuideResponse;
import xyz.einandartun.burpplefoodplaces.network.responses.GetPromotionResponse;

/**
 * Created by einandartun on 1/14/18.
 */

public class RetrofitDataAgent implements BurppleFoodDataAgent,FoodGuideDataAgent {

    private static RetrofitDataAgent sObjInstance;

    private FoodApi mFoodApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder() //2
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mFoodApi = retrofit.create(FoodApi.class);
    }

    public static RetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void LoadFoodItems() {
        Call<GetPromotionResponse> getPromotionResponseCall = mFoodApi.getPromotionItems(1,"b002c7e1a528b7cb460933fc2875e916");
        getPromotionResponseCall.enqueue(new Callback<GetPromotionResponse>() {
            @Override
            public void onResponse(Call<GetPromotionResponse> call, Response<GetPromotionResponse> response) {
                GetPromotionResponse getNewsResponse = response.body();

                if(getNewsResponse != null){
                    LoadedFeaturedItemsEvent event = new LoadedFeaturedItemsEvent(getNewsResponse.getFoodPromotion());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetPromotionResponse> call, Throwable t) {

            }
        });


    }

    @Override
    public void loadGuide() {
        Call<GetGuideResponse> getGuideResponseCall = mFoodApi.getFoodtems(1,"b002c7e1a528b7cb460933fc2875e916");
        getGuideResponseCall.enqueue(new Callback<GetGuideResponse>() {
            @Override
            public void onResponse(Call<GetGuideResponse> call, Response<GetGuideResponse> response) {
                GetGuideResponse getGuideResponse = response.body();

                if(getGuideResponse != null){
                    LoadedFoodGuideItemsEvent event = new LoadedFoodGuideItemsEvent(getGuideResponse.getFoodGuide());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetGuideResponse> call, Throwable t) {

            }
        });
    }
}
