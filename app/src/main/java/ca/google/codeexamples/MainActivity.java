package ca.google.codeexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnThousandNumbers, btnConversions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding the Views
        btnThousandNumbers = findViewById(R.id.btnThousandNumbers);
        btnConversions = findViewById(R.id.btnConversions);

        // Setting up Event Handlers
        EventHandler eventHandler = new EventHandler();
        btnThousandNumbers.setOnClickListener(eventHandler);
        btnConversions.setOnClickListener(eventHandler);


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
            }
        }
    }

    // Add 3 new Activities: ThousandNumbers, Conversions, MathFunctions
    // Show how to start activities by tapping buttons in a menu
    // Make a 4th activity to show off data persistence, and passing data through activities
    // Remember to study for the knowledge part
}
