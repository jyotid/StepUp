package com.womandroid.stepup.categories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.womandroid.stepup.LoginActivity;
import com.womandroid.stepup.R;

public class CategoryBasedPeopleListActivity extends AppCompatActivity {

    public static Intent getIntent(Context context){
        return new Intent(context, CategoryBasedPeopleListActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_description);
    }
}
