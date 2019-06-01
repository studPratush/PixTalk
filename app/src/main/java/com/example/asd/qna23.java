package com.example.asd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class qna23 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna23);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        radioGroup = (RadioGroup) findViewById(R.id.radiogrp);
        btnDisplay = (Button) findViewById(R.id.btn1);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==R.id.radio2){
                    Toast.makeText(qna23.this,
                            radioButton.getText() + " is correct answer", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), QnAMenu.class));


                }
                else{
                    Toast.makeText(qna23.this,
                            radioButton.getText()+" is incorrect answer", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), QnAMenu.class));

                }


            }

        });


    }
}
