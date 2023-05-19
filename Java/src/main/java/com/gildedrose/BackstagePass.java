package com.gildedrose;

public class BackstagePass extends ItemWrapper {

    protected BackstagePass(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        boolean afterConcert = item.sellIn <= 0;
        item.quality = afterConcert ?
            0 :
            Math.min(item.quality + qualityIncreaseFromSellIn(), 50);
        item.sellIn -= 1;
    }

    private int qualityIncreaseFromSellIn() {
        if (item.sellIn <= 5) {
            return 3;
        } else if (item.sellIn <= 10) {
            return 2;
        } else {
            return 1;
        }
    }

}
