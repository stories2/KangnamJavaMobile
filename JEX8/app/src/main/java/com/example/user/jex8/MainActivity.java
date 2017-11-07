package com.example.user.jex8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init1();
    }

    public void Init1() {
        final String[] versionArray = new String[] {
                "Lolli", "Mash", "Nugat"
        };
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Version");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setItems(versionArray,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Test", "index: " + versionArray[i]);
                    }
                });
        alertDialogBuilder.setPositiveButton("Close", null);
        alertDialogBuilder.show();
    }
}
