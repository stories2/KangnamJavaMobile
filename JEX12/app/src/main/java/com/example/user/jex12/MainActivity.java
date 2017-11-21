package com.example.user.jex12;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    final int DRAW_CIRCLE = 2, DRAW_LINE = 1;

    CustomCanvasView customCanvasView;
    CustomImageView customImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);/*
        customCanvasView = new CustomCanvasView(this);
        setContentView(customCanvasView);*/
        customImageView = new CustomImageView(this);
        setContentView(customImageView);
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
