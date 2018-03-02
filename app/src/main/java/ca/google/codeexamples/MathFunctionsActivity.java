package ca.google.codeexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MathFunctionsActivity extends AppCompatActivity {

    private TextView tvArray, tvMean, tvMedium, tvMode, tvRange;
    private int[] intArray = {13, 18, 13, 14, 13, 16, 14, 21, 13};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_functions);

        tvArray = findViewById(R.id.tvArray);
        tvMean = findViewById(R.id.tvMean);
        tvMedium = findViewById(R.id.tvMedium);
        tvMode = findViewById(R.id.tvMode);
        tvRange = findViewById(R.id.tvRange);

        // Displaying the array of numbers
        StringBuilder text = new StringBuilder("Numbers: ");
        for (int number : intArray) {
            text.append(Integer.toString(number)).append(" ");
        }
        tvArray.setText(text.toString());

        // Finding mean, medium, mode, and range.
        tvMean.setText(Double.toString(findMean(intArray)));
        tvMedium.setText(Double.toString(findMedium(intArray)));
        tvMode.setText(Double.toString(findMode(intArray)));
        tvRange.setText(Double.toString(findRange(intArray)));

    }

    public double findMean(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (sum / numbers.length);
    }

    public double findMedium(int[] numbers) {
        Arrays.sort(numbers);
        return 0;
    }

    public double findMode(int[] numbers) {
        return 0;
    }

    public double findRange(int[] numbers) {
        return 0;
    }
}
