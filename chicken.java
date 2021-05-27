package com.example.lenovo.letseat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lenovo.letseat.Database.Database;
import com.example.lenovo.letseat.model.Order;

public class chicken extends AppCompatActivity {
   //obj
    Float price=0.0f;
    String foodID="";
    int id;
    private Button shawarmapizza;
    private Button charcoalpizza;
    private Button dragonpizza;
    private Button buterpizza;

    // button for item select
    ElegantNumberButton counterButton1;
    ElegantNumberButton counterButton2;
    ElegantNumberButton counterButton3;
    ElegantNumberButton counterButton5;
    public chicken() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken);
        setTitle("chicken Pizza");

        counterButton1= (ElegantNumberButton)findViewById(R.id.number_button1);
        counterButton2= (ElegantNumberButton)findViewById(R.id.number_button2);
        counterButton3= (ElegantNumberButton)findViewById(R.id.number_button3);
        counterButton5= (ElegantNumberButton)findViewById(R.id.number_button5);

        // logic for show item information in perticular category of food

        shawarmapizza = (Button) findViewById(R.id.shawarmapizza);
        shawarmapizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "01",
                        "shawarma pizza",
                        counterButton1.getNumber(),
                        "14"
                ));

                Toast.makeText(chicken.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        charcoalpizza= (Button) findViewById(R.id.khichadi);
        charcoalpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "02",
                        "charcoal pizza",
                        counterButton2.getNumber(),
                        "20"
                ));

                Toast.makeText(chicken.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        dragonpizza = (Button) findViewById(R.id.vadapav);
        dragonpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "03",
                        "dragon pizza",
                        counterButton3.getNumber(),
                        "14"
                ));

                Toast.makeText(chicken.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });

        buterpizza= (Button) findViewById(R.id.masaladosa);
        buterpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "05",
                        "buter pizza",
                        counterButton5.getNumber(),
                        "14"
                ));

                Toast.makeText(chicken.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });


    }
}