package com.gildedrose;

public abstract class ItemWrapper {
    protected final Item item;

    protected ItemWrapper(Item item) {
        this.item = item;
    }

    abstract void updateQuality();

    public static ItemWrapper from(Item item) {
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(item);
            default -> new OtherItem(item);
        };
    }
}
