package com.guseyn.urlshortener.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String original;
    private String shortened;

    protected Url() {
    }

    public Url(int id, String original, String shortened) {
        this.id = id;
        this.original = original;
        this.shortened = shortened;
    }

    public Url(String original, String shortened) {
        this.original = original;
        this.shortened = shortened;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, original='%s', shortened='%s']",
            id, original, shortened);
    }

    public int getId() {
        return id;
    }

    public String getOriginal() {
        return original;
    }

    public String getShortened() {
        return shortened;
    }
}
