package com.example.asd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildMenu extends AppCompatActivity implements View.OnClickListener {

    Button swl,counting,diff,qna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_menu);
        swl = findViewById(R.id.btnswl);
        counting = findViewById(R.id.btncounting);
        diff = findViewById(R.id.btndifferentiate);
        qna = findViewById(R.id.btnqna);

        swl.setOnClickListener(this);
        counting.setOnClickListener(this);
        diff.setOnClickListener(this);
        qna.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnswl)
        {
           startActivity(new Intent(ChildMenu.this,SWL.class));
        }
        if(v.getId()==R.id.btncounting)
        {
            startActivity(new Intent(ChildMenu.this,Counting.class));
        }
        if(v.getId()==R.id.btndifferentiate)
        {
            startActivity(new Intent(ChildMenu.this,Differentiate.class));
        }
        if(v.getId()==R.id.btnqna)
        {
            startActivity(new Intent(ChildMenu.this,QnAMenu.class));
        }
    }
}
