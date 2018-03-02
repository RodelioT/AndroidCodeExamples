package ca.google.codeexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;

public class ConversionsActivity extends AppCompatActivity {

    private EditText etKilograms, etPounds;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversions);

        etKilograms = findViewById(R.id.etKilograms);
        etPounds = findViewById(R.id.etPounds);
        btnConvert = findViewById(R.id.btnConvert);

        etKilograms.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                // If Kilograms gets focus, clear Pounds
                if (etKilograms.hasFocus()) {
                    etPounds.setText("");
                }

                // If Kilograms is null when it loses focus, make its value 0
                if (!etKilograms.hasFocus()) {
                    if (etKilograms.getText().toString().trim().equals("")) {
                        etKilograms.setText("0");
                    }
                }
            }
        });

        etPounds.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                // If Pounds gets focus, clear Kilograms
                if (etPounds.hasFocus()) {
                    etKilograms.setText("");
                }

                // If Pounds is null when it loses focus, make its value 0
                if (!etPounds.hasFocus()) {
                    if (etPounds.getText().toString().trim().equals("")) {
                        etPounds.setText("0");
                    }
                }
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If Pounds has a value, convert it to Kilograms
                // If pounds is 0, automatically make kilograms 0; no divide by 0 error
                if (!etPounds.getText().toString().trim().equals("")) {
                    double conversion = etPounds.getText().toString().trim().equals("0") ? 0 : Double.parseDouble(etPounds.getText().toString()) / 2.2;
                    etKilograms.setText(Double.toString(conversion));
                // Else if Kilograms has a value, convert it to Pounds
                } else if (!etKilograms.getText().toString().trim().equals("")) {
                    double conversion = Double.parseDouble(etKilograms.getText().toString()) * 2.2;
                    etPounds.setText(Double.toString(conversion));
                }
            }
        });


    }
}
