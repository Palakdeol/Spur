package com.lenovo.spur;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class First_activity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);


        final Handler handler = new Handler();
        Toast.makeText(First_activity.this, "connecting", Toast.LENGTH_SHORT).show();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(First_activity.this , MainActivity.class);

                startActivity(i);    

                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);

                finish();





            }
        }, 2000 );


    }
}