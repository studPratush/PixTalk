package com.example.asd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageGeneration extends AppCompatActivity implements View.OnClickListener {

    ImageView image;
    Button record;
    Button generate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_generation);
        image = findViewById(R.id.imageview);
        record = findViewById(R.id.btnrecord);
        generate = findViewById(R.id.btngenerate);

        record.setOnClickListener(this);
        generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
