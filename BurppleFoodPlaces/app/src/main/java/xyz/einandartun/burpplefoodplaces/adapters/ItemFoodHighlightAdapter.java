package xyz.einandartun.burpplefoodplaces.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.einandartun.burpplefoodplaces.R;
import xyz.einandartun.burpplefoodplaces.viewitems.FoodHighlightViewItem;

/**
 * Created by einandartun on 1/5/18.
 */

public class ItemFoodHighlightAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //return false;
        return (view == (View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        FoodHighlightViewItem viewItem = (FoodHighlightViewItem)layoutInflater.inflate(R.layout.item_burpple_food_highlight, container, false);
        container.addView(viewItem);
        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
