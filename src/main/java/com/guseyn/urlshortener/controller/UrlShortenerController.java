package com.guseyn.urlshortener.controller;

import com.guseyn.urlshortener.domain.OriginalUrl;
import com.guseyn.urlshortener.domain.Url;
import com.guseyn.urlshortener.repository.UrlRepository;
import com.guseyn.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("url")
public class UrlShortenerController {
    @Autowired
    UrlRepository urlRepository;
    @Autowired
    UrlShortenerService urlShortenerService;
    @Value("${service-url}")
    private String serviceUrl;

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

    @PostMapping("/shorten")
    public Url shorten(@RequestBody OriginalUrl originalUrl) {
        Url savedOriginalUrl = urlRepository.save(originalUrl.getValue(), "");
        return urlRepository.save(
            new Url(
                savedOriginalUrl.getId(),
                originalUrl.getValue(),
                String.format(
                    "%s/%s",
                    serviceUrl,
                    urlShortenerService.idToShortURL(savedOriginalUrl.getId())
                )
            )
        );
    }
}
