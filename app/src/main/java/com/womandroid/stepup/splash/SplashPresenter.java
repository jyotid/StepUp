package com.womandroid.stepup.splash;


/**
 * Created by jyotidubey on 16/02/19.
 */

public class SplashPresenter {
  private SplashActivity view;

  public void onViewAttached(SplashActivity view) {
    this.view = view;
  }

  public void performUserLoginStatusCheck() {
    if (true) {//user is logged in
      view.showLoginScreen();
    } else {
      view.showHomeScreen();
    }
  }
}
