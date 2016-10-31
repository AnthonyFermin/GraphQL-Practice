package com.fuzz.anthonyfermin.starwarsgraphql.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by afermin on 10/31/16.
 */

@JsonObject
public class GraphQLData {

    @JsonField
    private AllFilms allFilms;

    @JsonField
    private AllPeople allPeople;

    public AllFilms getAllFilms() {
        return allFilms;
    }

    public void setAllFilms(AllFilms allFilms) {
        this.allFilms = allFilms;
    }

    public AllPeople getAllPeople() {
        return allPeople;
    }

    public void setAllPeople(AllPeople allPeople) {
        this.allPeople = allPeople;
    }

    @Override
    public String toString() {
        return "GraphQLData{" +
                "allFilms=" + allFilms +
                ", allPeople=" + allPeople +
                '}';
    }
}
