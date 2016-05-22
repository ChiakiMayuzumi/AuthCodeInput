package com.example.chiakimayuzumi.codeinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class DemoActivity extends AppCompatActivity {

  Toolbar mToolbar;
  AuthCodeInput mAuthCodeInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mAuthCodeInput = (AuthCodeInput)findViewById(R.id.authcodeinput);

    setSupportActionBar(mToolbar);
    getSupportActionBar().setTitle("");

    init();

  }

  private void init() {
    mAuthCodeInput.setOnCompletionListener(new AuthCodeInput.OnCompletionListener() {
      @Override
      public void onCompleted(String text) {
        Toast.makeText(DemoActivity.this, "输入的是" + text, Toast.LENGTH_SHORT).show();
      }
    });
  }

}
