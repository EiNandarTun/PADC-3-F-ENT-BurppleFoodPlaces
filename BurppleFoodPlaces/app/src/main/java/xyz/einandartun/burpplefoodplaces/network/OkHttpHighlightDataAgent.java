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
import xyz.einandartun.burpplefoodplaces.events.LoadedHighlightItemEvent;
import xyz.einandartun.burpplefoodplaces.network.responses.GetHighlightResponse;

/**
 * Created by einandartun on 1/14/18.
 */

public class OkHttpHighlightDataAgent implements FoodHighlightDataAgent {

    public static OkHttpHighlightDataAgent objInstance;

    public OkHttpHighlightDataAgent() {
    }

    public static OkHttpHighlightDataAgent getObjInstance(){
        if (objInstance == null){
            objInstance = new OkHttpHighlightDataAgent();
        }
        return objInstance;
    }

    @Override
    public void LoadHighlightFoodItems() {
        new LoadFoodHighlightTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getFeatured.php");
    }

    private static class LoadFoodHighlightTask extends AsyncTask<String, Void,String>{
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
            GetHighlightResponse getHighlightResponse = gson.fromJson(response, GetHighlightResponse.class);

            LoadedHighlightItemEvent event = new LoadedHighlightItemEvent(getHighlightResponse.getFoodHighlight());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);
        }
    }
}
