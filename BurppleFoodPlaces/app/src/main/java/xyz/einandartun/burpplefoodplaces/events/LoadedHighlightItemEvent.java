package xyz.einandartun.burpplefoodplaces.events;

import java.util.List;

import xyz.einandartun.burpplefoodplaces.data.vo.FeaturedVO;

/**
 * Created by einandartun on 1/14/18.
 */

public class LoadedHighlightItemEvent {
    private List<FeaturedVO> highlightItemsList;

    public LoadedHighlightItemEvent(List<FeaturedVO> highlightItemsList) {
        this.highlightItemsList = highlightItemsList;
    }

    public List<FeaturedVO> getHighlightItemsList() {
        return highlightItemsList;
    }
}
