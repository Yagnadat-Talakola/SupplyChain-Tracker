package com.supplychain.tracker.model;

import com.google.gson.annotations.SerializedName;

public class ErrorModel {

    @SerializedName("error_name")
    private String name;

    @SerializedName("error_description")
    private String description;

    public ErrorModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
