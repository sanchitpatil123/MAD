package com.example.skillapp;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etCourse, etProgress;
    ProgressBar progressBar;
    RatingBar ratingBar;
    Button btnUpdate, btnSubmit;
    TextView tvResult;

    int progressValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCourse = findViewById(R.id.etCourse);
        etProgress = findViewById(R.id.etProgress);
        progressBar = findViewById(R.id.progressBar);
        ratingBar = findViewById(R.id.ratingBar);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        // Update Progress
        btnUpdate.setOnClickListener(v -> {

            String progressStr = etProgress.getText().toString();

            if (!progressStr.isEmpty()) {
                progressValue = Integer.parseInt(progressStr);

                if (progressValue > 100) progressValue = 100;

                progressBar.setProgress(progressValue);

                Toast.makeText(this, "Progress Updated", Toast.LENGTH_SHORT).show();
            }
        });

        // Submit Feedback
        btnSubmit.setOnClickListener(v -> {

            String course = etCourse.getText().toString();
            float rating = ratingBar.getRating();

            String result =
                    "Course: " + course + "\n" +
                    "Skills Learned: " + progressValue + "%\n" +
                    "Rating: " + rating;

            tvResult.setText(result);

            Toast.makeText(this, "Feedback Submitted", Toast.LENGTH_SHORT).show();
        });
    }
}