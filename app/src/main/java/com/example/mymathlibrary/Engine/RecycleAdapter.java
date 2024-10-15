package com.example.mymathlibrary.Engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mymathlibrary.R;
import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<Item> itemArrayList;
    private Context context;
    private final RecyclerInterface recyclerInterface;
    private static Button button;
    public RecycleAdapter(ArrayList<Item> itemArrayList, Context context,
                          RecyclerInterface recyclerInterface, Button button) {
        this.itemArrayList = itemArrayList;
        this.context = context;
        this.recyclerInterface = recyclerInterface;
        this.button = button;
    }
    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<Item> filterlist) {
        itemArrayList = filterlist;
        notifyDataSetChanged();
        button.setVisibility(View.INVISIBLE);
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View convertView) {
            super(convertView);
        }
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theory, parent, false);
        return new ViewHolder(view, recyclerInterface);
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
        TextView courseNameTV;
        TextView courseDescTV;
        public ViewHolder(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVTheoryName);
            courseDescTV = itemView.findViewById(R.id.idTVTheoryDescription);
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