package com.womandroid.stepup.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jyotidubey on 17/02/19.
 */

public class UserStore {


  private static final String USER_STORE = "USER_STORE:";
  private static final String USER_AUTH_TOKEN = "USER_AUTH_TOKEN:";


  private UserStore() {}

  private static SharedPreferences getSharedPreferences(Context context) {
    return context.getSharedPreferences(USER_STORE, Context.MODE_PRIVATE);
  }

  public static String getUserAuthToken(Context context) {
    return getSharedPreferences(context).getString(USER_AUTH_TOKEN, null);
  }

  public static void setUserAuthToken(Context context, String newValue) {
    final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
    editor.putString(USER_AUTH_TOKEN, newValue);
    editor.commit();
  }

}
