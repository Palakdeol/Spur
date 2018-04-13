package com.lenovo.spur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lenovo.spur.datamodels.Sp_Category_Data;

import java.util.ArrayList;

public class Sp_home extends AppCompatActivity {

    ArrayList<Sp_Category_Data> category_list ;

    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_home);

        category_list = new ArrayList<>();

        recyclerView = findViewById(R.id.category_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(Sp_home.this , LinearLayoutManager.VERTICAL, false));

    }

    public void add_new_category(View view) {


        Intent i = new Intent(Sp_home.this , Sp_Add_Category.class);

        startActivity(i);
    }

public void get_category()
{
    FirebaseAuth firebase = FirebaseAuth.getInstance();
    String email=firebase.getCurrentUser().getEmail();
    FirebaseDatabase data =FirebaseDatabase.getInstance();
    data.getReference().child("category").child(email.replace(".","")).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot data : dataSnapshot.getChildren())
            {
                Sp_Category_Data category_data = data.getValue(Sp_Category_Data.class);

                category_list.add(category_data);

                Adapter adapter = new Adapter();

                recyclerView.setAdapter(adapter);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}


    @Override
    protected void onResume() {
        super.onResume();

        get_category();
    }

    public class view_holder extends RecyclerView.ViewHolder{

        TextView category_name ;

        public view_holder(View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name_id);
        }
    }

    public class Adapter extends RecyclerView.Adapter<view_holder>
    {

        @Override
        public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

            view_holder v = new view_holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_cell,parent , false ));

            return v ;
        }

        @Override
        public void onBindViewHolder(view_holder holder, int position) {

            Sp_Category_Data data = category_list.get(position);

            holder.category_name.setText(data.category);
        }

        @Override
        public int getItemCount() {
            return category_list.size();
        }
    }
}
