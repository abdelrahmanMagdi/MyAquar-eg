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

import aquar.aswany.myaquar_eg.Adapters.Developer_Category_Adapter;
import aquar.aswany.myaquar_eg.Models.Pojo_Developer_Category_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Developer_Category_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Popular_Home_Activity extends AppCompatActivity {

    @BindView(R.id.Popular_Home_RV)
    RecyclerView Popular_Home_RV;
    final String TAG="Popular_Home_Activity";

    ProgressDialog dialog;
    private ArrayList<Pojo_Developer_Category_Obj> PopularProjects=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_home);
        dialog = new ProgressDialog(this);
        ButterKnife.bind(this);
        Recive_Data();

    }

    private void Recive_Data() {
        dialog.show();
        AndroidNetworking.get(URLS.PopularP)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Log.d(TAG,"response"+response.toString());
//                        response.get("er")
                        Gson gson= new GsonBuilder().setPrettyPrinting().create();
                        Pojo_Developer_Category_Res category_res = gson.fromJson(response.toString(),Pojo_Developer_Category_Res.class);
                        PopularProjects =category_res.getDevelopers();
                        SetPopularProjectsData(PopularProjects);

                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(Popular_Home_Activity.this, "DataBase Error", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(Popular_Home_Activity.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void SetPopularProjectsData(ArrayList<Pojo_Developer_Category_Obj> popularProjects) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        Popular_Home_RV.setLayoutManager(layoutManager);
        Developer_Category_Adapter adapter = new Developer_Category_Adapter(popularProjects,this);
        Popular_Home_RV.setAdapter(adapter);
    }

}
