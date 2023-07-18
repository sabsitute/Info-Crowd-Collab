package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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