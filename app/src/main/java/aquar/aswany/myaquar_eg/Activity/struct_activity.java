package aquar.aswany.myaquar_eg.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ortiz.touchview.TouchImageView;

import aquar.aswany.myaquar_eg.R;


public class struct_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struct);

        TouchImageView img =  findViewById(R.id.img);
        img.setMaxZoom(3);
        img.setMinZoom(1);

    }





}