package com.example.alarmmanagement;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EasyWakeup extends AppCompatActivity {
    private Button turnOf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_method_fragment);

        turnOf = findViewById(R.id.turnOff);

        beginAction();
        turnOf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: CANCEL SOUND AND INTENT
                endAction();
            }
        });
    }

    

    private void beginAction(){
        //todo: begin
    }

    private void endAction(){
        //todo: delete all action
        stopService(new Intent(getApplicationContext(), SoundService.class));
    }
}
