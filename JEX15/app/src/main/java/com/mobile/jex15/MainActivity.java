package com.mobile.jex15;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    CustomCanvas customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CustomCanvas)findViewById(R.id.customCanvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MyShape myShape = new MyShape();
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                myShape.setStartX((int) event.getX());
                myShape.setStartY((int) event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                myShape.setStopX((int) event.getX());
                myShape.setStopY((int) event.getY());
                customCanvas.AppendShape(myShape);
                break;
        }
        return true;
    }
}
