package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GildedRoseTempTest {
    @Test
    void other__sellin_1__quality_32() {

        Item item = new Item("foo", 1, 32);
        GildedRose.processOther(item);

        assertThat(item.sellIn).isZero();
        assertThat(item.quality).isEqualTo(31);
    }

    @Test
    void other__sellin_0__quality_32() {

        Item item = new Item("foo", 0, 32);
        GildedRose.processOther(item);

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(30);
    }
}
