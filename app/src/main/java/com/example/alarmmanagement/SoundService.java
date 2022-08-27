package com.example.alarmmanagement;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class SoundService extends Service {
    MediaPlayer mediaPlayer;
    boolean play = true;
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
        super.onDestroy();
        endAction();
    }

    private void beginAction(){
        //todo: begin
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    private void endAction(){
        //todo: delete all action
        mediaPlayer.stop();
    }
}