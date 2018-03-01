package ca.google.codeexamples;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ThousandNumbers extends AppCompatActivity {

    EditText etNumber;
    TextView tvInstances;
    Button btnFindNumbers, btnGenerateNewNumbers;
    ArrayList<Integer> numberList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thousand_numbers);

        etNumber = findViewById(R.id.etNumber);
        tvInstances = findViewById(R.id.tvInstances);
        btnFindNumbers = findViewById(R.id.btnFindNumbers);
        btnGenerateNewNumbers = findViewById(R.id.btnGenerateNewNumbers);

        // Setting up Event Handlers
        EventHandler eventHandler = new EventHandler();
        btnFindNumbers.setOnClickListener(eventHandler);
        btnGenerateNewNumbers.setOnClickListener(eventHandler);

        generateRandomArray();
    }

    // Class to handle Event Handling
    class EventHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnFindNumbers:
                    // If input is null
                    if (etNumber.getText().toString().trim().equals("")) {
                        // Displays a Toast
                        Toast.makeText(ThousandNumbers.this, "Please enter a number from 1 to 1000", Toast.LENGTH_SHORT).show();
                    // Else set the text of the TextView
                    } else {
                        // Converting String to Int
                        int enteredNumber = Integer.parseInt(etNumber.getText().toString());
                        int numberOfInstances = Collections.frequency(numberList, enteredNumber);

                        // Converting Int to String
                        tvInstances.setText(Integer.toString(numberOfInstances) + " times.");
                    }
                    break;
                case R.id.btnGenerateNewNumbers:
                    generateRandomArray();
                    break;
            }
        }
    }

    // Fills the arrayList with 1000 ints, ranging from 1-1000 inclusive
    public void generateRandomArray() {
        // Initialize variables
        numberList = new ArrayList<>();

        // Insert 1000 random ints (from 1-1000 incl.) into the ArrayList
        for (int i = 0; i < 1000; i++) {
            numberList.add((new Random().nextInt(1000)) + 1);
        }

        // Sorts the ArrayList from lowest to highest
        Collections.sort(numberList);
    }
}
