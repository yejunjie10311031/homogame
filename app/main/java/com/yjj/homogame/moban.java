package com.yjj.homogame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
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

public class moban extends AppCompatActivity {

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
        finish=sp1.getInt("jqa1f",-1);
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
        setContentView(R.layout.moban);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try {
            MainActivity.mpstop();
        } catch (Exception e) {
        }
        sp1=getSharedPreferences("config", Context.MODE_PRIVATE);
        num=0;
        enable=0;
        num2=enable;
        back=findViewById(R.id.back);
        jixu=findViewById(R.id.jixu);
        p1=findViewById(R.id.p1);
        c1p=findViewById(R.id.c1p);
        c2p=findViewById(R.id.c2p);
        tishi=findViewById(R.id.tishi);
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
        jixu.setImageResource(R.drawable.black);
        jixu.setEnabled(true);
        RelativeLayout.LayoutParams layout=(RelativeLayout.LayoutParams) p1.getLayoutParams();
        layout.leftMargin=550;
        layout.topMargin=300;
        p1.setText("你是一位经历了十个甚至九个世界的旅行者\n"+"你来到了一个名为下北泽的世界\n"+"你和木毛们快乐地生活了一段时间\n"+"直到有一天，林檎恶魔降临于这个世界......");
        p1.setTextColor(Color.parseColor("#ffffff"));
        p1.setTextSize(30);
        p1.setLayoutParams(layout);
        jqa1mp=MediaPlayer.create(this,R.raw.m1);
        jqa1mp.start();
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert1=new AlertDialog.Builder(moban.this);
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
        jixu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num++;
                    switch (num) {
                        case 1:
                            p1.setText("巨大的林檎恶魔摧毁了木毛们的城市\n" + "木毛们与林檎恶魔浴雪奋战\n" + "可一切都是徒劳");
                            waitclick(1);
                            break;
                        case 2:
                            p1.setText("");
                            jixu.setImageResource(R.drawable.jqa2);
                            waitclick(2);
                            break;
                        case 3:
                            i1.setImageResource(R.drawable.chat);
                            RelativeLayout.LayoutParams l1 = new RelativeLayout.LayoutParams(2000, 500);
                            l1.leftMargin = 280;
                            l1.topMargin = 50;
                            i1.setLayoutParams(l1);
                            layout.leftMargin = 950;
                            layout.topMargin = 180;
                            p1.setText("德川君，已经结束力");
                            p1.setTextColor(Color.parseColor("#000000"));
                            p1.setTextSize(20);
                            p1.setLayoutParams(layout);
                            waitclick(6);
                            break;
                        case 4:
                            i1.setImageResource(R.drawable.none);
                            p1.setText("");
                            jixu.setImageResource(R.drawable.jqa3);
                            waitclick(4);
                            break;
                        case 5:
                            jixu.setImageResource(R.drawable.jqa4);
                            waitclick(5);
                            break;
                        case 6:
                            jixu.setImageResource(R.drawable.jqa5);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
                                    msg1.what=114;
                                    msg1.obj="“淳平，我不会让你的计划得逞的！”".toString();
                                    msg2.what=114;
                                    msg2.obj="“淳平，我会打败你！”".toString();
                                    ch1.sendMessage(msg1);
                                    ch2.sendMessage(msg2);
                                    choose1.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            exitchoose();
                                            jixu.setImageResource(R.drawable.jqa6);
                                            waitclick(6);
                                        }
                                    });
                                    choose2.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            exitchoose();
                                            jixu.setImageResource(R.drawable.jqa6);
                                            waitclick(6);
                                        }
                                    });
                                }
                            };
                            timer.schedule(t,1000);
                            break;
                        case 7: jixu.setImageResource(R.drawable.jqa7);
                            waitclick(7);
                            break;
                        case 8: jixu.setImageResource(R.drawable.jqa8);
                            waitclick(8);
                            break;
                        case 9: jixu.setImageResource(R.drawable.jqa8_2);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
                                    msg1.what=114;
                                    msg1.obj="“因为我还有想保护的homo”".toString();
                                    msg2.what=114;
                                    msg2.obj="“因为我不想食雪”".toString();
                                    ch1.sendMessage(msg1);
                                    ch2.sendMessage(msg2);
                                    choose1.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            exitchoose();
                                            jixu.setImageResource(R.drawable.jqa9);
                                            waitclick(6);
                                        }
                                    });
                                    choose2.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            exitchoose();
                                            jixu.setImageResource(R.drawable.jqa9);
                                            waitclick(6);
                                        }
                                    });
                                }
                            };
                            timer.schedule(t,1000);
                            break;
                        case 10: jixu.setImageResource(R.drawable.jqa10);
                            waitclick(10);
                            break;
                        case 11: jixu.setImageResource(R.drawable.jqa11);
                            waitclick(11);
                            break;
                        case 12: jixu.setImageResource(R.drawable.jqa12);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
                                    msg1.what=114;
                                    msg1.obj="“你是......?”".toString();
                                    msg2.what=114;
                                    msg2.obj="“别过来！”".toString();
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
                        case 13: jixu.setImageResource(R.drawable.jqa13);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    msg1.what=114;
                                    msg1.obj="“果然只有这个结局吗......”".toString();
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
                        case 14:jixu.setImageResource(R.drawable.jqa14);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                            @Override
                            public void run() {
                                Message msg1=new Message();
                                Message msg2=new Message();
                                msg1.what=114;
                                msg1.obj="“可是我已经被林檎恶魔杀死了”".toString();
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
                        case 15: jixu.setImageResource(R.drawable.jqa15);
                            waitclick(15);
                            break;
                        case 16:jixu.setImageResource(R.drawable.jqa16);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
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
                        case 17:jixu.setImageResource(R.drawable.jqa17);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
                                    msg1.what=114;
                                    msg1.obj="感到一阵眩晕".toString();
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
                        case 18: jixu.setImageResource(R.drawable.jqa17);
                            waitclick(17);
                            break;
                        case 19:jixu.setImageResource(R.drawable.jqa18);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
                                    msg1.what=114;
                                    msg1.obj="睁开双眼".toString();
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
                        case 20:jixu.setImageResource(R.drawable.jqa19);
                            jixu.setEnabled(false);
                            t=new TimerTask() {
                                @Override
                                public void run() {
                                    Message msg1=new Message();
                                    Message msg2=new Message();
                                    msg1.what=114;
                                    msg1.obj="“这里是......114年前的下北泽?”".toString();
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
                            if(finish!=1){
                                editor = sp1.edit();
                                editor.putInt("jj", jj+1145);
                                editor.putInt("lq", lq+191);
                                editor.putInt("jqa1f", 1);
                                editor.commit();
                                mpstop();
                            Intent i1=new Intent(moban.this, jqfinish.class);
                            startActivity(i1);
                            finish();}
                            else{
                                mpstop();
                                Intent i1=new Intent(moban.this, jqfinished.class);
                                startActivity(i1);
                                finish();
                            }
                            break;
                    }
            }
        });
    }
}