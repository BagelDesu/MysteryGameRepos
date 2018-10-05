package com.example.student.mysterygame;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.john.waveview.WaveView;

import pl.droidsonroids.gif.GifTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class datePassword extends Fragment {

    EditText notes;

    int seekValue;
    String value;
    String userInputVal;
    String passwordValue = "5 13 2017";  //This is the password





    public static datePassword newInstance() {
        datePassword fragment = new datePassword();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_password_container, container, false);


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView checkText = getView().findViewById(R.id.checkText);
        final TextView userValTest = getView().findViewById(R.id.userValTest);

        final GifTextView unlockedGIF = getView().findViewById(R.id.unlockedgif);

        final SeekBar seekBar = getView().findViewById(R.id.seekBar);
        final SeekBar seekBar1 = getView().findViewById(R.id.seekBar1);
        final SeekBar seekBar2 = getView().findViewById(R.id.seekBar2);

        final Button checkButton = getView().findViewById(R.id.checkButton);

        final TextView seekbarVal = getView().findViewById(R.id.textView);
        final TextView seekbarVal1 = getView().findViewById(R.id.textView1);
        final TextView seekbarVal2 = getView().findViewById(R.id.textView2);

        final WaveView waveView = getView().findViewById(R.id.wave_view);
        final WaveView waveView1 = getView().findViewById(R.id.wave_view1);
        final WaveView waveView2 = getView().findViewById(R.id.wave_view2);
        waveView.setProgress(seekBar.getProgress());
        waveView1.setProgress(seekBar.getProgress());
        waveView2.setProgress(seekBar.getProgress());


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekbarVal.setText(Integer.toString(progress));
            int scaleValue = progress * 100 / 12;
            waveView.setProgress(scaleValue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarVal1.setText(Integer.toString(progress));
                int scaleValue = progress * 100 / 31;
                waveView1.setProgress(scaleValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarVal2.setText(Integer.toString(progress + 2000));
                int scaleValue = progress * 100 / 18;
                waveView2.setProgress(scaleValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();

                userInputVal = seekbarVal.getText() + " " + seekbarVal1.getText() + " " + seekbarVal2.getText();
                userValTest.setText(userInputVal);



                if ( userInputVal.equals(passwordValue)){


                    checkText.setText("It works!");

                   
                    unlockedGIF.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.gif_file));
                  /*  handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //TODO Put Unlock animation here
                            //TODO close fragment after or move to next puzzle






                        }
                    }, 2000);*/

                }
                else {
                    checkText.setText("Nope guess again");
                }


            }
        });
    }




}
