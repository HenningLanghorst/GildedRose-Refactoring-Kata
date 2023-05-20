package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> increaseQuality(item, 1);
                case "Backstage passes to a TAFKAL80ETC concert" -> handleBackstagePass(item);
                case "Sulfuras, Hand of Ragnaros" -> doNothing();
                default -> decreaseQuality(item, 1);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                switch (item.name) {
                    case "Aged Brie" -> increaseQuality(item, 1);
                    case "Backstage passes to a TAFKAL80ETC concert" -> setZeroQuality(item);
                    case "Sulfuras, Hand of Ragnaros" -> doNothing();
                    default -> decreaseQuality(item, 1);
                }
            }
        }
    }

    private static void handleBackstagePass(Item item) {

        if (item.sellIn < 6) {
            increaseQuality(item, 3);
        } else if (item.sellIn < 11) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }


    private static void doNothing() {
        // placeholder for doing nothing
    }

    private static void setZeroQuality(Item item) {
        item.quality = 0;
    }

    private static void increaseQuality(Item item, int count) {
        item.quality = Math.min(50, item.quality + count);
    }

    private static void decreaseQuality(Item item, int count) {
        item.quality = Math.max(0, item.quality - count);
    }
}
