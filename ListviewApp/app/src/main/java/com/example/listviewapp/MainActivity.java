package com.example.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
public class MainActivity extends AppCompatActivity {

    String[] nameArray = {
            "octopus",
            "pig",
            "sheep",
            "rabbit",
            "snake",
            "spider",
    };

    String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a Stew",
            "Great for Shoes",
            "Scary.",
    };

    Integer[] imageArray = {
            R.drawable.octopus,
            R.drawable.pig,
            R.drawable.sheep,
            R.drawable.rabbit,
            R.drawable.snake,
            R.drawable.spider
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter whatever = new CustomListAdapter(this , nameArray,infoArray, imageArray);
        ListView ListView = (ListView) findViewById(R.id.ListViewID);
        ListView.setAdapter(whatever);
    }
}

//Variables
