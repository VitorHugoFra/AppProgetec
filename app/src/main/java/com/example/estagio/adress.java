package com.example.estagio;

import com.google.gson.annotations.SerializedName;

public class adress {
    @SerializedName("country")
    private String Country;
    @SerializedName("city")
    private String City;


    public adress(String Country,String City) {
        this.Country = Country;
        this.City = City;
    }
}
