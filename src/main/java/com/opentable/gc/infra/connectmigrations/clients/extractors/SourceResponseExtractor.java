package com.opentable.gc.infra.connectmigrations.clients.extractors;

import java.io.IOException;

import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;

public interface SourceResponseExtractor {

    SourceResponse extract(String response) throws IOException;

}
