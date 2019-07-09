package com.example.funfacts;

import android.support.v4.widget.ViewGroupUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declaring view variables
    private TextView mTextView;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing View variables
        mTextView = (TextView) findViewById(R.id.infoTextView);
        mButton = (Button) findViewById(R.id.factButton);

        //Display another fun fact after clicking the button
        View.OnClickListener listener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = "";
                String[] facts = {
                        "Ants strech when they wake up in the morning",
                        "Ostriches run faster than horses",
                        "Olympic gold medals are actually made of silver",
                        "You are born with 300 bones, by the time you are an adult you will have 206",
                        "It takes about 8minutes for light from the sun to reach Earth",
                        "Some bamboo plants cna grow almost a meter in just one day",
                        "The county of Nairobi is biger than Kisumu",
                        "Some penguins can leap 2-3 meters out of the water",
                        "On average , it takes 66days to form a new habitat",
                        "Mammoths still walked the Earth when the Great Pyramid was first built",
                        "MPs have been caught off-guard because of change in currency",
                        "Kartelo will be the next president in 2022"
                };
                //Randomly select a fact
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(facts.length);
                fact = facts[randomNumber];

                //Update the strin with a dynamic fact
                mTextView.setText(fact);
            }
        };
        mButton.setOnClickListener(listener);
    }
}
