package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class OtherFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contain  , Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.otherfragment ,contain, false);
        return view;
    };
}
