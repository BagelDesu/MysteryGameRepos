package com.example.student.mysterygame;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineSweeper extends Fragment {


    public static MineSweeper newInstance() {
        // Required empty public constructor
        MineSweeper fragment = new MineSweeper();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine_sweeper, container, false);
    }

}
