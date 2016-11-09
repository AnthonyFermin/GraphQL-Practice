package com.fuzz.anthonyfermin.starwarsgraphql.model;

import com.anthonyfdev.graphQLQueryGen.GraphQLField;
import com.anthonyfdev.graphQLQueryGen.GraphQLObject;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by afermin on 10/31/16.
 */

@GraphQLObject
@JsonObject
public class AllFilms {

    @GraphQLField
    @JsonField
    private int totalCount;

    @GraphQLField
    @JsonField
    private List<Film> films;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "AllFilms { \n" +
                "\ttotalCount= " + totalCount + "\n" +
                "\tfilms= " + films + "\n" +
                '}';
    }
}
