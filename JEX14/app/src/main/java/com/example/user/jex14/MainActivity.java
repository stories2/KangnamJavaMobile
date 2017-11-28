package com.example.user.jex14;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {

    GridView gridImages;
    int voteData[];
    String imageNames[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridImages = (GridView)findViewById(R.id.gridImages);

        int images[] = {
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
                R.drawable.pic9,
        };

        imageNames = new String[] {
                "test1",
                "test2",
                "test3",
                "test4",
                "test5",
                "test6",
                "test7",
                "test8",
                "test9"
        };

        GridImageAdapter gridImageAdapter = new GridImageAdapter(
                getApplicationContext(),
                R.layout.grid_row,
                images
        );

        voteData = new int[9];

        gridImages.setAdapter(gridImageAdapter);

        gridImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                voteData[i] = voteData [i] + 1;
                Log.d("JEX14", "click position = " + i + " vote: " + voteData[i]);
            }
        });
    }

    public void btnOnViewResult(View view) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("vote", voteData);
        intent.putExtra("name", imageNames);
        startActivity(intent);
    }
}
