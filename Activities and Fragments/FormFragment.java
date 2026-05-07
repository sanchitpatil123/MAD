package com.example.fragmentdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment {

    EditText etName, etEmail;
    Button btnSubmit;
    TextView tvResult;

    public FormFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_form, container, false);

        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        tvResult = view.findViewById(R.id.tvResult);

        // Event Handling (Button Click)
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {
                Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                String result = "Name: " + name + "\nEmail: " + email;

                tvResult.setText(result);

                Toast.makeText(getActivity(), "Form Submitted!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}