package com.example.buttons5;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button phone,sms,camera,share,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.button1);
        sms=findViewById(R.id.button2);
        camera=findViewById(R.id.button3);
        share=findViewById(R.id.button4);
        email=findViewById(R.id.button5);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonecall=new Intent(Intent.ACTION_DIAL);
                phonecall.setData(Uri.parse("tel: +254736976836"));
                startActivity(phonecall);

            }
        });
sms.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri myno=Uri.parse("smsto:+254736976836");
        Intent sms=new Intent(Intent.ACTION_SENDTO,myno);
        sms.putExtra("body","My Name is Muya");
        startActivity(sms);



    }
});
camera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera,0);


    }
});
share.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("plain/text");
        share.putExtra(Intent.EXTRA_SUBJECT,new String[]{"peekabu"});
        share.putExtra(Intent.EXTRA_TEXT,new String[]{"Welcome Home"});
        startActivity(Intent.createChooser(share,"Select App"));


    }
});
email.setOnClickListener(new View.OnClickListener() {
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
