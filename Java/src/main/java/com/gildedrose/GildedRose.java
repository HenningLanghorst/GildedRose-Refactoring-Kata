package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> {
                    adjustQuality(item, isExpired(item) ? 2 : 1);
                }
                case "Backstage passes to a TAFKAL80ETC concert" -> {
                    adjustQuality(item, backstagePassQualityIncrease(item));
                    if (isExpired(item)) adjustQuality(item, -item.quality);
                }
                case "Sulfuras, Hand of Ragnaros" -> {
                    adjustQuality(item, 0);
                }
                default -> {
                    adjustQuality(item, isExpired(item) ? -2 : -1);
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

        }
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 1;
    }

    private static int backstagePassQualityIncrease(Item item) {
        if (item.sellIn < 6) {
            return 3;
        } else if (item.sellIn < 11) {
            return 2;
        } else {
            return 1;
        }
    }

    private static void adjustQuality(Item item, int count) {
        item.quality = Math.max(0, Math.min(50, item.quality + count));
    }

}
