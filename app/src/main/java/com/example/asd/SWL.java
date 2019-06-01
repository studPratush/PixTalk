package com.example.asd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class SWL extends AppCompatActivity implements View.OnClickListener {

    ImageButton i1,i2,i3,i4;
    ArrayList<Integer> imagearray;
    ArrayList<String> stringarray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swl);
        i1 = findViewById(R.id.btnanimals);
        i2 = findViewById(R.id.btnfruits);
        i3 = findViewById(R.id.btnflowers);
        i4 = findViewById(R.id.btnbirds);

        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        imagearray = new ArrayList<Integer>();
        if(v.getId() == R.id.btnanimals)
        {
            imagearray.add(R.drawable.horse);
            imagearray.add(R.drawable.lion);
            imagearray.add(R.drawable.panda);
            imagearray.add(R.drawable.zebra);
            stringarray.add("horse");
            stringarray.add("lion");
            stringarray.add("panda");
            stringarray.add("zebra");

            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("MyArray", imagearray);
            bundle.putStringArrayList("caption",stringarray);
            startActivity(new Intent(SWL.this,SWLImages.class).putExtras(bundle));
            stringarray.clear();
        }
        if(v.getId() == R.id.btnfruits)
        {
            imagearray.add(R.drawable.apple);
            imagearray.add(R.drawable.banana);
            imagearray.add(R.drawable.mango);
            imagearray.add(R.drawable.orange);
            stringarray.add("apple");
            stringarray.add("banana");
            stringarray.add("mango");
            stringarray.add("orange");

            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("MyArray", imagearray);
            bundle.putStringArrayList("caption",stringarray);
            startActivity(new Intent(SWL.this,SWLImages.class).putExtras(bundle));
            stringarray.clear();
        }
        if(v.getId() == R.id.btnflowers)
        {
            imagearray.add(R.drawable.daisy);
            imagearray.add(R.drawable.rose);
            imagearray.add(R.drawable.tulip);
            imagearray.add(R.drawable.sunflower);
            stringarray.add("daisy");
            stringarray.add("rose");
            stringarray.add("tulip");
            stringarray.add("sunflower");

            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("MyArray", imagearray);
            bundle.putStringArrayList("caption",stringarray);
            startActivity(new Intent(SWL.this,SWLImages.class).putExtras(bundle));
            stringarray.clear();
        }
        if(v.getId() == R.id.btnbirds)
        {
            imagearray.add(R.drawable.blackbird);
            imagearray.add(R.drawable.crow);
            imagearray.add(R.drawable.sparrow);
            imagearray.add(R.drawable.cardinal);
            stringarray.add("blackbird");
            stringarray.add("crow");
            stringarray.add("sparrow");
            stringarray.add("cardinal");

            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("MyArray", imagearray);
            bundle.putStringArrayList("caption",stringarray);
            startActivity(new Intent(SWL.this,SWLImages.class).putExtras(bundle));
            stringarray.clear();
        }

    }
}
