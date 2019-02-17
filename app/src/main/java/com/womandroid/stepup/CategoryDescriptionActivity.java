package com.womandroid.stepup;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.womandroid.stepup.data.DataModel;
import com.womandroid.stepup.data.DataModelDesc;
import com.womandroid.stepup.data.MyData;

import java.util.ArrayList;

public class CategoryDescriptionActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<DataModelDesc> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    boolean isFABOpen = false;
    FloatingActionButton fab1, fab2;
    FrameLayout frame1, frame2, frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_description);
        myOnClickListener = new MyOnClickListener(CategoryDescriptionActivity.this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(CategoryDescriptionActivity.this, resId);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModelDesc>();
        for (int i = 0; i < MyData.profileName.length; i++) {
            data.add(new DataModelDesc(
                    MyData.profileName[i],
                    MyData.profile[i],
                    MyData.profession[i],
                    MyData.location[i],
                    MyData.categories[i]
            ));
        }

        adapter = new CustomAdapterDesc(data);
        recyclerView.setAdapter(adapter);

         frame1 = (FrameLayout)findViewById(R.id.frame1);
         frame2 = (FrameLayout)findViewById(R.id.frame2);
         frame = (FrameLayout)findViewById(R.id.frame);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            }
        });
    }

    private void showFABMenu(){
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

}