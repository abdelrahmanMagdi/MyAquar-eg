package aquar.aswany.myaquar_eg.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Adapters.Exampel_adapter_Real_stat;
import aquar.aswany.myaquar_eg.Models.Example_real_state;
import aquar.aswany.myaquar_eg.R;

public class Real_state extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_state);

        ArrayList<Example_real_state> exampleList = new ArrayList<>();
exampleList.add(new Example_real_state(R.drawable.statone));

        exampleList.add(new Example_real_state(R.drawable.statfour));
        exampleList.add(new Example_real_state(R.drawable.statthree));
        exampleList.add(new Example_real_state(R.drawable.statthree));

        mRecyclerView = findViewById(R.id.recyclerView11);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Exampel_adapter_Real_stat(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
