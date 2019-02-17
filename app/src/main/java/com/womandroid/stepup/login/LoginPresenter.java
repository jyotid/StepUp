package com.womandroid.stepup.login;

import android.content.Context;
import com.womandroid.stepup.preference.UserStore;

/**
 * Created by jyotidubey on 17/02/19.
 */

public class LoginPresenter {
  private LoginActivity view;
  private final Context context;
  LoginPresenter(Context context){
     this.context = context;
  }

  public void onViewAttached( LoginActivity view){
    this.view = view;
  }
  public void onLoginClicked(String username, String password){
    UserStore.setUserAuthToken(context, username+password);
    view.onLoginSuccess();
  }
}
