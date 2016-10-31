package com.fuzz.anthonyfermin.starwarsgraphql;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by afermin on 10/31/16.
 */

@JsonObject
public class GraphQLQuery {

    @JsonField
    private String query;

    public GraphQLQuery() {
        //default Constructor
    }

    public GraphQLQuery(String graphQLRequest) {
        query = graphQLRequest;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
