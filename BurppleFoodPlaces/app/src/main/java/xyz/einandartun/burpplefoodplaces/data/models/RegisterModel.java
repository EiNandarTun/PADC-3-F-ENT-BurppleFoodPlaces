package xyz.einandartun.burpplefoodplaces.data.models;

import xyz.einandartun.burpplefoodplaces.data.vo.RegisterUserVO;
import xyz.einandartun.burpplefoodplaces.events.SuccessRegisterEvent;
import xyz.einandartun.burpplefoodplaces.network.BurppleFoodDataAgent;
import xyz.einandartun.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by einandartun on 1/27/18.
 */

public class RegisterModel {

    private static RegisterModel objInstance;

    private BurppleFoodDataAgent mDataAgent;

    private RegisterUserVO mRegisterUser;

    private RegisterModel(){
        mDataAgent = RetrofitDataAgent.getsObjInstance();
    }

    public static RegisterModel getObjInstance(){
        if (objInstance == null){
            objInstance = new RegisterModel();
        }
        return objInstance;
    }

    public void registerUser(String phoneNo,String password, String name){
        mDataAgent.registerUser(phoneNo,password,name);
    }

    public void onRegisterSuccess(SuccessRegisterEvent event){
        mRegisterUser = event.getRegisterUserVO();
    }
}
