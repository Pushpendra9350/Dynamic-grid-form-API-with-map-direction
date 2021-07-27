package com.example.rupeekmapapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Places> places;
    Adapter adapter;
    private static String url = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/placesofinterest39c1c48.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclegrid);
        places = new ArrayList<>();
        extractplaces();


    }

    private void extractplaces(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++)
                {
                    try{
                        JSONObject placesObject = response.getJSONObject(i);
                        Places place = new Places();
                        place.setId(placesObject.getString("id").toString());
                        place.setName(placesObject.getString("name").toString());
                        place.setImageurl(placesObject.getString("image").toString());
                        place.setLatitude(placesObject.getString("latitude").toString());
                        place.setLongitude(placesObject.getString("longitude").toString());
                        place.setAddress(placesObject.getString("address").toString());
                        places.add(place);
                    } catch(JSONException e){
                        e.printStackTrace();
                    }

                }
                adapter = new Adapter(getApplicationContext(),places);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
        queue.add(jsonArrayRequest);

    }


}