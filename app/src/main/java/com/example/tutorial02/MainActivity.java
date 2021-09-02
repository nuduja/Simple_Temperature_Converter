package com.example.tutorial02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton RBtn_celsius;
    RadioButton RBtn_farenheit;
    Button Btn_calculate;
    TextView TV_Cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        RBtn_celsius = findViewById(R.id.RBtn_celsius);
        RBtn_farenheit = findViewById(R.id.RBtn_farenheit);
        Btn_calculate = findViewById(R.id.Btn_calculate);
        TV_Cal = findViewById(R.id.TV_Cal);

    }

    @Override protected void onResume() {
        super.onResume();
        Btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    public void calculateAnswer() {
        Calculations cal = new Calculations();
        String value = et_temp.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter teh Temperature", Toast.LENGTH_LONG).show();
        }
        else{
            Float temp = Float.parseFloat(value);
            if(RBtn_celsius.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if(RBtn_farenheit.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            }
            else {
                Toast.makeText(this, "Select the Type", Toast.LENGTH_LONG).show();
                temp = 0.0f;
            }

            TV_Cal.setText(new Float(temp).toString());
        }

    }
}