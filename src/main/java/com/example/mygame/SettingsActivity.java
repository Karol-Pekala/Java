package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    Button Pink1, Pink2, Blue1, Blue2;
    Button Green1, Green2, Mint1, Mint2;
    Button Yellow1, Yellow2, Orange1, Orange2;
    Button Main;
    TextView PlayerOne, PlayerTwo;

    public static String OneColor = "#7E7EFF";
    public static String TwoColor = "#FF8FFF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        PlayerOne = (TextView) findViewById(R.id.One);
        PlayerTwo = (TextView) findViewById(R.id.Two);

        PlayerOne.setTextColor(Color.parseColor(OneColor));
        PlayerTwo.setTextColor(Color.parseColor(TwoColor));

        Pink1 = (Button) findViewById(R.id.Pink1);
        Pink1.setOnClickListener(this);
        Pink2 = (Button) findViewById(R.id.Pink2);
        Pink2.setOnClickListener(this);
        Blue1 = (Button) findViewById(R.id.Blue1);
        Blue1.setOnClickListener(this);
        Blue2 = (Button) findViewById(R.id.Blue2);
        Blue2.setOnClickListener(this);
        Green1 = (Button) findViewById(R.id.Green1);
        Green1.setOnClickListener(this);
        Green2 = (Button) findViewById(R.id.Green2);
        Green2.setOnClickListener(this);
        Mint1 = (Button) findViewById(R.id.Mint1);
        Mint1.setOnClickListener(this);
        Mint2 = (Button) findViewById(R.id.Mint2);
        Mint2.setOnClickListener(this);
        Yellow1 = (Button) findViewById(R.id.Yellow1);
        Yellow1.setOnClickListener(this);
        Yellow2 = (Button) findViewById(R.id.Yellow2);
        Yellow2.setOnClickListener(this);
        Orange1 = (Button) findViewById(R.id.Orange1);
        Orange1.setOnClickListener(this);
        Orange2 = (Button) findViewById(R.id.Orange2);
        Orange2.setOnClickListener(this);
        Main = (Button) findViewById(R.id.Main);

        Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }

    @Override
    public void onClick(View v) {
        String ButtonID = v.getResources().getResourceEntryName(v.getId());
        switch (ButtonID){

            case "Pink1": OneColor = "#FF8FFF"; break;
            case "Pink2": TwoColor = "#FF8FFF"; break;
            case "Blue1": OneColor = "#7E7EFF"; break;
            case "Blue2": TwoColor = "#7E7EFF"; break;
            case "Green1": OneColor = "#7ECC7E"; break;
            case "Green2": TwoColor = "#7ECC7E"; break;
            case "Mint1": OneColor = "#7EDDDD"; break;
            case "Mint2": TwoColor = "#7EDDDD"; break;
            case "Yellow1": OneColor = "#FFDD7E"; break;
            case "Yellow2": TwoColor = "#FFDD7E"; break;
            case "Orange1": OneColor = "#FF9977"; break;
            case "Orange2": TwoColor = "#FF9977"; break;
        }
        PlayerOne.setTextColor(Color.parseColor(OneColor));
        PlayerTwo.setTextColor(Color.parseColor(TwoColor));
    }

    public void openMainActivity() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }
}