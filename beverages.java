package com.example.lenovo.letseat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lenovo.letseat.Database.Database;
import com.example.lenovo.letseat.model.Order;

public class beverages extends AppCompatActivity {
  String foodID="";
  int id;
    Float price;
    private Button tea;
    private Button hotcoffee;
    private Button coldcoffee;
    private Button faluda;
    private Button soda;
    private Button fruitjuice;

    ElegantNumberButton counterButton24;
    ElegantNumberButton counterButton25;
    ElegantNumberButton counterButton26;
    ElegantNumberButton counterButton27;
    ElegantNumberButton counterButton28;
    ElegantNumberButton counterButton29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);
        setTitle("Beverages");
        counterButton24= (ElegantNumberButton)findViewById(R.id.number_button24);
        counterButton25= (ElegantNumberButton)findViewById(R.id.number_button25);
        counterButton26= (ElegantNumberButton)findViewById(R.id.number_button26);
        counterButton27= (ElegantNumberButton)findViewById(R.id.number_button27);
        //counterButton28= (ElegantNumberButton)findViewById(R.id.number_button28);
       // counterButton29= (ElegantNumberButton)findViewById(R.id.number_button29);


        tea = (Button) findViewById(R.id.tea);
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "24",
                        "Tea",
                        counterButton24.getNumber(),
                        "10"
                ));

                Toast.makeText(beverages.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        hotcoffee = (Button) findViewById(R.id.hotcoffee);
        hotcoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "25",
                        "Hot Coffee",
                        counterButton25.getNumber(),
                        "12"
                ));

                Toast.makeText(beverages.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        fruitjuice = (Button) findViewById(R.id.fruitjuice);
        fruitjuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "26",
                        "Fruit Juice",
                        counterButton26.getNumber(),
                        "30"
                ));

                Toast.makeText(beverages.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        faluda = (Button) findViewById(R.id.faluda);
        faluda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "27",
                        "Faluda",
                        counterButton27.getNumber(),
                        "30"
                ));

                Toast.makeText(beverages.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        /*coldcoffee=(Button) findViewById(R.id.coldcoffee);
        coldcoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "28",
                        "Cold Coffee",
                        counterButton28.getNumber(),
                        "30"
                ));

                Toast.makeText(beverages.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });

        soda = (Button) findViewById(R.id.soda);
        soda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "29",
                        "Soda",
                        counterButton29.getNumber(),
                        "10"
                ));

                Toast.makeText(beverages.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });*/


    }


}
