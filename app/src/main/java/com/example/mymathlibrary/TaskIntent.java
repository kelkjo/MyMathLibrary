package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import com.bumptech.glide.Glide;

import static com.example.mymathlibrary.Dicts.Tasks.taskAnswers;
import static com.example.mymathlibrary.Dicts.Tasks.taskDef;
import static com.example.mymathlibrary.Dicts.Tasks.taskImago;
import static com.example.mymathlibrary.Dicts.Tasks.taskList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class TaskIntent extends AppCompatActivity {
    private ImageView imageIV;
    private TextView textTV;
    private TextView taskName;
    private ImageView btLibrary;
    private boolean isChanged = false;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_intent);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        String nameT = getIntent().getStringExtra("Name");
        int a  = taskList.indexOf(nameT);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.kid_font);



        taskName = (TextView) findViewById(R.id.tv_task);
        taskName.setText(taskList.get(a));
        taskName.setTypeface(typeface);
        taskName.setTextColor(Color.BLACK);
        taskName.setTextSize(30);

        textTV = (TextView) findViewById(R.id.tv_intent);
        textTV.setText(taskDef.get(a));
        textTV.setTypeface(typeface);
        textTV.setTextColor(Color.BLACK);
        textTV.setGravity(Gravity.CENTER);
        textTV.setTextSize(textSize(taskDef.get(a).length()));

        EditText editView = findViewById(R.id.editView);

        Button submit = findViewById(R.id.buttonRight);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = editView.getText().toString();
                String answer2 = taskAnswers.get(a);
                if (answer.equals(answer2)){
                    showCustomToast("Верно", R.drawable.ic_info);
                } else {
                    showCustomToast("Неверно", R.drawable.ic_info);
                }
            }
        });

        ImageView imageIV = (ImageView) findViewById(R.id.iv_intent);
        imageIV.setVisibility(View.INVISIBLE);
        String imageName = (String) taskImago.get(a);
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        Glide.with(this).load(resId).into(imageIV);

        TextView textView = findViewById(R.id.textViewUnderEdit);
        textView.setTextColor(Color.BLACK);
        textView.setOnClickListener(view -> {
            if (isChanged) {
                textView.setTextColor(Color.BLACK);
                textView.setText("Посмотреть решение:");
                imageIV.setVisibility(View.INVISIBLE);
            } else {
                textView.setTextColor(Color.GRAY);
                textView.setText("Скрыть решение:");
                imageIV.setVisibility(View.VISIBLE);
            }
            isChanged = !isChanged;
        });

        btLibrary = (ImageView) findViewById(R.id.bt_backlb);
        btLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(TaskIntent.this, TaskList.class);
                finishAndRemoveTask();
            }
        });
    }
    private void showCustomToast(String message, int iconResId) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_layout));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastIcon = layout.findViewById(R.id.toast_icon);

        toastText.setText(message);
        toastIcon.setImageResource(iconResId);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 100);
        toast.show();
    }
    private int textSize(int size){
        int t = 30;
        if (size > 50) {
            while (size > 1) {
                size -= 50;
                t -= 1;
            }
        }
        return t;
    }
}