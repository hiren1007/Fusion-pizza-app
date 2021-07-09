package com.example.lenovo.letseat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lenovo.letseat.Database.Database;
import com.example.lenovo.letseat.model.Order;

public class lamb extends AppCompatActivity {
    String foodID="";
    int id;
    Float price;
    private Button lambpizza;
    private Button chillilambpizza;
    //private Button nonvegthaali;

    ElegantNumberButton counterButton7;
    ElegantNumberButton counterButton8;
    //ElegantNumberButton counterButton9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamb);
        setTitle("Lunch");

        counterButton7= (ElegantNumberButton)findViewById(R.id.number_button7);
        counterButton8= (ElegantNumberButton)findViewById(R.id.number_button8);
       // counterButton9= (ElegantNumberButton)findViewById(R.id.number_button9);

        lambpizza = (Button) findViewById(R.id.lambpizza);
        lambpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "07",
                        "lamb pizza",
                        counterButton7.getNumber(),
                        "30"
                ));

                Toast.makeText(lamb.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
        chillilambpizza = (Button) findViewById(R.id.chillilambpizza);
        chillilambpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        "08",
                        "chillilamb pizza",
                        counterButton8.getNumber(),
                        "50"
                ));

                Toast.makeText(lamb.this, "Item is Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
