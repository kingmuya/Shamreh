package com.example.fireness;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText mName,mEmail,mPass;
    Button mSave,mView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.edtname);
        mEmail = findViewById(R.id.edtmail);
        mPass = findViewById(R.id.edtPass);
        mName = findViewById(R.id.edtname);
        mSave = findViewById(R.id.btnsave);
        mView = findViewById(R.id.btnView);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Saving");
        dialog.setMessage("Please wait!!!");
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPass.getText().toString().trim();
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill in all inputs", Toast.LENGTH_SHORT).show();
                }else {
                    long time = System.currentTimeMillis();
                    DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Users/"+time);
                    item x = new item(name,email,password,String.valueOf(time));
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                           dialog.dismiss();
                           if (task.isSuccessful()){
                               Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                           }else {
                               Toast.makeText(MainActivity.this, "Saving Failedo", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                }
            }
        });

    }
}
