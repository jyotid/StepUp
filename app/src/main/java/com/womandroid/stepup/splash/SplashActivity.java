package com.womandroid.stepup.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.womandroid.stepup.CategoryActivity;
import com.womandroid.stepup.LoginActivity;
import com.womandroid.stepup.MainActivity;
import com.womandroid.stepup.R;

/**
 * Created by jyotidubey on 16/02/19.
 */

public class SplashActivity extends AppCompatActivity {

  SplashPresenter presenter = new SplashPresenter();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    presenter.onViewAttached(this);
    presenter.performUserLoginStatusCheck();

  }

  public void showLoginScreen(){
      startActivity(LoginActivity.getIntent(this));
  }

  public void showHomeScreen(){
    startActivity(CategoryActivity.getIntent(this));
  }
}
