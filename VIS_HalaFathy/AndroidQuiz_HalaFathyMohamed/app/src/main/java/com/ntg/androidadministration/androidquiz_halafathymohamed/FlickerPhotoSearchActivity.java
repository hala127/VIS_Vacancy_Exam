package com.ntg.androidadministration.androidquiz_halafathymohamed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

public class FlickerPhotoSearchActivity extends AppCompatActivity {

    private RecyclerView rv_photos;
    String url = "http://api.androidhive.info/volley/person_object.json";

    private final String FLICKER_KEY = "1b00a765f801d6e1882b1e6071f7bc20";
    private final String FLICKER_SECRET = "fc5bef8df524a34c";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flicker_photo_search);

        rv_photos = (RecyclerView) findViewById(R.id.rv_photos);


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<Photo> items = new ArrayList<>();
                items.add(new Photo(response.toString()));
                setRecyclerViewData(items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance(this).addToRequestQueue(request, "flickerImages");
    }

    private void setRecyclerViewData(ArrayList<Photo> items) {
        rv_photos.setLayoutManager(new LinearLayoutManager(this));
        PhotosAdapter adapter = new PhotosAdapter(this, items);
        rv_photos.setItemAnimator(new DefaultItemAnimator());
        rv_photos.setAdapter(adapter);
    }
}
