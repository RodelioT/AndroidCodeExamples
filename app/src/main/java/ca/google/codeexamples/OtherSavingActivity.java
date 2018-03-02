package ca.google.codeexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class OtherSavingActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_saving);

        editText = findViewById(R.id.editText);
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed(); <-- Comment this out first, or place at end!

        String enteredText = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("enteredText", enteredText);

        if(!enteredText.trim().equals("")) {
            setResult(RESULT_OK, intent);
        } else {
            setResult(RESULT_CANCELED);
        }

        finish(); //Same as pressing back arrow normally
    }
}
