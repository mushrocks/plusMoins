package com.example.charlyhusson.plusmoins;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Button;
import android.widget.*;
import android.view.*;

import org.w3c.dom.Text;

public class PlusMoinsActivity extends AppCompatActivity {

    public double maValue = 0;
    private Button buttonClic, settingsButton;
    private TextView textA;
    private TextView textB;
    private TextView textC;
    private TextView displaySettings;
    public static final String mySettings = "mySettings";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_moins);
        this.getSettings(displaySettings);

        textA = (TextView) findViewById(R.id.a);
        textB = (TextView) findViewById(R.id.b);
        textC = (TextView) findViewById(R.id.c);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        displaySettings = (TextView) findViewById(R.id.displaySettings);

        textA.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                calculResultat(textC);
            }
        });

        textB.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                calculResultat(textC);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlusMoinsActivity.this, SettingsActivity.class);
                PlusMoinsActivity.this.startActivity(intent);
                //SettingsActivity.this.finish();
            }

        });

        SharedPreferences sharedpreferences = getSharedPreferences(mySettings, Context.MODE_PRIVATE);
        this.getSettings(displaySettings);

    }

    @Override
    public void onResume () {
        super.onResume();
        this.getSettings(displaySettings);
    }


    public void updateView(TextView c) {
        c.setText(new Double(maValue).toString());
    }

    public void calculResultat(TextView c){
        try {
            SharedPreferences sharedpreferences = getSharedPreferences(mySettings, Context.MODE_PRIVATE);

            Double a = new Double(textA.getText().toString());
            Double b = new Double(textB.getText().toString());

            if(a > new Double(sharedpreferences.getAll().get("maxValeur").toString()) || b > new Double(sharedpreferences.getAll().get("maxValeur").toString())) {
                Toast.makeText(PlusMoinsActivity.this,"Maximum reached",Toast.LENGTH_LONG).show();
            }
            else if(a < new Double(sharedpreferences.getAll().get("minValeur").toString()) || b < new Double(sharedpreferences.getAll().get("minValeur").toString())) {
                Toast.makeText(PlusMoinsActivity.this,"Minimum not reached",Toast.LENGTH_LONG).show();
            }
            else {
                maValue = new Double(textA.getText().toString()) + new Double(textB.getText().toString());
                updateView(c);
            }
        } catch (Exception e) {
            maValue=0;
            updateView(textC);
        }
    }

    public void getSettings(TextView t) {
        t = (TextView) findViewById(R.id.displaySettings);

        SharedPreferences sharedpreferences = getSharedPreferences(mySettings, Context.MODE_PRIVATE);

        t.setText("Min val: "+sharedpreferences.getInt("minValeur", 10)+"" +
                "\nMax val: "+sharedpreferences.getInt("maxValeur", 2000)+"" +
                "\n Increment val :"+sharedpreferences.getInt("incrementValeur", 1)+""+
                "\n Initial val :"+sharedpreferences.getInt("initialValeur",0)
        );
    }

}
