package com.example.firebaseapp2020;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Declaring View Variables
    EditText fNames, mEmail, mAge;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize View Variables
        fNames = (EditText) findViewById(R.id.inputName);
        mEmail = (EditText) findViewById(R.id.inputEmail);
        mAge = (EditText) findViewById(R.id.inputAge);
    }
    public void save(View view) {
        String names = fNames.getText().toString();
        String email = mEmail.getText().toString();
        String age = mAge.getText().toString();
        progress = new ProgressDialog(this);
        progress.setMessage("Saving...");

        if (names.isEmpty() || email.isEmpty() || age.isEmpty()) {
            Toast.makeText(this, "Fill in all the Inputs", Toast.LENGTH_SHORT).show();
            return;
        }
        long time = System.currentTimeMillis();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Names/" + time);
        User x = new User(names, email, age,String.valueOf(time));
        progress.show();
        ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progress.dismiss();
                if (task.isSuccessful()) {
                    fNames.setText("");
                    mEmail.setText("");
                    mAge.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Failed. Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void fetch(View view) {
        Intent intent = new Intent(getApplicationContext(),UsersActivity.class);
        startActivity(intent);
    }
}
