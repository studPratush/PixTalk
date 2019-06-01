package com.example.asd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
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


public class ImageCard extends AppCompatActivity {

    public static final String SERVER_URL="http://192.168.43.16:5000";
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_card);
        image = findViewById(R.id.imageview);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, SERVER_URL + "/imagecard/gen",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject responseObj = null;
                        try {

                            responseObj=new JSONObject(response);

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

        RequestQueue requestQueue = Volley.newRequestQueue(ImageCard.this);
        requestQueue.add(stringRequest);



    }




}
