package aquar.aswany.myaquar_eg.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aquar.aswany.myaquar_eg.Models.Example_real_state;
import aquar.aswany.myaquar_eg.R;

public class Exampel_adapter_Real_stat extends RecyclerView.Adapter <Exampel_adapter_Real_stat.ExampleViewHolder>{

    private ArrayList<Example_real_state> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {


public ImageView imageView_Real_stat;
        public ExampleViewHolder(View itemView) {
            super(itemView);
imageView_Real_stat =itemView.findViewById(R.id.image_real_stat_id);

        }
    }

    public Exampel_adapter_Real_stat(ArrayList<Example_real_state> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampl_item_real_stat, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Example_real_state currentItem = mExampleList.get(position);

        holder.imageView_Real_stat.setImageResource(currentItem.getImage_real_stat());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
