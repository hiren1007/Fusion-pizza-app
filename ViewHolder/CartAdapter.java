package com.example.lenovo.letseat.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lenovo.letseat.Cart;
import com.example.lenovo.letseat.Common.Common;
import com.example.lenovo.letseat.Database.Database;
import com.example.lenovo.letseat.Interface.ItemClickListener;
import com.example.lenovo.letseat.R;
import com.example.lenovo.letseat.model.Order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        ,View.OnCreateContextMenuListener{

    public TextView txt_cart_name,txt_price;
    public ElegantNumberButton btn_quantity;
    private ItemClickListener itemClickListener;

    public void setTxt_cart_name(TextView txt_cart_name) {
        this.txt_cart_name=txt_cart_name;
    }



    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_cart_name=(TextView)itemView.findViewById(R.id.cart_item_name);
        txt_price=(TextView)itemView.findViewById(R.id.cart_item_price);
        btn_quantity=(ElegantNumberButton)itemView.findViewById(R.id.btn_quantity);
        itemView.setOnCreateContextMenuListener(this);

    }
    @Override
    public void onClick(View view){

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select action");
        menu.add(0,0,getAdapterPosition(), Common.DELETE);
    }
}

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<Order> listData= new ArrayList<>();
    private Cart cart;


    public CartAdapter(List<Order> listData, Cart cart) {
        this.listData = listData;
        this.cart = cart;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater inflater=LayoutInflater.from(cart);
        View itemView=inflater.inflate(R.layout.cart_layout,parent,false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, final int position){

        holder.btn_quantity.setNumber(listData.get(position).getQuantity());
        holder.btn_quantity.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Order order = listData.get(position);
                order.setQuantity(String.valueOf(newValue));
                new Database(cart).updateCart(order);

                int total=0;
                List<Order> orders = new Database(cart).getCart();
                for(Order item:orders)
                    total+=(Integer.parseInt(item.getPrice()))*(Integer.parseInt(item.getQuantity()));
                Locale locale=new Locale("en","nz");
                NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

                cart.TotalPrice.setText(fmt.format(total));


            }
        });
        Locale locale=new Locale("en","nz");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        int price =(Integer.parseInt(listData.get(position).getPrice()));
        holder.txt_price.setText(fmt.format(price));
        holder.txt_cart_name.setText(listData.get(position).getFoodName());
    }

    @Override
    public int getItemCount(){
        return listData.size();
    }
}
