package com.guseyn.urlshortener.controller;

import com.guseyn.urlshortener.domain.OriginalUrl;
import com.guseyn.urlshortener.domain.Url;
import com.guseyn.urlshortener.repository.UrlRepository;
import com.guseyn.urlshortener.service.UrlShortenerService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class UrlShortenerController {
    @Autowired
    UrlRepository urlRepository;
    @Value("${service-url}")
    private String serviceUrl;

    @GetMapping("url/by/original")
    public Url getByOriginal(
        @RequestParam(
            value = "value",
            defaultValue = "https://guseyn.com/posts/type-is-not-source-of-behaviour?v=1.0.227") String original) {
        return urlRepository.findByOriginal(original);
    }

    @GetMapping("url/by/shortened")
    public Url getByShortened(
        @RequestParam(
            value = "value",
            defaultValue = "http://localhost:8080/short1") String shortened) {
        return urlRepository.findByShortened(shortened);
    }

    @GetMapping("/r/**")
    public RedirectView redirect(HttpServletRequest request) {
        Url originalPage = urlRepository.findByShortened(
            request.getRequestURL().toString()
        );
        if (Objects.isNull(originalPage)) {
            return new RedirectView();
        }
        return new RedirectView(originalPage.getOriginal());
    }

    @PostMapping(
        value = "url/shorten",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  Url shorten(@RequestBody OriginalUrl originalUrl) {
        Url foundUrl = urlRepository.findByOriginal(originalUrl.getValue());
        if (!Objects.isNull(foundUrl)) {
            return foundUrl;
        }
        Url savedOriginalUrl = urlRepository.save(
            new Url(originalUrl.getValue(), "")
        );
        return urlRepository.save(
            new Url(
                savedOriginalUrl.getId(),
                originalUrl.getValue(),
                String.format(
                    "%s/r/%s",
                    serviceUrl,
                    UrlShortenerService.idToShortURL(savedOriginalUrl.getId())
                )
            )
        );
    }
}
