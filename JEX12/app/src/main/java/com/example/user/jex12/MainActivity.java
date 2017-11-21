package com.example.user.jex12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    final int DRAW_CIRCLE = 2, DRAW_LINE = 1;

    CustomCanvasView customCanvasView;
    CustomImageView customImageView;
    CustomPhotoView customPhotoView;
    LinearLayout linearCustomPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);/*
        customCanvasView = new CustomCanvasView(this);
        setContentView(customCanvasView);*/
        /*customImageView = new CustomImageView(this);
        setContentView(customImageView);*/
        setContentView(R.layout.activity_main2);
        linearCustomPhoto = (LinearLayout)findViewById(R.id.linearCustomPhoto);
        customPhotoView = new CustomPhotoView(this);
        linearCustomPhoto.addView(customPhotoView);
    }

    public void btnOnGray(View view) {
        if(customPhotoView.getSatur() == 1) {
            customPhotoView.setSatur(0);
        }
        else {
            customPhotoView.setSatur(1);
        }
        customPhotoView.invalidate();
    }

    public void btnOnBrightDown(View view) {
        customPhotoView.setColor(customPhotoView.getColor() - 0.2f);
        customPhotoView.invalidate();
    }

    public void btnOnBrightUp(View view) {
        customPhotoView.setColor(customPhotoView.getColor() + 0.2f);
        customPhotoView.invalidate();
    }

    public void btnOnRotate(View view) {
        customPhotoView.setAngle(customPhotoView.getAngle() + 20);
        customPhotoView.invalidate();
    }

    public void btnOnZoomOut(View view) {
        customPhotoView.setScale(customPhotoView.getScale() - 0.2f);
        customPhotoView.invalidate();
    }

    public void btnOnZoomIn(View view) {
        customPhotoView.setScale(customPhotoView.getScale() + 0.2f);
        customPhotoView.invalidate();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, DRAW_LINE, 0, "Draw line");
        menu.add(0, DRAW_CIRCLE, 0, "Draw circle");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case DRAW_LINE:
                customCanvasView.setDrawType(DRAW_LINE);
                break;
            case DRAW_CIRCLE:
                customCanvasView.setDrawType(DRAW_CIRCLE);
                break;
                default:
                    break;
        }
        return true;
    }*/
}
