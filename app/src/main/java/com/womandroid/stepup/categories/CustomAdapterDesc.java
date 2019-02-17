package com.womandroid.stepup.categories;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.womandroid.stepup.R;
import com.womandroid.stepup.data.DataModelDesc;
import com.womandroid.stepup.data.PeopleListDataModel;
import com.womandroid.stepup.onAdapterClickListener;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterDesc extends RecyclerView.Adapter<CustomAdapterDesc.MyViewHolder> {

    private List<PeopleListDataModel> dataSet = new ArrayList<>();
    private Context context;
    private onAdapterClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewProfessionalTitle;
        ImageView imageView;
        TextView textViewLocation;
        TextView textViewCategories, tvMentorDetails;
        LinearLayout viewMentorDetails,viewPerson;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.tv_name);
            this.textViewProfessionalTitle = (TextView) itemView.findViewById(R.id.tv_professional_title);
            this.imageView = (ImageView) itemView.findViewById(R.id.iv_category_desc);
            this.textViewLocation = (TextView) itemView.findViewById(R.id.tv_location);
            this.textViewCategories = (TextView) itemView.findViewById(R.id.tv_category);
            this.viewMentorDetails = itemView.findViewById(R.id.viewMentorDetails);
            this.tvMentorDetails = itemView.findViewById(R.id.tvMentorDetails);
            this.viewPerson = itemView.findViewById(R.id.viewPerson);
        }
    }

    public CustomAdapterDesc(Context context, onAdapterClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_description, parent, false);

        view.setOnClickListener(CategoryBasedPeopleListActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    public void updateList(List<PeopleListDataModel> dataSet) {
        this.dataSet.clear();
        this.dataSet.addAll(dataSet);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewProfessionalTitle = holder.textViewProfessionalTitle;
        ImageView imageView = holder.imageView;
        TextView textViewLocation = holder.textViewLocation;
        TextView textViewCategories = holder.textViewCategories;
        LinearLayout viewMentorDetails = holder.viewMentorDetails;
        LinearLayout viewPerson = holder.viewPerson;
        TextView tvMentorDetails = holder.tvMentorDetails;

        Log.d("Name : ", "adapter" + dataSet.get(listPosition).getProfessionalTitle() + " " + listPosition);
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewProfessionalTitle.setText(dataSet.get(listPosition).getProfessionalTitle());

//        Glide.with(context).load(dataSet.get(listPosition).getImageUrl())
//                .thumbnail(0.5f)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imageView);
        textViewLocation.setText(dataSet.get(listPosition).getLocation());

        viewMentorDetails.setBackgroundResource(R.color.colorPrimaryLight);
        textViewName.setTextColor(ContextCompat.getColor(context, R.color.white));
        textViewLocation.setTextColor(ContextCompat.getColor(context, R.color.white));
        textViewCategories.setTextColor(ContextCompat.getColor(context, R.color.white));
        textViewProfessionalTitle.setTextColor(ContextCompat.getColor(context, R.color.white));
        tvMentorDetails.setText(dataSet.get(listPosition).getDescription());
        viewPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAdapterClick(dataSet.get(listPosition));
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
