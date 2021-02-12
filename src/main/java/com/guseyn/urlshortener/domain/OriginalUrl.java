package com.guseyn.urlshortener.domain;

public class OriginalUrl {
    private String value;

    protected OriginalUrl() {}

    public OriginalUrl(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
