package com.tbs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner spinner;
    private AppCompatTextView activationTemp,activationPer;
    private AppCompatButton tempRaise,tempLower,perRaise,perLower;
    private static final String[] items = {"Automatic", "Blinds Up", "Semi-Permiable","Blackout"};
    private int initTemp = 75;
    private int initPer = 85;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSpinner();
        initialize();
    }

    private void initialize() {
        activationTemp = (AppCompatTextView) findViewById(R.id.activationTemp);
        activationPer = (AppCompatTextView) findViewById(R.id.activationPer);
        tempRaise = (AppCompatButton) findViewById(R.id.tempRaise);
        tempLower = (AppCompatButton) findViewById(R.id.tempLower);
        perRaise = (AppCompatButton) findViewById(R.id.perRaise);
        perLower = (AppCompatButton) findViewById(R.id.perLower);
        tempRaise.setOnClickListener(this);
        tempLower.setOnClickListener(this);
        perRaise.setOnClickListener(this);
        perLower.setOnClickListener(this);
        setTempValue(initTemp);
        setPerValue(initPer);
    }

    private void setPerValue(int initPer) {
        String perValue = String.valueOf(initPer) + " " + getString(R.string.per_text);
        activationPer.setText(perValue);
    }

    private void setTempValue(int initTemp) {
        String tempValue = String.valueOf(initTemp) + " " + getString(R.string.f_text);
        activationTemp.setText(tempValue);
    }

    private void setSpinner() {
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tempRaise){
            initTemp += 1;
            setTempValue(initTemp);
        }else if (v.getId() == R.id.tempLower){
            initTemp -= 1;
            setTempValue(initTemp);
        }else if (v.getId() == R.id.perLower){
            initPer -= 1;
            setPerValue(initPer);
        }else if (v.getId() == R.id.perRaise){
            initPer += 1;
            setPerValue(initPer);
        }
    }
}