package com.example.lenovo.letseat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.letseat.Common.Common;
import com.example.lenovo.letseat.Database.Database;
import com.example.lenovo.letseat.ViewHolder.CartAdapter;
import com.example.lenovo.letseat.model.Order;
import com.example.lenovo.letseat.model.Request;
import com.example.lenovo.letseat.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.lenovo.letseat.model.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;
    public static int od=0;
    FirebaseDatabase database;
    DatabaseReference requests;
   public TextView TotalPrice;

    Button OrderButton;

    List<Order> cart=new ArrayList<>();
   CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("Cart");

        database=FirebaseDatabase.getInstance();
        requests=database.getReference("Added Orders");

        recyclerView=(RecyclerView) findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        TotalPrice=(TextView)findViewById(R.id.total);
        OrderButton=(Button)findViewById(R.id.placeorder);

        OrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cart.size()>0)
                    showAlertDialog();
                else
                    Toast.makeText(Cart.this,  "Cart is Empty", Toast.LENGTH_SHORT).show();
            }
        });
        loadListProduct();

    }
    private void showAlertDialog(){
        final AlertDialog.Builder builder= new AlertDialog.Builder(Cart.this);


       builder.setMessage("Are you sure to place Order?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(
                   LinearLayout.LayoutParams.MATCH_PARENT,
                   LinearLayout.LayoutParams.MATCH_PARENT
           );
           @Override
           public void onClick(DialogInterface dialog, int which) {

               Request request=new Request(Common.currentuser.getPhone(), Common.currentuser.getName(), TotalPrice.getText().toString(), cart);
               requests.child(String.valueOf(System.currentTimeMillis())).setValue(request);
               new Database(getBaseContext()).cleanCart();
               finish();
               startActivity(new Intent(((Dialog)dialog).getContext(),yourorder.class));
           }
       })
               .setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
        builder.show();
    }
    private void loadListProduct()
    {
        cart=new Database(this).getCart();
        adapter=new CartAdapter(cart,this);
        recyclerView.setAdapter(adapter);

        int total=0;
        for(Order order:cart)
            total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getQuantity()));



        Locale locale=new Locale("en","nz");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        TotalPrice.setText(fmt.format(total));

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals(Common.DELETE))
            deleteCart(item.getOrder());
        return true;
    }

    private void deleteCart(int position) {
        cart.remove(position);
        new Database(this).cleanCart();
        for(Order item:cart)
            new Database(this).addToCart(item);
        loadListProduct();

    }
}
