package aquar.aswany.myaquar_eg.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Activity.Product_Activity;
import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_Developer_Category_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_Home_Obj;
import aquar.aswany.myaquar_eg.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aswany on 1/19/19.
 */

public class Developer_Category_Adapter extends RecyclerView.Adapter<Developer_Category_Adapter.Dev_Cat> {
    private ArrayList<Pojo_Developer_Category_Obj> developerCategoryObj;
    private Context context;
//    private ArrayList<Pojo_Home_Obj>homeObjs;
    private final String TAG="Developer_Cat_Adapter";

    public Developer_Category_Adapter(ArrayList<Pojo_Developer_Category_Obj> developerCategoryObj, Context context) {
        this.developerCategoryObj = developerCategoryObj;
        this.context = context;
    }

    @NonNull
    @Override
    public Dev_Cat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context.getApplicationContext())
               .inflate( R.layout.home_item,parent,false);
        ButterKnife.bind(context.getApplicationContext(),view);
        return new Dev_Cat(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Dev_Cat holder, final int position) {
        holder.Text_Of_AllProjects.setText(developerCategoryObj.get(position).getProjectName());
        holder.Text_Of_Location.setText(developerCategoryObj.get(position).getLocation());
        holder.Text_Of_AllDeveloper.setText(developerCategoryObj.get(position).getDeveloperName());
        Glide.with(context).load(developerCategoryObj.get(position).getProjectImg()).
                into(holder.Image_Of_AllDeveloper);

    }


    @Override
    public int getItemCount() {
        try {
            return developerCategoryObj.size();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context,"No Data Available",Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    class Dev_Cat extends RecyclerView.ViewHolder {
        @BindView(R.id.LinearLayout_Of_AllDeveloper)
        RelativeLayout LinearLayout_Of_AllDeveloper;
        @BindView(R.id.Image_Of_AllDeveloper)
        ImageView Image_Of_AllDeveloper;
        @BindView(R.id.Text_Of_AllDeveloper)
        TextView Text_Of_AllDeveloper;
        @BindView(R.id.Text_Of_AllProjects)
        TextView Text_Of_AllProjects;
        @BindView(R.id.Text_Of_AllLocation)
        TextView Text_Of_Location;

        Dev_Cat(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        @OnClick(R.id.LinearLayout_Of_AllDeveloper)
        public void onClick(){
            Session.getInstance().setProductID(developerCategoryObj.get(getAdapterPosition()).getProductId());
//            Toast.makeText(context,"Pos: "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
            Log.d(TAG,"Pos: "+getAdapterPosition());
            context.startActivity(new Intent(context.getApplicationContext(), Product_Activity.class));
        }


    }
}
