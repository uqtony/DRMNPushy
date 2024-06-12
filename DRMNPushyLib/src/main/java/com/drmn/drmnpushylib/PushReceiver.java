package com.drmn.drmnpushylib;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.util.Log;

public class PushReceiver extends BroadcastReceiver {
    private final static String TAG = "Pushy";
    @Override
    public void onReceive(Context context, Intent intent) {
        // Attempt to extract the "title" property from the data payload, or fallback to app shortcut label
        String notificationTitle = intent.getStringExtra("title") != null ? intent.getStringExtra("title") : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();

        // Attempt to extract the "message" property from the data payload: {"message":"Hello World!"}
        String notificationText = intent.getStringExtra("message") != null ? intent.getStringExtra("message") : "Test notification";

        Log.d(TAG, "On receive Pushy Notification, title="+notificationTitle+", text="+notificationText);
        Push._onNotification(notificationTitle, notificationText);
    }
}
