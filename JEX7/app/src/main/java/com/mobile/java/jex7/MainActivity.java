package com.mobile.java.jex7;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    LinearLayout linearMain;
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearMain = (LinearLayout)findViewById(R.id.linearMain);
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
}
