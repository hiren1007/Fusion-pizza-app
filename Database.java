package com.example.lenovo.letseat.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.lenovo.letseat.model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;
/** Database class for store item of category **/
public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="exp.db";
    private static final   int DB_VER=1;


    public Database(Context context) {
        super(context,  DB_NAME, null, DB_VER);

    }
    public List<Order> getCart(){
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        String[] sqlSelect={"ID","FoodID","FoodName","Quantity","Price"};
        String sqlTable="items";

        qb.setTables(sqlTable);
        Cursor c=qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Order> result=new ArrayList<>();
        if(c.moveToFirst())
        {
            do{
                result.add(new Order(
                        c.getInt(c.getColumnIndex("ID")),
                        c.getString(c.getColumnIndex("FoodID")),
                        c.getString(c.getColumnIndex("FoodName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price"))));
            }while(c.moveToNext());
        }
        return result;

    }

    public void addToCart(Order order)
    {
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("INSERT INTO items(FoodID,FoodName,Quantity,Price)VALUES('%s','%s','%s','%s');",
               // order.getID(),
                order.getFoodID(),
                order.getFoodName(),
                order.getQuantity(),
                order.getPrice());
        db.execSQL(query);
    }
    public void cleanCart()
    {
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("DELETE FROM items");
        db.execSQL(query);
    }
    public void updateCart(Order order)
    {
        SQLiteDatabase db =getReadableDatabase();
        String query= String.format("UPDATE items SET Quantity= %s WHERE ID = %s",order.getQuantity(),order.getID());
        db.execSQL(query);
    }
}
