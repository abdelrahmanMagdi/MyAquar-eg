package aquar.aswany.myaquar_eg.Fragments.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Activity.Popular_Home_Activity;
import aquar.aswany.myaquar_eg.Adapters.Home_Dev_Adapter;
import aquar.aswany.myaquar_eg.Models.Pojo_Home_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Home_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;

/**
 * Created by aswany on 1/19/19.
 */

public class All_Data_Fragment extends Fragment {
    private final String TAG = "All_Data_Fragment";
    @BindView(R.id.Fragment_RV)
    RecyclerView Fragment_RV;

    private AlertDialog dialog;
    private ArrayList<Pojo_Home_Obj> pojo_home_objs = new ArrayList<>();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "" + "onAttached");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog= new SpotsDialog.Builder().setContext(getActivity()).setTheme(R.style.Custom).build();
        dialog.setMessage("Please wait.....");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragments, container, false);
        ButterKnife.bind(this, view);
        GetHome_Developer_Data();
//        Fragment_RV
        return view;
    }

    private void GetHome_Developer_Data() {
        dialog.show();
        Log.d("URL: ", URLS.Alldevelopers);
        AndroidNetworking.get(URLS.Alldevelopers)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Log.d("HomeResponse", response.toString());

                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        Pojo_Home_Res pojoHomeObj = gson.fromJson(response.toString(), Pojo_Home_Res.class);
                        pojo_home_objs = pojoHomeObj.getDevelopers();

                        setHome_DeveloperData(pojo_home_objs);
                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        if (anError.getErrorCode() != 0) {
                            Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                            Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                            if (anError.getErrorCode() == 500) {
                                Log.d(TAG, "onError errorBody : " + "DataBase Error");
                                Toast.makeText(getActivity(), "DataBase Error", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
                            Toast.makeText(getActivity(), "Connection Lost", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void setHome_DeveloperData(ArrayList<Pojo_Home_Obj> Developers) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        Fragment_RV.setLayoutManager(layoutManager);
        Home_Dev_Adapter adapter = new Home_Dev_Adapter(getActivity(), Developers);
        Fragment_RV.setAdapter(adapter);


    }
}
