package com.example.user.jex8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView txtName, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init4();
    }

    public void BtnOnAlertClick(View view) {
        final View alertDialogView = (View) View.inflate(MainActivity.this, R.layout.alert_dialog_view, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setView(alertDialogView);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText etxtEmail, etxtName;
                etxtEmail = (EditText)alertDialogView.findViewById(R.id.etxtEmail);
                etxtName = (EditText)alertDialogView.findViewById(R.id.etxtName);

                txtEmail.setText(etxtEmail.getText().toString());
                txtName.setText(etxtName.getText().toString());
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final View toastView = (View)View.inflate(MainActivity.this, R.layout.toast_view, null);
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(toastView);
                toast.show();
            }
        });
        alertDialogBuilder.show();
    }

    public void Init4() {
        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
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
    public void Init2() {
        final String[] versionArray = new String[] {
                "Lolli", "Mash", "Nugat"
        };
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Version");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setSingleChoiceItems(versionArray, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Test", "index: " + versionArray[i]);
                    }
                });
        alertDialogBuilder.setPositiveButton("Close", null);
        alertDialogBuilder.show();
    }
    public void Init3() {
        final String[] versionArray = new String[] {
                "Lolli", "Mash", "Nugat"
        };
        final boolean[] checkArray = new boolean[] {
                false, false, false
        };
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Version");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        alertDialogBuilder.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Log.d("Test", "index: " + versionArray[i] + " check: " + b);
                    }
                });
                alertDialogBuilder.setPositiveButton("Close", null);
        alertDialogBuilder.show();
    }
}
