package xyz.einandartun.burpplefoodplaces.data.models;

import xyz.einandartun.burpplefoodplaces.network.FoodHighlightDataAgent;
import xyz.einandartun.burpplefoodplaces.network.OkHttpHighlightDataAgent;
import xyz.einandartun.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by einandartun on 1/15/18.
 */

public class BurppleHighlightModel {
    private static BurppleHighlightModel sObjInstance;

    private FoodHighlightDataAgent mFoodHighlightDataAgent;

    public BurppleHighlightModel() {
        //mFoodHighlightDataAgent = OkHttpHighlightDataAgent.getObjInstance();
        mFoodHighlightDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static BurppleHighlightModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new BurppleHighlightModel();
        }
        return  sObjInstance;
    }

    public void loadFoodHighlight(){
        mFoodHighlightDataAgent.LoadHighlightFoodItems();
    }
}
