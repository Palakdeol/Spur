package com.lenovo.spur;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sp_Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp__signup);
    }

    public void submit_sp(View view) {


        EditText email_ = findViewById(R.id.email_txt);

        EditText password_ = findViewById(R.id.password_txt);

        EditText confirmpassword_ = findViewById(R.id.confirm_password_txt);

        String email = email_.getText().toString();

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        } else {
            Toast.makeText(Sp_Signup.this, "invalid email", Toast.LENGTH_SHORT).show();
            return;
        }


        String password = password_.getText().toString();

        if (password.length() >= 8 && password.length() < 33) {
        } else {
            Toast.makeText(Sp_Signup.this, "password length must be between 8 and 32", Toast.LENGTH_SHORT).show();

            return;
        }

        String Confirmpassword = confirmpassword_.getText().toString();


        if (password.equals(Confirmpassword)) {

        } else {
            Toast.makeText(Sp_Signup.this, "confirm password do not match", Toast.LENGTH_SHORT).show();

            return;
        }


        final ProgressDialog progress_bar = new ProgressDialog(Sp_Signup.this);

        progress_bar.setTitle("please wait");

        progress_bar.setMessage("Loading");

        progress_bar.show();


        FirebaseAuth f_auth = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progress_bar.hide();


                if (task.isSuccessful()) {

                    Toast.makeText(Sp_Signup.this, "done", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Sp_Signup.this, Sp_profile.class);

                    startActivity(i);

                    finish();
                } else {
                    Toast.makeText(Sp_Signup.this, "error try again", Toast.LENGTH_SHORT).show();
                }
            }
        };

        f_auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(listener);


    }
}


