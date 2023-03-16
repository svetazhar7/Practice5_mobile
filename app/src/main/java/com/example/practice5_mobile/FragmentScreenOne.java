package com.example.practice5_mobile;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.practice5_mobile.databinding.Screen1Binding;

public class FragmentScreenOne extends Fragment {
    Screen1Binding binding;
    float rating_book1;
    float rating_book2;
    public FragmentScreenOne()
    {
        super(R.layout.screen1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Screen1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("rating2"))
            {
                rating_book1 = bundle.getFloat("rating2");
                binding.button4.setText("Вы оценили книгу на "+rating_book1);
            }
            else
            {
                rating_book2 = bundle.getFloat("rating3");
                binding.button6.setText("Вы оценили книгу на "+rating_book2);
            }

        }

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_first_fragment_to_second_fragment);
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_first_fragment_to_third_fragment);
            }
        });

    }
}