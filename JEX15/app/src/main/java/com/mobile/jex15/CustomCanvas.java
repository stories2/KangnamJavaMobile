package com.mobile.jex15;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static com.mobile.jex15.MainActivity.COLOR_BLUE;
import static com.mobile.jex15.MainActivity.COLOR_GREEN;
import static com.mobile.jex15.MainActivity.COLOR_RED;
import static com.mobile.jex15.MainActivity.DRAW_CIRCLE;
import static com.mobile.jex15.MainActivity.DRAW_LINE;
import static com.mobile.jex15.MainActivity.DRAW_RECTANGLE;

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

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        for(MyShape myShape : myShapes) {
            switch (myShape.getColor()) {
                case COLOR_RED:
                    paint.setColor(Color.RED);
                    break;
                case COLOR_GREEN:
                    paint.setColor(Color.GREEN);
                    break;
                case COLOR_BLUE:
                    paint.setColor(Color.BLUE);
                    break;
            }
            switch (myShape.getShapeType()) {
                case DRAW_LINE:
                    canvas.drawLine(myShape.getStartX(), myShape.getStartY(), myShape.getStopX(), myShape.getStopY(), paint);
                    break;
                case DRAW_CIRCLE:
                    int radius = (int)Math.sqrt(Math.pow(myShape.getStartX() - myShape.getStopX(), 2) + Math.pow(myShape.getStartY() - myShape.getStopY(), 2));
                    canvas.drawCircle(myShape.getStartX(), myShape.getStartY(), radius, paint);
                    break;
                case DRAW_RECTANGLE:
                    canvas.drawRect(myShape.getStartX(), myShape.getStartY(), myShape.getStopX(), myShape.getStopY(), paint);
                    break;
            }
        }
    }

    public void AppendShape(MyShape myShape) {
        myShapes.add(myShape);
        this.invalidate();
    }
}
