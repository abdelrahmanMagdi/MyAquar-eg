package aquar.aswany.myaquar_eg.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import aquar.aswany.myaquar_eg.Models.SearchArrayTypes;
import aquar.aswany.myaquar_eg.Models.SearchLimts;
import aquar.aswany.myaquar_eg.Models.SearchLocationArray;
import aquar.aswany.myaquar_eg.Models.SearchLocationObject;
import aquar.aswany.myaquar_eg.Models.SearchObjectTypes;
import aquar.aswany.myaquar_eg.R;
import aquar.aswany.myaquar_eg.Utils.URLS;

public class Findhome extends AppCompatActivity  {


    private TextView priceMin , priceMax , areaMin , areaMax;
    private CrystalRangeSeekbar rangeSeekbar, rangeSeekbar2;
    private Spinner spinner_loacation, spinner_home_type;
    int max_area ,max_price ,min_price ,min_area  ;
    ArrayList<SearchObjectTypes> listTypes = new ArrayList<>();
    ArrayList<SearchLocationObject> listLocations = new ArrayList<>();
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findhome);
        dialog = new ProgressDialog(this);

        spinner_loacation = findViewById(R.id.spinner_location);
        spinner_home_type = findViewById(R.id.spinner_home_type);
         priceMin = findViewById(R.id.minprice);
       priceMax = findViewById(R.id.maxprice);
          areaMin = findViewById(R.id.minarea);
         areaMax = findViewById(R.id.maxarea);
        rangeSeekbar = findViewById(R.id.simpleSeekBar1);
        rangeSeekbar2 = findViewById(R.id.simpleSeekBar2);





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
        getTypes();
        getLocation();

    }






    private void getTypes() {
        dialog.show();
        AndroidNetworking.get(URLS.SearchLink)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dialog.dismiss();
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        SearchArrayTypes array = gson.fromJson(response.toString(), SearchArrayTypes.class);
                        listTypes = array.getTypes();

                        spinner_home_type.setAdapter(new MyCustomAdapter(Findhome.this,
                                R.layout.activity_main2, listTypes));
                    }
                    @Override
                    public void onError(ANError anError) {
                        dialog.dismiss();
                        Toast.makeText(Findhome.this, "Connection Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void getLimits() {

        AndroidNetworking.get(URLS.SearchLink)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        SearchLimts limet = gson.fromJson(response.toString(), SearchLimts.class);
                         max_area = limet.getMax_area();
                         max_price = limet.getMax_price();
                         min_area = limet.getMin_area();
                         min_price = limet.getMin_price();
                        priceMin.setText(String.valueOf(min_price));
                        priceMax.setText(String.valueOf(max_price));
                        areaMin.setText(String.valueOf(min_area));
                        areaMax.setText(String.valueOf(max_area));
                        rangeSeekbar.setMaxValue(max_price);
                        rangeSeekbar2.setMaxValue(max_area);
                        rangeSeekbar2.setMinValue(min_area);
                        rangeSeekbar.setMinValue(min_price);
                        rangeSeekbar.setSteps(((float) 0.5));
                        rangeSeekbar2.setSteps(1);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(Findhome.this, "Connection Failed", Toast.LENGTH_SHORT).show();


                    }
                });


    }

    private void getLocation() {

        AndroidNetworking.get(URLS.SearchLink)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        SearchLocationArray array = gson.fromJson(response.toString(), SearchLocationArray.class);
                        listLocations  = array.getLocations();

                        spinner_loacation.setAdapter(new MyCustomAdapter2(Findhome.this,
                                R.layout.activity_main2, listLocations));


                    }

                    @Override
                    public void onError(ANError anError) {

                        Toast.makeText(Findhome.this, "Connection Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }




    public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId, ArrayList objects) {
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
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.activity_main2, parent, false);
            TextView label = row.findViewById(R.id.city);
            label.setText(listTypes.get(position).getType_name());

            if (position == 0)
                label.setTextColor(Color.WHITE);

            return row;
        }
    }
    public class MyCustomAdapter2 extends ArrayAdapter<String> {

        public MyCustomAdapter2(Context context, int textViewResourceId, ArrayList objects) {
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
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.activity_main2, parent, false);
            TextView label = row.findViewById(R.id.city);
            label.setText(listLocations.get(position).getLocation());

            if (position == 0)
                label.setTextColor(Color.WHITE);

            return row;
        }
    }
}


