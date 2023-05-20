package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        inreaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        inreaseQuality(item);
                    }
                }
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                handleExpired(item);
            }
        }
    }


    private static void handleExpired(Item item) {
        String name = item.name;
        switch (name) {
            case "Aged Brie":
                inreaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.quality = 0;
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                decreaseQuality(item);
                break;
        }
    }

    private static void inreaseQuality(Item item) {
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
