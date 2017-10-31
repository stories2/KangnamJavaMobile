package com.mobile.java.jex7;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    LinearLayout linearMain;
    Button btnTest, btnColor, btnRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        linearMain = (LinearLayout)findViewById(R.id.linearMain);

    }

    public void Init2() {
        btnColor = (Button)findViewById(R.id.btnColor);
        btnRotate = (Button)findViewById(R.id.btnRotate);

        registerForContextMenu(btnColor);
        registerForContextMenu(btnRotate);
    }

    public void Init1() {
        btnTest = (Button)findViewById(R.id.btnTest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        menu.add(0, 1, 0, "test red");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                linearMain.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                linearMain.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                linearMain.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemHello:
                btnTest.setRotation(45);
                break;
            case 1:
                linearMain.setBackgroundColor(Color.RED);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        if(v == btnColor) {
            menuInflater.inflate(R.menu.color_menu, menu);
        }
        else if(v == btnRotate) {
            menuInflater.inflate(R.menu.rotate_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        return true;
    }
}
