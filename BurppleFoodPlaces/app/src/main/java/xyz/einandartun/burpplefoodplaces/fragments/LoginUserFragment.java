package xyz.einandartun.burpplefoodplaces.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.data.models.LoginUserModel;
import xyz.einandartun.burpplefoodplaces.events.SuccessLoginEvent;

/**
 * Created by einandartun on 1/25/18.
 */

public class LoginUserFragment extends Fragment {

    @BindView(R.id.et_mobile_or_email)
    EditText etMobileOrEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view){
        String phoneNo = etMobileOrEmail.getText().toString();
        String password = etPassword.getText().toString();
        LoginUserModel.getsObjInstance().loginUser(phoneNo,password);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event){
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
