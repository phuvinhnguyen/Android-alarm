package com.example.alarmmanagement;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class hardReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "1234";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, HardWakeup.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,3,i,0);

        //start sound service
        context.startService(new Intent(context.getApplicationContext(), SoundService.class));

        //make notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Alarm")
                .setContentText("Wake up !!!")
                .setAutoCancel(false)
                .setSound(null)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setFullScreenIntent(pendingIntent, true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        if (notificationManagerCompat != null)
            notificationManagerCompat.notify(123,builder.build());
    }
}
