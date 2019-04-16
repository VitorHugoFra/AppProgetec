package com.example.estagio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name = "Vitor";

        adress adress = new adress("Brazil", "Betim");

        Gson gson = new Gson();
        /*Employee employee = new Employee(name,30, "vitorhdepaula1@gmail.com",adress);
        String json = gson.toJson(employee);*/

        String json = "{\"address\":{\"city\":\"Betim\",\"country\":\"Brazil\"},\"email\": \"vitorhdepaula1@gmail.com\",\"id\": 2,\"Name\": \"Eu\"}";
        Employee employee = gson.fromJson(json,Employee.class);

    }
}
