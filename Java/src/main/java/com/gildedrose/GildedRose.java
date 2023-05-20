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

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            decreaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            decreaseQuality(item);
                        }
                    }
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            decreaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            decreaseQuality(item);
                        }
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
                decreaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.quality = 0;
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                increaseQuality(item);
                break;
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
