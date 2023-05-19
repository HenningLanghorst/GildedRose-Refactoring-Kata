package com.gildedrose;

public class AgedBrie extends ItemWrapper {

    protected AgedBrie(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        boolean sellDatePassed = item.sellIn > 0;
        int qualityIncrease = sellDatePassed ? 1 : 2;
        item.quality = Math.min(item.quality + qualityIncrease, 50);
        item.sellIn -= 1;
    }

}
