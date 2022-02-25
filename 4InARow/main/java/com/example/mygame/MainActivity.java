package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button PlayButton, SettingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayButton = (Button) findViewById(R.id.PlayButton);
        PlayButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
            }
        }));
        SettingsButton = (Button) findViewById(R.id.SettingsButton);
        SettingsButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsActivity();
            }
        }));
    }

    public void openGameActivity() {
        Intent gameIntent = new Intent(this, GameActivity.class);
        startActivity(gameIntent);
    }

    public void openSettingsActivity() {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }
}