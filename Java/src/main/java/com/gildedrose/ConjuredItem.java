package com.gildedrose;

public class ConjuredItem extends ItemWrapper {

    protected ConjuredItem(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        int qualityDecrease = item.sellIn > 0 ? 2 : 4;
        item.quality = Math.max(0, item.quality - qualityDecrease);
        item.sellIn -= 1;
    }

}
