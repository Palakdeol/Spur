package com.lenovo.spur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivitySignup_Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup__next);
    }

    public void user_click(View view) {

        Intent i = new Intent(MainActivitySignup_Next.this,Signup.class);

        startActivity(i);
    }

    public void service_provider_click(View view) {

        Intent i = new Intent(MainActivitySignup_Next.this,Sp_Signup.class);

        startActivity(i);

    }
}
