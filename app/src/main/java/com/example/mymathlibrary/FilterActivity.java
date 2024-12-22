package com.example.mymathlibrary;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import static com.example.mymathlibrary.Dicts.FilterItems.filterHelper;
import static com.example.mymathlibrary.Dicts.FilterItems.filterItems;
import static com.example.mymathlibrary.Dicts.FilterItems.filterKeys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FilterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        Button back = new Button(this);
        ll.addView(back);
        List<CheckBox> checkArray = new ArrayList<>();
        List<Boolean> boolArray = new ArrayList<>();
        for ( Map.Entry<String, Boolean> entry : filterKeys.entrySet()) {
            Boolean tab = entry.getValue();
            boolArray.add(tab);
        }
        for(int i = 0; i < filterItems.size(); i++) {
            CheckBox cb = new CheckBox(this);
            if (boolArray.get(i)){
                cb.setChecked(true);
            }
            cb.setText(filterItems.get(i));
            checkArray.add(cb);
            ll.addView(cb);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FilterActivity.this, LibraryList.class);
                Map<String, Boolean> demoMap = new LinkedHashMap<>();
                filterHelper.clear();
                for (int i = 0; i < filterKeys.size(); i++) {
                    if (checkArray.get(i).isChecked()){
                        demoMap.put((String) filterItems.get(i), true);
                        filterHelper.add(filterItems.indexOf(filterItems.get(i)));
                    } else {
                        demoMap.put((String) filterItems.get(i), false);
                    }
                }
                System.out.println(filterHelper);
                filterKeys = demoMap;
                startActivity(intent);
            }
        });
        this.setContentView(sv);
    }
}