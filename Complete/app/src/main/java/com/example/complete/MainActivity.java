package com.example.complete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    protected boolean _active=true;
    protected int _splashtime=3000;

    Button clickbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickbutton=findViewById(R.id.btnbutton);
        Thread abel=new Thread() {
            public void run() {
                try {


                    int wait = 0;
                    while (_active && (wait < _splashtime)) {
                        sleep(100);
                        if (_active) {
                            wait += 100;
                        }
                    }
                } catch (Exception e) {
                } finally {
                    startActivity(new Intent(MainActivity.this, Second.class));
                    finish();
                }
            }
        };
                abel.start();
            }
        }