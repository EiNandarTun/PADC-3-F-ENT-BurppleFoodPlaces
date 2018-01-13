package xyz.einandartun.burpplefoodplaces.data.models;

import xyz.einandartun.burpplefoodplaces.network.BurppleFoodDataAgent;
import xyz.einandartun.burpplefoodplaces.network.OkHttpDataAgent;
import xyz.einandartun.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by einandartun on 1/12/18.
 */

public class BurppleFoodModel {

    private static BurppleFoodModel sObjInstance;
    private BurppleFoodDataAgent mBurppleFoodDataAgent;

    private  BurppleFoodModel(){
       // mBurppleFoodDataAgent = OkHttpDataAgent.getObjInstance();
        mBurppleFoodDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static BurppleFoodModel getsObjInstance(){
        if(sObjInstance == null){
            sObjInstance = new BurppleFoodModel();
        }
        return  sObjInstance;
    }

    /**
     * Get News from network api.
     */
    public  void loadFoodItems(){
        mBurppleFoodDataAgent.LoadFoodItems();
    }
}

