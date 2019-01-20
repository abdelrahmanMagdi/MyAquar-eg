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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Activity.Product_Activity;
import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_Home_Obj;
import aquar.aswany.myaquar_eg.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aswany on 1/15/19.
 */

public class Home_Dev_Adapter extends RecyclerView.Adapter<Home_Dev_Adapter.Package_RV> {
    private ArrayList<Pojo_Home_Obj> home_objs;
    private Context context;
//    private String IdPackage;

    public Home_Dev_Adapter(Context context, ArrayList<Pojo_Home_Obj> home_objs) {
        this.home_objs = home_objs;
        this.context = context;

    }

    @Override
    public Package_RV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).
               inflate(R.layout.home_item,parent,false);
        ButterKnife.bind(context.getApplicationContext(),view);

        return new Package_RV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Package_RV holder, final int position) {
        holder.Text_Of_AllProjects.setText(home_objs.get(position).getProjectName());
        holder.Text_Of_Location.setText(home_objs.get(position).getLocation());
        holder.Text_Of_Developer.setText(home_objs.get(position).getDeveloperName());
        Glide.with(context).load(home_objs.get(position).getProjectImg()).
                into(holder.Image_Of_Developer);
        Log.d("Home_adapter",home_objs.get(position).getProductId()+"");

    }

    @Override
    public int getItemCount() {
        return home_objs.size();
    }

    class Package_RV extends RecyclerView.ViewHolder {
        @BindView(R.id.LinearLayout_Of_AllDeveloper)
        RelativeLayout LinearLayout_Of_Developer;
        @BindView(R.id.Image_Of_AllDeveloper)
        ImageView Image_Of_Developer;
        @BindView(R.id.Text_Of_AllDeveloper)
        TextView Text_Of_Developer;
        @BindView(R.id.Text_Of_AllProjects)
        TextView Text_Of_AllProjects;
        @BindView(R.id.Text_Of_AllLocation)
        TextView Text_Of_Location;
        Package_RV(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        @OnClick(R.id.LinearLayout_Of_AllDeveloper)
       public void omClick(){
            Session.getInstance().setProductID((int) home_objs.get(getAdapterPosition()).getProductId());
            Toast.makeText(context,"Pos: "+home_objs.get(getAdapterPosition()).getProductId(),Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context.getApplicationContext(),Product_Activity.class));
        }
    }
}
