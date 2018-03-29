package com.example.hauntarl.expandablelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class DashActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    public GridView gridView;
    int images[] =
            {
                    R.drawable.new_entry,
                    R.drawable.notify ,
                    R.drawable.past_entries,
                    R.drawable.my_account,
                    R.drawable.support,
                    R.drawable.about_us
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        gridView = findViewById(R.id.gridView1);

        GridActivity gridAdapter = new GridActivity(getApplicationContext(),images);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //position would tell u everything
    }

}
