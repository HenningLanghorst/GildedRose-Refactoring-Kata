package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> adjustQuality(item, 1);
                case "Backstage passes to a TAFKAL80ETC concert" ->
                    adjustQuality(item, backstagePassQualityIncrease(item));
                case "Sulfuras, Hand of Ragnaros" -> adjustQuality(item, 0);
                default -> adjustQuality(item, -1);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie" -> adjustQuality(item, 1);
                    case "Backstage passes to a TAFKAL80ETC concert" -> setZeroQuality(item);
                    case "Sulfuras, Hand of Ragnaros" -> adjustQuality(item, 0);
                    default -> adjustQuality(item, -1);
                }
            }
        }
    }

    private static int backstagePassQualityIncrease(Item item) {
        int count;
        if (item.sellIn < 6) {
            count = 3;
        } else if (item.sellIn < 11) {
            count = 2;
        } else {
            count = 1;
        }
        return count;
    }


    private static void setZeroQuality(Item item) {
        item.quality = 0;
    }

    private static void adjustQuality(Item item, int count) {
        item.quality = Math.max(0, Math.min(50, item.quality + count));
    }

}
