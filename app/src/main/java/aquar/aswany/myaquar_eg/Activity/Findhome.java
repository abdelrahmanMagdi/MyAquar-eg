package aquar.aswany.myaquar_eg.Activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_Developer_Category_Res;
import aquar.aswany.myaquar_eg.Models.Pojo_Project_Res;
import aquar.aswany.myaquar_eg.Models.SearchArray;
import aquar.aswany.myaquar_eg.Models.SearchLimts;
import aquar.aswany.myaquar_eg.Models.SearchObject;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;

public class Findhome extends AppCompatActivity {


    private TextView textView,textView2,all,villa,flat,chalet,twin,doblex,twon_house,penta,stand;
    private CrystalRangeSeekbar rangeSeekbar,rangeSeekbar2;
    private List<TextView> text_list;
    private String ret_string;
    private Spinner spinner;
    String item []= new String[] {"Select City","new Cairo","new Cairo","new Cairo","new Cairo"};

    ArrayList<SearchObject>listTypes = new ArrayList<>();
    ArrayList<SearchObject>listLimts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findhome);

        spinner =findViewById(R.id.spinner);

        spinner.setAdapter(new MyCustomAdapter(Findhome.this, R.layout.activity_main2,item));

        all=findViewById(R.id.all);
        villa=findViewById(R.id.villa);
        flat=findViewById(R.id.flat);
        chalet=findViewById(R.id.chalet);
        twin=findViewById(R.id.twinhome);
        doblex=findViewById(R.id.duplex);
        twon_house=findViewById(R.id.toenhouse);
        penta=findViewById(R.id.penta);
        stand=findViewById(R.id.standalone);

        final TextView priceMin =  findViewById(R.id.minprice);
        final  TextView priceMax = findViewById(R.id.maxprice);
        final TextView areaMin =  findViewById(R.id.minarea);
        final  TextView areaMax = findViewById(R.id.maxarea);
        rangeSeekbar=findViewById(R.id.simpleSeekBar1);
        rangeSeekbar2=findViewById(R.id.simpleSeekBar2);
        text_list= Arrays.asList(new TextView[]{all, villa});
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                priceMin.setText(String.valueOf(minValue));
                priceMax.setText(String.valueOf(maxValue));
            }
        });

        rangeSeekbar2.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                areaMin.setText(String.valueOf(minValue));
                areaMax.setText(String.valueOf(maxValue));
            }
        });
        getLimits();
        GetHome_Categories_Data();


    }

    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View row, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            row=inflater.inflate(R.layout.activity_main2, parent, false);
            TextView label=row.findViewById(R.id.city);
            label.setText(item[position]);

            if(position == 0)
                label.setTextColor(Color.WHITE);

            return row;
        }
    }
    public void all(List<TextView>t,int x)
    {
        if (x==1){

            for(int i=2;i<t.size();i++)
            {
                t.get(i).setTextColor(Color.RED);
            }
        }

        else
            for(int i=0;i<t.size();i++){

                if(x==i){
                    t.get(i).setTextColor(Color.RED);

                }

            }
    }


    private void GetHome_Categories_Data() {

        AndroidNetworking.get(URLS.SearchLink)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        SearchArray array = gson.fromJson(response.toString(), SearchArray.class);
                        listTypes = array.getTypes();

                        Toast.makeText(Findhome.this, listTypes.get(0).getType_name() + "", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(ANError anError) {

                        if (anError.getErrorCode() != 0) {

                            if (anError.getErrorCode() == 500) {

                            }

                        } else {
                        }

                    }
                });
    }
        private void getLimits(){

            AndroidNetworking.get(URLS.SearchLink)
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            SearchLimts limet = gson.fromJson(response.toString(), SearchLimts.class);
                          int x = limet.getMax_area();

                            Toast.makeText(Findhome.this, x + "ashfhi", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(ANError anError) {

                            if (anError.getErrorCode() != 0) {

                                if (anError.getErrorCode() == 500) {

                                }

                            } else {
                            }

                        }
                    });

    }
}
