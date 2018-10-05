package com.example.student.mysterygame;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class patternLockIntergration extends Fragment {


    PatternLockView mPatternLockView;
    logView mLogView;

    public patternLockIntergration() {
        // Required empty public constructor
    }


    public static patternLockIntergration newInstance(){
        patternLockIntergration fragment = new patternLockIntergration();

        return fragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pattern_lock_intergration, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // ((MainActivity)getActivity().getSupportFragmentManager().;


        final String password = "63478521";

        final TextView mTxt = view.findViewById(R.id.patternLockText);

        mPatternLockView = view.findViewById(R.id.pattern_lock_view);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {

                if(PatternLockUtils.patternToString(mPatternLockView, pattern).equals(password)){

                    mTxt.setText("Access Granted... Welcome Float.");
                 //   mLogView.populateMainPhone();
                }

                Log.d("Pattern Lock Control", "Password: " + PatternLockUtils.patternToString(mPatternLockView, pattern));

            }

            @Override
            public void onCleared() {

            }
        });

    }
}
