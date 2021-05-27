package com.example.lenovo.letseat;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private GestureDetectorCompat gestureObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject =new GestureDetectorCompat(this,new MainActivity.LearnGesture());

    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);


    }
    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent event1,MotionEvent event2,float velocityX,float velocityY){

            if(event2.getX()< event1.getX()|| event2.getX()> event1.getX()|| event2.getX()==event1.getX()){


                Intent intent=new Intent(MainActivity.this,signin.class);
                finish();
                startActivity(intent);
            }


            return true;

        }
    }


}


