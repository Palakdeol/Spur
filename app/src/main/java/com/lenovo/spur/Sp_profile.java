package com.lenovo.spur;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.lenovo.spur.datamodels.Sp_Profile_Data;

public class Sp_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_profile);
    }



    public void save_profile(View view) {


        EditText name_et = findViewById(R.id.name_et);

        EditText shop_name_et = findViewById(R.id.shop_name_et);

        String name = name_et.getText().toString();

        String shop_name =  shop_name_et.getText().toString();

        Sp_Profile_Data data = new Sp_Profile_Data(name , shop_name);

        FirebaseDatabase database = FirebaseDatabase.getInstance();


        FirebaseAuth auth = FirebaseAuth.getInstance();

        String email =  auth.getCurrentUser().getEmail();

        database.getReference().child("shop").child(email.replace(".","")).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Intent i = new Intent(Sp_profile.this , Sp_home.class);

                startActivity(i);
            }
        });
    }
}
