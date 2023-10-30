package uk.ac.tees.mgd.b1032293.weekoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GestureDetectorCompat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements GestureDetector.OnGestureListener {

    TextView posXView, posYView, winScreen;
    MainActivity mainActivity;
    ImageView boatShape, targetShape;
    int movementInteger = 50;

    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gestureDetector = new GestureDetector(this, this);

        posXView = findViewById(R.id.textX);
        posYView = findViewById(R.id.textY);
        winScreen = findViewById(R.id.winText);

        boatShape = findViewById(R.id.boatShape);
        targetShape = findViewById(R.id.goalShape);
    }

   /* public boolean onTouchEvent(MotionEvent event) {
        posXView.setText("X: " + targetShape.getX() + "Y: " + targetShape.getY());
        posYView.setText("X: " + boatShape.getX() + "Y: " + boatShape.getY());

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                boatShape.setY(boatShape.getY() - movementInteger);
                if (checkOverlap(boatShape)){ winScreen.setVisibility(View.VISIBLE); }
                break;
        }
        return true;
    }*/

    public void onTouchBack(View v){
        Log.d("MainActivity2", "Button Pressed");
        finish();
    }

    public boolean checkOverlap(ImageView checking) {
        if (checking.getX() >= targetShape.getX() - 5 && checking.getX() <= targetShape.getX() + 5){
            if (checking.getY() >= targetShape.getY() - 5 && checking.getY() <= targetShape.getY() + 5){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        return true;
    }
    @Override
    public void onShowPress(@NonNull MotionEvent motionEvent) {
    }
    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        return false;
    }
    @Override
    public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {
    }

    private static final int SWIPE_THRESHOLD = 10;
    private static final int SWIPE_VELOCITY_THRESHOLD = 10;

    @Override
    public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {

        posXView.setText("X: " + targetShape.getX() + "Y: " + targetShape.getY());
        posYView.setText("X: " + boatShape.getX() + "Y: " + boatShape.getY());


        float diffY = e2.getY() - e1.getY();
        float diffX = e2.getX() - e1.getX();

        if (Math.abs(diffX) > Math.abs(diffY)) {
            // Horizontal Swipe
            if ((Math.abs(diffX) > SWIPE_THRESHOLD) && (Math.abs(velocityX)) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    onSwipeRight();
                } else {
                    onSwipeLeft();
                }
            }
        } else {
        // Vertical Swipe
            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    onSwipeDown();
                } else {
                    onSwipeUp();
                }
            }
        }
        return true;
    }

    private void onSwipeUp() {
        boatShape.setY(boatShape.getY() - movementInteger);
        if (checkOverlap(boatShape)) {
            winScreen.setVisibility(View.VISIBLE);
        }
    }

    private void onSwipeDown() {
        boatShape.setY(boatShape.getY() + movementInteger);
        if (checkOverlap(boatShape)) {
            winScreen.setVisibility(View.VISIBLE);
        }
    }

    private void onSwipeLeft() {
        boatShape.setX(boatShape.getX() - movementInteger);
        if (checkOverlap(boatShape)) {
            winScreen.setVisibility(View.VISIBLE);
        }
    }

    private void onSwipeRight() {
        boatShape.setX(boatShape.getX() + movementInteger);
        if (checkOverlap(boatShape)) {
            winScreen.setVisibility(View.VISIBLE);
        }
    }

}