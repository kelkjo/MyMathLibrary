package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btLibrary;
    Button btTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        btLibrary = (Button) findViewById(R.id.bt_library);
        btLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(MainActivity.this, LibraryList.class);
                startActivity(mainActivityIntent);

            }
        });
        btTask = (Button) findViewById(R.id.bt_task);
        btTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskIntent = new Intent(MainActivity.this, TaskList.class);
                startActivity(taskIntent);
            }
        });
    }
}