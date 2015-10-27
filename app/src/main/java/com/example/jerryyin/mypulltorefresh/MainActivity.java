package com.example.jerryyin.mypulltorefresh;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    private PullToRefreshListView mListView;
    private ArrayAdapter mAdapter;
    private ArrayList<String> arry = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_list_view);
        arry.add("1111111");
        arry.add("22222222");
        arry.add("ddddddd");

        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arry);
        mListView.setAdapter(mAdapter);
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(3000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
//                        super.onPostExecute(aVoid);
                        arry.add("刷新出来的数据");
                        arry.add("新数据2");
                        mListView.onRefreshComplete();
                    }
                }.execute();
            }
        });
    }




}
