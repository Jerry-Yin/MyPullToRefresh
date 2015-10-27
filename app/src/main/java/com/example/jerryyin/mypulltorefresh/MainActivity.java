package com.example.jerryyin.mypulltorefresh;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;


public class MainActivity extends ActionBarActivity {


    private PullToRefreshListView mListView;
    private ArrayAdapter mAdapter;
    private String[] arry = {"www", "ddddd", "222"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_list_view);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arry);
        mListView.setAdapter(mAdapter);
    }




}
