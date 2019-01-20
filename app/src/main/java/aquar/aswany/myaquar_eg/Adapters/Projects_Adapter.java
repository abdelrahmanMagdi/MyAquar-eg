package aquar.aswany.myaquar_eg.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.InternalStorage.Session;
import aquar.aswany.myaquar_eg.Models.Pojo_Projects_Obj;
import aquar.aswany.myaquar_eg.R;

/**
 * Created by aswany on 1/15/19.
 */

public class Projects_Adapter extends RecyclerView.Adapter<Projects_Adapter.Projects_RV> {
    private ArrayList<Pojo_Projects_Obj> projects_objs;
    private Context context;

    public Projects_Adapter(ArrayList<Pojo_Projects_Obj> projects_objs, Context context) {
        this.projects_objs = projects_objs;
        this.context = context;
    }

    @NonNull
    @Override
    public Projects_Adapter.Projects_RV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).
                inflate(R.layout.project_item, parent, false);
        return new Projects_RV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Projects_Adapter.Projects_RV holder, final int position) {
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "projectPos: " + (projects_objs.get(position).getId()), Toast.LENGTH_SHORT).show();
//                Session.getInstance().setCategoryObjs(projects_objs.get(position).getCategories());
//                context.startActivity(new Intent(context, Category_Activity.class));
            }
        });
        holder.textView.setText(projects_objs.get(position).getName());
        Glide.with(context).load(projects_objs.get(position).getImg()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return projects_objs.size();
    }

    class Projects_RV extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;

        Projects_RV(View view) {
            super(view);
//            ButterKnife.bind(view.get)
            linearLayout = view.findViewById(R.id.LinearLayout_Of_Developer);
            textView = view.findViewById(R.id.Text_Of_Developer);
            imageView = view.findViewById(R.id.Image_Of_Developer);
        }
    }
}
