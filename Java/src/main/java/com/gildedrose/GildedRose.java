package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> increaseQuality(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> handleBackstagePass(item);
                case "Sulfuras, Hand of Ragnaros" -> doNothing();
                default -> decreaseQuality(item);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                handleExpired(item);
            }
        }
    }

    private static void handleBackstagePass(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }


    private static void handleExpired(Item item) {
        switch (item.name) {
            case "Aged Brie" -> increaseQuality(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> setZeroQuality(item);
            case "Sulfuras, Hand of Ragnaros" -> doNothing();
            default -> decreaseQuality(item);
        }
    }

    private static void doNothing() {
        // placeholder for doing nothing
    }

    private static void setZeroQuality(Item item) {
        item.quality = 0;
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
