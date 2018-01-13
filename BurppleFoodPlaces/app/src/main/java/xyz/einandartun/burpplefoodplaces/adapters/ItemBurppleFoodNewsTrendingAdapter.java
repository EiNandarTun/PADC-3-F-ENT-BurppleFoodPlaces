package xyz.einandartun.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.viewholders.ItemBurppleFoodNewsTrendingViewHolder;

/**
 * Created by einandartun on 1/7/18.
 */

public class ItemBurppleFoodNewsTrendingAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodItemView = inflater.inflate(R.layout.item_burpple_food_news_trending,parent,false);
        ItemBurppleFoodNewsTrendingViewHolder itemBurppleFoodNewsTrendingViewHolder = new ItemBurppleFoodNewsTrendingViewHolder(foodItemView);

        return itemBurppleFoodNewsTrendingViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
