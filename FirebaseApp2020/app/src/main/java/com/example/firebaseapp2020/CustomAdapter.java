package com.example.firebaseapp2020;
//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import android.widget.BaseAdapter;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<User> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<User> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_layout, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.tvnames =  convertView.findViewById(R.id.tvName);
            viewHolder.tvemail =  convertView.findViewById(R.id.tvEmail);
            viewHolder.tvage =  convertView.findViewById(R.id.tvAge);
            viewHolder.mBtnDel = convertView.findViewById(R.id.btnDel);

            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        final User person = data.get(position);//modify here
        viewHolder.tvnames.setText(person.getNames());//modify here
        viewHolder.tvemail.setText(person.getEmail());//modify here
        viewHolder.tvage.setText(person.getAge());//modify here
        viewHolder.mBtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Names/"+person.getId());
                ref.removeValue();
                Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;

    }
    static class ViewHolder {
        TextView tvnames;
        TextView tvemail;
        TextView tvage;//These don't have to be same names as the Id's
        Button mBtnDel;

    }

}
