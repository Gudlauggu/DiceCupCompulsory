package com.example.gudla.dicecupcompulsory;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    Button btnClear;
    ListView listHistory;
    private ArrayList<RollEntity> rollEntities;
    Boolean clearHistory = false;
    HistoryAdapter hAdapter;

    int RESULT_CLEAR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Bundle extras = getIntent().getExtras();
        rollEntities = (ArrayList<RollEntity>) extras.getSerializable("History");

        if( rollEntities == null)
        {
            rollEntities = new ArrayList<>();
        }
        hAdapter = new HistoryAdapter(this, rollEntities);

        listHistory = findViewById(R.id.listHistory);
        listHistory.setAdapter(hAdapter);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearH();
            }
        });

    }

    public static Intent getHistoryIntent(Context context)
    {
        Intent intent = new Intent(context, HistoryActivity.class );
        return intent;
    }

    //Clears the history if the clear button is pressed otherwise not
    @Override
    public void onBackPressed()
    {
        if (clearHistory)
        {
            setResult(RESULT_CLEAR);
        }
        else{
            setResult(RESULT_CANCELED);
        }
        finish();
    }

    //Clears the History
    private void ClearH()
    {
        rollEntities.clear();
        clearHistory = true;
        hAdapter.notifyDataSetChanged();
    }
}
