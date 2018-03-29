package com.example.hauntarl.expandablelogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridActivity extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    int images[];

    public GridActivity(Context context,  int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {

        return (images.length);
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
        convertView = layoutInflater.inflate(R.layout.activity_grid,null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewForGrid);

        TextView textView =(TextView) convertView.findViewById(R.id.textViewForGrid);

        switch (position){
            case 0:
                textView.setText(R.string.new_entry);
                break;
            case 1:
                textView.setText(R.string.notify);
                break;
            case 2:
                textView.setText(R.string.past_entries);
                break;
            case 3:
                textView.setText(R.string.my_account);
                break;
            case 4:
                textView.setText(R.string.support);
                break;
            case 5:
                textView.setText(R.string.about_us);
                break;
        }

        imageView.setImageResource(images[position]);
        return convertView;
    }
}
