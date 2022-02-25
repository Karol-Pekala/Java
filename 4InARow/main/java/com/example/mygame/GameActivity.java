package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView PlayerOneScore, PlayerTwoScore, PlayerOne, PlayerTwo;
    Button[] AddButtons = new Button[7];
    Button[][] Fields = {new Button[7], new Button[7], new Button[7], new Button[7], new Button[7]};
    private Button Restart, MainMenu, Settings;

    int[][] Board = {{2,2,2,2,2,2,2},{2,2,2,2,2,2,2},{2,2,2,2,2,2,2},{2,2,2,2,2,2,2},{2,2,2,2,2,2,2}};
    int[][] WinningPosition = {{0,0},{0,0},{0,0},{0,0}};

    String PlayerOneColor = SettingsActivity.OneColor;
    String PlayerTwoColor = SettingsActivity.TwoColor;
    private int PlayerOnePoints, PlayerTwoPoints;
    boolean ActivePlayer;   // = false (Player One) or
                            // = true (Player Two)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        PlayerOneScore = (TextView) findViewById(R.id.PlayerOneScore);
        PlayerTwoScore = (TextView) findViewById(R.id.PlayerTwoScore);
        PlayerOne = (TextView) findViewById(R.id.PlayerOne);
        PlayerTwo = (TextView) findViewById(R.id.PlayerTwo);

        Restart = (Button) findViewById(R.id.Restart);
        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restart();
            }
        });
        MainMenu = (Button) findViewById(R.id.Main);
        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
        Settings = (Button) findViewById(R.id.Settings);
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  openSettingsActivity();
            }
        });


        AddButtons[0] = (Button) findViewById(R.id.add0);
        AddButtons[0].setOnClickListener(this);
        AddButtons[1] = (Button) findViewById(R.id.add1);
        AddButtons[1].setOnClickListener(this);
        AddButtons[2] = (Button) findViewById(R.id.add2);
        AddButtons[2].setOnClickListener(this);
        AddButtons[3] = (Button) findViewById(R.id.add3);
        AddButtons[3].setOnClickListener(this);
        AddButtons[4] = (Button) findViewById(R.id.add4);
        AddButtons[4].setOnClickListener(this);
        AddButtons[5] = (Button) findViewById(R.id.add5);
        AddButtons[5].setOnClickListener(this);
        AddButtons[6] = (Button) findViewById(R.id.add6);
        AddButtons[6].setOnClickListener(this);

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 8; j++){
                String ButtonID = "b" + i + j;
                int resourceID = getResources().getIdentifier(ButtonID, "id", getPackageName());
                Fields[i-1][j-1] = (Button) findViewById(resourceID);
            }
        }

        PlayerOnePoints = 0;
        PlayerTwoPoints = 0;
        ActivePlayer = true;
        ChangePlayer(PlayerOneColor);
        PlayerOneScore.setTextColor(Color.parseColor(PlayerOneColor));
        PlayerTwoScore.setTextColor(Color.parseColor(PlayerTwoColor));
        PlayerOne.setTextColor(Color.parseColor(PlayerOneColor));
        PlayerTwo.setTextColor(Color.parseColor(PlayerTwoColor));
    }



    @Override
    public void onClick(View v) {
        String ButtonID = v.getResources().getResourceEntryName(v.getId());
        int ColumnNumber = Integer.parseInt(ButtonID.substring(ButtonID.length()-1, ButtonID.length()));
        int RowNumber = 0;
        if (Board[4][ColumnNumber]!=2) return;
        if (ActivePlayer){
            if (Board[0][ColumnNumber]==2){
                Board[0][ColumnNumber] = 1;
                Fields[0][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerTwoColor));
                RowNumber = 0;
            }
            else if (Board[1][ColumnNumber]==2){
                Board[1][ColumnNumber] = 1;
                Fields[1][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerTwoColor));
                RowNumber = 1;
            }
            else if (Board[2][ColumnNumber]==2){
                Board[2][ColumnNumber] = 1;
                Fields[2][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerTwoColor));
                RowNumber = 2;
            }
            else if (Board[3][ColumnNumber]==2){
                Board[3][ColumnNumber] = 1;
                Fields[3][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerTwoColor));
                RowNumber = 3;
            }
            else {
                Board[4][ColumnNumber] = 1;
                Fields[4][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerTwoColor));
                RowNumber = 4;
            }
            if (WinningColumns(RowNumber, ColumnNumber) || WinningRows(RowNumber, ColumnNumber) || WinningCrosses(RowNumber, ColumnNumber)){
                PlayerTwoPoints++;
                PlayerTwoScore.setText(Integer.toString(PlayerTwoPoints));
                HighlightWinningPosition(WinningPosition);
            }
            ChangePlayer(PlayerOneColor);
        }
        else {
            if (Board[0][ColumnNumber]==2){
                Board[0][ColumnNumber] = 0;
                Fields[0][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerOneColor));
                RowNumber = 0;
            }
            else if (Board[1][ColumnNumber]==2){
                Board[1][ColumnNumber] = 0;
                Fields[1][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerOneColor));
                RowNumber = 1;
            }
            else if (Board[2][ColumnNumber]==2){
                Board[2][ColumnNumber] = 0;
                Fields[2][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerOneColor));
                RowNumber = 2;
            }
            else if (Board[3][ColumnNumber]==2){
                Board[3][ColumnNumber] = 0;
                Fields[3][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerOneColor));
                RowNumber = 3;
            }
            else {
                Board[4][ColumnNumber] = 0;
                Fields[4][ColumnNumber].setBackgroundColor(Color.parseColor(PlayerOneColor));
                RowNumber = 4;
            }
            if (WinningColumns(RowNumber, ColumnNumber) || WinningRows(RowNumber, ColumnNumber) || WinningCrosses(RowNumber, ColumnNumber)){
                PlayerOnePoints++;
                PlayerOneScore.setText(Integer.toString(PlayerOnePoints));
                HighlightWinningPosition(WinningPosition);
            }
            ChangePlayer(PlayerTwoColor);
        }
    }

    public boolean WinningColumns (int r, int c) {
    if (Board[1][c]==Board[r][c] && Board[2][c]==Board[r][c] && Board[3][c]==Board[r][c] && Board[4][c]==Board[r][c]){
        WinningPosition = new int[][]{{1,c},{2,c},{3,c},{4,c}};
        return true;
    }
    else if (Board[1][c]==Board[r][c] && Board[2][c]==Board[r][c] && Board[3][c]==Board[r][c] && Board[0][c]==Board[r][c]){
        WinningPosition = new int[][]{{1,c},{2,c},{3,c},{0,c}};
        return true;
    }
    else return false;
    }

    public boolean WinningRows (int r, int c) {
        if (Board[r][0]==Board[r][c] && Board[r][1]==Board[r][c] && Board[r][2]==Board[r][c] && Board[r][3]==Board[r][c]){
            WinningPosition = new int[][]{{r,0},{r,1},{r,2},{r,3}};
            return true;
        }
        else if (Board[r][4]==Board[r][c] && Board[r][1]==Board[r][c] && Board[r][2]==Board[r][c] && Board[r][3]==Board[r][c]){
            WinningPosition = new int[][]{{r,4},{r,1},{r,2},{r,3}};
            return true;
        }
        else if (Board[r][4]==Board[r][c] && Board[r][5]==Board[r][c] && Board[r][2]==Board[r][c] && Board[r][3]==Board[r][c]){
            WinningPosition = new int[][]{{r,4},{r,5},{r,2},{r,3}};
            return true;
        }
        else if (Board[r][4]==Board[r][c] && Board[r][5]==Board[r][c] && Board[r][6]==Board[r][c] && Board[r][3]==Board[r][c]){
            WinningPosition = new int[][]{{r,4},{r,5},{r,6},{r,3}};
            return true;
        }
        else return false;
    }

    public boolean WinningCrosses (int r, int c){
        int Crosses[][][] = {{{0,0},{1,1},{2,2},{3,3}}, {{0,1},{1,2},{2,3},{3,4}}, {{0,2},{1,3},{2,4},{3,5}}, {{0,3},{1,4},{2,5},{3,6}}, {{0,3},{1,2},{2,1},{3,0}}, {{0,4},{1,3},{2,2},{3,1}}, {{0,5},{1,4},{2,3},{3,2}}, {{0,6},{1,5},{2,4},{3,3}}};
        for(int i = 0; i < 8; i++){
            if (Board[Crosses[i][0][0]][Crosses[i][0][1]]==Board[r][c] && Board[Crosses[i][1][0]][Crosses[i][1][1]]==Board[r][c] && Board[Crosses[i][2][0]][Crosses[i][2][1]]==Board[r][c] && Board[Crosses[i][3][0]][Crosses[i][3][1]]==Board[r][c]){
                WinningPosition = Crosses[i];
                return true;
            }
            else if (Board[Crosses[i][0][0]+1][Crosses[i][0][1]]==Board[r][c] && Board[Crosses[i][1][0]+1][Crosses[i][1][1]]==Board[r][c] && Board[Crosses[i][2][0]+1][Crosses[i][2][1]]==Board[r][c] && Board[Crosses[i][3][0]+1][Crosses[i][3][1]]==Board[r][c]){
                WinningPosition = Crosses[i];
                return true;
            }
        }
        return false;
    }

    public void Restart(){
        ChangePlayer(PlayerOneColor);
        ActivePlayer = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++){
                Fields[i][j].setBackgroundColor(Color.parseColor("#7E7E7E"));
                Board[i][j] = 2;
            }
        }
        for(int i = 0; i < 7; i++){
            AddButtons[i].setClickable(true);
        }
    }

    public void HighlightWinningPosition(int[][] WinPos) {
        for(int i = 0; i < 4; i++){
            Fields[WinPos[i][0]][WinPos[i][1]].setBackgroundColor(Color.parseColor("#111111"));
        }
        for(int i = 0; i < 7; i++){
            AddButtons[i].setClickable(false);
        }
    }

    public void ChangePlayer(String color){
        ActivePlayer=!ActivePlayer;
        for(int i = 0; i < 7; i++){
            AddButtons[i].setBackgroundColor(Color.parseColor(color));
        }
    }

    public void openMainActivity() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    private void openSettingsActivity() {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }
}
