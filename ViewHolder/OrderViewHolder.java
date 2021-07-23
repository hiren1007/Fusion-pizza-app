package com.example.lenovo.letseat.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.lenovo.letseat.Interface.ItemClickListener;
import com.example.lenovo.letseat.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtOrderId,txtOrderPhone,txtOrderprice;
    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView){
        super(itemView);
        txtOrderId=(TextView)itemView.findViewById(R.id.order_id);
        txtOrderPhone=(TextView)itemView.findViewById(R.id.order_phone);
        txtOrderprice=(TextView)itemView.findViewById(R.id.order_price);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view)
    {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}

