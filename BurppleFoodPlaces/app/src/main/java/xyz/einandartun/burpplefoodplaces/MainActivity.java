package xyz.einandartun.burpplefoodplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.einandartun.burpplefoodplaces.activities.AccountControlActivity;
import xyz.einandartun.burpplefoodplaces.adapters.ItemBurppleFoodFeaturedAdapter;
import xyz.einandartun.burpplefoodplaces.adapters.ItemBurppleFoodLatestAdapter;
import xyz.einandartun.burpplefoodplaces.adapters.ItemBurppleFoodNewlyOpenedAdapter;
import xyz.einandartun.burpplefoodplaces.adapters.ItemBurppleFoodTrendingVenuesAdapter;
import xyz.einandartun.burpplefoodplaces.adapters.ItemFoodHighlightAdapter;
import xyz.einandartun.burpplefoodplaces.data.models.BurppleFoodModel;
import xyz.einandartun.burpplefoodplaces.data.models.BurppleGuideModel;
import xyz.einandartun.burpplefoodplaces.data.models.BurppleHighlightModel;
import xyz.einandartun.burpplefoodplaces.delegates.BeforeLoginDelegate;
import xyz.einandartun.burpplefoodplaces.events.LoadedFeaturedItemsEvent;
import xyz.einandartun.burpplefoodplaces.events.LoadedFoodGuideItemsEvent;
import xyz.einandartun.burpplefoodplaces.events.LoadedHighlightItemEvent;
import xyz.einandartun.burpplefoodplaces.viewpods.BeforeLoginViewPod;

public class MainActivity extends AppCompatActivity implements BeforeLoginDelegate {

    @BindView(R.id.vp_highlight)
    ViewPager vpHighlight;

    @BindView(R.id.rv_burpple_food_featured)
    RecyclerView rvBurppleFoodFeatured;

    @BindView(R.id.rv_burpple_food_latest)
    RecyclerView rvBurppleFoodLatest;

    @BindView(R.id.rv_newly_opened)
    RecyclerView rvBurppleFoodNewlyOpened;

    @BindView(R.id.rv_trending_venues)
    RecyclerView rvBurppleFoodTrendingVenued;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private ItemFoodHighlightAdapter mItemFoodHighlightAdapter;
    private ItemBurppleFoodFeaturedAdapter mItemBurppleFoodFeaturedAdapter;
    private ItemBurppleFoodLatestAdapter mItemBurppleFoodLatestAdapter;
    private ItemBurppleFoodNewlyOpenedAdapter mItemBurppleFoodNewlyOpenedAdapter;
    private ItemBurppleFoodTrendingVenuesAdapter mItemBurppleFoodTrendingVenuesAdapter;

    private BeforeLoginViewPod beforeLoginViewPod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this,this);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        mItemBurppleFoodFeaturedAdapter = new ItemBurppleFoodFeaturedAdapter();
        LinearLayoutManager linearLayoutManagerFeatured = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        rvBurppleFoodFeatured.setLayoutManager(linearLayoutManagerFeatured);
        rvBurppleFoodFeatured.setAdapter(mItemBurppleFoodFeaturedAdapter);

        mItemBurppleFoodLatestAdapter = new ItemBurppleFoodLatestAdapter();
        LinearLayoutManager linearLayoutManagerLatest = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        rvBurppleFoodLatest.setLayoutManager(linearLayoutManagerLatest);
        rvBurppleFoodLatest.setAdapter(mItemBurppleFoodLatestAdapter);

        mItemBurppleFoodNewlyOpenedAdapter = new ItemBurppleFoodNewlyOpenedAdapter();
        LinearLayoutManager linearLayoutManagerNewlyOpened = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        rvBurppleFoodNewlyOpened.setLayoutManager(linearLayoutManagerNewlyOpened);
        rvBurppleFoodNewlyOpened.setAdapter(mItemBurppleFoodNewlyOpenedAdapter);

        mItemBurppleFoodTrendingVenuesAdapter = new ItemBurppleFoodTrendingVenuesAdapter();
        LinearLayoutManager linearLayoutManagerTrendingVenues = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        rvBurppleFoodTrendingVenued.setLayoutManager(linearLayoutManagerTrendingVenues);
        rvBurppleFoodTrendingVenued.setAdapter(mItemBurppleFoodTrendingVenuesAdapter);

        mItemFoodHighlightAdapter = new ItemFoodHighlightAdapter();
        vpHighlight.setAdapter(mItemFoodHighlightAdapter);

        BurppleFoodModel.getsObjInstance().loadFoodItems();
        BurppleGuideModel.getsObjInstance().loadFoodItems();
        BurppleHighlightModel.getsObjInstance().loadFoodHighlight();

        if (getSupportActionBar()!= null){
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        beforeLoginViewPod = (BeforeLoginViewPod) navigationView.getHeaderView(0);
        beforeLoginViewPod.setDelegate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFoodItemsLoaded(LoadedFeaturedItemsEvent event){
        Log.d(BurppleFoodApp.LOG_TAG, "onFoodItemsLoaded: " +event.getFeaturedItemsList().size());
        mItemBurppleFoodFeaturedAdapter.setFeaturedItems(event.getFeaturedItemsList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFoodGuideLoaded(LoadedFoodGuideItemsEvent event){
        Log.d(BurppleFoodApp.LOG_TAG, "onFoodGuideLoaded: " +event.getGuideItemList().size());
        mItemBurppleFoodLatestAdapter.setGuideItems(event.getGuideItemList());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFoodHighlightLoaded(LoadedHighlightItemEvent event){
        Log.d(BurppleFoodApp.LOG_TAG, "onFoodHighlightLoaded: " +event.getHighlightItemsList().size());
        mItemFoodHighlightAdapter.setFeaturedItems(event.getHighlightItemsList());
    }


    @Override
    public void onTapLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
        }

    @Override
    public void onTapRegister() {
        Intent intent = AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }
}
