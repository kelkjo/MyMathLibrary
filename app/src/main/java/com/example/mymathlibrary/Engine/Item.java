package com.example.mymathlibrary.Engine;

public class Item {
    private final String name;
    private final String type;
    public Item(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getItemName(){return name;}
    public String getItemType(){return type;}
}
