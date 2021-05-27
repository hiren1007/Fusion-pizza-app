package com.example.lenovo.letseat;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lenovo.letseat.ViewHolder.OrderViewHolder;
import com.example.lenovo.letseat.model.Request;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.lenovo.letseat.Common.Common;
import com.example.lenovo.letseat.Cart.*;
import org.w3c.dom.Text;
import static com.example.lenovo.letseat.Cart.od;
public class myorders extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference requests;
    FirebaseRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);
        database= FirebaseDatabase.getInstance();
        requests=database.getReference("Added Orders");
        recyclerView=(RecyclerView)findViewById(R.id.listOrder);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadOrders(Common.currentuser.getPhone());


    };
    private void loadOrders(String phone){

        adapter =new FirebaseRecyclerAdapter<Request,OrderViewHolder>(
                Request.class,
                R.layout.order_layout,
                OrderViewHolder.class,
                requests.orderByChild("phone").equalTo(phone)
        ){
            @Override
            protected void populateViewHolder(OrderViewHolder viewHolder, Request model, int position){
                viewHolder.txtOrderId.setText(adapter.getRef(position).getKey());
                viewHolder.txtOrderPhone.setText(model.getPhone());
                viewHolder.txtOrderprice.setText(model.getTotal());
            }
        };
        recyclerView.setAdapter(adapter);

    }

}


