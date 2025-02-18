package com.example.mymathlibrary.Engine;

import static com.example.mymathlibrary.Dicts.FilterItems.filterItems;
import static com.example.mymathlibrary.Dicts.Theory.theoryFilter;
import static com.example.mymathlibrary.Dicts.Theory.theoryList;

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

public class RecycleAdapterSec extends RecyclerView.Adapter<RecycleAdapterSec.ViewHolder> {
    private ArrayList<String> itemArrayList;
    private Context context;
    private final RecyclerInterface recyclerInterface;
    public RecycleAdapterSec(ArrayList<String> itemArrayList, Context context,
                             RecyclerInterface recyclerInterface) {
        this.itemArrayList = itemArrayList;
        this.context = context;
        this.recyclerInterface = recyclerInterface;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<String> filterlist) {
        itemArrayList = filterlist;
        notifyDataSetChanged();
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View convertView) {
            super(convertView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String model = itemArrayList.get(position);
        holder.courseNameTV.setText(model);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTV;
        public ViewHolder(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVTheoryName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerInterface.onItemClicked(pos);
                        }
                    }
                }
            });
        }
    }
}