package com.example.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declring view variables
    EditText num1,num2;
    TextView result;
    Button clickAdd, clickNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing View Variables
        num1 = findViewById(R.id.edfirstnum);
        num2 = findViewById(R.id.edSecondNum);
        result = findViewById(R.id.resultTextView);
        clickAdd = findViewById(R.id.btnAdd);
        clickNextActivity = findViewById(R.id.btnNewActiviry);


        clickAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNum = Integer.parseInt(num1.getText().toString());
                int secNum = Integer.parseInt(num2.getText().toString());
                int sum = firstNum+secNum;
                result.setText(Integer.toString(sum));

                clickAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                    }
                });
clickNextActivity.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent jj=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(jj);
    }
});

            }
        });
    }
}
