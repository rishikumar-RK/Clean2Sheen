package com.example.rishi.clean2sheen;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class drainref extends AppCompatActivity {

    Button back2,drainloc;
    DatabaseReference ref1,ref2;
    String value1,value2;
    TextView drainvalue,drainstatus;
    FirebaseDatabase database=FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drainref);

        drainloc=findViewById(R.id.drainloc);
        back2=findViewById(R.id.back2);
        drainvalue=findViewById(R.id.drainvalue);
        drainstatus=findViewById(R.id.drainstatus);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back2=new Intent(drainref.this,mainref.class);
                startActivity(back2);
            }
        });
        drainloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drainloc=new Intent(Intent.ACTION_VIEW);
                drainloc.setData(Uri.parse("https://goo.gl/maps/dk4sKzxzjg46LEvBA"));
                startActivity(drainloc);
            }
        });
        ref1=database.getReference("drain");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1=dataSnapshot.getValue(String.class);
                drainvalue.setText(value1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref2=database.getReference("drainstatus");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value2=dataSnapshot.getValue(String.class);
                drainstatus.setText(value2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
