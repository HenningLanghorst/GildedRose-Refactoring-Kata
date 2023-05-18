package com.gildedrose;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo__sellin_10__quality_20() {
        Item[] items = new Item[]{new Item("foo", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("foo", 9, 19));
    }
    @Test
    void foo__sellin_minus1__quality_20() {
        Item[] items = new Item[]{new Item("foo", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("foo", -2, 18));
    }

    @Test
    void foo__sellin_10__quality_0() {
        Item[] items = new Item[]{new Item("foo", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("foo", 9, 0));
    }

    @Test
    void foo__sellin_0__quality_0() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("foo", -1, 0));
    }

    @Test
    void aged_brie__sellin_10__quality_20() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Aged Brie", 9, 21));
    }

    @Test
    void aged_brie__sellin_10__quality_0() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Aged Brie", 9, 1));
    }

    @Test
    void aged_brie__sellin_0__quality_0() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Aged Brie", -1, 2));
    }

    @Test
    void backstage_passes__sellin_10__quality_20() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22));
    }

    @Test
    void backstage_passes__sellin_10__quality_0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2));
    }

    @Test
    void backstage_passes__sellin_0__quality_0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
    }

    @Test
    void sulfuras__sellin_10__quality_20() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Sulfuras, Hand of Ragnaros", 10, 20));
    }

    @Test
    void sulfuras__sellin_10__quality_0() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Sulfuras, Hand of Ragnaros", 10, 0));
    }

    @Test
    void sulfuras__sellin_0__quality_0() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Sulfuras, Hand of Ragnaros", 0, 0));
    }

}
