package aquar.aswany.myaquar_eg.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import aquar.aswany.myaquar_eg.R;


public class PanoramaView_activity extends AppCompatActivity {


    private VrPanoramaView vrPanoramaView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panorama_view);

        vrPanoramaView=findViewById(R.id.panorama);

        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.newphoto);
        vrPanoramaView.loadImageFromBitmap(icon, new VrPanoramaView.Options());
        vrPanoramaView.setInfoButtonEnabled(false);

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
