package com.lenovo.spur;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.lenovo.spur.datamodels.Sp_Category_Data;

public class Sp_Add_Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp__add__category);
    }

    public void save_category(View view) {

        EditText category_name_et = findViewById(R.id.category_name);

        String category = category_name_et.getText().toString();

        Sp_Category_Data data = new Sp_Category_Data(category);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        String email = auth.getCurrentUser().getEmail();

        database.getReference().child("category").child(email.replace(".","")).child(category).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                finish();
            }
        });


    }
}
