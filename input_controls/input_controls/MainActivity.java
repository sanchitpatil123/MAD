package com.example.input_controls;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    RadioGroup radioGroup;
    CheckBox checkSports, checkMusic;
    Switch switchStatus;
    ProgressBar progressBar;
    RatingBar ratingBar;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        radioGroup = findViewById(R.id.radioGroup);
        checkSports = findViewById(R.id.checkSports);
        checkMusic = findViewById(R.id.checkMusic);
        switchStatus = findViewById(R.id.switchStatus);
        progressBar = findViewById(R.id.progressBar);
        ratingBar = findViewById(R.id.ratingBar);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();

                // Validation
                if (name.isEmpty()) {
                    editName.setError("Enter Name");
                    return;
                }

                // Gender check
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadio = findViewById(selectedId);
                String gender = selectedRadio.getText().toString();

                // Hobbies
                String hobbies = "";
                if (checkSports.isChecked()) hobbies += "Sports ";
                if (checkMusic.isChecked()) hobbies += "Music ";

                // Switch status
                String status = switchStatus.isChecked() ? "ON" : "OFF";

                // Progress
                progressBar.setProgress(80);

                // Rating
                float rating = ratingBar.getRating();

                // Result
                String result = "Name: " + name +
                        "\nGender: " + gender +
                        "\nHobbies: " + hobbies +
                        "\nStatus: " + status +
                        "\nRating: " + rating;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}