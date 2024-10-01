package com.example.mymathlibrary;

import android.widget.ImageView;

import com.example.mymathlibrary.Engine.Item;

import java.util.HashMap;
import java.util.Map;

public class Theory {
    public static Map<String, Integer> theoryKey;
    public static Map<Integer, String> theoryImago;
    public static Map<Integer, String> theoryDef;
    public static void main(String[] args) {
        theoryKey = new HashMap<>();
        theoryImago = new HashMap<>();
        theoryKey.put("Apple",0);
        theoryKey.put("Banana", 1);
        theoryKey.put("Cherry", 2);
        theoryKey.put("Date", 3);
        theoryKey.put("Fig", 4);
        theoryKey.put("Grape", 5);
        theoryKey.put("Kiwi", 6);
        theoryKey.put("Lemon", 7);
        theoryKey.put("Mango", 8);
        theoryKey.put("Orange", 9);
        theoryKey.put("Papaya", 10);
        theoryKey.put("Peach", 11);
        theoryKey.put("Pear", 12);
        theoryKey.put("Pineapple", 13);
        theoryKey.put("Plum", 14);
        theoryKey.put("Raspberry",  15);
        theoryKey.put("Strawberry",  16);
        theoryKey.put("Tangerine",  17);
        theoryKey.put("Watermelon",  18);
        theoryImago.put(0, "pifagor_theorem.png");
        theoryDef.put(0, "summa kvadratov");
    }
}
