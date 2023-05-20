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
        int adjustment = calculateQualityChange(item);
        adjustQuality(item, adjustment);
        decreaseSellInDate(item);
    }

    private static int calculateQualityChange(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> {
                if (isExpired(item)) yield 2;
                yield 1;
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                if (isExpired(item)) {
                    yield -item.quality;
                } else if (item.sellIn < 6) {
                    yield 3;
                } else if (item.sellIn < 11) {
                    yield 2;
                } else {
                    yield 1;
                }
            }
            case "Sulfuras, Hand of Ragnaros" -> 0;
            default -> {
                if (isExpired(item)) yield -2;
                yield -1;
            }
        };
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
