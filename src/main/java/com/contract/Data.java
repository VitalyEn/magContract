package com.contract;

import java.util.HashMap;

public class Data {
    private HashMap<String, Object> properties;

    public Data(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    //Get properties
    public Object getProperty(String key) {
        return this.properties.getOrDefault(key, null);
    }
}
