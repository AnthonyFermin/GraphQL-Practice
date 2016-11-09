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
public class GraphQLData {

    @GraphQLField
    @JsonField
    private AllFilms allFilms;

    @GraphQLField
    @JsonField
    private AllPeople allPeople;

    @JsonField
    private Person luke;

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

    public Person getLuke() {
        return luke;
    }

    public void setLuke(Person luke) {
        this.luke = luke;
    }

    @Override
    public String toString() {
        return "GraphQLData{" +
                "allFilms=" + allFilms +
                ", allPeople=" + allPeople +
                '}';
    }
}
