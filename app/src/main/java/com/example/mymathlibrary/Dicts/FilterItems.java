package com.example.mymathlibrary.Dicts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterItems {
    public static Map<String, Boolean> filterKeys = new LinkedHashMap<>();
    static {
        filterKeys.put("Теорема", false);
        filterKeys.put("Определение", false);
        filterKeys.put("Аксиома", false);
        filterKeys.put("Треугольник", false);
        filterKeys.put("Прямая", false);
        filterKeys.put("Угол", false);
    }
    public static List<String> filterItems = new ArrayList<String>()
    {{
        add("Теорема");
        add("Определение");
        add("Аксиома");
        add("Треугольник");
        add("Прямая");
        add("Угол");
    }};
    public static List<Integer> filterHelper = new ArrayList<Integer>();
}
