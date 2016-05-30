package com.example.charlyhusson.plusmoins;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.*;
import android.view.*;

public class PlusMoinsActivity extends AppCompatActivity {

    public int maValue = 0;
    private Button buttonClic;
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

    }

    public void updateView(TextView c) {
        c.setText(new Integer(maValue).toString());
    }

    public void calculResultat(TextView c){
        try {
            maValue = new Integer(textA.getText().toString()) + new Integer(textB.getText().toString());
            updateView(c);
        } catch (Exception e) {
            maValue=0;
            updateView(textC);
        }
    }
}
