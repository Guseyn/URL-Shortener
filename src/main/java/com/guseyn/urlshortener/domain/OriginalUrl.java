package com.guseyn.urlshortener.domain;

import java.io.Serializable;

public class OriginalUrl implements Serializable {
    private String value;

    public OriginalUrl() {}

    public OriginalUrl(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
