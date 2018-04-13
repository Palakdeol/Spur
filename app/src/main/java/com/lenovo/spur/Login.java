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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void login_btn(View view) {

        EditText email_address = findViewById(R.id.login_email);

        EditText password = findViewById(R.id.login_password);

        String email = email_address.getText().toString();

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

        } else {
            Toast.makeText(Login.this, "invalid email", Toast.LENGTH_SHORT).show();
            return;
        }

        String password_ = password.getText().toString();

        if (password_.length() >= 8 && password_.length() <=33)
        {

        }
        else {
            Toast.makeText(Login.this,"incorrect password", Toast.LENGTH_SHORT).show();

            return;
        }

        final ProgressDialog progress_bar = new ProgressDialog(Login.this);

        progress_bar.setTitle("please wait");

        progress_bar.setMessage("Loading");

        progress_bar.show();

        FirebaseAuth f_auth = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progress_bar.hide();


                if (task.isSuccessful()) {

                    Toast.makeText(Login.this, "done", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, user_home_page.class);

                    startActivity(i);

                    finish();
                } else {
                    Toast.makeText(Login.this, "error try again", Toast.LENGTH_SHORT).show();
                }
            }
        };

        f_auth.signInWithEmailAndPassword(email, password_).addOnCompleteListener(listener);



    }
}

