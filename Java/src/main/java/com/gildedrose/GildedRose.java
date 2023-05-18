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
        if (item.sellIn > 0) {
            increaseQuality(1, item);
            decreaseSellIn(item);

        } else {
            increaseQuality(2, item);
            decreaseSellIn(item);
        }

    }

    private static void processBackstagePass(Item item) {
        increaseQuality(1, item);
        if (item.sellIn < 11) {
            increaseQuality(1, item);
        }
        if (item.sellIn < 6) {
            increaseQuality(1, item);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }


    static void processOther(Item item) {
        if (item.sellIn > 0) {
            decreaseQuality(1, item);
            decreaseSellIn(item);
        } else {
            decreaseQuality(2, item);
            decreaseSellIn(item);

        }
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void increaseQuality(int count, Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + count;
        }
    }

    private static void decreaseQuality(int count, Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - count;
        }
    }
}
