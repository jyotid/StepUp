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
import com.womandroid.stepup.data.DataModelDesc;
import com.womandroid.stepup.data.MyData;

import com.womandroid.stepup.profile.ProfileDescriptionActivity;
import java.util.ArrayList;

public class CategoryBasedPeopleListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<DataModelDesc> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    boolean isFABOpen = false;
    FloatingActionButton fab1, fab2;

    public static Intent getIntent(Context context){
        return new Intent(context, com.womandroid.stepup.categories.CategoryBasedPeopleListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_description);
        myOnClickListener = new MyOnClickListener(CategoryBasedPeopleListActivity.this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(CategoryBasedPeopleListActivity.this, resId);
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

        adapter = new CustomAdapterDesc(this,data);
        recyclerView.setAdapter(adapter);
    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(CategoryBasedPeopleListActivity.this, ProfileDescriptionActivity.class);
            startActivity(intent);
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