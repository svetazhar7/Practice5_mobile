package com.example.practice5_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.practice5_mobile.databinding.Screen2Binding;

public class FragmentScreenTwo extends Fragment {
    Screen2Binding binding;
    public FragmentScreenTwo()
    {
        super(R.layout.screen2);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = Screen2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Bundle bundle = new Bundle();
                bundle.putFloat("rating2",  binding.ratingBar.getRating());
                Navigation.findNavController(view).navigate(R.id.action_second_fragment_to_first_fragment,bundle);
            }
        });

    }
}
