package com.lenovo.spur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User_profile extends AppCompatActivity {






    EditText first_name;


    RadioGroup gender_radio_group ;

    EditText last_name;

    EditText address;

    TextView blood_group;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        first_name = findViewById(R.id.first_name);

        gender_radio_group = findViewById(R.id.gender_radio_group);

        last_name = findViewById(R.id.Last_name);

        address = findViewById(R.id.Address);

        blood_group = findViewById(R.id.blood_group);


        Spinner spinner_bg = (Spinner) findViewById(R.id.bg_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> bg_adapter = ArrayAdapter.createFromResource(this, R.array.blood_group, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        bg_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_bg.setAdapter(bg_adapter);


        Spinner spinner_category = (Spinner) findViewById(R.id.category_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> category_adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        category_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_category.setAdapter(category_adapter);






    }

    public void next_btn(View view) {


        RadioButton checked_btn = findViewById(gender_radio_group.getCheckedRadioButtonId());

        String gender = checked_btn.getText().toString();

        String first_name_s = first_name.getText().toString();
        String last_name_s = last_name.getText().toString();
        String address_s = address.getText().toString();
        String blood_group_s = blood_group.getText().toString();


        User_data data = new User_data(first_name_s ,last_name_s,address_s,blood_group_s,gender);


        FirebaseDatabase database = FirebaseDatabase.getInstance();


        database.getReference().child("user").child("xyz@gmailcom").setValue(data);
    }

    public void read_user_data()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                User_data recieved_data = dataSnapshot.getValue(User_data.class);

                System.out.println(recieved_data.first_name );
                System.out.println(recieved_data.last_name);
                System.out.println( recieved_data.address );
                System.out.println( recieved_data.gender );
                System.out.println( recieved_data.blood_group);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        database.getReference().child("user").child("xyz@gmailcom").addValueEventListener(valueEventListener);


    }
}
