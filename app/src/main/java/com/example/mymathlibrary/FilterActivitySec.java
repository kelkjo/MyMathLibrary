package com.example.mymathlibrary;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterHelperTask;
import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterItemsTask;
import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterKeysTask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FilterActivitySec extends AppCompatActivity {
    private Context context;

    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_sec);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        List<CheckBox> checkArray = new ArrayList<>();
        List<Boolean> boolArray = new ArrayList<>();
        for ( Map.Entry<String, Boolean> entry : filterKeysTask.entrySet()) {
            Boolean tab = entry.getValue();
            boolArray.add(tab);
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.parseColor("#7ac28a"));
        linearLayout.setPadding(16, 16, 16, 16);
        ImageView backButton = new ImageView(this);
        backButton.setImageResource(R.drawable.backarrowm);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        imageParams.setMargins(0, 0, 16, 0);
        backButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        backButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        backButton.setScaleX(1.4f);
        backButton.setScaleY(1.4f);
        backButton.setLayoutParams(imageParams);
        linearLayout.addView(backButton);
        for(int i = 0; i < filterItemsTask.size(); i++) {
            CheckBox cb = new CheckBox(this);
            if (boolArray.get(i)){
                cb.setChecked(true);
            }
            cb.setButtonDrawable(R.drawable.checkbox_selector);
            cb.setText(filterItemsTask.get(i));
            cb.setTextColor(Color.parseColor("#2b452a"));
            cb.setTextSize(24);
            checkArray.add(cb);
            Typeface typeface = ResourcesCompat.getFont(this, R.font.fredoka_one);
            cb.setTypeface(typeface);
            cb.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            linearLayout.addView(cb);
        }
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilterActivitySec.this, TaskList.class);
                Map<String, Boolean> demoMap = new LinkedHashMap<>();
                filterHelperTask.clear();
                for (int i = 0; i < filterKeysTask.size(); i++) {
                    if (checkArray.get(i).isChecked()){
                        demoMap.put((String) filterItemsTask.get(i), true);
                        filterHelperTask.add(filterItemsTask.indexOf(filterItemsTask.get(i)));
                    } else {
                        demoMap.put((String) filterItemsTask.get(i), false);
                    }
                }
                System.out.println(filterHelperTask);
                filterKeysTask = demoMap;
                startActivity(intent);
            }
        });
        setContentView(linearLayout);
    }
}