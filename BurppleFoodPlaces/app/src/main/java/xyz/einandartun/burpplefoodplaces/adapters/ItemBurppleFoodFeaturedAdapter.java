package xyz.einandartun.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.data.vo.PromotionsVO;
import xyz.einandartun.burpplefoodplaces.viewholders.ItemBurppleFoodFeaturedViewHolder;

/**
 * Created by einandartun on 1/5/18.
 */

public class ItemBurppleFoodFeaturedAdapter extends RecyclerView.Adapter<ItemBurppleFoodFeaturedViewHolder> {

    private List<PromotionsVO> mPromotionsItemsList;

    public ItemBurppleFoodFeaturedAdapter() {
        mPromotionsItemsList = new ArrayList<>();
    }

    @Override
    public ItemBurppleFoodFeaturedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodItemView = inflater.inflate(R.layout.item_burpple_food_featured, parent,false);
        ItemBurppleFoodFeaturedViewHolder itemBurppleFoodFeaturedViewHolder = new ItemBurppleFoodFeaturedViewHolder(foodItemView);
        return itemBurppleFoodFeaturedViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemBurppleFoodFeaturedViewHolder holder, int position) {
        holder.setFeaturedItems(mPromotionsItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPromotionsItemsList.size();
    }

    public void setFeaturedItems(List<PromotionsVO> featuredItemsList){
        mPromotionsItemsList = featuredItemsList;
        notifyDataSetChanged();
    }
}
