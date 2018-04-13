package com.lenovo.spur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity_Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__next);
    }

    public void user_click(View view) {

        Intent i = new Intent(MainActivity_Next.this, Login.class);

        startActivity(i);
    }

    public void service_provider_click(View view) {
        Intent i = new Intent(MainActivity_Next.this,Sp_Login.class);

        startActivity(i);
    }
}
