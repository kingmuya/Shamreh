package com.example.complete;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_three extends AppCompatActivity {
    Button SimToolkit,Phone,Share,Email,Sms,Camera,CardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        SimToolkit=findViewById(R.id.button8);
        Phone=findViewById(R.id.button9);
        Share=findViewById(R.id.button10);
        Email=findViewById(R.id.button11);
        Sms=findViewById(R.id.button12);
        Camera=findViewById(R.id.button13);
        CardView=findViewById(R.id.button14);
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonecall=new Intent(Intent.ACTION_DIAL);
                phonecall.setData(Uri.parse("tel: +254736976836"));
                startActivity(phonecall);

            }
        });
        Sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri myno=Uri.parse("smsto:+254736976836");
                Intent sms=new Intent(Intent.ACTION_SENDTO,myno);
                sms.putExtra("body","My Name is Muya");
                startActivity(sms);



            }
        });
        Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera,0);


            }
        });
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("plain/text");
                share.putExtra(Intent.EXTRA_SUBJECT,new String[]{"peekabu"});
                share.putExtra(Intent.EXTRA_TEXT,new String[]{"Welcome Home"});
                startActivity(Intent.createChooser(share,"Select App"));


            }
        });
        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("plain/text");
                share.putExtra(Intent.EXTRA_EMAIL,new String[]{"kevinombati2014@gmail.com"});
                share.putExtra(Intent.EXTRA_SUBJECT,new String[]{"Welcome Home.......Jipe Nguvu baba"});
                startActivity(Intent.createChooser(share,"Feedback"));


            }
        });
    }
}




