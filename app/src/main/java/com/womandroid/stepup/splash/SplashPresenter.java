package com.womandroid.stepup.splash;


import android.content.Context;
import com.womandroid.stepup.preference.UserStore;

/**
 * Created by jyotidubey on 16/02/19.
 */

public class SplashPresenter {
  private SplashActivity view;
  private final Context context;

  public SplashPresenter(Context context) {
    this.context = context;
  }

  public void onViewAttached(SplashActivity view) {
    this.view = view;
  }

  public void performUserLoginStatusCheck() {
    if (UserStore.getUserAuthToken(context)!=null) {//user is logged in
      view.showHomeScreen();
    } else {
      view.showLoginScreen();
    }
  }
}
