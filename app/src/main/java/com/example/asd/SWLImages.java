package com.example.asd;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;

import java.util.ArrayList;
import java.util.Locale;

public class SWLImages extends AppCompatActivity {

    ImageButton i1,i2,i3,i4;
    TextView o1,o2,o3,o4;
    String category;
    ArrayList<Integer> imgarray;
    Bundle bundle;
    ArrayList<String> lele;
    ArrayList<Integer> imagearray;
    ArrayList<String> stringarray = new ArrayList<String>();
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        setContentView(R.layout.activity_swlimages);
        i1 = findViewById(R.id.btn1);
        i2 = findViewById(R.id.btn2);
        i3 = findViewById(R.id.btn3);
        i4 = findViewById(R.id.btn4);

        o1 = findViewById(R.id.opt1);
        o2 = findViewById(R.id.opt2);
        o3 = findViewById(R.id.opt3);
        o4 = findViewById(R.id.opt4);


      //  i1.setOnClickListener(this);
      /*  i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);*/
bundle = getIntent().getExtras();
        //category = i.getStringExtra("category");
        assert bundle != null;
        imgarray = bundle.getIntegerArrayList("MyArray");
        lele = bundle.getStringArrayList("caption");
        i1.setImageResource(imgarray.get(0));
        i2.setImageResource(imgarray.get(1));
        i3.setImageResource(imgarray.get(2));
        i4.setImageResource(imgarray.get(3));

        o1.setText(lele.get(0));
        o2.setText(lele.get(1));
        o3.setText(lele.get(2));
        o4.setText(lele.get(3));

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
i1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String toSpeak = o1.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
      //Toast.makeText(getApplicationContext(),o1.getText(),Toast.LENGTH_LONG).show();
    }
});
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = o2.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                //Toast.makeText(getApplicationContext(),o1.getText(),Toast.LENGTH_LONG).show();
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = o3.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                //Toast.makeText(getApplicationContext(),o1.getText(),Toast.LENGTH_LONG).show();
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = o4.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                //Toast.makeText(getApplicationContext(),o1.getText(),Toast.LENGTH_LONG).show();
            }
        });


        //Toast.makeText(getApplicationContext(),lele.get(0),Toast.LENGTH_LONG).show();

    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}
