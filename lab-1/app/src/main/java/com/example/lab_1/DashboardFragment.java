package com.example.lab_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class DashboardFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(recyclerLayoutManager);

        String[] stringArray = getResources().getStringArray(R.array.items);
        List<String> dataset = Arrays.asList(stringArray);
        RecyclerView.Adapter adapter = new ListStringAdapter(dataset);
        recyclerView.setAdapter(adapter);

        return view;
    }
}