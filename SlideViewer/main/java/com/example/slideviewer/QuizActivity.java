package com.example.slideviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
    TextView tv1,tv2;
    RadioButton a,b,c,d;
    Button btn, menu;
    RadioGroup rg;
    int qnumber,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tv1=(TextView)findViewById(R.id.question);
        tv2=(TextView)findViewById(R.id.response);
        rg=(RadioGroup)findViewById(R.id.optionGroup);
        a=(RadioButton)findViewById(R.id.option1);
        b=(RadioButton)findViewById(R.id.option2);
        c=(RadioButton)findViewById(R.id.option3);
        d=(RadioButton)findViewById(R.id.option4);
        btn=(Button)findViewById(R.id.next);
        menu=(Button)findViewById(R.id.menu);
        qnumber=0;
        score=0;
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openMainActivity();}
        });
    }

    public void openMainActivity() {
        Intent MainIntent = new Intent(this, MainActivity.class);
        startActivity(MainIntent);
    }
    public void quiz(View v){
        switch (qnumber){
            case 0:
            {
                rg.setVisibility(View.VISIBLE);
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                tv2.setText("");
                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                d.setEnabled(true);
                btn.setText("Next");
                score=0;
                tv1.setText("1. Pakiet biblioteki Swing ?");
                a.setText("java.swing");
                b.setText("java.awt");
                c.setText("javax.swing");
                d.setText("javax.awt");
                qnumber=1;
                break;
            }
            case 1:
            {
                tv1.setText("2. Która technologia jest związana z JavaFX ?");
                a.setText("JSP");
                b.setText("FXML");
                c.setText("JSF");
                d.setText("EJB");
                if (c.isChecked()){
                    score=score+1;
                    Toast.makeText(getApplicationContext(),"Gratulacje!",
                            Toast.LENGTH_SHORT).show();
                }
                qnumber=2;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                break;
            }
            case 2:
            {
                tv1.setText("3. Który pakiet związany jest z serwletami ?");
                a.setText("javax.servlet");
                b.setText("java.servlet");
                c.setText("javaee.servlet");
                d.setText("javae.servlet");
                if (b.isChecked()){
                    score=score+1;
                    Toast.makeText(getApplicationContext(),"Swietnie!",
                            Toast.LENGTH_SHORT).show();
                }
                qnumber=3;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                break;
            }
            case 3:
            {
                tv1.setText("4. Który pakiet związany jest z platformą Android ?");
                a.setText("javax.android");
                b.setText("java.android");
                c.setText("android.java");
                d.setText("android.app");
                if (a.isChecked()){
                    score=score+1;
                    Toast.makeText(getApplicationContext(),"Dobra robota!",
                            Toast.LENGTH_SHORT).show();
                }
                qnumber=4;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                break;
            }
            case 4:
            {
                tv1.setText("5. Która technologia jest bezpośrednio związana z obsługą transakcji ?");
                a.setText("JDBC");
                b.setText("EJB");
                c.setText("JTA");
                d.setText("JPA");
                if (d.isChecked()){
                    score=score+1;
                    Toast.makeText(getApplicationContext(),"Bravo!",
                            Toast.LENGTH_SHORT).show();
                }
                qnumber=5;
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                btn.setText("Finish");
                break;
            }
            case 5:
            {
                if (c.isChecked()){
                    score=score+1;
                    Toast.makeText(getApplicationContext(),"Dobra robota!",
                            Toast.LENGTH_SHORT).show();
                }
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                rg.clearCheck();
                rg.setVisibility(View.INVISIBLE);
                tv1.setText("");
                tv2.setText("Wynik testu: " + score + "/5");
                btn.setText("Restart");
                qnumber=0;
                break;
            }
        }
    }
}