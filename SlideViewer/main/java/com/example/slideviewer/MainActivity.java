package com.example.slideviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.Btn1);
        btn2 = (Button) findViewById(R.id.Btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewerActivity();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuizActivity();
            }
        });
    }

    public void openViewerActivity() {
        Intent ViewIntent = new Intent(this, ViewerActivity.class);
        startActivity(ViewIntent);
    }
    public void openQuizActivity() {
        Intent QuizIntent = new Intent(this, QuizActivity.class);
        startActivity(QuizIntent);
    }
}