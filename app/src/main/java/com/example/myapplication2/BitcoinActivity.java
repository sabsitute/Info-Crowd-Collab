package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BitcoinActivity extends AppCompatActivity {

    TextView tvAsk, tvBid, tvDate;
    private final String URL = "https://logger.mypapit.net/api/XBTMYR.json";
    RequestQueue requestQueue;
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitcoin);

        tvAsk = (TextView) findViewById(R.id.tvAsk);
        tvBid = (TextView) findViewById(R.id.tvBid);
        tvDate = (TextView) findViewById(R.id.tvDate);

        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        sendRequest();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.report:

                //Toast.makeText(this,"You are in report page.",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, RahsiaActivity.class);
                startActivity(intent);
                break;


            case R.id.about:

                //Toast.makeText(this,"You are in about page.",Toast.LENGTH_LONG).show();
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.bitcoin:

                //Toast.makeText(this,"You are in bitcoin price page.",Toast.LENGTH_LONG).show();
                intent = new Intent(this, BitcoinActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    private void sendRequest() {
        StringRequest request = new StringRequest(Request.Method.GET, URL, onSuccess, onError);
        requestQueue.add(request);


    }

    Response.Listener<String> onSuccess = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Bitcoinprice price = gson.fromJson(response, Bitcoinprice.class);

            tvAsk.setText(price.ask);
            tvBid.setText(price.bid);



            Date date = new Date(price.timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss Z", Locale.getDefault());
            String displaydate = sdf.format(date);


            tvDate.setText(displaydate);


        }
    };

    public Response.ErrorListener onError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
        }
    };
}
