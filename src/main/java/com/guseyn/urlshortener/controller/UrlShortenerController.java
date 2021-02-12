package com.guseyn.urlshortener.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {
    @GetMapping("/greeting")
    public Map<String, String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HashMap<String, String>(){{
            put("Hello", "World");
        }};
    }
}
