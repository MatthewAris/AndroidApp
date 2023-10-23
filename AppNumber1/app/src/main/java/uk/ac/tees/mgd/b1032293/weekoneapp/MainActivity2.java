package uk.ac.tees.mgd.b1032293.weekoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView posXView, posYView, winScreen;
    MainActivity mainActivity;
    ImageView boatShape;
    ImageView targetShape;
    int movementInteger = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        posXView = findViewById(R.id.textX);
        posYView = findViewById(R.id.textY);
        winScreen = findViewById(R.id.winText);

        boatShape = findViewById(R.id.boatShape);
        targetShape = findViewById(R.id.goalShape);
    }

    public void onTouchBack(View v){
        Log.d("MainActivity2", "Button Pressed");
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        finish();
    }
    public boolean onTouchEvent(MotionEvent event) {
        posXView.setText("X: " + targetShape.getX() + "Y: " + targetShape.getY());
        posYView.setText("X: " + boatShape.getX() + "Y: " + boatShape.getY());

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                boatShape.setY(boatShape.getY() - movementInteger);
                if (checkOverlap(boatShape)){ winScreen.setVisibility(View.VISIBLE); }
                break;
        }
        return true;
    }
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        //Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        return true;
    }
    public boolean checkOverlap(ImageView checking) {
        if (checking.getX() >= targetShape.getX() - 5 && checking.getX() <= targetShape.getX() + 5){
            if (checking.getY() >= targetShape.getY() - 5 && checking.getY() <= targetShape.getY() + 5){
                return true;
            }
        }
        return false;
    }

}