package com.yjj.homogame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class jqa2 extends AppCompatActivity {

    private ImageButton jixu;
    private ImageButton choose1;
    private ImageButton choose2;
    private TextView p1;
    private TextView c1p;
    private TextView c2p;
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
    private TimerTask t;
    private Timer timer=new Timer();
    private SharedPreferences sp1;
    private SharedPreferences.Editor editor;

    private void loaddata()
    {
        name=sp1.getString("name","homo");
        jj=sp1.getInt("jj",-1);
        lq=sp1.getInt("lq",-1);
        finish=sp1.getInt("jqa2f",-1);
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jqa2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sp1=getSharedPreferences("config", Context.MODE_PRIVATE);
        num=0;
        enable=0;
        num2=enable;
        jixu=findViewById(R.id.jixu);
        p1=findViewById(R.id.p1);
        c1p=findViewById(R.id.c1p);
        c2p=findViewById(R.id.c2p);
        i1=findViewById(R.id.i1);
        choose1=findViewById(R.id.choose1);
        choose2=findViewById(R.id.choose2);
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
        jixu.setImageResource(R.drawable.jqa20);
        jixu.setEnabled(true);
        jixu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                switch (num) {
                    case 1:
                        jixu.setImageResource(R.drawable.jqa21);
                        waitclick(1);
                        break;
                    case 2: jixu.setImageResource(R.drawable.jqa22);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="“. . . . . .”".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 3: jixu.setImageResource(R.drawable.jqa23);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                Message msg2=new Message();
                                msg1.what=114;
                                msg1.obj="“其实我是从未来穿越来的”".toString();
                                msg2.what=114;
                                msg2.obj="“没错，我是来被你们雷普的”".toString();
                                ch1.sendMessage(msg1);
                                ch2.sendMessage(msg2);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                                choose2.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 4:
                        jixu.setImageResource(R.drawable.jqa24);
                        waitclick(4);
                        break;
                    case 5: jixu.setImageResource(R.drawable.jqa25);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="“为什么24岁了还是学生？”".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 6: jixu.setImageResource(R.drawable.jqa26);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                Message msg2=new Message();
                                msg1.what=114;
                                msg1.obj="“原来如此”".toString();
                                msg2.what=114;
                                msg2.obj="“其实你是不想考吧”".toString();
                                ch1.sendMessage(msg1);
                                ch2.sendMessage(msg2);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                                choose2.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 7: jixu.setImageResource(R.drawable.jqa27);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="“你知道林檎恶魔吗？”".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 8:
                        jixu.setImageResource(R.drawable.jqa28);
                        waitclick(8);
                        break;
                    case 9: jixu.setImageResource(R.drawable.jqa29);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="“那你有听说过淳平这个人吗？”".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 10:
                        jixu.setImageResource(R.drawable.jqa210);
                        waitclick(10);
                        break;
                    case 11:
                        jixu.setImageResource(R.drawable.jqa211);
                        waitclick(11);
                        break;
                    case 12:
                        jixu.setImageResource(R.drawable.jqa212);
                        waitclick(12);
                        break;
                    case 13:
                        jixu.setImageResource(R.drawable.jqa213);
                        waitclick(13);
                        break;
                    case 14: jixu.setImageResource(R.drawable.jqa214);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="跟随田所和远野来到屋顶".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 15:
                        jixu.setImageResource(R.drawable.jqa215);
                        waitclick(15);
                        break;
                    case 16:
                        jixu.setImageResource(R.drawable.jqa216);
                        waitclick(16);
                        break;
                    case 17:
                        jixu.setImageResource(R.drawable.jqa217);
                        waitclick(17);
                        break;
                    case 18:
                        jixu.setImageResource(R.drawable.jqa218);
                        waitclick(18);
                        break;
                    case 19:
                        jixu.setImageResource(R.drawable.jqa219);
                        waitclick(19);
                        break;
                    case 20: jixu.setImageResource(R.drawable.jqa220);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="先辈似乎往红茶里到了一些奇怪的粉末".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 21:
                        jixu.setImageResource(R.drawable.jqa221);
                        waitclick(21);
                        break;
                    case 22: jixu.setImageResource(R.drawable.jqa222);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="远野站起来后突然晕倒".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 23: jixu.setImageResource(R.drawable.jqa223);
                        jixu.setEnabled(false);
                        t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                msg1.what=114;
                                msg1.obj="随后，先辈将晕倒的远野扶回屋内".toString();
                                ch1.sendMessage(msg1);
                                choose1.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                        exitchoose();
                                        jixu.performClick();
                                    }
                                });
                            }
                        };
                        timer.schedule(t,1000);
                        break;
                    case 24:
                        jixu.setImageResource(R.drawable.jqa224);
                        waitclick(24);
                        break;
                    case 25:
                        if(finish!=1){
                            editor = sp1.edit();
                            editor.putInt("jj", jj+1145);
                            editor.putInt("lq", lq+191);
                            editor.putInt("jqa2f", 1);
                            editor.commit();
                            Intent i1=new Intent(jqa2.this, jqfinish.class);
                            startActivity(i1);
                            finish();}
                        else{
                            Intent i1=new Intent(jqa2.this, jqfinished.class);
                            startActivity(i1);
                            finish();
                        }
                        break;
                }
            }
        });
    }
}