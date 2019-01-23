package aquar.aswany.myaquar_eg.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Adapters.Search_Adapter;
import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_S_Budget_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_S_Budget_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Search_Activity extends AppCompatActivity {
    private ProgressDialog dialog;
    @BindView(R.id.Search_RecyclerView)
    RecyclerView Search_RecyclerView;
    private ArrayList<Pojo_S_Budget_Obj> sBudgetObjs = new ArrayList<>();
    String DeveloperId, Min, Max;
    private final String TAG = "Search_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        Decelerations();
    }

    private void Decelerations() {
        dialog = new ProgressDialog(this);
//        DeveloperId = Session.getInstance().getDeveloperID();
        Log.d("DevID", DeveloperId);
//        getProjectsData();
//        Search_Price_Method(Min, Max);
//        Search_Area_Method(Min, Max);

    }

    private void Search_Area_Method(String min, String max) {
        dialog.dismiss();
        AndroidNetworking.post(URLS.Search_Area)
                .addBodyParameter("min", min)
                .addBodyParameter("max", max)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Log.d(TAG, "Response : " + response.toString());
                        Gson gson=new GsonBuilder().setPrettyPrinting().create();
                        Pojo_S_Budget_Res s_budget_obj=gson.fromJson(response.toString(),Pojo_S_Budget_Res.class);
                        sBudgetObjs=s_budget_obj.getBadget();
                        setProjectsData(sBudgetObjs);

                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(Search_Activity.this, "DataBase Error", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(Search_Activity.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void Search_Price_Method(String min, String max) {
        dialog.show();
        AndroidNetworking.post(URLS.Search_Price)
                .addBodyParameter("min", min)
                .addBodyParameter("max", max)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Log.d(TAG, "Response : " + response.toString());
                        Gson gson=new GsonBuilder().setPrettyPrinting().create();
                        Pojo_S_Budget_Res s_budget_obj=gson.fromJson(response.toString(),Pojo_S_Budget_Res.class);
                        sBudgetObjs=s_budget_obj.getBadget();
                        setProjectsData(sBudgetObjs);

                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(Search_Activity.this, "DataBase Error", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(Search_Activity.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    private void setProjectsData(ArrayList<Pojo_S_Budget_Obj> projectData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        Search_RecyclerView.setLayoutManager(layoutManager);
        Search_Adapter adapter = new Search_Adapter(projectData, this);
        Search_RecyclerView.setAdapter(adapter);
    }
}
