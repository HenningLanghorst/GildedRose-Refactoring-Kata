package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void characterizationTest() {

        // given
        Item[] items = items();
        GildedRose app = new GildedRose(items);
        // when
        app.updateQuality();
        // then
        String resultAsString = Arrays.stream(app.items).map(Item::toString).collect(Collectors.joining("\n"));
        assertEquals(expected(), resultAsString);

    }

    private static Item[] items() {
        return Stream.of(
                "Aged Brie",
                "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros",
                "Other"
            ).flatMap(itemType -> IntStream.range(-5, 55)
                .mapToObj(sellIn -> IntStream.range(0, 51)
                    .mapToObj(quality -> new Item(
                        itemType,
                        sellIn,
                        quality
                    )))
            ).flatMap(Function.identity())
            .toArray(Item[]::new);
    }

    private static String expected() {

        try (
            InputStream stream = ClassLoader.getSystemResourceAsStream("expected.txt");
            ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            Objects.requireNonNull(stream, "Resource not found").transferTo(out);
            return out.toString(StandardCharsets.UTF_8).trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
