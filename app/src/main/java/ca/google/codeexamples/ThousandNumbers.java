package ca.google.codeexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class ThousandNumbers extends AppCompatActivity {

    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thousand_numbers);

        btnRandom = findViewById(R.id.btnRandom);

        EventHandler eventHander = new EventHandler();
        btnRandom.setOnClickListener(eventHander);

    }

    // Class to handle Event Handling
    class EventHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnRandom:

                    ArrayList<Integer> numberList = new ArrayList<>();
                    int randomInt;

                    for (int i = 0; i < 5; i++) {
                        randomInt = (new Random().nextInt(1000)) + 1;
                        numberList.add(randomInt);
                    }




                    //Creates a number from 0 incl to 1000 excl, then add 1
//                    btnRandom.setText(Integer.toString(randomNumber));
                    break;
            }
        }
    }
}
