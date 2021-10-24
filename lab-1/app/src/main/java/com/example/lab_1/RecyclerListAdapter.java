package com.example.lab_1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {
    List<String> dataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.recycler_item_text);
            itemView.setOnClickListener(v -> Log.i("Click", "item pressed"));
        }

        public void setText(String text) {
            textView.setText(text);
        }
    }

    public RecyclerListAdapter(List<String> dataset) {
        this.dataset = dataset;
    }

    @Override
    public RecyclerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListAdapter.ViewHolder holder, int position) {
        holder.setText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
