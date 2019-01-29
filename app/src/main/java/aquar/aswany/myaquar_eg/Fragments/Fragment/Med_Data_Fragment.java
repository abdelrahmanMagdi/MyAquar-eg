package aquar.aswany.myaquar_eg.Fragments.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import aquar.aswany.myaquar_eg.Adapters.Developer_Category_Adapter;
import aquar.aswany.myaquar_eg.Models.Pojo_Developer_Category_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Developer_Category_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;

/**
 * Created by aswany on 1/21/19.
 */

public class Med_Data_Fragment extends Fragment {
    private AlertDialog dialog;
    private final String TAG="Med_Data_Fragment";
    @BindView(R.id.Fragment_RV)
    RecyclerView Fragment_RV;
    private ArrayList<Pojo_Developer_Category_Obj> pojoDeveloperCategoryObj=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog= new SpotsDialog.Builder().setContext(getActivity()).setTheme(R.style.Custom).build();
        dialog.setMessage("Please wait.....");        Receive_Med_Data();
    }

    private void Receive_Med_Data() {
        dialog.show();
        AndroidNetworking.get(URLS.Developer_category)
                .addQueryParameter("id","3")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Log.d(TAG, "Response: " + response);
                        Gson gson= new GsonBuilder().setPrettyPrinting().create();
                        Pojo_Developer_Category_Res category_res = gson.fromJson(response.toString(),Pojo_Developer_Category_Res.class);
                        pojoDeveloperCategoryObj =category_res.getDevelopers();
                        SetMed_DeveloperData(pojoDeveloperCategoryObj);
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

    private void SetMed_DeveloperData(ArrayList<Pojo_Developer_Category_Obj> pojoDeveloperCategoryObj) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        Fragment_RV.setLayoutManager(layoutManager);
        Developer_Category_Adapter adapter = new Developer_Category_Adapter(pojoDeveloperCategoryObj,getActivity());
        Fragment_RV.setAdapter(adapter);


    }
}
