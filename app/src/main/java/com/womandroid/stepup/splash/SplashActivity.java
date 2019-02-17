package com.womandroid.stepup.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.womandroid.stepup.categories.CategoriesActivity;
import com.womandroid.stepup.login.LoginActivity;
import com.womandroid.stepup.R;

/**
 * Created by jyotidubey on 16/02/19.
 */

public class SplashActivity extends AppCompatActivity {

  SplashPresenter presenter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    presenter = new SplashPresenter(this);
    presenter.onViewAttached(this);
    presenter.performUserLoginStatusCheck();

  }

  public void showLoginScreen(){
      startActivity(LoginActivity.getIntent(this));
  }

  public void showHomeScreen(){
    startActivity(CategoriesActivity.getIntent(this));
  }
}
