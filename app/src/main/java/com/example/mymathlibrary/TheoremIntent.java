package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import static com.example.mymathlibrary.Dicts.FilterItems.filterItems;
import static com.example.mymathlibrary.Dicts.Theory.theoryDef;
import static com.example.mymathlibrary.Dicts.Theory.theoryFilter;
import static com.example.mymathlibrary.Dicts.Theory.theoryImago;
import static com.example.mymathlibrary.Dicts.Theory.theoryList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class TheoremIntent extends AppCompatActivity {
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
        int a  = theoryList.indexOf(nameT);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.kid_font);

        textType = (TextView) findViewById(R.id.tv_intent_type);
        textType.setText(filterItems.get(Integer.parseInt((theoryFilter.get(a)).substring(0, 1))));
        textType.setTypeface(typeface);
        textType.setTextColor(R.color.greeny);
        textType.setTextSize(30);

        textTV = (TextView) findViewById(R.id.tv_intent);
        textTV.setText(theoryDef.get(a));
        textTV.setTypeface(typeface);
        textTV.setTextColor(R.color.arlekin);
        textTV.setGravity(Gravity.CENTER);
        textTV.setTextSize(25);

        ImageView imageIV = (ImageView) findViewById(R.id.iv_intent);
        String imageName = (String) theoryImago.get(a);
        int ImageId = getResources().getIdentifier(imageName,"drawable", getPackageName());
        imageIV.setImageResource(ImageId);
        btLibrary = (ImageView) findViewById(R.id.bt_backlb);
        btLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(TheoremIntent.this, LibraryList.class);
                finishAndRemoveTask();
            }
        });
    }

}
