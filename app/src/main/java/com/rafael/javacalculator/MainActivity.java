package com.rafael.javacalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numberFirst;
    EditText numberSecond;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberFirst = findViewById(R.id.editText1);
        numberSecond = findViewById(R.id.editText2);
        resultText = findViewById(R.id.textView);

    }


    public void performOperation(View view, String operation) {
        if (numberFirst.getText().toString().isEmpty() || numberSecond.getText().toString().isEmpty()) {
            resultText.setText("Enter Numbers");
            return;
        }
        double number1 = Double.parseDouble(numberFirst.getText().toString());
        double number2 = Double.parseDouble(numberSecond.getText().toString());

        if (number2 == 0) {
            resultText.setText("Cannot Divide by Zero");
            return;
        }

        double result = 0.0;
        String resultMessage = "Result: ";

        switch (operation) {
            case "sum":
                result = number1 + number2;
                break;
            case "deduct":
                result = number1 - number2;
                break;
            case "divide":
                result = number1 / number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
        }

        resultText.setText(resultMessage + result);
    }

    public void sum(View view) {
        performOperation(view, "sum");
    }

    public void deduct(View view) {
        performOperation(view, "deduct");
    }

    public void divide(View view) {
        performOperation(view, "divide");
    }

    public void multiply(View view) {
        performOperation(view, "multiply");
    }

}