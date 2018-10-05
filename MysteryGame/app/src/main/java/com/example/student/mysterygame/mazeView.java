package com.example.student.mysterygame;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class mazeView extends Fragment {

    Button startStopBttn;
    private boolean run = false;
    private SensorHolder accel;
    DrawingView drawView;
    float moveCircleX = 0;
    float moveCircleY = 0;

    public static mazeView newInstance() {
        // Required empty public constructor
        mazeView fragment = new mazeView();


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maze_view, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        startStopBttn = getView().findViewById(R.id.start_stop_bttn);

        startStopBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run = !run;
                final Handler handler = new Handler();
                handler.post(new Runnable()

                {
                    @Override
                    public void run() {
                        float[] sensorResults = accel.getValues();

                        String outputString = String.format("x=%.2f   y=%.2f   z=%.2f", sensorResults[0], sensorResults[1], sensorResults[2]);

                        moveCircleX += sensorResults[1];
                        drawView.setX(drawView.moveCircleX() - sensorResults[0]);
                        drawView.setY(drawView.moveCircleY() + sensorResults[1]);
                        drawView.invalidate();
                        TextView message = getView().findViewById(R.id.textView);
                        message.setText(outputString);

                        if (run) {

                            handler.postDelayed(this, 100);
                        }

                    }
                });
            }
        });


    }

}
