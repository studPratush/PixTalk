package com.example.asd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = findViewById(R.id.btncare);
        l2 = findViewById(R.id.btnchild);

        l1.setOnClickListener(this);
        l2.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btncare)
        {
            startActivity(new Intent(MainActivity.this,ImageGeneration.class));
        }
        if (v.getId() == R.id.btnchild)
        {
            startActivity(new Intent(MainActivity.this,ChildMenu.class));
        }


    }
}