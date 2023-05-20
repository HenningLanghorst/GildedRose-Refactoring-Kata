package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityOf(item);
        }
    }

    private static void updateQualityOf(Item item) {
        int adjustment = switch (item.name) {
            case "Aged Brie" -> agedBrieQualityChange(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> backstagePassQualityChange(item);
            case "Sulfuras, Hand of Ragnaros" -> 0;
            default -> othersQualityChange(item);
        };
        adjustQuality(item, adjustment);
        decreaseSellInDate(item);
    }

    private static int agedBrieQualityChange(Item item) {
        return isExpired(item) ? 2 : 1;
    }

    private static int backstagePassQualityChange(Item item) {
        if (isExpired(item)) {
            return -item.quality;
        } else if (item.sellIn < 6) {
            return 3;
        } else if (item.sellIn < 11) {
            return 2;
        } else {
            return 1;
        }
    }

    private static int othersQualityChange(Item item) {
        return isExpired(item) ? -2 : -1;
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 1;
    }

    private static void adjustQuality(Item item, int adjustment) {
        item.quality = Math.max(0, Math.min(50, item.quality + adjustment));
    }

    private static void decreaseSellInDate(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

}
