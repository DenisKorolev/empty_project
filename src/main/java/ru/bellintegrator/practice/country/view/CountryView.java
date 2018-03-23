package ru.bellintegrator.practice.country.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class CountryView {
    @JsonProperty("name")
    public String countryName;

    @JsonProperty("code")
    public String countryCode;

    public CountryView(){

    }

    public CountryView(String countryName, String countryCode){
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @Override
    public String toString(){
        return "{name:" + countryName + "; code:" + countryCode + "}";
    }
}
