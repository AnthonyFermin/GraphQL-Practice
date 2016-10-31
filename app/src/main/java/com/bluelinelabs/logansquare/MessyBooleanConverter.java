package com.bluelinelabs.logansquare;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;

/**
 * Description: Parses out the value of the field as a String or boolean into a boolean. It writes
 * the value as a {@link Boolean}
 */
public class MessyBooleanConverter implements TypeConverter<Boolean> {
    @Override
    public Boolean parse(JsonParser jsonParser) throws IOException {
        String booleanString = jsonParser.getValueAsString(null);
        if (booleanString != null) {
            return "true".equalsIgnoreCase(booleanString);
        }
        return null;
    }

    @Override
    public void serialize(Boolean object, String fieldName, boolean writeFieldNameForObject, JsonGenerator jsonGenerator) throws IOException {
        if (fieldName != null && object != null) {
            jsonGenerator.writeBooleanField(fieldName, object);
        } else if (object != null) {
            jsonGenerator.writeBoolean(object);
        } else {
            if (fieldName != null) {
                jsonGenerator.writeFieldName(fieldName);
            }
            jsonGenerator.writeBoolean(false);
        }
    }
}
