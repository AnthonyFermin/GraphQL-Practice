package com.fuzz.anthonyfermin.starwarsgraphql.model;


import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.fuzz.anthonyfermin.starwarsgraphql.Beautifier;

import java.io.IOException;

/**
 * Created by afermin on 10/31/16.
 */
@JsonObject
public class GraphQLResponse {

    @JsonField
    private GraphQLData data;

    public GraphQLData getData() {
        return data;
    }

    public void setData(GraphQLData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String string = "";
        try {
            string = LoganSquare.mapperFor(GraphQLData.class).serialize(data);
            string = Beautifier.beautify(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
