package xyz.einandartun.burpplefoodplaces.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.data.vo.GuidesVO;

/**
 * Created by einandartun on 1/6/18.
 */

public class ItemBurppleFoodLatestViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_latest_image)
    ImageView ivLatestImage;

    @BindView(R.id.tv_image_text)
    TextView tvImageText;

    private GuidesVO mGuide;
    public ItemBurppleFoodLatestViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setGuide(GuidesVO guide){
        mGuide = guide;
        Glide.with(ivLatestImage.getContext())
                .load(guide.getBurppleGuideImage())
                .into(ivLatestImage);

        tvImageText.setText(guide.getBurppleGuideTitle());
    }
}
