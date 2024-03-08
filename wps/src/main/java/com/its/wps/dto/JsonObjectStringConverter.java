package com.its.wps.dto;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;
import org.json.JSONObject;

@Converter
public class JsonObjectStringConverter implements AttributeConverter<JSONObject, String> {

    @Override
    public String convertToDatabaseColumn(JSONObject attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.toString();
    }

    @Override
    public JSONObject convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return new JSONObject(dbData);
    }
}