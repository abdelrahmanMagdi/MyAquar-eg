package aquar.aswany.myaquar_eg.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs.Product_Feature_Fragments;
import aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs.Product_Images_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs.Product_info_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment_Adapter.SectionPagerAdapter;
import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Res;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Product_Activity extends AppCompatActivity {

    private final String TAG = "Product_Activity";
    private Dialog dialog;

    @BindView(R.id.Product_Slider)
    SliderLayout Product_Slider;
    private SectionPagerAdapter sectionPagerAdapter;
//    @BindView(R.id.tabs)
//    TabLayout tabs;
//    @BindView(R.id.viewPager)
//    ViewPager viewPager;
    //    int Product_ID;

    @BindView(R.id.product_price)
    TextView product_price;
    @BindView(R.id.Product_Project)
    TextView Product_Project;

    @BindView(R.id.Product_Frag_Details)
    TextView Product_Frag_Details;

    @BindView(R.id.Product_Frag_Size)
    TextView Product_Frag_Size;
    @BindView(R.id.Product_Frag_Type)
    TextView Product_Frag_Type;
    @BindView(R.id.Product_Frag_BedRoom)
    TextView Product_Frag_BedRoom;
    @BindView(R.id.Product_Frag_BathRoom)
    TextView Product_Frag_BathRoom;
    @BindView(R.id.Product_Frag_Accommodation)
    TextView Product_Frag_Accommodation;
    @BindView(R.id.Product_Frag_Call)
    Button Product_Frag_Call;
    @BindView(R.id.Product_Frag_Share)
    Button Product_Frag_Share;

    private ArrayList<Pojo_Project_Obj> projectObjs = new ArrayList<>();
    int Product_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Deceleration();
    }

    private void Deceleration() {
        Product_ID = Session.getInstance().getProductID();
        dialog = new ProgressDialog(Product_Activity.this);
        getData();
        ButterKnife.bind(this);

        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        sectionPagerAdapter.AddFragment(new Product_info_Fragment(), "Info");
        sectionPagerAdapter.AddFragment(new Product_Images_Fragment(), "VR");
        sectionPagerAdapter.AddFragment(new Product_Feature_Fragments(), "Features");

//        viewPager.setAdapter(sectionPagerAdapter);
//        tabs.setupWithViewPager(viewPager);
//        getData();
        DataOfSlider();
    }


    private void DataOfSlider() {
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Phase 1", R.drawable.azad1);
        file_maps.put("Phase 2", R.drawable.azad2);
        file_maps.put("Phase 3", R.drawable.azad3);
        file_maps.put("Phase 4", R.drawable.azad4);
        file_maps.put("Phase 5", R.drawable.azad5);
        file_maps.put("Phase 6", R.drawable.azad6);
        file_maps.put("Phase 7", R.drawable.azad7);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            Product_Slider.addSlider(textSliderView);
        }
        Product_Slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        Product_Slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        Product_Slider.setCustomAnimation(new DescriptionAnimation());
        Product_Slider.setDuration(4000);
    }

    private void SetData() {
        try {

            Product_Frag_Details.setText(projectObjs.get(0).getDescription());
            Product_Frag_Type.setText(projectObjs.get(0).getType());

            Product_Frag_BedRoom.setText(projectObjs.get(0).getRooms() + "");
            Product_Frag_BathRoom.setText(projectObjs.get(0).getBathsrooms() + "");
            Product_Frag_Accommodation.setText(projectObjs.get(0).getAccommodation() + "");
            Product_Frag_Size.setText(projectObjs.get(0).getArea() + "");
            Product_Project.setText(projectObjs.get(0).getLocation() + " - ");

        } catch (Exception e) {
            Toast.makeText(Product_Activity.this, "Package Lost !!", Toast.LENGTH_SHORT).show();
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
                        projectObjs = new ArrayList<>();
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

    @OnClick(R.id.Product_Frag_Call)
    public void onCall() {
        Intent contact = new Intent(Intent.ACTION_DIAL);
        contact.setData(Uri.parse("tel:01095488883"));
        startActivity(contact);
    }
    @OnClick(R.id.Product_Frag_Share)
    public void OnShare(){
        Intent share = new Intent();
        share.setAction(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=com.youssef.maggy.aqartest");
        share.setType("textDes/plain");
        startActivity(share);
    }
}
