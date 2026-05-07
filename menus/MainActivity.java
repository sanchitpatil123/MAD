package com.example.menudemo;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPopup;
    TextView tvContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopup = findViewById(R.id.btnPopup);
        tvContext = findViewById(R.id.tvContext);

        // Register context menu
        registerForContextMenu(tvContext);

        // Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(this, btnPopup);
            popup.getMenuInflater().inflate(R.menu.menu_popup, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });

            popup.show();
        });
    }

    // OPTION MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    // CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}