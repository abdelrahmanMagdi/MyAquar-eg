package aquar.aswany.myaquar_eg.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

import aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs.Product_Feature_Fragments;
import aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs.Product_Images_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs.Product_info_Fragment;
import aquar.aswany.myaquar_eg.Fragments.Fragment_Adapter.SectionPagerAdapter;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Obj;
import aquar.aswany.myaquar_eg.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Product_Activity extends AppCompatActivity {

    private final String TAG = "Product_Activity";
    @BindView(R.id.Product_Slider)
    SliderLayout Product_Slider;
    private SectionPagerAdapter sectionPagerAdapter;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    //    int Product_ID;
    private ArrayList<Pojo_Project_Obj> projectObjs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Deceleration();
    }

    private void Deceleration() {
        ButterKnife.bind(this);

        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        sectionPagerAdapter.AddFragment(new Product_info_Fragment(), "Info");
        sectionPagerAdapter.AddFragment(new Product_Images_Fragment(), "VR");
        sectionPagerAdapter.AddFragment(new Product_Feature_Fragments(), "Features");

        viewPager.setAdapter(sectionPagerAdapter);
        tabs.setupWithViewPager(viewPager);
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


}
