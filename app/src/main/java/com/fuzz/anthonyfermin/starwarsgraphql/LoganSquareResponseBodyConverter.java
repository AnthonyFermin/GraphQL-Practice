package com.fuzz.anthonyfermin.starwarsgraphql;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Converter;

import static com.bluelinelabs.logansquare.ConverterUtils.parameterizedTypeOf;


public final class LoganSquareResponseBodyConverter implements Converter<ResponseBody, Object> {

    private final Type type;

    public LoganSquareResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public Object convert(ResponseBody value) throws IOException {
        try {

            // do not convert response body.
            if (type instanceof Class) {
                String name = ((Class) type).getName();
                String other = ResponseBody.class.getName();
                if (name.equals(other)) {
                    return value;
                }
            }

            BufferedSource bs = value.source();
            bs.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = bs.buffer();
            //Clone the buffer and set it as input stream, so we do not wipe the actual error body
            InputStream is = buffer.clone().inputStream();
            if (type instanceof Class) {
                // Plain object conversion
                return LoganSquare.parse(is, (Class<?>) type);

            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                Type firstType = typeArguments[0];

                Type rawType = parameterizedType.getRawType();
                if (rawType == Map.class) {
                    return LoganSquare.parseMap(is, (Class<?>) typeArguments[1]);

                } else if (rawType == List.class) {
                    return LoganSquare.parseList(is, (Class<?>) firstType);

                } else {
                    // Generics
                    return LoganSquare.parse(is, parameterizedTypeOf(type));
                }
            }
            return null;

        } finally {
            // Close the response body after being done with it
            value.close();
        }
    }
}

