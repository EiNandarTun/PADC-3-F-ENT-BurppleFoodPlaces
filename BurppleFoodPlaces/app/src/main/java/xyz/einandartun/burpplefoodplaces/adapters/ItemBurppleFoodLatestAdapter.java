package xyz.einandartun.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.data.vo.GuidesVO;
import xyz.einandartun.burpplefoodplaces.viewholders.ItemBurppleFoodLatestViewHolder;

/**
 * Created by einandartun on 1/6/18.
 */

public class ItemBurppleFoodLatestAdapter extends RecyclerView.Adapter <ItemBurppleFoodLatestViewHolder>{

    private List<GuidesVO> mGuideList;

    public ItemBurppleFoodLatestAdapter() {
        mGuideList = new ArrayList<>();
    }

    @Override
    public ItemBurppleFoodLatestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View latestFoodItemView = inflater.inflate(R.layout.item_burpple_food_latest, parent,false);
        ItemBurppleFoodLatestViewHolder itemBurppleFoodLatestViewHolder = new ItemBurppleFoodLatestViewHolder(latestFoodItemView);
        return itemBurppleFoodLatestViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemBurppleFoodLatestViewHolder holder, int position) {
        holder.setGuide(mGuideList.get(position));
    }

    @Override
    public int getItemCount() {
        return mGuideList.size();
    }

    public void setGuideItems(List<GuidesVO> guidesVOList){
        mGuideList = guidesVOList;
        notifyDataSetChanged();
    }
}
