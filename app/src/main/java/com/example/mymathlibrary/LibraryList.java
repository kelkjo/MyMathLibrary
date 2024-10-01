package com.example.mymathlibrary;
//yoy
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mymathlibrary.Engine.Item;
import com.example.mymathlibrary.Engine.RecycleAdapter;
import com.example.mymathlibrary.Engine.RecyclerInterface;

import java.util.ArrayList;

public class LibraryList extends AppCompatActivity implements RecyclerInterface {
    private RecyclerView itemRV;
    private RecycleAdapter adapter;
    private ArrayList<Item> items;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_list);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        itemRV = findViewById(R.id.recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildRecyclerView();
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
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {

        ArrayList<Item> filteredlist = new ArrayList<>();

        for (Item item : items) {
            if (item.getItemName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }

        if (!(filteredlist.isEmpty())) {
            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {
        items = new ArrayList<>();
        items.add(new Item("Apple","Theory"));
        items.add(new Item("Banana","Theory"));
        items.add(new Item("Cherry","Theory"));
        items.add(new Item("Date","Theory"));
        items.add(new Item("Fig","Theory"));
        items.add(new Item("Grape","Theory"));
        items.add(new Item("Kiwi","Theory"));
        items.add(new Item("Lemon","Theory"));
        items.add(new Item("Mango","Theory"));
        items.add(new Item("Orange","Theory"));
        items.add(new Item("Papaya","Theory"));
        items.add(new Item("Peach","Theory"));
        items.add(new Item("Pear","Theory"));
        items.add(new Item("Pineapple","Theory"));
        items.add(new Item("Plum","Theory"));
        items.add(new Item("Raspberry","Theory"));
        items.add(new Item("Strawberry","Theory"));
        items.add(new Item("Tangerine","Theory"));
        items.add(new Item("Watermelon","Theory"));
        adapter = new RecycleAdapter(items, LibraryList.this, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        itemRV.setHasFixedSize(true);

        itemRV.setLayoutManager(manager);

        itemRV.setAdapter(adapter);
    }
    @Override
    public void onItemClicked(int position) {
        System.out.println(position);
        Intent LibraryListIntent = new Intent(LibraryList.this, TheoremIntent.class);
        LibraryListIntent.putExtra("Name", items.get(position).getItemName());
        LibraryListIntent.putExtra("Type", items.get(position).getItemType());
        startActivity(LibraryListIntent);
    }
}
