package ca.google.codeexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Add 3 new Activities: ThousandNumbers, Conversions, MathFunctions
    // Show how to start activities by tapping buttons in a menu
    // Make a 4th activity to show off data persistence, and passing data through activities
    // Remember to study for the knowledge part
}
