package ca.google.codeexamples;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SavingDataActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText etText;
    private Switch swSwitch;
    private Button btnOtherSaving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_data);

        // Find the views before loading data to them from SharedPreferences
        etText = findViewById(R.id.etText);
        swSwitch = findViewById(R.id.swSwitch);
        btnOtherSaving = findViewById(R.id.btnOtherSaving);

        // Load data from SharedPreferences
        sharedPreferences = getSharedPreferences("sharedPreferencesData", 0);
        etText.setText(sharedPreferences.getString("keyName", "DefaultValue"));
        swSwitch.setChecked(sharedPreferences.getBoolean("switch", false));

        // StartActivityForResult Example
        btnOtherSaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (SavingDataActivity.this, OtherSavingActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Save Data to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("keyName", etText.getText().toString());
        editor.putBoolean("switch", swSwitch.isChecked());
        boolean success = editor.commit();

        if(success) {
            Toast.makeText(SavingDataActivity.this, "Shared Preferences Saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SavingDataActivity.this, "Error saving Shared Preferences...", Toast.LENGTH_SHORT).show();
        }
    }

    // Receiving data from StartActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            String enteredText = data.getStringExtra("enteredText");
            Toast.makeText(SavingDataActivity.this, "Your text: " + enteredText, Toast.LENGTH_LONG).show();
        } else {
            //assuming RESULT_CANCELLED
            Toast.makeText(SavingDataActivity.this, "You left it blank!", Toast.LENGTH_LONG).show();
        }
    }
}
