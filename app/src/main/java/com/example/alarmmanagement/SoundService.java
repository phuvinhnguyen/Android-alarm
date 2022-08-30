package com.example.alarmmanagement;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.os.IBinder;
import android.util.Log;

public class SoundService extends Service {
    MediaPlayer mediaPlayer = null;
    public SoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        beginAction();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.v("SERVICE","Service killed");
        endAction();
        super.onDestroy();
    }

    private void beginAction(){
        //todo: begin
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();
    }

    private void endAction(){
        if (mediaPlayer != null) {
            Log.v("SERVICE", "call stop music");
            //todo: delete all action
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }















}