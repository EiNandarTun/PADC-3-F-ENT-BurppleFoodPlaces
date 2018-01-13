package xyz.einandartun.burpplefoodplaces.events;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.GuidesVO;

/**
 * Created by einandartun on 1/13/18.
 */

public class LoadedFoodGuideItemsEvent {
    private List<GuidesVO> guideItemList;

    public LoadedFoodGuideItemsEvent(List<GuidesVO> guideItemList) {
        this.guideItemList = guideItemList;
    }

    public List<GuidesVO> getGuideItemList() {
        return guideItemList;
    }
}
