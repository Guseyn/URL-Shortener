package com.guseyn.urlshortener.controller;

import com.guseyn.urlshortener.domain.Url;
import com.guseyn.urlshortener.repository.UrlRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("url")
public class UrlShortenerController {
    @Autowired
    UrlRepository urlRepository;

    @GetMapping
    public Url getByShortened(
        @RequestParam(
            value = "shortened",
            defaultValue = "http://localhost:8080/short1") String shortened) {
        return urlRepository.findByShortened(shortened);
    }

    @GetMapping("/redirect")
    public RedirectView redirect(
        @RequestParam(
            value = "shortened",
            defaultValue = "http://localhost:8080/short1") String shortened) {
        return new RedirectView(urlRepository.findByShortened(shortened).getOriginal());
    }
}
