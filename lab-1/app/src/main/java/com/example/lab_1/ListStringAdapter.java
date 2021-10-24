package com.example.lab_1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListStringAdapter extends RecyclerView.Adapter<ListStringAdapter.ViewHolder> {
    private List<String> dataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemText = itemView.findViewById(R.id.item_text);
            itemView.setOnClickListener(v -> Log.i("Click", "element was clicked"));
        }

        public void setItemText(String text) {
            itemText.setText(text);
        }
    }

    public ListStringAdapter(List<String> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_string_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setItemText(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }


}
