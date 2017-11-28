package com.example.user.jex14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by User on 2017-11-28.
 */

public class GridImageAdapter extends BaseAdapter {

    Context context;
    int rowLayout, images[];
    LayoutInflater layoutInflater;

    public GridImageAdapter(Context context, int rowLayout, int images[]) {
        super();

        this.context = context;
        this.rowLayout = rowLayout;
        this.images = images;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = layoutInflater.inflate(rowLayout, null);
        }
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(images[i]);
        return view;
    }
}
