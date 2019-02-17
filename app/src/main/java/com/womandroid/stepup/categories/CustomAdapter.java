package com.womandroid.stepup.categories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.womandroid.stepup.R;
import com.womandroid.stepup.data.CategoryListDataModel.CategoryDataModel;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<CategoryDataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.tv_category);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.iv_Category);
        }
    }

    public CustomAdapter(List<CategoryDataModel> data) {
        this.dataSet = data;
    }

    public void addData(List<CategoryDataModel> data){
        this.dataSet.clear();
        this.dataSet.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setOnClickListener(CategoriesActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).name);
       // imageView.setImageResource(dataSet.get(listPosition).id);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}