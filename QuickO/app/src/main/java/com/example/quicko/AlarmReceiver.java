package com.example.quicko;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action!=null){
            if(action.equals("SET_ALARM_1")){
                
            } else if (action.equals("SET_ALARM_2")) {
                
            }else if(action.equals("SET_ALARM_3")){

            }
        }
    }
}
