package com.example.accelrometerlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
            Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(accel!=null){
                sensorManager.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }else{
            Toast.makeText(this,"Sensor Services not detected",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
    txt=findViewById(R.id.txt);
    txt.setText("X: "+sensorEvent.values[0]+" Y: "+sensorEvent.values[1]+" Z: "+sensorEvent.values[2]);
}
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}