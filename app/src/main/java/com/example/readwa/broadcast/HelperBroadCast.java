package com.example.readwa.broadcast;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.readwa.message.UtilsMessage;
import com.example.readwa.models.Action;
import com.example.readwa.models.CustomerWA;
import com.example.readwa.models.PesananModel;
import com.example.readwa.robj.notificationhelperlibrary.utils.NotificationUtils;
import com.example.readwa.robj.notificationhelperlibrary.utils.TinyDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HelperBroadCast extends NotificationListenerService {

    private static final String TAG = "NotificationListener";
    private static final String WA_PACKAGE = "com.whatsapp";


    @Override
    public void onListenerConnected() {
        Log.i(TAG, "Notification Listener connected");
    }
    SharedPreferences sharedPreferences;

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        if(sbn.getPackageName().contains(WA_PACKAGE)){
            Notification notification = sbn.getNotification();
            Bundle bundle = notification.extras;
            String from = bundle.getString(NotificationCompat.EXTRA_TITLE);
            String message = bundle.getString(NotificationCompat.EXTRA_TEXT);
            if(from.contains("+62")){
                System.out.println(from + "  TITTLE");
                System.out.println(message + " EXTRA_TEXT");

            }

        }

        /*
        //this code for reply automaticly
       Action action = NotificationUtils.getQuickReplyAction(sbn.getNotification(), getPackageName());

       this code for sending notification
        Intent intent = new Intent("NOTIFICATION_DATA");

        intent.putExtra("title", from);
        intent.putExtra("text", message);
        sendBroadcast(intent);

         */


    }
}
