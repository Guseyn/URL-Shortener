package com.guseyn.urlshortener.service;

import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {
    public String idToShortURL(int n) {
        final char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        final StringBuilder shortUrl = new StringBuilder();
        final int mapSize = map.length;
        while (n > 0) {
            shortUrl.append(map[n % mapSize]);
            n = n / mapSize;
        }
        return shortUrl.reverse().toString();
    }
}
