package com.example.mymathlibrary;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theory extends Fragment {
    private Drawable imagev;
    public static Map<String, Integer> theoryKeys = new HashMap<String, Integer>()
    {{
        put("Теорема Пифагора", 0);
        put("Теорема Фалеса", 1);
    }};
    public static String[] theoryDef = {"Сумма квадратов катетов равна квадрату гипотенузы.",
            "Если параллельные прямые, пересекающие стороны угла, отсекают на одной его стороне равные отрезки, то они отсекают равные отрезки и на другой стороне угла."};
    public static String[] theoryImago = {"pifagor_theorem", "fales_theorem"};
}