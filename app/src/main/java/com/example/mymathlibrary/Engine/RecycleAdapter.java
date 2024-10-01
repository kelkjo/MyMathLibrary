package com.example.mymathlibrary.Engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymathlibrary.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<Item> itemArrayList;
    public RecycleAdapter(ArrayList<Item> itemArrayList, Context context) {
        this.itemArrayList = itemArrayList;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<Item> filterlist) {
        itemArrayList = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        Item model = itemArrayList.get(position);
        holder.courseNameTV.setText(model.getItemName());
        holder.courseDescTV.setText(model.getItemType());
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseNameTV;
        private final TextView courseDescTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVTheoryName);
            courseDescTV = itemView.findViewById(R.id.idTVTheoryDescription);
        }
    }
}