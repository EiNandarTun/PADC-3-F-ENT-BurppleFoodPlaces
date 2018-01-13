package xyz.einandartun.burpplefoodplaces.events;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.FeaturedVO;
import xyz.einandartun.burpplefoodplaces.data.vo.PromotionsVO;

/**
 * Created by einandartun on 1/12/18.
 */

public class LoadedFeaturedItemsEvent {

    private List<PromotionsVO> promotionsItemsList;

    public LoadedFeaturedItemsEvent(List<PromotionsVO> promotionsItemsList) {
        this.promotionsItemsList = promotionsItemsList;
    }

    public List<PromotionsVO> getFeaturedItemsList() {
        return promotionsItemsList;
    }
}
