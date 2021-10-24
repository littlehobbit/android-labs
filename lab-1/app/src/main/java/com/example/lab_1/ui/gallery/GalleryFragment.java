package com.example.lab_1.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab_1.R;
import com.example.lab_1.RecyclerListAdapter;
import com.example.lab_1.databinding.FragmentGalleryBinding;

import java.util.Arrays;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        RecyclerView recyclerView = binding.recycleView;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(layoutManager);

        List<String> stringList = Arrays.asList("aboba", "abobus");
        RecyclerView.Adapter adapter = new RecyclerListAdapter(stringList);
        recyclerView.setAdapter(adapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}