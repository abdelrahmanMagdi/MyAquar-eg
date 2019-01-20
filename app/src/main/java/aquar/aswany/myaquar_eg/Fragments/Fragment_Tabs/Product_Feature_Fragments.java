package aquar.aswany.myaquar_eg.Fragments.Fragment_Tabs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aquar.aswany.myaquar_eg.R;
import butterknife.ButterKnife;

/**
 * Created by aswany on 1/20/19.
 */

public class Product_Feature_Fragments extends Fragment {
    private Dialog dialog;
    private final String TAG = "Product_Feature_Fragments";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(getActivity());

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.project_item,container,false);
        ButterKnife.bind(this, view);
        return view;
    }
}
