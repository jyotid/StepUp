package com.womandroid.stepup.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.womandroid.stepup.R;
import com.womandroid.stepup.categories.CategoriesActivity;

public class LoginActivity extends AppCompatActivity {

  private TextView username;
  private TextView password;
  private LoginPresenter presenter ;

  public static Intent getIntent(Context context){
    return new Intent(context, LoginActivity.class);
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    presenter  = new LoginPresenter(getApplicationContext());
    username = findViewById(R.id.username);
    password = findViewById(R.id.password);
    presenter.onViewAttached(this);

  }

  public void onLoginButtonClick(View view){
    if(username.getText().toString().equals("")){
      Toast.makeText(this, "Please enter the Username", Toast.LENGTH_SHORT).show();
    }else if (password.getText().toString().equals("")){
      Toast.makeText(this, "Please enter the Password", Toast.LENGTH_SHORT).show();

    }else{
      presenter.onLoginClicked(username.getText().toString(),password.getText().toString());


    }


  }

  public void onLoginSuccess() {
    startActivity(CategoriesActivity.getIntent(this));
    finish();
  }
}
