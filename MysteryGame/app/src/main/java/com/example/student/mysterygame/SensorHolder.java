package com.example.student.mysterygame;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/*
 Created by student on 20/02/2018.
 */

public class SensorHolder implements SensorEventListener {

    private static Context context;
    private SensorManager mSensorManager;
    private Sensor mAccel;
    private float[] sensorValues;

    public SensorHolder (Context currentContext) {

        context = currentContext;
        mSensorManager = (SensorManager)context.getSystemService(context.SENSOR_SERVICE);
        mAccel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccel,SensorManager.SENSOR_DELAY_NORMAL);
        sensorValues = new float[3];
    }
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        sensorValues = event.values;
    }

    public float[] getValues()
    {
        return sensorValues;
    }

    public void restartSensor() {
        mSensorManager.registerListener(this, mAccel, SensorManager.SENSOR_DELAY_NORMAL);
    }


    public void pauseSensor() {
        mSensorManager.unregisterListener(this);
    }




}
