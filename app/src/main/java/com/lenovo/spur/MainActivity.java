package com.lenovo.spur;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewFlipper();

    }


    public void click_signup(View view) {

        Intent i = new Intent(MainActivity.this, MainActivitySignup_Next.class);

        startActivity(i);
    }



    public void ViewFlipper() {
        ViewFlipper viewflipper = findViewById(R.id.flipper);

        viewflipper.startFlipping();


    }

    public  void login_btn(View view)
    {
        Intent i = new Intent(MainActivity.this,MainActivity_Next.class);

        startActivity(i);
    }
}

