package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector.*;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int display_arr [][] = new int[4][4];
    int complete_2048 = 0;
    int image_mode = 1;
    int set_win_at = 64;
    int top = 1,left = 1, right = 1, down = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        display_arr [0][1] = 2;
        display_arr [0][2] = 2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        final TextView grid1 = findViewById(R.id.grid1);
        final TextView grid2 = findViewById(R.id.grid2);
        final TextView grid3 = findViewById(R.id.grid3);
        final TextView grid4 = findViewById(R.id.grid4);
        final TextView grid5 = findViewById(R.id.grid5);
        final TextView grid6 = findViewById(R.id.grid6);
        final TextView grid7 = findViewById(R.id.grid7);
        final TextView grid8 = findViewById(R.id.grid8);
        final TextView grid9 = findViewById(R.id.grid9);
        final TextView grid10 = findViewById(R.id.grid10);
        final TextView grid11 = findViewById(R.id.grid11);
        final TextView grid12 = findViewById(R.id.grid12);
        final TextView grid13 = findViewById(R.id.grid13);
        final TextView grid14 = findViewById(R.id.grid14);
        final TextView grid15 = findViewById(R.id.grid15);
        final TextView grid16 = findViewById(R.id.grid16);
        final TextView header = findViewById(R.id.header);
        final TextView header2 = findViewById(R.id.header2);
        if(image_mode == 1) {
            grid2.setBackgroundResource(R.drawable.img2);
            grid3.setBackgroundResource(R.drawable.img2);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent activity = getIntent();
                startActivity(activity);
            }
        });


        ObjectAnimator movetopdown = ObjectAnimator.ofFloat(header2,"translationY",800);
        movetopdown.setDuration(15000);
        movetopdown.start();

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout constraintLayout = findViewById(R.id.mainback);
                constraintLayout.setBackgroundResource(0);
                grid1.setVisibility(View.VISIBLE);
                grid2.setVisibility(View.VISIBLE);
                grid3.setVisibility(View.VISIBLE);
                grid4.setVisibility(View.VISIBLE);
                grid5.setVisibility(View.VISIBLE);
                grid6.setVisibility(View.VISIBLE);
                grid7.setVisibility(View.VISIBLE);
                grid8.setVisibility(View.VISIBLE);
                grid9.setVisibility(View.VISIBLE);
                grid10.setVisibility(View.VISIBLE);
                grid11.setVisibility(View.VISIBLE);
                grid12.setVisibility(View.VISIBLE);
                grid13.setVisibility(View.VISIBLE);
                grid14.setVisibility(View.VISIBLE);
                grid15.setVisibility(View.VISIBLE);
                grid16.setVisibility(View.VISIBLE);
                header.setVisibility(View.VISIBLE);
                header2.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);

            }
        });



    }

    public int check_game_over(int [] checkarr, String side){
        int checkstat = 0;

        for(int i=0;i<3;i++){
            if(checkarr[i] == 1){
                checkstat = 1;
                break;
            }
        }

        if(checkstat == 0 ){
            if(side.equals("left")){
                left = 0;

            }
            if(side.equals("right")){
                right = 0;
            }
            if(side.equals("top")){
                top = 0;
            }
            if(side.equals("down")){
                down = 0;
            }

            if(left == 0 && right == 0 && top == 0 && down == 0) {
                ImageView wingrid = findViewById(R.id.winheader);
                wingrid.setVisibility(View.VISIBLE);
                wingrid.setBackgroundResource(R.drawable.gameover);
            }

            return 0;
            //wingrid.setText("GAME OVER");
        }
           return 1;
    }

    public void populate_array(){

        final TextView grid1 = findViewById(R.id.grid1);
        final TextView grid2 = findViewById(R.id.grid2);
        final TextView grid3 = findViewById(R.id.grid3);
        final TextView grid4 = findViewById(R.id.grid4);
        final TextView grid5 = findViewById(R.id.grid5);
        final TextView grid6 = findViewById(R.id.grid6);
        final TextView grid7 = findViewById(R.id.grid7);
        final TextView grid8 = findViewById(R.id.grid8);
        final TextView grid9 = findViewById(R.id.grid9);
        final TextView grid10 = findViewById(R.id.grid10);
        final TextView grid11 = findViewById(R.id.grid11);
        final TextView grid12 = findViewById(R.id.grid12);
        final TextView grid13 = findViewById(R.id.grid13);
        final TextView grid14 = findViewById(R.id.grid14);
        final TextView grid15 = findViewById(R.id.grid15);
        final TextView grid16 = findViewById(R.id.grid16);
        final TextView header = findViewById(R.id.header);

        int arr [] = new int[65];

        arr[0] = R.drawable.back2;
        arr[2] = R.drawable.img2;
        arr[4] = R.drawable.img3;
        arr[8] = R.drawable.img1;
        arr[16] = R.drawable.img11;
        arr[32] = R.drawable.img7;
        arr[64] = R.drawable.img10;

       if(image_mode == 1) {
           grid1.setBackgroundResource(arr[display_arr[0][0]]);
           grid2.setBackgroundResource(arr[display_arr[0][1]]);
           grid3.setBackgroundResource(arr[display_arr[0][2]]);
           grid4.setBackgroundResource(arr[display_arr[0][3]]);
           grid5.setBackgroundResource(arr[display_arr[1][0]]);
           grid6.setBackgroundResource(arr[display_arr[1][1]]);
           grid7.setBackgroundResource(arr[display_arr[1][2]]);
           grid8.setBackgroundResource(arr[display_arr[1][3]]);
           grid9.setBackgroundResource(arr[display_arr[2][0]]);
           grid10.setBackgroundResource(arr[display_arr[2][1]]);
           grid11.setBackgroundResource(arr[display_arr[2][2]]);
           grid12.setBackgroundResource(arr[display_arr[2][3]]);
           grid13.setBackgroundResource(arr[display_arr[3][0]]);
           grid14.setBackgroundResource(arr[display_arr[3][1]]);
           grid15.setBackgroundResource(arr[display_arr[3][2]]);
           grid16.setBackgroundResource(arr[display_arr[3][3]]);
       }else {
           grid1.setText("" + display_arr[0][0]);
           grid2.setText("" + display_arr[0][1]);
           grid3.setText("" + display_arr[0][2]);
           grid4.setText("" + display_arr[0][3]);
           grid5.setText("" + display_arr[1][0]);
           grid6.setText("" + display_arr[1][1]);
           grid7.setText("" + display_arr[1][2]);
           grid8.setText("" + display_arr[1][3]);
           grid9.setText("" + display_arr[2][0]);
           grid10.setText("" + display_arr[2][1]);
           grid11.setText("" + display_arr[2][2]);
           grid12.setText("" + display_arr[2][3]);
           grid13.setText("" + display_arr[3][0]);
           grid14.setText("" + display_arr[3][1]);
           grid15.setText("" + display_arr[3][2]);
           grid16.setText("" + display_arr[3][3]);
       }
        if(complete_2048 == 1){
            complete_2048 = 0;
            ImageView wingrid = findViewById(R.id.winheader);
            Button button = findViewById(R.id.button);
            button.setVisibility(View.VISIBLE);
            wingrid.setVisibility(View.VISIBLE);
            ConstraintLayout maingrid = findViewById(R.id.mainback);
            grid1.setVisibility(View.INVISIBLE);
            grid2.setVisibility(View.INVISIBLE);
            grid3.setVisibility(View.INVISIBLE);
            grid4.setVisibility(View.INVISIBLE);
            grid5.setVisibility(View.INVISIBLE);
            grid6.setVisibility(View.INVISIBLE);
            grid7.setVisibility(View.INVISIBLE);
            grid8.setVisibility(View.INVISIBLE);
            grid9.setVisibility(View.INVISIBLE);
            grid10.setVisibility(View.INVISIBLE);
            grid11.setVisibility(View.INVISIBLE);
            grid12.setVisibility(View.INVISIBLE);
            grid13.setVisibility(View.INVISIBLE);
            grid14.setVisibility(View.INVISIBLE);
            grid15.setVisibility(View.INVISIBLE);
            grid16.setVisibility(View.INVISIBLE);
            header.setVisibility(View.INVISIBLE);
            maingrid.setBackgroundResource(R.drawable.win);
            wingrid.setBackgroundResource(R.drawable.win1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    float x1 ;
    float y1 ;
    float x2 ;
    float y2 ;


    @Override
    public boolean onTouchEvent(MotionEvent event){

        TextView header = findViewById(R.id.header);

        switch(event.getAction()) {
            case (MotionEvent.ACTION_DOWN): {
                    x1 = event.getX();
                    y1 = event.getY();
                    break;
            }
            case (MotionEvent.ACTION_UP) : {

                x2 = event.getX();
                y2 = event.getY();

                if (x1 < x2 && (Math.abs(x2-x1) > Math.abs(y2-y1)))
                {

                    int check_spot [] = new int [4];
                    for(int i=0;i<4;i++){
                        for(int j=0;j<3;j++){
                            if(display_arr[i][j] == display_arr[i][j+1]){
                                display_arr[i][j+1] = display_arr[i][j+1]*2;
                                if(display_arr[i][j+1] == set_win_at){
                                    complete_2048 = 1;
                                }
                                display_arr[i][j] = 0;

                            }else{
                                if(display_arr[i][j+1] == 0){
                                    display_arr[i][j+1] = display_arr[i][j];

                                    int k =0;
                                    for(k = j;k>0;k--){
                                        display_arr[i][k] =  display_arr[i][k-1];
                                    }
                                    display_arr[i][k] = 0;

                                }
                            }
                        }
                    }
                    if(display_arr[0][0] == 0){
                        check_spot[0] = 1;
                    }

                    if(display_arr[1][0] == 0){
                        check_spot[1] = 1;
                    }

                    if(display_arr[2][0] == 0){
                        check_spot[2] = 1;
                    }

                    if(display_arr[3][0] == 0){
                        check_spot[3] = 1;
                    }

                    int val = check_game_over(check_spot,"right");
                    if(val == 1) {
                        while (true) {
                            int randm = new Random().nextInt(4);
                            if (check_spot[randm] == 1) {
                                display_arr[randm][0] = 2;
                                break;
                            }
                        }
                    }
                    populate_array();
                    break;
                }

                if (x1 > x2 && (Math.abs(x2-x1) > Math.abs(y2-y1)))
                {

                    int check_spot [] = new int [4];
                    for(int i=0;i<4;i++){
                        for(int j=3;j>0;j--){
                            if(display_arr[i][j] == display_arr[i][j-1]){
                                display_arr[i][j-1] = display_arr[i][j-1]*2;
                                if(display_arr[i][j-1] == set_win_at){
                                    complete_2048 = 1;
                                }
                                display_arr[i][j] = 0;
                            }else{
                                if(display_arr[i][j-1] == 0){
                                    display_arr[i][j-1] = display_arr[i][j];
                                    int k =0;
                                    for(k = j;k<3;k++){
                                        display_arr[i][k] =  display_arr[i][k+1];
                                    }
                                    display_arr[i][k] = 0;
                                }
                            }
                        }
                    }
                    if(display_arr[0][3] == 0){
                        check_spot[0] = 1;
                    }

                    if(display_arr[1][3] == 0){
                        check_spot[1] = 1;
                    }

                    if(display_arr[2][3] == 0){
                        check_spot[2] = 1;
                    }

                    if(display_arr[3][3] == 0){
                        check_spot[3] = 1;
                    }


                    int val = check_game_over(check_spot,"left");
                    if(val == 1) {
                        while (true) {
                            int randm = new Random().nextInt(4);
                            if (check_spot[randm] == 1) {
                                display_arr[randm][3] = 2;
                                break;
                            }
                        }
                    }
                    populate_array();

                    break;
                }

                if (y1 < y2 && (Math.abs(x2-x1) < Math.abs(y2-y1)))
                {

                    int check_spot [] = new int [4];
                    for(int i=0;i<4;i++){
                        for(int j=0;j<3;j++){
                            if(display_arr[j][i] == display_arr[j+1][i]){
                                display_arr[j+1][i] = display_arr[j+1][i]*2;
                                if(display_arr[j+1][i] == set_win_at){
                                    complete_2048 = 1;
                                }
                                display_arr[j][i] = 0;
                            }else{
                                if(display_arr[j+1][i] == 0){
                                    display_arr[j+1][i] = display_arr[j][i];

                                    int k =0;
                                    for(k = j;k>0;k--){
                                        display_arr[k][i] =  display_arr[k-1][i];
                                    }
                                    display_arr[k][i] = 0;
                                }
                            }
                        }
                    }
                    if(display_arr[0][0] == 0){
                        check_spot[0] = 1;
                    }

                    if(display_arr[0][1] == 0){
                        check_spot[1] = 1;
                    }

                    if(display_arr[0][2] == 0){
                        check_spot[2] = 1;
                    }

                    if(display_arr[0][3] == 0){
                        check_spot[3] = 1;
                    }

                    int val = check_game_over(check_spot,"top");
                    if(val == 1) {
                        while (true) {
                            int randm = new Random().nextInt(4);
                            if (check_spot[randm] == 1) {
                                display_arr[0][randm] = 2;
                                break;
                            }
                        }
                    }
                    populate_array();
                    break;
                }

                if (y1 > y2 && (Math.abs(x2-x1) < Math.abs(y2-y1)))
                {

                    int check_spot [] = new int [4];
                    for(int i=0;i<4;i++){
                        for(int j=3;j>0;j--){
                            if(display_arr[j][i] == display_arr[j-1][i]){
                                display_arr[j-1][i] = display_arr[j-1][i]*2;
                                if(display_arr[j-1][i] == set_win_at){
                                    complete_2048 = 1;
                                }
                                display_arr[j][i] = 0;
                            }else{
                                if(display_arr[j-1][i] == 0){
                                    display_arr[j-1][i] = display_arr[j][i];
                                    int k =0;
                                    for(k = j;k<3;k++){
                                        display_arr[k][i] =  display_arr[k+1][i];
                                    }
                                    display_arr[k][i] = 0;
                                }
                            }
                        }
                    }
                    if(display_arr[3][0] == 0){
                        check_spot[0] = 1;
                    }

                    if(display_arr[3][1] == 0){
                        check_spot[1] = 1;
                    }

                    if(display_arr[3][2] == 0){
                        check_spot[2] = 1;
                    }

                    if(display_arr[3][3] == 0){
                        check_spot[3] = 1;
                    }

                    int val = check_game_over(check_spot,"down");
                    if(val == 1) {
                        while (true) {
                            int randm = new Random().nextInt(4);
                            if (check_spot[randm] == 1) {
                                display_arr[3][randm] = 2;
                                break;
                            }
                        }
                    }
                    populate_array();
                    break;
                }

            }

         }
      return false;
    }

}
