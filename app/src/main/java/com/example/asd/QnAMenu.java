package com.example.asd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QnAMenu extends AppCompatActivity implements View.OnClickListener {

    Button l1,l2,l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qn_amenu);
        l1 = findViewById(R.id.btnlevel1);
        l2 = findViewById(R.id.btnlevel2);
        l3 = findViewById(R.id.btnlevel3);

        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnlevel1)
        {
            startActivity(new Intent(QnAMenu.this,QnALevel1.class));
        }

    }
}
