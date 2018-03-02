package ca.google.codeexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnThousandNumbers, btnConversions, btnMathFunctions, btnSavingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding the Views
        btnThousandNumbers = findViewById(R.id.btnThousandNumbers);
        btnConversions = findViewById(R.id.btnConversions);
        btnMathFunctions = findViewById(R.id.btnMathFunctions);
        btnSavingData = findViewById(R.id.btnSavingData);

        // Setting up Event Handlers
        EventHandler eventHandler = new EventHandler();
        btnThousandNumbers.setOnClickListener(eventHandler);
        btnConversions.setOnClickListener(eventHandler);
        btnMathFunctions.setOnClickListener(eventHandler);
        btnSavingData.setOnClickListener(eventHandler);


    }

    // Class to handle Event Handling
    class EventHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnThousandNumbers:
                    // Starting a new Activity
                    Intent thousandNumbersIntent = new Intent(MainActivity.this, ThousandNumbers.class);
                    startActivity(thousandNumbersIntent);
                    break;
                case R.id.btnConversions:
                    Intent conversionsIntent = new Intent(MainActivity.this, ConversionsActivity.class);
                    startActivity(conversionsIntent);
                    break;
                case R.id.btnMathFunctions:
                    Intent mathFunctionsIntent = new Intent(MainActivity.this, MathFunctionsActivity.class);
                    startActivity(mathFunctionsIntent);
                case R.id.btnSavingData:
                    Intent savingDataIntent = new Intent(MainActivity.this, SavingDataActivity.class);
                    startActivity(savingDataIntent);
                    break;
            }
        }
    }





    // Activity is made

    // @Override
    // OnCreate is already made for you!
    // Mirai Zura!

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // Activity is currently on-screen

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // Activity is stopped
}
