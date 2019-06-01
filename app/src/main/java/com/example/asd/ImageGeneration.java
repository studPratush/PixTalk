package com.example.asd;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.io.ByteArrayOutputStream;
import java.io.IOException;



import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class ImageGeneration extends AppCompatActivity implements View.OnClickListener {

    ImageView image;
    Button record;
    Button generate;
    TextView text;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    public static final String SERVER_URL="http://192.168.43.16:5000";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_generation);
        image = findViewById(R.id.imageview);
        record = findViewById(R.id.btnrecord);
        generate = findViewById(R.id.btngenerate);
        text = findViewById(R.id.speech_text);

        record.setOnClickListener(this);
        generate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnrecord)
        {
            promptSpeechInput();
        }
        if(v.getId() == R.id.btngenerate)
        {

        }
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String value = result.get(0);
                    if(value.contains("flower"))
                    {
                        getData(value);
                        Toast.makeText(getApplicationContext(),"In",Toast.LENGTH_LONG).show();

                    }
                    else
                        text.setText(getString(R.string.pta));
                    //text.setText(result.get(0));
                }
                break;
            }

        }
    }




    public void getData(String value) {

        String n="basket",c;
        //n=name.getText().toString();
        //c=city.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_URL + "/imagegeneration/basket",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject responseObj = null;
                        try {

                            responseObj=new JSONObject(response);
                            //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                           // Toast.makeText(getApplicationContext(), responseObj.getString("disease"), Toast.LENGTH_SHORT).show();
                            String newval=responseObj.getString("data");
                            //Log.d("MAINACTIVITY", newval);
                            byte[] imageBytes = Base64.decode(newval, Base64.DEFAULT);
                           Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                            image.setImageBitmap(decodedImage);

                            //Toast.makeText(getApplicationContext(),"newval is "+newval,Toast.LENGTH_LONG).show();
                           //text.setText(newval);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Connection Failed.", Toast.LENGTH_SHORT).show();
                       // Log.d("MAINACTIVITY", error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }

        };

        //Adding the string request to the queue

        RequestQueue requestQueue = Volley.newRequestQueue(ImageGeneration.this);
        requestQueue.add(stringRequest);

    }


}
