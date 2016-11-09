package com.fuzz.anthonyfermin.starwarsgraphql.model;

import com.anthonyfdev.graphQLQueryGen.GraphQLField;
import com.anthonyfdev.graphQLQueryGen.GraphQLObject;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by afermin on 10/31/16.
 */

@GraphQLObject
@JsonObject
public class AllPeople {

    @GraphQLField(type = "totalCount")
    @JsonField
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AllPeople{" +
                "count=" + count +
                '}';
    }
}
