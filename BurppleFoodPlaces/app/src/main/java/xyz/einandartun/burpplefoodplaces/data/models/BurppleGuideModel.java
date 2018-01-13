package xyz.einandartun.burpplefoodplaces.data.models;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import xyz.einandartun.burpplefoodplaces.network.FoodGuideDataAgent;
import xyz.einandartun.burpplefoodplaces.network.OkHttpGuideDataAgent;
import xyz.einandartun.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by einandartun on 1/13/18.
 */

public class BurppleGuideModel {
    private static BurppleGuideModel sObjInstance;

    private FoodGuideDataAgent mDataAgent;


    private  BurppleGuideModel(){
        //mDataAgent = OkHttpGuideDataAgent.getObjInstance();
        mDataAgent = RetrofitDataAgent.getsObjInstance();

    }

    public static BurppleGuideModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new BurppleGuideModel();
        }
        return  sObjInstance;
    }

    /**
     * Get News from network api.
     */
    public  void loadFoodItems(){
        mDataAgent.loadGuide();
    }

}
