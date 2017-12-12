package com.examplejex17.user.jex17;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by User on 2017-12-12.
 */

public class CustomGalleryView extends BaseAdapter{

    ImageView moviePosterView;
    Context context;
    Integer[] movieItems = {
            R.drawable.mov01,
            R.drawable.mov02,
            R.drawable.mov03,
            R.drawable.mov04,
            R.drawable.mov05,
            R.drawable.mov06,
    };

    public CustomGalleryView(Context context, ImageView moviePosterView) {
        super();
        this.context = context;
        this.moviePosterView = moviePosterView;
    }

    @Override
    public int getCount() {
        return movieItems.length;
    }

    @Override
    public Object getItem(int i) {
        return movieItems[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(100, 150));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(movieItems[i]);

        final int pos = i;
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                moviePosterView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                moviePosterView.setImageResource(movieItems[pos]);
                return true;
            }
        });
        return imageView;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
