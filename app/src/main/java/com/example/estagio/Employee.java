package com.example.estagio;

import com.google.gson.annotations.SerializedName;

public class Employee {
    private String Name;
    private int id;
    private String email;
    @SerializedName("address")
    private adress Address;

    public Employee(String Name, int id, String email, adress Address) {
        this.Name = Name;
        this.id = id;
        this.email = email;
        this.Address = Address;
    }
}
