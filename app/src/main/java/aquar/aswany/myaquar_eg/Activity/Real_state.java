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
String dis;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_state);

        ArrayList<Example_real_state> exampleList = new ArrayList<>();
        exampleList.add(new Example_real_state("   Real estate in egypt cairo zamalek maadi dokki mohandessin 6 october cairo alex road new cairo qattamia heights el-rehab city helioplois . COMFORT is a real estate agency which has been offering property services plus appraisal real estate services for over 50 years in the Egyptian market. Since 1953 the company was …",R.drawable.a));
        exampleList.add(new Example_real_state("   Real estate in egypt cairo zamalek maadi dokki mohandessin 6 october cairo alex road new cairo qattamia heights el-rehab city helioplois . COMFORT is a real estate agency which has been offering property services plus appraisal real estate services for over 50 years in the Egyptian market. Since 1953 the company was …",R.drawable.c));
        exampleList.add(new Example_real_state("   Real estate in egypt cairo zamalek maadi dokki mohandessin 6 october cairo alex road new cairo qattamia heights el-rehab city helioplois . COMFORT is a real estate agency which has been offering property services plus appraisal real estate services for over 50 years in the Egyptian market. Since 1953 the company was …",R.drawable.b));
        exampleList.add(new Example_real_state("   Real estate in egypt cairo zamalek maadi dokki mohandessin 6 october cairo alex road new cairo qattamia heights el-rehab city helioplois . COMFORT is a real estate agency which has been offering property services plus appraisal real estate services for over 50 years in the Egyptian market. Since 1953 the company was …",R.drawable.f));

        mRecyclerView = findViewById(R.id.recyclerView11);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Exampel_adapter_Real_stat(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
