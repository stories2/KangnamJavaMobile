package com.mobile.jex15;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;

public class MainActivity extends Activity {

    public static final int
            DRAW_LINE = 1, DRAW_CIRCLE = 2, DRAW_RECTANGLE = 3,
            COLOR_RED = 4, COLOR_GREEN = 5, COLOR_BLUE = 6;

    CustomCanvas customCanvas;
    int lastDrawStyle = DRAW_LINE, lastDrawColor = COLOR_RED;
    MyShape myShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CustomCanvas)findViewById(R.id.customCanvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                myShape = new MyShape();

                myShape.setStartX((int) event.getX());
                myShape.setStartY((int) event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                myShape.setStopX((int) event.getX());
                myShape.setStopY((int) event.getY());
                myShape.setColor(lastDrawColor);
                myShape.setShapeType(lastDrawStyle);
                customCanvas.AppendShape(myShape);

                Log.d("JEX15", "new draw data: " +
                myShape.getStartX() + ", " + myShape.getStartY() +
                " " + myShape.getStopX() + ", " + myShape.getStopY() +
                " c: " + myShape.getColor() + " s: " + myShape.getShapeType());
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, DRAW_LINE, 0, "Draw line");
        menu.add(0, DRAW_CIRCLE, 0, "Draw circle");
        menu.add(0, DRAW_RECTANGLE, 0, "Draw rectangle");

        SubMenu subMenu = menu.addSubMenu("Change color");
        subMenu.add(0, COLOR_RED, 0, "Red");
        subMenu.add(0, COLOR_GREEN, 0, "Green");
        subMenu.add(0, COLOR_BLUE, 0, "Blue");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case DRAW_LINE:
                lastDrawStyle = DRAW_LINE;
                break;
            case DRAW_CIRCLE:
                lastDrawStyle = DRAW_CIRCLE;
                break;
            case DRAW_RECTANGLE:
                lastDrawStyle = DRAW_RECTANGLE;
                break;
            case COLOR_RED:
                lastDrawColor = COLOR_RED;
                break;
            case COLOR_GREEN:
                lastDrawColor = COLOR_GREEN;
                break;
            case COLOR_BLUE:
                lastDrawColor = COLOR_BLUE;
                break;
        }
        return true;
    }
}
