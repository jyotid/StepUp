package com.womandroid.stepup.categories;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;
import com.womandroid.stepup.R;
import com.womandroid.stepup.data.CoursesDataModel;
import com.womandroid.stepup.data.DataModelDesc;
import com.womandroid.stepup.data.MyData;

import com.womandroid.stepup.data.PeopleListDataModel;

import com.womandroid.stepup.onAdapterClickListener;
import com.womandroid.stepup.profile.ProfileDescriptionActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class CategoryBasedPeopleListActivity extends AppCompatActivity implements onAdapterClickListener {

    private CustomAdapterDesc adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<DataModelDesc> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    boolean isFABOpen = false;
    FloatingActionButton fab1, fab2;
    private CategoryBasePeopleListPresenter presenter;


    public static Intent getIntent(Context context){
        return new Intent(context, com.womandroid.stepup.categories.CategoryBasedPeopleListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_description);
        myOnClickListener = new MyOnClickListener(CategoryBasedPeopleListActivity.this);
        presenter = new CategoryBasePeopleListPresenter();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new CustomAdapterDesc(this,this);
        recyclerView.setAdapter(adapter);



        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(CategoryBasedPeopleListActivity.this, resId);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        presenter.onViewAttached(this);

        presenter.getData();

    }

    public void getMentorList(@Nullable ArrayList<PeopleListDataModel> mentorList) {
        adapter.updateList(mentorList);
    }

    @Override
    public void onAdapterClick(@NotNull Object data) {
        PeopleListDataModel peopleListDataModel = (PeopleListDataModel) data;
        Intent intent = new Intent(CategoryBasedPeopleListActivity.this, ProfileDescriptionActivity.class);
        intent.putExtra("person",peopleListDataModel);
        startActivity(intent);
    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

        }

    }

    /*private void showFABMenu(){
        isFABOpen=true;
        frame2.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        frame1.animate().translationY(-getResources().getDimension(R.dimen.standard_105));

        frame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Clicked","frame1");
            }
        });
    }

    private void closeFABMenu(){
        isFABOpen=false;
        frame2.animate().translationY(0);
        frame1.animate().translationY(0);
    }*/


}