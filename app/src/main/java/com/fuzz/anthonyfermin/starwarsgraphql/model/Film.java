package com.fuzz.anthonyfermin.starwarsgraphql.model;

import com.anthonyfdev.graphQLQueryGen.GraphQLField;
import com.anthonyfdev.graphQLQueryGen.GraphQLObject;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by afermin on 11/9/16.
 */

@GraphQLObject
@JsonObject
public class Film {

    @GraphQLField
    @JsonField
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
