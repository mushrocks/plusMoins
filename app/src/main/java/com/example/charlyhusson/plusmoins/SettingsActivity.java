package com.example.charlyhusson.plusmoins;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.*;
import android.view.*;

public class SettingsActivity extends AppCompatActivity {

    private EditText minValeur, maxValeur,incrementValeur;
    private Button saveButton;
    private TextView displaySettings;
    public static final String mySettings = "mySettings";
    SharedPreferences sharedPreferences;
    private TextView initialValeur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        minValeur = (EditText) findViewById(R.id.minValeur);
        maxValeur = (EditText) findViewById(R.id.maxValeur);
        incrementValeur = (EditText) findViewById(R.id.incrementValue);
        saveButton = (Button) findViewById(R.id.saveButton);
        displaySettings = (TextView) findViewById(R.id.displaySettings);
        initialValeur = (TextView) findViewById(R.id.initialValeur);





        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                int min = new Integer(minValeur.getText().toString());
                int max = new Integer(maxValeur.getText().toString());
                int increment = new Integer(incrementValeur.getText().toString());
                int initial = new Integer(initialValeur.getText().toString());
                SharedPreferences sharedpreferences = getSharedPreferences(mySettings, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("minValeur", min);
                editor.putInt("maxValeur", max);
                editor.putInt("incrementValeur", increment);
                editor.putInt("initialValeur", initial);
                editor.apply();

                Toast.makeText(SettingsActivity.this,"Settings Saved ",Toast.LENGTH_LONG).show();
            }

        });





    }
}
