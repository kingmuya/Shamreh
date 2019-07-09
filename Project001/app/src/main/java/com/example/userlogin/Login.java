package com.example.userlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project001.Dashboard;
import com.example.project001.R;

public class MainActivity extends AppCompatActivity {
    EditText uName, passTxt;
    CheckBox remPass;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uName = findViewById(R.id.usernameTxt);
        passTxt = findViewById(R.id.passwordTxt);
        remPass = findViewById(R.id.chkRemPass);
        loginBtn = findViewById(R.id.btnlogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login(uName.getText().toString(),passTxt.getText().toString())==1)
                {
                    Toast.makeText(getApplicationContext(),"Logged In.",Toast.LENGTH_LONG).show();
                    if ( !(remPass.isChecked()))
                    {
                        passTxt.setText("");
                    }
                    uName.setText("");
                    //open dashboard Activity
                    startActivity(new Intent(getApplication(), Dashboard.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Logged Failed. Please Try Again.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private  int login(String uname, String passwd)
    {
        //Admin
        if (uname.isEmpty() || passwd.isEmpty())
        {
            return 0;
        }
        else if (uname.equals("Admin") && passwd.equals("1234"))
        {
            return 1;
        }
        return 0;
    }
}

