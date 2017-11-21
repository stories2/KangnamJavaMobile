package com.example.user.jex12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by User on 2017-11-21.
 */

public class CustomCanvasView extends View {

    final int DRAW_LINE = 1, DRAW_CIRCLE = 2;
    int nowDrawType, touchStartPointX, touchStartPointY, touchEndPointX, touchEndPointY;
    ArrayList<Path> pathArray;
    Path path;

    public CustomCanvasView(Context context) {
        super(context);

        pathArray = new ArrayList<Path>();
        nowDrawType = DRAW_LINE;
        path = new Path();
    }

    public CustomCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomCanvasView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStartPointX = (int)event.getX();
                touchStartPointY = (int)event.getY();
                Log.d("jex12", "d x: " + touchStartPointX + " y: " + touchStartPointY);
                path.moveTo(touchStartPointX, touchStartPointY);
                if(nowDrawType == DRAW_LINE) {
                    path.lineTo(touchStartPointX, touchStartPointY);
                }
                else if(nowDrawType == DRAW_CIRCLE) {
                    path.addArc(touchStartPointX, touchStartPointY, touchStartPointX, touchStartPointY, 0, 360);
                }
                pathArray.add(path);
                this.invalidate();
                break;
            case MotionEvent.ACTION_MOVE:/*
                touchEndPointX = (int)event.getX();
                touchEndPointY = (int)event.getY();
                Log.d("jex12", "m x: " + touchEndPointX + " y: " + touchEndPointY);
                pathArray.remove(pathArray.size() - 1);
                path.moveTo(touchStartPointX, touchStartPointY);
                if(nowDrawType == DRAW_LINE) {
                    path.lineTo(touchEndPointX, touchEndPointY);
                }
                else if(nowDrawType == DRAW_CIRCLE) {
                    path.addArc(touchStartPointX, touchStartPointY, touchEndPointX, touchEndPointY, 0, 360);
                }
                pathArray.add(path);
                this.invalidate();*/
                break;
            case MotionEvent.ACTION_UP:
                touchEndPointX = (int)event.getX();
                touchEndPointY = (int)event.getY();
                Log.d("jex12", "u x: " + touchEndPointX + " y: " + touchEndPointY + " sx: " + touchStartPointX + " sy: " + touchStartPointY);
                pathArray.remove(pathArray.size() - 1);
                path.moveTo(touchStartPointX, touchStartPointY);
                if(nowDrawType == DRAW_LINE) {
                    path.lineTo(touchEndPointX, touchEndPointY);
                }
                else if(nowDrawType == DRAW_CIRCLE) {
                    path.addArc(touchStartPointX, touchStartPointY, touchEndPointX, touchEndPointY, 0, 360);
                }
                pathArray.add(path);
                this.invalidate();
                Log.d("jex12", "path len: " + pathArray.size());
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        if(path != null) {
            canvas.drawPath(path, paint);
        }
    }

    public void setDrawType(int drawType) {
        this.nowDrawType = drawType;
    }
}
