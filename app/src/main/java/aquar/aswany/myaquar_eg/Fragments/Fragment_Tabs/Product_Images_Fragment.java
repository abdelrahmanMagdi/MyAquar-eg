package aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aswany on 1/20/19.
 */

public class Product_Images_Fragment extends Fragment {
    private Dialog dialog;
    private final String TAG = "Product_Images_Fragment";
    @BindView(R.id.Vr_View)
    VrPanoramaView vrPanoramaView;
    String viewer360;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(getActivity());
        try {
            viewer360 = Session.getInstance().getProducts().get(0).getViewer360();
        }catch (Exception e){e.printStackTrace();}
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_vr,container,false);
        ButterKnife.bind(this, view);
        Bitmap icon = BitmapFactory.decodeResource(getResources(),(R.drawable.newphoto));
//        Bitmap icon = BitmapFactory.decodeFile(viewer360);
        vrPanoramaView.loadImageFromBitmap(icon, new VrPanoramaView.Options());
        vrPanoramaView.setInfoButtonEnabled(false);
        return view;
    }
}
