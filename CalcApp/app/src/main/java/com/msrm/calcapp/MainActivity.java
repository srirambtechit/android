package com.msrm.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText;

    private EditText secondNumberEditText;

    private Button addButton;

    private Button subButton;

    private Button mulButton;

    private Button divButton;

    private TextView resultTextView;

    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = (EditText) findViewById(R.id.firstNumberEditText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);

        resultTextView = (TextView) findViewById(R.id.resultTextView);

        addButton = (Button) findViewById(R.id.addBtn);
        subButton = (Button) findViewById(R.id.subBtn);
        mulButton = (Button) findViewById(R.id.mulBtn);
        divButton = (Button) findViewById(R.id.divBtn);
        closeButton = (Button) findViewById(R.id.closeBtn);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = getNumber(firstNumberEditText);
                int n2 = getNumber(secondNumberEditText);
                displayResult(n1 + " + " + n2 + " = " + (n1 + n2));
            }
        });

        subButton.setOnClickListener((v) -> {
            int a = getNumber(firstNumberEditText);
            int b = getNumber(secondNumberEditText);
            displayResult(a + " - " + b + " = " + (a - b));
        });

        mulButton.setOnClickListener(v -> {
            int a = getNumber(firstNumberEditText);
            int b = getNumber(secondNumberEditText);
            displayResult(a + " * " + b + " = " + (a * b));
        });

        divButton.setOnClickListener(v -> {
            int a = getNumber(firstNumberEditText);
            int b = getNumber(secondNumberEditText);
            try {
                displayResult(a + " / " + b + " = " + (a / b));
            } catch (ArithmeticException e) {
                if (a < 0 || b < 0)
                    displayResult(a + " / " + b + " = " + Float.NEGATIVE_INFINITY);
                else
                    displayResult(a + " / " + b + " = " + Float.POSITIVE_INFINITY);
            }

        });

        // closing this activity and informs the OS that whoever called this activity
        closeButton.setOnClickListener(v -> {
            finish();
        });

    }

    private int getNumber(EditText editText) {
        if (validateText()) {
            return Integer.parseInt(editText.getText().toString());
        }
        return 0;
    }

    private boolean validateText() {
        if (firstNumberEditText.getText() == null || firstNumberEditText.getText().toString().equals(""))
            return false;
        if (secondNumberEditText.getText() == null || secondNumberEditText.getText().toString().equals(""))
            return false;
        return true;
    }

    private void displayResult(String result) {
        firstNumberEditText.setText("");
        secondNumberEditText.setText("");
        resultTextView.setText(result);
    }


}
