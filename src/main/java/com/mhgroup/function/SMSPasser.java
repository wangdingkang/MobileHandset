package com.mhgroup.function;

import android.telephony.SmsManager;

/**
 * Created by DK Wang on 2015/3/20.
 */
public class SMSPasser {


    public void sendMessage(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

}
