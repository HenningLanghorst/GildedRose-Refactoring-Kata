package com.gildedrose;

public class OtherItem extends ItemWrapper {

    protected OtherItem(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        int qualityDecrease = item.sellIn > 0 ? 1 : 2;
        item.quality = Math.max(0, item.quality - qualityDecrease);
        item.sellIn -= 1;
    }

}
