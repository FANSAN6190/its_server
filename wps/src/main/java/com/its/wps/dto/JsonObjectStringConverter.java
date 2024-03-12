package com.its.wps.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.its.wps.model.Whistle;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
@Converter
@Slf4j
public class JsonObjectStringConverter implements AttributeConverter<Whistle, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Whistle whistleObj) {
        try {
            return objectMapper.writeValueAsString(whistleObj);
        } catch (JsonProcessingException jpe) {
            log.warn("Cannot convert Whistle Object into JSON");
            return null;
        }
    }

    @Override
    public Whistle convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, Whistle.class);
        } catch (JsonProcessingException e) {
            log.warn("Cannot convert JSON into Whistle Object");
            return null;
        }
    }
}
