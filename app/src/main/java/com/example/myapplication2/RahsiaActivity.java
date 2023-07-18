package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RahsiaActivity extends AppCompatActivity implements View.OnClickListener {


    GoogleSignInClient mGoogleSignInClient;
    String name, email;
    EditText etName, etEmail, etComments;

    RequestQueue queue;
    final String URL = "http://192.168.1.7/comments/api.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahsia);

        TextView tvName = (TextView) findViewById(R.id.tvName);


        name = getIntent().getStringExtra("Name");
        email = getIntent().getStringExtra("Email");

        tvName.setText(name);


       Button signout = findViewById(R.id.signout);
       signout.setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        queue = Volley.newRequestQueue(getApplicationContext());

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etComments = findViewById(R.id.etComments);

        Button button = (Button) findViewById(R.id.btnSubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //volley call

                makeRequest();
            }
        });

    }

    private void makeRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

            }
        }, errorListener) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("name", etName.getText().toString());
                params.put("email", etEmail.getText().toString());
                params.put("comments", etComments.getText().toString());

                return params;
            }


        };
        queue.add(stringRequest);

    }

        public Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();
            }
        };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signout:
                signOut();

                break;
        }

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(), email + " signed out", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
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

}