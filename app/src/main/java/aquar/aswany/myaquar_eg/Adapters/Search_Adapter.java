package aquar.aswany.myaquar_eg.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Models.Pojo_Projects_Obj;
import aquar.aswany.myaquar_eg.Models.Pojo_S_Budget_Obj;
import aquar.aswany.myaquar_eg.R;

/**
 * Created by aswany on 1/15/19.
 */

public class Search_Adapter extends RecyclerView.Adapter<Search_Adapter.Projects_RV> {
    private ArrayList<Pojo_S_Budget_Obj> projects_objs;
    private Context context;
    private final String TAG = "Search_Adapter";

    public Search_Adapter(ArrayList<Pojo_S_Budget_Obj> projects_objs, Context context) {
        this.projects_objs = projects_objs;
        this.context = context;
    }

    @NonNull
    @Override
    public Search_Adapter.Projects_RV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).
                inflate(R.layout.project_item, parent, false);
        return new Projects_RV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Search_Adapter.Projects_RV holder, final int position) {
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "" + projects_objs.get(position).getId());
//                Session.getInstance().setCategoryObjs(projects_objs.get(position).getCategories());
//                context.startActivity(new Intent(context, Category_Activity.class));
            }
        });
        holder.textView.setText(projects_objs.get(position).getName());
        Glide.with(context).load(projects_objs.get(position).getImg()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        try {
            return projects_objs.size();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "No Data Available", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    class Projects_RV extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;

        Projects_RV(View view) {
            super(view);
            linearLayout = view.findViewById(R.id.LinearLayout_Of_Developer);
            textView = view.findViewById(R.id.Text_Of_Developer);
            imageView = view.findViewById(R.id.Image_Of_Developer);
        }
    }
}
