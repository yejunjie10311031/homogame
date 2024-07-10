package com.yjj.homogame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private ImageButton ib1;
    private ImageButton ib2;
    private ImageView back;
    private Activity main;
    private static MediaPlayer mp;
    int num=0;

    private Handler h1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                back.setImageResource(R.drawable.cp1);
            }
            if(msg.what==2){
                back.setImageResource(R.drawable.p2);
            }
            if(msg.what==3){
                back.setImageResource(R.drawable.p3);
            }
            if(msg.what==4){
                back.setImageResource(R.drawable.p4);
            }
            if(msg.what==5){
                back.setImageResource(R.drawable.p5);
            }
            if(msg.what==6){
                back.setImageResource(R.drawable.p6);
            }
            if(msg.what==7){
                back.setImageResource(R.drawable.p7);
            }
            if(msg.what==8){
                back.setImageResource(R.drawable.p1);
            }
        }
    };

    public void changeimage(){
        new Thread(){
            public void run(){
                while (true){
                    try {
                        Thread.sleep(1500);
                        if(num>=8){
                            num=0;
                        }
                        num++;
                        Message msg=new Message();
                        msg.what=num;
                        h1.sendMessage(msg);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();
    }

    public static void mpstop(){
        mp.stop();
        mp.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        main=this;
        back=findViewById(R.id.back);
        mp=MediaPlayer.create(this,R.raw.m1);
        new Thread(){
            public void run(){
                try {
                    mp.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                while (true){
                    try {

                        Thread.sleep(1500);
                        if(num>=8){
                            num=0;
                        }
                        num++;
                        Message msg=new Message();
                        msg.what=num;
                        h1.sendMessage(msg);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();
        ib1=findViewById(R.id.ib1);
        ib2=findViewById(R.id.ib2);
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert1=new AlertDialog.Builder(MainActivity.this);
                alert1.setTitle("提醒");
                alert1.setMessage("确定要退出游戏吗？");
                alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert1.create();
                alert1.show();
            }
        });
        ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i1);
                finish();
            }
        });
        ib2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity.this, about.class);
                startActivity(i1);
            }
        });
    }
}