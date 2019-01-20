package aquar.aswany.myaquar_eg.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Adapters.Projects_Adapter;
import aquar.aswany.myaquar_eg.Models.Pojo_Projects_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Projects_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Search_Activity extends AppCompatActivity {
    private ProgressDialog dialog;
    @BindView(R.id.Projects_RecyclerView)
    RecyclerView Projects_RecyclerView;
    private ArrayList<Pojo_Projects_Obj> ProjectData = new ArrayList<>();
    String DeveloperId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        Decelerations();
    }

    private void Decelerations() {
        dialog = new ProgressDialog(this);
        DeveloperId = Session.getInstance().getDeveloperID();
        Log.d("DevID",DeveloperId);
        getProjectsData();

    }

    private void getProjectsData() {
        dialog.show();
        Log.d("URL: ", URLS.Alldevelopers);

        AndroidNetworking.get(URLS.project)
                .setPriority(Priority.LOW)
                .addQueryParameter("id", DeveloperId)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener(){
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        Pojo_Projects_Res pojoProjectsObj = gson.fromJson(response.toString(), Pojo_Projects_Res.class);
                        ProjectData = pojoProjectsObj.getProjects();
                        setProjectsData(ProjectData);
                        Log.d("Response", response.toString());
                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        Log.d("ErrProjects_Activity", anError.getErrorCode() + "");
                        Log.d("ErrProjects_Activity", anError.getErrorDetail() + "");
                    }
                });
    }

    private void setProjectsData(ArrayList<Pojo_Projects_Obj> projectData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        Projects_RecyclerView.setLayoutManager(layoutManager);
        Projects_Adapter adapter = new Projects_Adapter(projectData, this);
        Projects_RecyclerView.setAdapter(adapter);
    }
}
