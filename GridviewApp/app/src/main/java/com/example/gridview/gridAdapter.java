package com.example.gridview;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridviewapp.R;

public class gridAdapter extends BaseAdapter {

    Context mContext;
    private final String[] values;
    private final int[] images;
    View mView;
    LayoutInflater mLayoutInflater;
    public gridAdapter(Context context,String[]values,int[]images){
        this.mContext = context;
        this.values = values;
        this.images = images;
    }
    @Override
    public int getCount() {
        return values.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            mView = new View(mContext);
            mView = mLayoutInflater.inflate(R.layout.single_item, null);
            ImageView imageView = (ImageView) mView.findViewById(R.id.imageview);
            TextView textView = (TextView)mView.findViewById(R.id.textView);
            imageView.setImageResource(images[position]);
            textView.setText(values[position]);
        }
        return mView;
    }
}
