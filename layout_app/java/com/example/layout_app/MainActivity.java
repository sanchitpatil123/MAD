package com.example.layout_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLinear, btnFrame, btnConstraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinear = findViewById(R.id.btnLinear);
        btnFrame = findViewById(R.id.btnFrame);
        btnConstraint = findViewById(R.id.btnConstraint);

        btnLinear.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class)));

        btnFrame.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, FrameLayoutActivity.class)));

        btnConstraint.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class)));
    }
}