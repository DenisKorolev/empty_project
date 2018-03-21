package ru.bellintegrator.practice.country.view;

import io.swagger.annotations.ApiModelProperty;

public class CountryView {

    public String countryName;

    public long countryCode;

    public CountryView(){

    }

    public CountryView(String countryName, long countryCode){
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @Override
    public String toString(){
        return "{name:" + countryName + "; code:"+countryCode;
    }
}
