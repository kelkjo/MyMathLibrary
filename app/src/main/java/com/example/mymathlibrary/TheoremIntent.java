package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import static com.example.mymathlibrary.Theory.theoryImago;
import static com.example.mymathlibrary.Theory.theoryKey;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.io.File;
import java.io.InputStream;

public class TheoremIntent extends AppCompatActivity {
    ImageView imageIV;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theorem_intent);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        String name = theoryImago.get(theoryKey.get(getIntent().getStringExtra("Name"))); //"app/res/drawable/"+ theoryImago.get(name)
//        System.out.println(name);
//        String path = "app/res/drawable/" + name;
//        File imgFile = new File("app/res/drawable/pifagor_theorem.png");
        File imgFile = new File("app/src/main/res/drawable/pifagor_theorem.png");
        imageIV = (ImageView) findViewById(R.id.iv_intent);
        if (imgFile.exists()) {
            Bitmap imgBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageIV.setImageBitmap(imgBitmap);
        }

//        TextView dynamicTextView = new TextView(this);
//        dynamicTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        dynamicTextView.setText("Hello World");
    }
}
