package com.womandroid.stepup;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.womandroid.stepup.data.DataModel;
import com.womandroid.stepup.data.DataModelDesc;

import java.util.ArrayList;

public class CustomAdapterDesc extends RecyclerView.Adapter<CustomAdapterDesc.MyViewHolder> {

    private ArrayList<DataModelDesc> dataSet;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewProfessionalTitle;
        ImageView imageView;
        TextView textViewLocation;
        TextView textViewCategories;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.tv_name);
            this.textViewProfessionalTitle = (TextView) itemView.findViewById(R.id.tv_professional_title);
            this.imageView = (ImageView) itemView.findViewById(R.id.iv_category_desc);
            this.textViewLocation = (TextView)itemView.findViewById(R.id.tv_location);
            this.textViewCategories = (TextView)itemView.findViewById(R.id.tv_category);
        }
    }

    public CustomAdapterDesc(ArrayList<DataModelDesc> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_description, parent, false);

        view.setOnClickListener(CategoryDescriptionActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewProfessionalTitle = holder.textViewProfessionalTitle;
        ImageView imageView = holder.imageView;
        TextView textViewLocation = holder.textViewLocation;
        TextView textViewCategories = holder.textViewCategories;

        Log.d("Name : ","adapter"+dataSet.get(listPosition).getProfessionalTitle()+" "+listPosition);
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewProfessionalTitle.setText(dataSet.get(listPosition).getProfessionalTitle());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
        textViewLocation.setText(dataSet.get(listPosition).getLocation());
        textViewCategories.setText(dataSet.get(listPosition).getCategories());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
