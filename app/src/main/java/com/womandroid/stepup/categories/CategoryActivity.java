package com.womandroid.stepup.categories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.womandroid.stepup.data.CategoryListDataModel;
import com.womandroid.stepup.R;
import com.womandroid.stepup.data.CategoryListDataModel.CategoryDataModel;
import com.womandroid.stepup.data.MyData;
import com.womandroid.stepup.profile.ProfileDescriptionActivity;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private GridLayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private CustomAdapter adapter = new CustomAdapter(new ArrayList<CategoryDataModel>());
    static View.OnClickListener myOnClickListener;
    private CategoryPresenter presenter = new CategoryPresenter();

    public static Intent getIntent(Context context){
        return new Intent(context, CategoryActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        presenter.onViewAttached(this);
        presenter.getCategoryData();

        myOnClickListener = new MyOnClickListener(CategoryActivity.this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void onCategoryDataReceived(List<CategoryDataModel> categoryListDataModel){
        adapter.addData(categoryListDataModel);
    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
             context.startActivity(ProfileDescriptionActivity.getIntent(context));
        }

    }

}