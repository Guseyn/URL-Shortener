package com.guseyn.urlshortener.repository;

import com.guseyn.urlshortener.domain.Url;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<Url, Integer> {
    List<Url> findAll();
    Url findByShortened(String shortened);
    Url findByOriginal(String original);
}
