package aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aswany on 1/20/19.
 */

public class Product_info_Fragment extends Fragment {
    private Dialog dialog;
    private final String TAG = "Product_info_Fragment";
    ArrayList<Pojo_Project_Obj> projectObjs = new ArrayList<>();

    @BindView(R.id.Product_Frag_Details)
    TextView Product_Frag_Details;
    @BindView(R.id.Product_Frag_Type)
    TextView Product_Frag_Type;
    @BindView(R.id.Product_Frag_Size)
    TextView Product_Frag_Size;
    @BindView(R.id.Product_Frag_BedRoom)
    TextView Product_Frag_BedRoom;
    @BindView(R.id.Product_Frag_BathRoom)
    TextView Product_Frag_BathRoom;
    @BindView(R.id.Product_Frag_Accommodation)
    TextView Product_Frag_Accommodation;
    int Product_ID;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Product_ID = Session.getInstance().getProductID();
        dialog = new ProgressDialog(getActivity());
        getData();
    }

    @Override
    public void onResume() {
        super.onResume();
        Product_ID = Session.getInstance().getProductID();
        getData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        ButterKnife.bind(this, view);
//        SetData();
        return view;
    }

    private void SetData() {
        try {

            Product_Frag_Details.setText(projectObjs.get(0).getDescription());
            Product_Frag_Type.setText(projectObjs.get(0).getType());

            Product_Frag_BedRoom.setText(projectObjs.get(0).getRooms() + "");
            Product_Frag_BathRoom.setText(projectObjs.get(0).getBathsrooms() + "");
            Product_Frag_Accommodation.setText(projectObjs.get(0).getAccommodation() + "");
            Product_Frag_Size.setText(projectObjs.get(0).getArea() + "");
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Package Lost !!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void getData() {
        Log.d("zex", "Response: " + Product_ID);
        dialog.show();
        AndroidNetworking.get(URLS.project)
                .addQueryParameter("id", Product_ID + "")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                       dialog.dismiss();
                        Log.d(TAG, "Response: " + response.toString());
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        Pojo_Project_Res projectRes = gson.fromJson(response.toString(), Pojo_Project_Res.class);
                        projectObjs=new ArrayList<>();
                        projectObjs = projectRes.getProject();
                        SetData();

//                        Log.d(TAG, "Response: " + projectObjs.get(0).getDescription());
                        Session.getInstance().setProducts(projectRes.getProject());

                    }

                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        Log.d(TAG, "Response: " + anError.getErrorCode());

                    }
                });


    }
}
