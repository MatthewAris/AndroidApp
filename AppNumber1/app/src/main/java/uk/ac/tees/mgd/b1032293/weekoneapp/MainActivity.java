package uk.ac.tees.mgd.b1032293.weekoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    public String key = "my key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
    }

    public void onTouch(View v) {
        Log.d("MainActivity", "Button Pressed");
        Intent intent = new Intent(this, MainActivity2.class);
        String s = editText.getText().toString();
        if (s != null) {
            intent.putExtra(key, s);
        }
        startActivity(intent);
    }
}