package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bil_activity extends AppCompatActivity {
    TextView priceTotalText;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        priceTotalText=(TextView) findViewById(R.id.priceTotalText);
        Intent intent=getIntent();
        float tot=intent.getFloatExtra("totalPrice",0);
        priceTotalText.setText(tot+" dt");

    }
}
