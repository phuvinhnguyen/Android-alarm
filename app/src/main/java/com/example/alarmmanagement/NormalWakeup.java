package com.example.alarmmanagement;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class NormalWakeup extends AppCompatActivity {
    private class result {
        public String formula;
        public int result;
        public int answer;

        public result(String formula, int result, int answer) {
            this.answer = answer;
            this.result = result;
            this.formula = formula;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_method_fragment);

        setupButtonAndView();
        beginAction();
        buildQuestion();
    }

    private Button[] buttons = new Button[6];
    private TextView formularView;

    private void buildQuestion() {
        result present = CreateFormula();
        formularView.setText(present.formula);
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            if (i == present.answer) {
                buttons[i].setText(present.result + " ");
                buttons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO: CANCEL SOUND AND INTENT
                        endAction();
                    }
                });
            } else {
                int num = random.nextInt();
                while (num == present.result) {
                    num = random.nextInt();
                }
                buttons[i].setText(num + " ");
                buttons[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        buildQuestion();
                    }
                });
            }
        }
    }

    private void setupButtonAndView() {
        buttons[0] = findViewById(R.id.anw1);
        buttons[1] = findViewById(R.id.anw2);
        buttons[2] = findViewById(R.id.anw3);
        buttons[3] = findViewById(R.id.anw4);
        buttons[4] = findViewById(R.id.anw5);
        buttons[5] = findViewById(R.id.anw6);

        formularView = findViewById(R.id.formula);
    }

    private result CreateFormula() {
        Random random = new Random();
        Integer a = random.nextInt();
        Integer b = random.nextInt();
        int action = random.nextInt() % 4;

        switch (action) {
            case 0:
                return new result(a.toString() + "+" + b.toString(), a + b, random.nextInt(6));
            case 1:
                return new result(a.toString() + "-" + b.toString(), a - b, random.nextInt(6));
            case 2:
                return new result(a.toString() + "x" + b.toString(), a * b, random.nextInt(6));
            default:
                Integer c = a * b;
                return new result(c.toString() + "/" + b.toString(), a, random.nextInt(6));
        }
    }

    private void beginAction() {
        //todo: begin
    }

    private void endAction() {
        //todo: delete all action
        stopService(new Intent(getApplicationContext(), SoundService.class));
    }
}
