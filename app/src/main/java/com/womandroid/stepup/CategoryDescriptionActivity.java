package com.womandroid.stepup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_description);
        myOnClickListener = new MyOnClickListener(CategoryDescriptionActivity.this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
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