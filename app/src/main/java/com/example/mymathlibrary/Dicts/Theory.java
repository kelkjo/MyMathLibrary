package com.example.mymathlibrary.Dicts;
import java.util.ArrayList;
import java.util.List;

public class Theory {
    public static List<String> theoryList = new ArrayList<String>() {{
        add("Точка");
        add("Прямая");
        add("Отрезок");
        add("Луч");
        add("Угол");
        add("Полуплоскость");
        add("Теорема Пифагора");
        add("Теорема Фалеса");
    }};
    public static List<String> theoryDef = new ArrayList<String>() {{
        add("Точка — это геометрическая фигура, не имеющая размеров.");
        add("Прямая — это геометрическая фигура, не имеющая ширины.");
        add("Каждый отрезок получается так: на прямой берут две точки А и В (рис. 12). Их называют концами отрезка. Сам же отрезок состоит из этих выделенных точек А и В и всех точек прямой, лежащих между ними.");
        add("Любая точка О прямой разделяет ее на две части (рис. 10). Каждая из этих частей называется лучом, исходящим из точки О — начала луча. ");
        add("Угол - это геометрическая фигура, состоящая из точки и двух лучей, исходящих из этой точки.");
        add("Любая прямая разделяет плоскость на две части, каждая из которых называется полуплоскостью, а сама прямая служит границей этих полуплоскостей.");
        add("Сумма квадратов катетов равна квадрату гипотенузы.");
        add("Если параллельные прямые, пересекающие стороны угла, отсекают на одной его стороне равные отрезки, то они отсекают равные отрезки и на другой стороне угла.");
    }};
    public static List<String> theoryImago = new ArrayList<String>() {{
        add("point_def");
        add("straight_def");
        add("cut_def");
        add("ray_def");
        add("angle_def");
        add("halfflat_def");
        add("pifagor_theorem");
        add("fales_theorem");
    }};
    public static List<String> theoryFilter = new ArrayList<String>() {{
        add("1");
        add("14");
        add("1");
        add("1");
        add("15");
        add("1");
        add("03");
        add("04");
    }};
}