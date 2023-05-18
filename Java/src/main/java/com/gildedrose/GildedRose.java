package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            boolean agedBrie = item.name.equals("Aged Brie");
            boolean backstagePasses = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            boolean sulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");

            if (agedBrie) {
                processAgedBree(item);
            } else if (backstagePasses) {
                processBackstagePass(item);
            } else if (!sulfuras) {
                processOther(item);
            }
        }
    }

    private static void processAgedBree(Item item) {
        increaseQuality(item);

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private static void processBackstagePass(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11)
            increaseQuality(item);
        if (item.sellIn < 6)
            increaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }


    private static void processOther(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
