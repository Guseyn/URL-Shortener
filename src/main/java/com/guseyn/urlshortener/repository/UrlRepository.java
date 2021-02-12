package com.guseyn.urlshortener.repository;

import com.guseyn.urlshortener.domain.Url;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Long> {
    List<Url> findAll();
    Url findByShortened(String original);
    Url save(String original, String shortened);
    Url save(Url url);
}
