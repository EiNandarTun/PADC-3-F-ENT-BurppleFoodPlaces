package xyz.einandartun.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.viewholders.ItemBurppleFoodTrendingVenuesViewHolder;

/**
 * Created by einandartun on 1/8/18.
 */

public class ItemBurppleFoodTrendingVenuesAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View trendingVenuesItemView = inflater.inflate(R.layout.item_burpple_food_trending_venues,parent,false);
        ItemBurppleFoodTrendingVenuesViewHolder itemBurppleFoodTrendingVenuesViewHolder = new ItemBurppleFoodTrendingVenuesViewHolder(trendingVenuesItemView);
    return itemBurppleFoodTrendingVenuesViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
