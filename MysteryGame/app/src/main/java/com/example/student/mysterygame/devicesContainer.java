package com.example.student.mysterygame;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class devicesContainer extends Fragment {


    public static devicesContainer newInstance(){
        devicesContainer fragment = new devicesContainer();

        return fragment;
    }


    public devicesContainer() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        ImageView mainPhone = view.findViewById(R.id.mainPhone);
        ImageView friend1 = view.findViewById(R.id.friend1Phone);
        ImageView friend2 = view.findViewById(R.id.friend2Phone);
        ImageView friend3 = view.findViewById(R.id.friend3Phone);



       mainPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setActivePhone(1);
                Log.d("Main Phone OnClick" , "it works");

            }
        });

       friend1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ((MainActivity)getActivity()).setActivePhone(2);
               Log.d("Friend1 OnClick" , "it works");

           }
       });
        friend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setActivePhone(3);
                Log.d("Friend2 OnClick" , "it works");
            }
        });

        friend3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setActivePhone(4);
                Log.d("Friend3 OnClick" , "it works");

            }
        });



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_devices_container, container, false);


        return view;
    }



}
