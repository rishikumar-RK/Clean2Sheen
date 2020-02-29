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

public class toiletref extends AppCompatActivity {

    Button back3,toiletloc;
    DatabaseReference ref1,ref2;
    TextView watervalue,waterstatus;
    String value1,value2;
    FirebaseDatabase database=FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toiletref);

        toiletloc=findViewById(R.id.toiletloc);
        back3=findViewById(R.id.back3);
        watervalue=findViewById(R.id.watervalue);
        waterstatus=findViewById(R.id.waterstatus);

        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back3=new Intent(toiletref.this,mainref.class);
                startActivity(back3);
            }
        });
        toiletloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toiletloc=new Intent(Intent.ACTION_VIEW);
                toiletloc.setData(Uri.parse("https://goo.gl/maps/dk4sKzxzjg46LEvBA"));
                startActivity(toiletloc);
            }
        });
        ref1=database.getReference("level");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1=dataSnapshot.getValue(String.class);
                watervalue.setText(value1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref2=database.getReference("waterstatus");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value2=dataSnapshot.getValue(String.class);
                waterstatus.setText(value2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
