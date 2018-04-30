package com.telstra.gw.conf;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by abhishek.vangala on 3/26/2018.
 */

@Component
public class Config {

    public JsonObject getConfig() {
        return config;
    }

    public void setConfig(JsonObject config) {
        this.config = config;
    }

    JsonObject config = null;

    @PostConstruct
    public void  init(){
        Gson gson = new Gson();
        System.out.print(System.getProperty("user.dir"));
               JsonReader reader = new JsonReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("config.json")));
            config = gson.fromJson(reader,JsonObject.class);
    }


}
