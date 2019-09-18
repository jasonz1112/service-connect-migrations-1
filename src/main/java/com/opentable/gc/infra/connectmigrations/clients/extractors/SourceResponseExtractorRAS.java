package com.opentable.gc.infra.connectmigrations.clients.extractors;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opentable.gc.infra.connectmigrations.clients.SourceResponse;
import com.opentable.gc.infra.connectmigrations.util.Converter;

public class SourceResponseExtractorRAS implements SourceResponseExtractor {


    private static final Logger LOG = LoggerFactory.getLogger(SourceResponseExtractorRAS.class);


    @Override
    public SourceResponse extract(String response) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

            JsonNode node = mapper.readTree(response);

            JsonNode restaurantType = node.at("/core/restaurant/restaurantType");
            JsonNode rid = node.at("/core/restaurant/restaurantId");
            JsonNode country = node.at("/core/restaurant/countryCode");
            JsonNode restaurantName = node.at("/content/restaurantLocal/en-US/restaurantName");
            JsonNode stateId = node.at("/core/restaurant/restaurantStateId");
            String stateDescription = Converter.getStateDescription(stateId.toString());
            String typeDesc = Converter.getTypeDescription(restaurantType.textValue());

            return new SourceResponse(rid.toString(), restaurantType.textValue(), typeDesc, country.textValue(), restaurantName.textValue(), stateId.toString(), stateDescription);

        } catch (IOException io) {
            LOG.error(io.getMessage());
            throw io;
        }
    }


}
