package com.opentable.gc.infra.connectmigrations.clients.config;

import com.opentable.gc.infra.connectmigrations.clients.extractors.SourceResponseExtractor;

public class SourceConfiguration {


    private final String url;

    private final SourceResponseExtractor extractor;

    private final int delay;
    private final int maxDelay;
    private final int maxRetries;

    public SourceConfiguration(String url, SourceResponseExtractor extractor, int delay, int maxDelay, int maxRetries) {
        this.url = url;
        this.extractor = extractor;
        this.delay = delay;
        this.maxDelay = maxDelay;
        this.maxRetries = maxRetries;
    }

    public String getUrl() {
        return url;
    }

    public SourceResponseExtractor getExtractor() {
        return extractor;
    }

    public int getDelay() {
        return delay;
    }

    public int getMaxDelay() {
        return maxDelay;
    }

    public int getMaxRetries() {
        return maxRetries;
    }
}
