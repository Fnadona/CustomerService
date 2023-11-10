package com.example.customer.exceptions.structure;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GeneralErrorSerializer extends JsonSerializer<GeneralError> {
    @Override
    public void serialize(GeneralError value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("type", value.name());
        gen.writeObjectField("code", value.getErrorCode().toString());
        gen.writeObjectField("message", value.getErrorMessage());
        gen.writeEndObject();
    }
}
