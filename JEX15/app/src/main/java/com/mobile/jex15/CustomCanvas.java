package com.mobile.jex15;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stories2 on 2017. 12. 1..
 */

public class CustomCanvas extends View {

    List<MyShape> myShapes;

    public CustomCanvas(Context context) {
        super(context);
    }

    public CustomCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);

        myShapes = new ArrayList<MyShape>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void AppendShape(MyShape myShape) {
        myShapes.add(myShape);
        this.invalidate();
    }
}
