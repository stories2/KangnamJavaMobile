package com.examplejex17.user.jex17;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listView;
    EditText etxtData;
    ArrayAdapter<String>stringListItemAdapter;
    ArrayList<String>listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Init1();
        Init2();
    }

    public void Init2() {
        listView = (ListView) findViewById(R.id.listView);
        etxtData = (EditText) findViewById(R.id.etxtData);

        listItems = new ArrayList<String>();

        stringListItemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        listView.setAdapter(stringListItemAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                stringListItemAdapter.remove(stringListItemAdapter.getItem(i));
                stringListItemAdapter.setNotifyOnChange(true);
                return true;
            }
        });
    }

    public void Init1() {
        listView = (ListView)findViewById(R.id.listView);

        final String[] items = {"a" ,"b", "c", "d", "e"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items);

        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onBtnAdd(View view) {
        stringListItemAdapter.add(etxtData.getText().toString());
        stringListItemAdapter.setNotifyOnChange(true);
    }
}
