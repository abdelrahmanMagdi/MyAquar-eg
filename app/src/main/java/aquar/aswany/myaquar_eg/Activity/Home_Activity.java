package aquar.aswany.myaquar_eg.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Fragments.Fragment.All_Data_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment.Com_Data_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment.Holy_Data_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment.LS_Data_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment.Med_Data_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment.Res_Data_Fragment;
import aquar.aswany.myaquar_eg.Models.Pojo_Home_Obj;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_Activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "Home_Activity_Res";
    private ProgressDialog dialog;
    private Fragment fragment;
    private FragmentTransaction transaction;

    //Layout
    @BindView(R.id.Home_FrameLayout)
    FrameLayout Home_FrameLayout;

    //Navi
    @BindView(R.id.Home_BottomNavi)
    BottomNavigationView Home_BottomNavi;

    private ArrayList<Pojo_Home_Obj> pojo_home_res = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Decelerations();
    }

    private void Decelerations() {
        ButterKnife.bind(this);
        dialog = new ProgressDialog(this);
        AndroidNetworking.initialize(this);
        GetHome_Categories_Data();
        fragment_All();
        Home_BottomNavi.setOnNavigationItemSelectedListener(this);


    }

    private void GetHome_Categories_Data() {
        dialog.show();
        AndroidNetworking.get(URLS.Category)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Log.d(TAG, "Response: " + response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(Home_Activity.this, "DataBase Error", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(Home_Activity.this, "Connection Lost", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
//        GetHome_Dev_Data();
    }

//    private void GetHome_Developer_Data() {
//        dialog.show();
//        Log.d("URL: ", URLS.Alldevelopers);
//        AndroidNetworking.get(URLS.Alldevelopers)
//                .setPriority(Priority.LOW)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        dialog.dismiss();
//                        Log.d("HomeResponse", response.toString());
//
//                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                        Pojo_Home_Res pojoHomeObj = gson.fromJson(response.toString(), Pojo_Home_Res.class);
//                        pojo_home_res = pojoHomeObj.getDevelopers();
//                        setHome_DeveloperData(pojo_home_res);
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        dialog.dismiss();
//                        if (anError.getErrorCode() != 0) {
//                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
//                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
//                            if (anError.getErrorCode() == 500) {
//                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
//                                Toast.makeText(Home_Activity.this, "DataBase Error", Toast.LENGTH_SHORT).show();
//
//                            }
//
//                        } else {
//                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
//                            Toast.makeText(Home_Activity.this, "Connection Lost", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }

//    private void setHome_DeveloperData(ArrayList<Pojo_Home_Obj> Developers) {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        Home_RecyclerView.setLayoutManager(layoutManager);
//        Home_Dev_Adapter adapter = new Home_Dev_Adapter(Home_Activity.this, Developers);
//        Home_RecyclerView.setAdapter(adapter);
//
//
//    }

    private void dismissProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        dismissProgressDialog();
        super.onDestroy();
    }


    private void fragment_All() {
        fragment = new All_Data_Fragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Home_FrameLayout, fragment, "All_Data_Fragment");
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.Navigation_Res:
                Log.d(TAG, "Linear_Res" + "");
                fragment = new Res_Data_Fragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home_FrameLayout, fragment, "Res_Data_Fragment");
                transaction.commitNow();
                return true;
            case R.id.Navigation_Com:
                Log.d(TAG, "Linear_Com" + "");
                fragment = new Com_Data_Fragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home_FrameLayout, fragment, "Com_Data_Fragment");
                transaction.commitNow();
                return true;
            case R.id.Navigation_Med:
                Log.d(TAG, "Linear_Med" + "");
                fragment = new Med_Data_Fragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home_FrameLayout, fragment, "Med_Data_Fragment");
                transaction.commitNow();
                return true;
            case R.id.Navigation_HH:
                Log.d(TAG, "Linear_HH" + "");
                fragment = new Holy_Data_Fragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home_FrameLayout, fragment, "Holy_Data_Fragment");
                transaction.commitNow();
                return true;
            case R.id.Navigation_LS:
                Log.d(TAG, "Linear_LS" + "");
                fragment = new LS_Data_Fragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.Home_FrameLayout, fragment, "LS_Data_Fragment");
                transaction.commitNow();
                return true;
            default:
                Log.d(TAG, "Default" + "");
                break;

        }
        return false;
    }
}
