package xyz.einandartun.burpplefoodplaces.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.delegates.BeforeLoginDelegate;

/**
 * Created by einandartun on 1/25/18.
 */

public class BeforeLoginViewPod extends RelativeLayout {

    private BeforeLoginDelegate mBeforeLoginDelegate;
    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setDelegate(BeforeLoginDelegate beforeLoginDelegate){
        mBeforeLoginDelegate = beforeLoginDelegate;
    }

    @OnClick(R.id.btn_to_login)
    public void onTapLogin(View view){
        mBeforeLoginDelegate.onTapLogin();
    }

    @OnClick(R.id.btn_to_register)
    public void onTapRegister(View view){
        mBeforeLoginDelegate.onTapRegister();
    }
}
