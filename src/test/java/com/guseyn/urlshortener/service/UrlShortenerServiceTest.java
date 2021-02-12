package com.guseyn.urlshortener.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlShortenerServiceTest {
    @Test
    public void idToShortURL() {
        assertEquals(UrlShortenerService.idToShortURL(10), "k");
    }
}
