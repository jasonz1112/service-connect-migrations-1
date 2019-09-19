package com.opentable.gc.infra.connectmigrations.clients.config;

public class Configuration {


    private final String url;

    private final int delay;
    private final int maxDelay;
    private final int maxRetries;

    public Configuration(String url, int delay, int maxDelay, int maxRetries) {
        this.url = url;
        this.delay = delay;
        this.maxDelay = maxDelay;
        this.maxRetries = maxRetries;
    }

    public String getUrl() {
        return url;
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
