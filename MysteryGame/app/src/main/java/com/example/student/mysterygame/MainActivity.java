package com.example.student.mysterygame;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    android.support.v4.app.FragmentManager mmFragmentManger;
    android.support.v4.app.FragmentTransaction mmFragmentTransaction;

    logView mmlogView;
    datePassword mmDatePassword;
    devicesContainer mmdevicesContainer;
    patternLockIntergration mmPatternCreate;
    mazeView mmMazeGameContainer;
    MineSweeper mmMineSweeper;

    ArrayAdapter<LogItems> logSave;
    ArrayList<LogItems> logList;


    int activePhone;

    /////for the maze
    // private boolean run = false;
    private SensorHolder accel;
    DrawingView drawView;
    //float moveCircleX = 0;
    //float moveCircleY = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mmlogView = logView.newInstance(4); //calls which friend convo.

        mmFragmentManger = getSupportFragmentManager();
        mmFragmentTransaction = mmFragmentManger.beginTransaction();
        mmFragmentTransaction.add(R.id.mainContainer, mmlogView);
        mmFragmentTransaction.commit();


        //Maze

        drawView = findViewById(R.id.drawingViewCanvas); //TO DO Create custom view in fragment
        accel = new SensorHolder(this);

        //drawView.setX(500);
        //drawView.setY(500);
        //drawView.invalidate();

    }


    //onclick for the maze
    public void buttonClick(View view) {


    }


    public void setDevicesContainer(View view) {

        if (mmdevicesContainer == null) {
            mmdevicesContainer = devicesContainer.newInstance();
            mmFragmentManger = getSupportFragmentManager();
            mmFragmentTransaction = mmFragmentManger.beginTransaction();
            mmFragmentTransaction.add(R.id.miniGamesContainer, mmdevicesContainer);
            mmFragmentTransaction.commit();
        } else {

            mmFragmentManger = getSupportFragmentManager();
            mmFragmentTransaction = mmFragmentManger.beginTransaction();
            mmFragmentTransaction.replace(R.id.miniGamesContainer, mmdevicesContainer);
            mmFragmentTransaction.addToBackStack(null);
            mmFragmentTransaction.commit();

        }

    }

    public void setActivePhone(int selectedPhone) {
        activePhone = selectedPhone;

        mmlogView = logView.newInstance(activePhone); //calls witch friend convo.

        mmFragmentManger = getSupportFragmentManager();
        mmFragmentTransaction = mmFragmentManger.beginTransaction();
        mmFragmentTransaction.add(R.id.mainContainer, mmlogView);
        mmFragmentTransaction.commit();

    }

    public void changeFragmentforPattern() {

        mmPatternCreate = patternLockIntergration.newInstance();

        mmFragmentManger = getSupportFragmentManager();
        mmFragmentTransaction = mmFragmentManger.beginTransaction();
        mmFragmentTransaction.add(R.id.miniGamesContainer, mmPatternCreate);
        mmFragmentTransaction.commit();
    }


    public void changeFragmentToWaveHello() {

        mmDatePassword = datePassword.newInstance();

        mmFragmentManger = getSupportFragmentManager();
        mmFragmentTransaction = mmFragmentManger.beginTransaction();
        mmFragmentTransaction.add(R.id.miniGamesContainer, mmDatePassword);
        mmFragmentTransaction.commit();
    }

    public void changeFragmentToMs() {
        mmMineSweeper = MineSweeper.newInstance();

        mmFragmentManger = getSupportFragmentManager();
        mmFragmentTransaction = mmFragmentManger.beginTransaction();
        mmFragmentTransaction.replace(R.id.miniGamesContainer, mmMineSweeper);
        mmFragmentTransaction.commit();

    }

    public void changeFragmenttoMazeGame() {
        mmMazeGameContainer = mazeView.newInstance();

        mmFragmentManger = getSupportFragmentManager();
        mmFragmentTransaction = mmFragmentManger.beginTransaction();
        mmFragmentTransaction.add(R.id.miniGamesContainer, mmMazeGameContainer);
        mmFragmentTransaction.commit();

    }
   /*  @Override
    protected void onResume() {
        super.onResume();
        accel.restartSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        accel.pauseSensor();
    }



    */
}
