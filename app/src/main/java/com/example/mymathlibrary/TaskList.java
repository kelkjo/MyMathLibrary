package com.example.mymathlibrary;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterHelperTask;
import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterItemsTask;
import static com.example.mymathlibrary.Dicts.FilterItemsSec.filterHelperTask;
import static com.example.mymathlibrary.Dicts.Tasks.taskFilter;
import static com.example.mymathlibrary.Dicts.Tasks.taskList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mymathlibrary.Engine.RecycleAdapter;
import com.example.mymathlibrary.Engine.RecyclerInterface;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity implements RecyclerInterface {
    private RecyclerView itemRV;
    private RecycleAdapter adapter;
    public ArrayList<String> filteredList;
    ImageView ivFilter;
    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        ivFilter = (ImageView) findViewById(R.id.iv_filter);
        ivFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskList.this, FilterActivitySec.class);
                startActivity(intent);
            }
        });
        ivBack = (ImageView) findViewById(R.id.bt_backlb);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskList.this, MainActivity.class);
                startActivity(intent);
            }
        });
        itemRV = findViewById(R.id.recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buildRecyclerView();
        filter("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        assert searchView != null;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return false;}

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        return true;
    }
    private void filter(String text) {
        ArrayList<String> filteredlist = new ArrayList<>();
        for (int i = 0; i < taskFilter.size(); i++) {
            int b = 0;
            for (Integer integer : filterHelperTask) {
                String integ = "" + integer;
                if ((taskFilter.get(i)).contains(integ)) {
                    b++;
                }
            }
            if (b == filterHelperTask.size() && taskList.get(i).toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(taskList.get(i));
            }
        }
        adapter.filterList(filteredlist);
        filteredList = filteredlist;
    }
    private void buildRecyclerView() {
        adapter = new RecycleAdapter((ArrayList<String>) taskList, TaskList.this, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        itemRV.setHasFixedSize(true);
        itemRV.setLayoutManager(manager);
        itemRV.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int position) {
        Intent TaskListIntent = new Intent(TaskList.this, TaskIntent.class);
        TaskListIntent.putExtra("Name", filteredList.get(position));
        startActivity(TaskListIntent);
    }
}