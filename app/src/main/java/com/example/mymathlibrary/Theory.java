package com.example.mymathlibrary;

import com.example.mymathlibrary.Engine.Item;

import java.util.HashMap;
import java.util.Map;

public class Theory {
    public static Map<Item, Integer> theoryKey;
    public static void main(String[] args){
        theoryKey = new HashMap<>();
        theoryKey.put(new Item("Apple","Theory"), 0);
        theoryKey.put(new Item("Banana","Theory"), 1);
        theoryKey.put(new Item("Cherry","Theory"), 2);
        theoryKey.put(new Item("Date","Theory"), 3);
        theoryKey.put(new Item("Fig","Theory"), 4);
        theoryKey.put(new Item("Grape","Theory"), 5);
        theoryKey.put(new Item("Kiwi","Theory"), 6);
        theoryKey.put(new Item("Lemon","Theory"), 7);
        theoryKey.put(new Item("Mango","Theory"), 8);
        theoryKey.put(new Item("Orange","Theory"), 9);
        theoryKey.put(new Item("Papaya","Theory"), 10);
        theoryKey.put(new Item("Peach","Theory"), 11);
        theoryKey.put(new Item("Pear","Theory"), 12);
        theoryKey.put(new Item("Pineapple","Theory"), 13);
        theoryKey.put(new Item("Plum","Theory"), 14);
        theoryKey.put(new Item("Raspberry","Theory"), 15);
        theoryKey.put(new Item("Strawberry","Theory"), 16);
        theoryKey.put(new Item("Tangerine","Theory"), 17);
        theoryKey.put(new Item("Watermelon","Theory"), 18);
    }
}
