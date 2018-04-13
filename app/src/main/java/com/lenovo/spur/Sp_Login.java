package com.lenovo.spur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sp_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp__login);
    }

    public void login_btn(View view) {

        Intent i = new Intent (Sp_Login.this,Sp_profile.class);


        startActivity(i);
    }
}
