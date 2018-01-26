package xyz.einandartun.burpplefoodplaces.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.einandartun.burpplefoodplaces.data.vo.LoginUserVO;
import xyz.einandartun.burpplefoodplaces.events.SuccessLoginEvent;
import xyz.einandartun.burpplefoodplaces.network.BurppleFoodDataAgent;
import xyz.einandartun.burpplefoodplaces.network.RetrofitDataAgent;

/**
 * Created by einandartun on 1/27/18.
 */

public class LoginUserModel {

    private static LoginUserModel objInstance;

    private BurppleFoodDataAgent mDataAgent;

    private LoginUserVO mLoginUser;

    private LoginUserModel(){
        mDataAgent = RetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getsObjInstance(){
        if(objInstance == null){
            objInstance = new LoginUserModel();
        }
        return  objInstance;
    }

    public void loginUser(String phoneNo,String password){
        mDataAgent.loginUser(phoneNo,password);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        mLoginUser = event.getLoginUser();
    }
}
