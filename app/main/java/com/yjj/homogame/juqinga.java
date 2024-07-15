package com.yjj.homogame;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class juqinga extends AppCompatActivity {

    private ImageButton back;
    private ImageButton jrjqa1;
    private ImageButton jrjqa2;
    private ImageButton jrjqa3;
    private ImageButton jrjqa4;
    private ImageButton jrjqa5;
    private TextView jqa1f;
    private TextView jqa2f;
    private TextView jqa3f;
    private TextView jqa4f;
    private TextView jqa5f;
    static Activity juqinga_activity;
    private SharedPreferences p1;
    private SharedPreferences.Editor editor;

    private void loaddata()
    {
        int num1=p1.getInt("jqa1f",-1);
        if(num1==-1){
            editor = p1.edit();
            editor.putInt("jqa1f",0);
            editor.commit();
        }
        if(num1!=1) {
            jrjqa2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert1 = new AlertDialog.Builder(juqinga.this);
                    alert1.setTitle("提醒");
                    alert1.setMessage("需要先完成前面剧情");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert1.create();
                    alert1.show();
                }
            });
        }
        if(num1==1){
            jqa1f.setText("已完成");
            jrjqa2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent i1=new Intent(juqinga.this,jqa2.class);
                    startActivity(i1);
                }
            });
        }
            int num2=p1.getInt("jqa2f",-1);
            if(num2==-1){
                editor = p1.edit();
                editor.putInt("jqa2f",0);
                editor.commit();
            }
            if(num2!=1){
                jrjqa3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alert1=new AlertDialog.Builder(juqinga.this);
                        alert1.setTitle("提醒");
                        alert1.setMessage("需要先完成前面剧情");
                        alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        alert1.create();
                        alert1.show();
                    }
                });
        }
        if(num2==1){
            jqa2f.setText("已完成");
            jrjqa3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent i1=new Intent(juqinga.this,jqa3.class);
                    startActivity(i1);
                }
            });
        }
        int num3=p1.getInt("jqa3f",-1);
        if(num3==-1){
            editor = p1.edit();
            editor.putInt("jqa3f",0);
            editor.commit();
        }
        if(num3!=1){
            jrjqa4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert1=new AlertDialog.Builder(juqinga.this);
                    alert1.setTitle("提醒");
                    alert1.setMessage("需要先完成前面剧情");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert1.create();
                    alert1.show();
                }
            });
        }
        if(num3==1){
            jqa3f.setText("已完成");
            jrjqa4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent i1=new Intent(juqinga.this,jqa4.class);
                    startActivity(i1);
                }
            });
        }
        int num4=p1.getInt("jqa4f",-1);
        if(num4==-1){
            editor = p1.edit();
            editor.putInt("jqa4f",0);
            editor.commit();
        }
        if(num4!=1){
            jrjqa5.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert1=new AlertDialog.Builder(juqinga.this);
                    alert1.setTitle("提醒");
                    alert1.setMessage("需要先完成前面剧情");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert1.create();
                    alert1.show();
                }
            });
        }
        if(num4==1){
            jqa4f.setText("已完成");
            jrjqa5.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert1=new AlertDialog.Builder(juqinga.this);
                    alert1.setTitle("该剧情尚未完成");
                    alert1.setMessage("请期待后续更新");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert1.create();
                    alert1.show();
                }
            });
        }
        /*int num5=p1.getInt("jqa5f",-1);
        if(num5==-1){
            editor = p1.edit();
            editor.putInt("jqa5f",0);
            editor.commit();
        }
        if(num5!=1){
            jrjqa6.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert1=new AlertDialog.Builder(juqinga.this);
                    alert1.setTitle("提醒");
                    alert1.setMessage("需要先完成前面剧情");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert1.create();
                    alert1.show();
                }
            });
        }
        if(num5==1){
            jqa5f.setText("已完成");
            jrjqa6.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent i1=new Intent(juqinga.this,jqa3.class);
                    startActivity(i1);
                }
            });
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juqinga);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        juqinga_activity=this;
        p1=getSharedPreferences("config", Context.MODE_PRIVATE);
        back=findViewById(R.id.back);
        jrjqa1=findViewById(R.id.jinrujqa1);
        jrjqa2=findViewById(R.id.jinrujqa2);
        jrjqa3=findViewById(R.id.jinrujqa3);
        jrjqa4=findViewById(R.id.jinrujqa4);
        jrjqa5=findViewById(R.id.jinrujqa5);
        jqa1f=findViewById(R.id.jqa1f);
        jqa2f=findViewById(R.id.jqa2f);
        jqa3f=findViewById(R.id.jqa3f);
        jqa4f=findViewById(R.id.jqa4f);
        jqa5f=findViewById(R.id.jqa5f);
        loaddata();
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        jrjqa1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(juqinga.this,moban.class);
                startActivity(i1);
            }
        });
    }
}