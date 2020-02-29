package com.example.rishi.clean2sheen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainref extends AppCompatActivity {
    Button bin,drain,toilet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainref);

        bin=findViewById(R.id.bin);
        drain=findViewById(R.id.drain);
        toilet=findViewById(R.id.toilet);

        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bin1=new Intent(mainref.this,binref.class);
                startActivity(bin1);
            }
        });
        drain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drain1=new Intent(mainref.this,drainref.class);
                startActivity(drain1);
            }
        });
        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toilet1=new Intent(mainref.this,toiletref.class);
                startActivity(toilet1);
            }
        });

    }
}
