package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import utils.Bill;

public class PurchaseActivity extends AppCompatActivity {
    TextView fruitNameView ;
    EditText fruitNbText;
    Button ajouterBtn ;
    Button acheterBtn;



    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_view);
        Intent intent=getIntent();
        String fruitName=intent.getStringExtra("fruitName");
        float fruitPrice=intent.getFloatExtra("fruitPrice",0);

        fruitNameView=findViewById(R.id.fruitName);
        fruitNbText=(EditText) findViewById(R.id.nbElement);
        ajouterBtn=(Button) findViewById(R.id.ajouterBtn);
        acheterBtn=(Button) findViewById(R.id.acheterBtn);

        fruitNameView.setText(fruitName);
        ajouterBtn.setOnClickListener(view -> {
            int quantity = Integer.parseInt(fruitNbText.getText().toString());
            float detailPrice = (quantity * fruitPrice);
            Bill.addToTotal(detailPrice);
            Intent toMainIntent=new Intent(PurchaseActivity.this,MainActivity.class);
            startActivity(toMainIntent);
        });



        acheterBtn.setOnClickListener(view -> {

            float recentTotal=Bill.totalAmount;



            int quantity = Integer.parseInt(fruitNbText.getText().toString());
            float totalPrice = (quantity * fruitPrice)+recentTotal;

            Intent billIntent = new Intent(PurchaseActivity.this, Bil_activity.class);
            billIntent.putExtra("totalPrice", totalPrice);
            startActivity(billIntent);
        });





    }
}
