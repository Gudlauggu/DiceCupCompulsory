package com.example.gudla.dicecupcompulsory;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RollModel mRollModel;
    private HistoryAdapter mRecyclerHistoryAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mRollModel = RollModel.getInstance();

        RecyclerView recyclerView = findViewById(R.id.rclHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerHistoryAdapter = new HistoryAdapter();
        recyclerView.setAdapter(mRecyclerHistoryAdapter);

    }

}
