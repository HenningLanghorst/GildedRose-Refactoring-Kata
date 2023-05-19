package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;

class GildedRoseTest {


    @Test
    @DisplayName("At the end of each day our system lowers both values for every item")
    void quality_decrease() {
        Item[] items = new Item[]{new Item("foo", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("foo", 9, 19));
    }

    @Test
    @DisplayName("At the end of each day our system lowers both values for every item")
    void quality_decrease_after_sell_date() {
        Item[] items = new Item[]{new Item("foo", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("foo", -1, 18));
    }

    @CsvSource({
        "foo,2,1",
        "foo,1,1",
        "foo,2,0",
        "foo,1,0",
        "foo,0,0",
        "foo,-1,0",
    })
    @ParameterizedTest
    @DisplayName("The Quality of an item is never negative")
    void quality_never_ngeative(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item(name, sellIn - 1, 0));
    }

    @Test
    @DisplayName("Aged Brie” actually increases in Quality the older it gets")
    void aged_brie_increase() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Aged Brie", 9, 21));
    }

    @Test
    @DisplayName("Aged Brie” actually double increases in Quality the older it gets")
    void aged_brie_double_increase() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Aged Brie", -1, 22));
    }

    @ParameterizedTest
    @CsvSource({
        "Aged Brie,10,50",
        "Aged Brie,10,49",
        "Aged Brie,6,50",
        "Aged Brie,6,49",
        "Aged Brie,5,50",
        "Aged Brie,5,49",
        "Aged Brie,0,50",
        "Aged Brie,0,49",
        "Aged Brie,0,48",
        "Backstage passes to a TAFKAL80ETC concert,11,50",
        "Backstage passes to a TAFKAL80ETC concert,11,49",
        "Backstage passes to a TAFKAL80ETC concert,10,50",
        "Backstage passes to a TAFKAL80ETC concert,10,49",
        "Backstage passes to a TAFKAL80ETC concert,10,48",
        "Backstage passes to a TAFKAL80ETC concert,7,50",
        "Backstage passes to a TAFKAL80ETC concert,7,49",
        "Backstage passes to a TAFKAL80ETC concert,7,48",
        "Backstage passes to a TAFKAL80ETC concert,6,50",
        "Backstage passes to a TAFKAL80ETC concert,6,49",
        "Backstage passes to a TAFKAL80ETC concert,6,48",
        "Backstage passes to a TAFKAL80ETC concert,5,50",
        "Backstage passes to a TAFKAL80ETC concert,5,49",
        "Backstage passes to a TAFKAL80ETC concert,5,48",
        "Backstage passes to a TAFKAL80ETC concert,5,47",
    })
    @DisplayName("The Quality of an item is never more than 50")
    void max_quality_50(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item(name, sellIn - 1, 50));
    }

    @Test
    @DisplayName("“Sulfuras”, being a legendary item, never has to be sold or decreases in Quality")
    void sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Sulfuras, Hand of Ragnaros", 10, 20));
    }

    @Test
    @DisplayName("“Backstage passes”, like aged brie, increases in Quality as its SellIn value approaches; ")
    void backstage_passes__sellin_1__quality_20() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 21));
    }

    @Test
    @DisplayName("Quality of “Backstage passes” increases by 2 when there are 10 days or less")
    void backstage_passes__sellin_10__quality_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 12));
    }

    @Test
    @DisplayName("Quality of “Backstage passes” increases by 2 when there are 5 days or less")
    void backstage_passes__sellin_5__quality_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 13));
    }

    @Test
    @DisplayName("The Quality of a 'Backstage Passes' item is never more than 50")
    void backstage_passes__sellin_5__quality_48() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50));
    }

    @Test
    @DisplayName("Quality of 'Backstage Passes' drops to 0 after the concert")
    void backstage_passes__sellin_0__quality_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items)
            .usingRecursiveFieldByFieldElementComparator()
            .containsExactly(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
    }


}
