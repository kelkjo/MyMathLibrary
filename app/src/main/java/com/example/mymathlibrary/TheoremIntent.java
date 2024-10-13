package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import static com.example.mymathlibrary.Theory.theoryDef;
import static com.example.mymathlibrary.Theory.theoryImago;
import static com.example.mymathlibrary.Theory.theoryKeys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TheoremIntent extends AppCompatActivity {
    private ImageView imageIV;
    private TextView textTV;
    private TextView textType;
    Button btLibrary;
    //pifagor_theorem.png
    @SuppressLint({"UseCompatLoadingForDrawables", "DiscouragedApi", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theorem_intent);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        String nameT = getIntent().getStringExtra("Name");
        String typeT = getIntent().getStringExtra("Type");
        Integer a  = theoryKeys.get(nameT);
        textType = (TextView) findViewById(R.id.tv_intent_type);
        textType.setText(typeT);
        textTV = (TextView) findViewById(R.id.tv_intent);
        textTV.setText(theoryDef[a]);
        ImageView imageIV = (ImageView)findViewById(R.id.iv_intent);
        String imageName = theoryImago[a];
        int ImageId = getResources().getIdentifier(imageName,"drawable", getPackageName());
        imageIV.setImageResource(ImageId);

        btLibrary = (Button) findViewById(R.id.bt_backlb);
        btLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(TheoremIntent.this, LibraryList.class);
                startActivity(mainActivityIntent);

            }
        });
    }

}
