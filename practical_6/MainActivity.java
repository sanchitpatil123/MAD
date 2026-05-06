package com.example.formapp;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    RadioGroup radioGroup;
    CheckBox cbJava, cbPython, cbWeb;
    ToggleButton toggleHostel;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        radioGroup = findViewById(R.id.radioGroup);
        cbJava = findViewById(R.id.cbJava);
        cbPython = findViewById(R.id.cbPython);
        cbWeb = findViewById(R.id.cbWeb);
        toggleHostel = findViewById(R.id.toggleHostel);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            // Gender
            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);
            String gender = (rb != null) ? rb.getText().toString() : "Not Selected";

            // Skills
            String skills = "";
            if (cbJava.isChecked()) skills += "Java ";
            if (cbPython.isChecked()) skills += "Python ";
            if (cbWeb.isChecked()) skills += "Web ";

            // Toggle
            String hostel = toggleHostel.isChecked() ? "Yes" : "No";

            String result =
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Gender: " + gender + "\n" +
                    "Skills: " + skills + "\n" +
                    "Hostel: " + hostel;

            tvResult.setText(result);

            Toast.makeText(this, "Form Submitted", Toast.LENGTH_SHORT).show();
        });
    }
}