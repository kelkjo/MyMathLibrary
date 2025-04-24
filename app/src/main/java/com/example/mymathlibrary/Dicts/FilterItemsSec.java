package com.example.mymathlibrary.Dicts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterItemsSec {
    public static Map<String, Boolean> filterKeysTask = new LinkedHashMap<>();

    static {
        filterKeysTask.put("Стереометрия", false);
        filterKeysTask.put("Планиметрия", false);
        filterKeysTask.put("Четырёхугольник", false);
        filterKeysTask.put("Треугольник", false);
        filterKeysTask.put("Трапеция", false);
        filterKeysTask.put("Ромб", false);
        filterKeysTask.put("Прямоугольник", false);
        filterKeysTask.put("Квадрат", false);
        filterKeysTask.put("Площадь", false);
    }

    public static List<String> filterItemsTask = new ArrayList<String>() {{
        add("Стереометрия");
        add("Планиметрия");
        add("Четырёхугольник");
        add("Треугольник");
        add("Трапеция");
        add("Ромб");
        add("Прямоугольник");
        add("Квадрат");
        add("Площадь");
    }};
    public static List<Integer> filterHelperTask = new ArrayList<Integer>();
}