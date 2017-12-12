package com.examplejex17.user.jex17;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by User on 2017-12-12.
 */

public class CustomGridAdapter extends BaseAdapter {

    Context context;
    Integer[] imgArray = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    public CustomGridAdapter(Context context) {
        super();

        this.context = context;
    }

    @Override
    public int getCount() {
        return imgArray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(100, 150));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(imgArray[i]);

        final int pos = i;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = (View)View.inflate(context, R.layout.grid_item, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                ImageView imagePoster = (ImageView) dialogView.findViewById(R.id.imagePoster);
                imagePoster.setImageResource(imgArray[pos]);
                alertDialogBuilder.setTitle("image");
                alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
                alertDialogBuilder.setView(dialogView);
                alertDialogBuilder.setNegativeButton("Close", null);
                alertDialogBuilder.show();
            }
        });

        return imageView;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
