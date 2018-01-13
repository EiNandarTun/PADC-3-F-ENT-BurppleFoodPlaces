package xyz.einandartun.burpplefoodplaces.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.data.vo.FeaturedVO;
import xyz.einandartun.burpplefoodplaces.data.vo.PromotionsVO;

/**
 * Created by einandartun on 1/5/18.
 */

public class ItemBurppleFoodFeaturedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_featured_image)
    ImageView ivFeaturedImage;

    @BindView(R.id.tv_promotion_title)
    TextView tvPromotionTitle;

    @BindView(R.id.tv_promotion_last_date)
    TextView tvPromotionLastDate;

    @BindView(R.id.tv_shop_name)
    TextView tvShopName;

    @BindView(R.id.tv_shop_place)
    TextView tvShopPlace;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    public ItemBurppleFoodFeaturedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setFeaturedItems(PromotionsVO promotionsItems){
        tvTitle.setText(promotionsItems.getBurpplePromotionTittle());

        tvPromotionTitle.setText(promotionsItems.getBurpplePromotionTittle());

        tvPromotionLastDate.setText(promotionsItems.getBurpplePromotionUntil());



        Glide.with(ivFeaturedImage.getContext())
                .load(promotionsItems.getBurpplePromotionImage())
                .into(ivFeaturedImage);

    }

}
