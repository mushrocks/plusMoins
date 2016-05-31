package com.example.charlyhusson.plusmoins;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.*;
import android.view.*;

public class SettingsActivity extends AppCompatActivity {

    private EditText minValeur, maxValeur,incrementValeur;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        minValeur = (EditText) findViewById(R.id.minValeur);
        maxValeur = (EditText) findViewById(R.id.maxValeur);
        incrementValeur = (EditText) findViewById(R.id.incrementValue);




    }
}
