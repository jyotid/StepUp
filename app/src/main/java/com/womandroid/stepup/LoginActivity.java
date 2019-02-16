package com.womandroid.stepup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.womandroid.stepup.categories.CategoryActivity;

import com.womandroid.stepup.categories.CategoryActivity;

public class LoginActivity extends AppCompatActivity {

  public static Intent getIntent(Context context){
    return new Intent(context, LoginActivity.class);
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    Intent intent = new Intent(LoginActivity.this,CategoryActivity.class);
    startActivity(intent);
  }
}
