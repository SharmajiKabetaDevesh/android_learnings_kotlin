package com.example.lightsensorlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(sensor!=null){
sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }else {
            Log.d("Failed","Exit");

        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
    txt = findViewById(R.id.txt);
    txt.setText("Values "+sensorEvent.values[0]);
}
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}