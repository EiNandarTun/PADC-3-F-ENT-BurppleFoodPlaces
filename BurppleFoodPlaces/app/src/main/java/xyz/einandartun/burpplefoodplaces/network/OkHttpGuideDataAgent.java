package xyz.einandartun.burpplefoodplaces.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.einandartun.burpplefoodplaces.BurppleFoodApp;
import xyz.einandartun.burpplefoodplaces.events.LoadedFoodGuideItemsEvent;
import xyz.einandartun.burpplefoodplaces.network.responses.GetGuideResponse;

/**
 * Created by einandartun on 1/13/18.
 */

public class OkHttpGuideDataAgent implements FoodGuideDataAgent {

    public static OkHttpGuideDataAgent objInstance;

    private OkHttpGuideDataAgent(){

    }

    public static OkHttpGuideDataAgent getObjInstance(){
        if (objInstance == null){
            objInstance = new OkHttpGuideDataAgent();
        }
        return objInstance;
    }
    @Override
    public void loadGuide() {
        new LoadFoodGuideTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");
    }

    private static class LoadFoodGuideTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];

            OkHttpClient httpClient = new OkHttpClient.Builder() //1
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder()//2
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder()//3
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString = null;

            try {
                Response response = httpClient.newCall(request).execute();//4
                if (response.isSuccessful() && response.body() != null){
                    responseString = response.body().string();
                    //return responseString;
                }
            } catch (IOException e){
                Log.e(BurppleFoodApp.LOG_TAG, e.getMessage() );
            }

            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();
            GetGuideResponse getGuideResponse = gson.fromJson(response, GetGuideResponse.class);

            LoadedFoodGuideItemsEvent event = new LoadedFoodGuideItemsEvent(getGuideResponse.getFoodGuide());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);
        }
    }

}
