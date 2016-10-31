package com.fuzz.anthonyfermin.starwarsgraphql.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by afermin on 10/31/16.
 */
@JsonObject
public class AllPeople {

    @JsonField
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "AllPeople{" +
                "totalCount=" + totalCount +
                '}';
    }
}
