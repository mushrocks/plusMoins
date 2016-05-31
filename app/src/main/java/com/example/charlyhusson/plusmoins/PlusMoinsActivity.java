package com.example.charlyhusson.plusmoins;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.*;
import android.view.*;

public class PlusMoinsActivity extends AppCompatActivity {

    public double maValue = 0;
    private Button buttonClic, settingsButton;
    private TextView textA;
    private TextView textB;
    private TextView textC;





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_moins);

        textA = (TextView) findViewById(R.id.a);
        textB = (TextView) findViewById(R.id.b);
        textC = (TextView) findViewById(R.id.c);
        settingsButton = (Button) findViewById(R.id.settingsButton);

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

    }

    public void updateView(TextView c) {
        c.setText(new Double(maValue).toString());
    }

    public void calculResultat(TextView c){
        try {
            maValue = new Double(textA.getText().toString()) + new Double(textB.getText().toString());
            updateView(c);
        } catch (Exception e) {
            maValue=0;
            updateView(textC);
        }
    }
}
