package xyz.einandartun.burpplefoodplaces.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.data.vo.FeaturedVO;

/**
 * Created by einandartun on 1/5/18.
 */

public class FoodHighlightViewItem extends FrameLayout {

    @BindView(R.id.iv_food_highlight)
    ImageView ivFoodHighLight;

    @BindView(R.id.tv_first_text)
    TextView tvFirstText;

    @BindView(R.id.tv_second_text)
    TextView tvSecondText;

    @BindView(R.id.tv_feature)
    TextView tvFeature;

//    @BindView(R.id.tv_shop_name)
//    TextView tvShopName;
//
//    @BindView(R.id.tv_shop_place)
//    TextView tvShopPlace;

    public FoodHighlightViewItem(@NonNull Context context) {
        super(context);
    }

    public FoodHighlightViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FoodHighlightViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setData(FeaturedVO featuredItem){
        Glide.with(ivFoodHighLight.getContext())
                .load(featuredItem.getBurppleFeaturedImage())
                .into(ivFoodHighLight);
        tvFirstText.setText(featuredItem.getBurppleFeaturedtittle());

        tvFirstText.setText(featuredItem.getBurppleFeaturedDesc());

        tvFeature.setText(featuredItem.getBurppleFeaturedTag());

        //tvShopName.setText(featuredItem.getBurpplePromotionShop().getBurppleShopName());

        //tvShopPlace.setText(featuredItem.getBurpplePromotionShop().getBurppleShopArea());
    }
}
