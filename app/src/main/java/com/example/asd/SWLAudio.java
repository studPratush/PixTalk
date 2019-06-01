package com.example.asd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SWLAudio extends AppCompatActivity {

    Button play;
    ImageButton single;
    TextView t1;
    ArrayList<Integer> imgarray;
    Bundle bundle;
    ArrayList<String> lele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swlaudio);
        single = findViewById(R.id.imgoption);
        t1= findViewById(R.id.txt1);
        play = findViewById(R.id.playaud);

        bundle = getIntent().getExtras();
        //category = i.getStringExtra("category");
        assert bundle != null;
        imgarray = bundle.getIntegerArrayList("singleimage");
        lele = bundle.getStringArrayList("singlecaption");

        single.setImageResource(imgarray.get(0));
        t1.setText(lele.get(0));

    }
}
