package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import com.bumptech.glide.Glide;
import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterItemsTask;
import static com.example.mymathlibrary.Dicts.Tasks.taskDef;
import static com.example.mymathlibrary.Dicts.Tasks.taskFilter;
import static com.example.mymathlibrary.Dicts.Tasks.taskImago;
import static com.example.mymathlibrary.Dicts.Tasks.taskList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class TaskIntent extends AppCompatActivity {
    private ImageView imageIV;
    private TextView textTV;
    private TextView textType;
    private ImageView btLibrary;
    @SuppressLint({"ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theorem_intent);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        String nameT = getIntent().getStringExtra("Name");
        int a  = taskList.indexOf(nameT);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.kid_font);

        textType = (TextView) findViewById(R.id.tv_intent_type);
        textType.setText(filterItemsTask.get(Integer.parseInt((taskFilter.get(a)).substring(0, 1))));
        textType.setTypeface(typeface);
        textType.setTextColor(R.color.greeny);
        textType.setTextSize(30);

        textTV = (TextView) findViewById(R.id.tv_intent);
        textTV.setText(taskDef.get(a));
        textTV.setTypeface(typeface);
        textTV.setTextColor(R.color.arlekin);
        textTV.setTextSize(30);

        ImageView imageIV = (ImageView) findViewById(R.id.iv_intent);
        String imageName = (String) taskImago.get(a);
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        Glide.with(this).load(resId).into(imageIV);

        btLibrary = (ImageView) findViewById(R.id.bt_backlb);
        btLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(TaskIntent.this, TaskList.class);
                finishAndRemoveTask();
            }
        });
    }

}