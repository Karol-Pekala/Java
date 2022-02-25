package com.example.slideviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;




public class ViewerActivity extends AppCompatActivity {

    private ImageView iv_display;
    private Button btn_right, btn_left, menu;
    private int current_image_index;
    private TextView txt1, txt2, txt3, txt4, title;
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    private String[][] Descriptions = {{"Srodowiskiem umozliwiającym tworzenie","aplikacji na Platformę Android jest","Android Studio. Pakietem związanym z tą","platforma jest android.app."},
            {"Servlet jest to klasa Javy działająca po","stronie serwera WWW w modelu żąd-odp,","rozszerzająca jego możliwości. Pakietem"," związanym z servletami jest javax.servlet."},
            {"Swing jest biblioteką graficzną,","ulepszoną wersją biblioteki AWT (The","Abstract Window Toolkit). Jej pakietem","jest javax.swing."},
            {"JavaFX – rodzina technologii i produktów","firmy Sun Microsystems. W skład JavaFX","wchodzi język skryptowy JavaFX Script.","Powiązana jest z nim Technologia FXML."},
            {"Technologia JTA (Java Transaction API)","umożliwia dokonywanie transakcji między","rożnymi zasobami w środowisku Java.",""}};
    private String[] Titles = {"Android Studio", "Servlety", "Java Swing", "JavaFX", "Java Transaction API"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        txt1 = (TextView)findViewById(R.id.txtFile1);
        txt2 = (TextView)findViewById(R.id.txtFile2);
        txt3 = (TextView)findViewById(R.id.txtFile3);
        txt4 = (TextView)findViewById(R.id.txtFile4);
        title = (TextView)findViewById(R.id.TextTitle);
        DisplayImage();
        DisplayText(0);
        SwitchButton();
    }
    void DisplayImage(){
        iv_display = (ImageView)findViewById(R.id.iv_display);
    }
    void SwitchButton(){
        btn_right = (Button)findViewById(R.id.btn_right);
        btn_left = (Button)findViewById(R.id.btn_left);
        menu = (Button)findViewById(R.id.menu);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index++;
                current_image_index = current_image_index % images.length;
                iv_display.setImageResource(images[current_image_index]);
                DisplayText(current_image_index);
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index--;
                if(current_image_index < 0){
                    current_image_index = images.length - 1;
                }
                iv_display.setImageResource(images[current_image_index]);
                DisplayText(current_image_index);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openMainActivity();}
        });
    }

    public void openMainActivity() {
        Intent MainIntent = new Intent(this, MainActivity.class);
        startActivity(MainIntent);
    }

    void DisplayText(int index) {
        txt1.setText(Descriptions[index][0]);
        txt2.setText(Descriptions[index][1]);
        txt3.setText(Descriptions[index][2]);
        txt4.setText(Descriptions[index][3]);
        title.setText(Titles[index]);
    }
}