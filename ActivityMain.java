package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    private TextView result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        result1 = (TextView) findViewById(R.id.result1);
    }

    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
    }


        private void displayBMI(float bmiValue) {
            String bmiLabel = "";

            if (bmiValue < 16) {
                bmiLabel = "Severely underweight";
            } else if (bmiValue < 18.5) {

                bmiLabel =  "Underweight";
            } else if (bmiValue < 25) {

                bmiLabel =  "Normal";
            } else if (bmiValue < 30) {

                bmiLabel =  "Overweight";
            } else {
                bmiLabel =  "Obese";
            }

            bmiLabel = "BMI: " + bmiValue + "\n\n" +  bmiLabel;
            result1.setText("Your Result");
           result.setText(bmiLabel);

        }
      
}
