package aquar.aswany.myaquar_eg.Fragments.Fragment;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * Created by aswany on 1/19/19.
 */

public class Res_Data_Fragment extends Fragment {
    private Dialog dialog;
    private final String TAG="Res_Data_Fragment";
    private ArrayList<Pojo_Developer_Category_Obj> pojoDeveloperCategoryObj=new ArrayList<>();

    @BindView(R.id.Fragment_RV)
    RecyclerView Fragment_RV;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(getActivity());
        Receive_Category_ID();

    }

    private void Receive_Category_ID() {
        dialog.show();
        AndroidNetworking.get(URLS.Developer_category)
                .addQueryParameter("id","1")
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
//                        Developer_Category_Adapter adapter= new Developer_Category_Adapter(pojoDeveloperCategoryObj,getContext());
                        setRes_DeveloperData(pojoDeveloperCategoryObj);
                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        Log.d(TAG, "Error: " + anError.getErrorDetail());
                        Log.d(TAG, "Error: " + anError.getErrorCode());
                    }
                });

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    private void setRes_DeveloperData(ArrayList<Pojo_Developer_Category_Obj> pojoDeveloperCategoryObj) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        Fragment_RV.setLayoutManager(layoutManager);
        Developer_Category_Adapter adapter = new Developer_Category_Adapter(pojoDeveloperCategoryObj,getActivity());
        Fragment_RV.setAdapter(adapter);


    }
}
