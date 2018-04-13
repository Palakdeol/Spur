package com.lenovo.spur;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class user_home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home_page);




    }


    public void cab_booking(View view) {
    }

    public void healthcare(View view) {
    }

    public void Bill_payment(View view) {
    }

    public void chatting(View view) {
    }

    public void menu_icon(View view) {

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        drawerLayout.openDrawer(Gravity.LEFT);
    }

    public void edit_profile(View view) {
    }

    public void view_order_history(View view) {
    }

    public void feedback(View view) {
    }

    public void log_out(View view) {
    }
}
