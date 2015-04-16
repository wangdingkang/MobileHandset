package com.mhgroup.function;

import android.app.AlarmManager;
import android.content.Context;
import android.os.SystemClock;

import java.util.Calendar;

/**
 * Created by DK Wang on 2015/3/20.
 */
public class AlarmSetter {

    private Context context;

    public AlarmSetter(Context c)
    {
        this.context = c;
    }

    public void setAlarmAfter(long elapsedTime)
    {
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + elapsedTime, null);
    }

    public void setAlarmAt(int hour, int minute, int daysAfter)
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.add(Calendar.DATE, daysAfter);
        AlarmManager am = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC, c.getTimeInMillis(), null);
    }
}
