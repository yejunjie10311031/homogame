package com.yjj.homogame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class jqa3 extends AppCompatActivity {

    private Button back;
    private ImageButton jixu;
    private ImageButton choose1;
    private ImageButton choose2;
    private TextView p1;
    private TextView c1p;
    private TextView c2p;
    private TextView tishi;
    private ImageView i1;
    private int num;
    private int enable;
    private int jj;
    private int lq;
    private int finish;
    private String name;
    RelativeLayout.LayoutParams c1;
    RelativeLayout.LayoutParams c2;
    RelativeLayout.LayoutParams c3;
    RelativeLayout.LayoutParams c4;
    private int num2;
    private static MediaPlayer jqa1mp;
    private TimerTask t;
    private Timer timer=new Timer();
    private SharedPreferences sp1;
    private SharedPreferences.Editor editor;

    private void loaddata()
    {
        name=sp1.getString("name","homo");
        jj=sp1.getInt("jj",-1);
        lq=sp1.getInt("lq",-1);
        finish=sp1.getInt("jqa3f",-1);
    }

    private Handler h1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what!=0){
                jixu.setEnabled(true);
            }
        }
    };

    private Handler ch1=new Handler(){
        @Override
        public void handleMessage(Message msg1) {
            choose1.setImageResource(R.drawable.white);
            c1 = new RelativeLayout.LayoutParams(1500, 200);
            c1.leftMargin = 480;
            c1.topMargin = 220;
            c1.addRule(RelativeLayout.CENTER_HORIZONTAL);
            choose1.setLayoutParams(c1);
            c3=(RelativeLayout.LayoutParams) c1p.getLayoutParams();
            c3.leftMargin=720;
            c3.topMargin=270;
            c3.addRule(RelativeLayout.CENTER_HORIZONTAL);
            c1p.setText((String)msg1.obj);
            c1p.setTextSize(20);
            c1p.setLayoutParams(c3);
            tishi.setText("请选择");
        }
    };

    private Handler ch2=new Handler(){
        @Override
        public void handleMessage(Message msg2) {
            choose2.setImageResource(R.drawable.white);
            c2 = new RelativeLayout.LayoutParams(1500, 200);
            c2.leftMargin = 480;
            c2.topMargin = 440;
            c2.addRule(RelativeLayout.CENTER_HORIZONTAL);
            choose2.setLayoutParams(c2);
            c4=(RelativeLayout.LayoutParams) c2p.getLayoutParams();
            c4.leftMargin=720;
            c4.topMargin=490;
            c4.addRule(RelativeLayout.CENTER_HORIZONTAL);
            c2p.setText((String)msg2.obj);
            c2p.setTextSize(20);
            c2p.setLayoutParams(c4);
            tishi.setText("请选择");
        }
    };

    private void waitclick(int temp){
        jixu.setEnabled(false);
        t=new TimerTask() {
            @Override
            public void run() {
                Message msg=new Message();
                msg.what=temp;
                h1.sendMessage(msg);
            }
        };
        timer.schedule(t,1200);
    }

    private void exitchoose(){
        choose1.setImageResource(R.drawable.none);
        c1 = new RelativeLayout.LayoutParams(0, 0);
        c1.leftMargin = 0;
        c1.topMargin = 0;
        c1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        choose1.setLayoutParams(c1);
        c3=(RelativeLayout.LayoutParams) c1p.getLayoutParams();
        c3.leftMargin=0;
        c3.topMargin=0;
        c3.addRule(RelativeLayout.CENTER_HORIZONTAL);
        c1p.setText("");
        c1p.setTextSize(0);
        c1p.setLayoutParams(c3);
        choose2.setImageResource(R.drawable.none);
        c2 = new RelativeLayout.LayoutParams(0, 0);
        c2.leftMargin = 0;
        c2.topMargin = 0;
        c2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        choose2.setLayoutParams(c2);
        c4=(RelativeLayout.LayoutParams) c2p.getLayoutParams();
        c4.leftMargin=0;
        c4.topMargin=0;
        c4.addRule(RelativeLayout.CENTER_HORIZONTAL);
        c2p.setText("");
        c2p.setTextSize(0);
        c2p.setLayoutParams(c4);
        tishi.setText("点击屏幕任意位置以继续");
    }

    public static void mpstop(){
        jqa1mp.stop();
        jqa1mp.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jqa3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sp1 = getSharedPreferences("config", Context.MODE_PRIVATE);
        num = 0;
        enable = 0;
        num2 = enable;
        back = findViewById(R.id.back);
        jixu = findViewById(R.id.jixu);
        p1 = findViewById(R.id.p1);
        c1p = findViewById(R.id.c1p);
        c2p = findViewById(R.id.c2p);
        tishi = findViewById(R.id.tishi);
        i1 = findViewById(R.id.i1);
        choose1 = findViewById(R.id.choose1);
        choose2 = findViewById(R.id.choose2);
        loaddata();
        choose1.setImageResource(R.drawable.none);
        choose2.setImageResource(R.drawable.none);
        c1 = new RelativeLayout.LayoutParams(0, 0);
        c1.leftMargin = 0;
        c1.topMargin = 0;
        choose1.setLayoutParams(c1);
        c2 = new RelativeLayout.LayoutParams(0, 0);
        c2.leftMargin = 0;
        c2.topMargin = 0;
        choose2.setLayoutParams(c2);
        jixu.setImageResource(R.drawable.jqa31);
        jixu.setEnabled(true);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert1 = new AlertDialog.Builder(jqa3.this);
                alert1.setTitle("确定要退出该剧情吗？");
                alert1.setMessage("你将失去已保存的进度");
                alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            mpstop();
                        } catch (Exception e) {
                        }
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
        jixu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                switch (num) {
                    case 1:
                        jixu.setImageResource(R.drawable.jqa32);
                        waitclick(1);
                        break;
                    case 2:
                        jixu.setImageResource(R.drawable.jqa33);
                        waitclick(2);
                        break;
                    case 3:
                        jixu.setImageResource(R.drawable.jqa34);
                        waitclick(3);
                        break;
                    case 4:
                        jixu.setImageResource(R.drawable.jqa35);
                        waitclick(4);
                        break;
                    case 5:
                        jixu.setImageResource(R.drawable.jqa36);
                        waitclick(5);
                        break;
                    case 6:
                        jixu.setImageResource(R.drawable.jqa37);
                        waitclick(6);
                        break;
                    case 7:
                        jixu.setImageResource(R.drawable.jqa38);
                        waitclick(7);
                        break;
                    case 8:
                        jixu.setImageResource(R.drawable.jqa39);
                        waitclick(8);
                        break;
                    case 9:
                        jixu.setImageResource(R.drawable.jqa310);
                        waitclick(9);
                        break;
                    case 10:
                        jixu.setImageResource(R.drawable.jqa311);
                        waitclick(10);
                        break;
                    case 11:
                        jixu.setImageResource(R.drawable.jqa312);
                        waitclick(11);
                        break;
                    case 12:
                        jixu.setImageResource(R.drawable.jqa313);
                        waitclick(12);
                        break;
                    case 13:
                        jixu.setImageResource(R.drawable.jqa314);
                        waitclick(13);
                        break;
                    case 14:
                        jixu.setImageResource(R.drawable.jqa315);
                        waitclick(14);
                        break;
                    case 15:
                        jixu.setImageResource(R.drawable.jqa316);
                        waitclick(15);
                        break;
                    case 16:
                        if(finish!=1){
                            editor = sp1.edit();
                            editor.putInt("jj", jj+1145);
                            editor.putInt("lq", lq+191);
                            editor.putInt("jqa3f", 1);
                            editor.commit();
                            Intent i1=new Intent(jqa3.this, jqfinish.class);
                            startActivity(i1);
                            finish();}
                        else{
                            Intent i1=new Intent(jqa3.this, jqfinished.class);
                            startActivity(i1);
                            finish();
                        }
                        break;
                }
            }
        });
    }
}