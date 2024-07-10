package com.yjj.homogame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private Button b1;
    private ImageButton ib1;
    private ImageButton body;
    private ImageButton juqing;
    private TextView name;
    private TextView jj;
    private TextView lq;
    private TextView speak;
    private ImageView head;
    private SharedPreferences p1;
    private int clicknum;
    private SharedPreferences.Editor editor;

    private void loaddata()
    {
        int num1=p1.getInt("jj",-1);
        if(num1==-1){
            editor = p1.edit();
            editor.putInt("jj",0);
            editor.commit();
            jj.setText("0");
        }
        else{
            jj.setText(Integer.toString(num1));
        }
        int num2=p1.getInt("lq",-1);
        if(num2==-1){
            editor = p1.edit();
            editor.putInt("lq",0);
            editor.commit();
            lq.setText("0");
        }
        else{
            lq.setText(Integer.toString(num2));
        }
        String str3=p1.getString("name","none");
        if(str3.equals("none")){
            editor.putString("name","homo");
            editor.commit();
            name.setText("homo");
        }
        else{
            name.setText(str3);
        }
    }

    private int randomts(){
        Random r1=new Random();
        int randomnum=r1.nextInt(6);
        switch (randomnum){
            case 0:head.setImageResource(R.drawable.ts2);
                   speak.setText("欢迎来到下北泽！");
                   break;
            case 1:head.setImageResource(R.drawable.ts3);
                speak.setText("每当下雪的时候，我都会想撅那个人");
                break;
            case 2:head.setImageResource(R.drawable.ts4);
                speak.setText("24岁，是学生");
                break;
            case 3:head.setImageResource(R.drawable.ts5);
                speak.setText("你是一个，一个一个一个......");
                break;
            case 4:head.setImageResource(R.drawable.ts6);
                speak.setText("哼哼哼啊啊啊啊啊啊啊......");
                break;
            case 5:head.setImageResource(R.drawable.ts8);
                speak.setText("今天下北泽的太阳也很好！");
                break;
            default:head.setImageResource(R.drawable.ts2);
                speak.setText("欢迎来到下北泽！");
                break;
        }
        return randomnum;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b1=findViewById(R.id.b1);
        ib1=findViewById(R.id.ib1);
        name=findViewById(R.id.name);
        jj=findViewById(R.id.jj);
        lq=findViewById(R.id.lq);
        body=findViewById(R.id.body);
        head=findViewById(R.id.head);
        speak=findViewById(R.id.speak);
        juqing=findViewById(R.id.juqing);
        clicknum=-1;
        p1=getSharedPreferences("config", Context.MODE_PRIVATE);
        loaddata();
        randomts();
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity2.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                try {
                    MainActivity.mpstop();
                } catch (Exception e) {
                }
                startActivity(intent);
                finish();
            }
        });
        ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity2.this,editname.class);
                startActivity(i1);
            }
        });
        body.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clicknum++;
                if(clicknum==randomts()){
                    clicknum++;
                    if(clicknum>5){
                        clicknum--;
                    }
                }
                if(clicknum>5){
                    clicknum=0;
                }
                switch (clicknum){
                    case 0:head.setImageResource(R.drawable.ts2);
                        speak.setText("欢迎来到下北泽！");
                        break;
                    case 1:head.setImageResource(R.drawable.ts3);
                        speak.setText("每当下雪的时候，我都会想撅那个人");
                        break;
                    case 2:head.setImageResource(R.drawable.ts4);
                        speak.setText("24岁，是学生");
                        break;
                    case 3:head.setImageResource(R.drawable.ts5);
                        speak.setText("你是一个，一个一个一个......");
                        break;
                    case 4:head.setImageResource(R.drawable.ts6);
                        speak.setText("哼哼哼啊啊啊啊啊啊啊......");
                        break;
                    case 5:head.setImageResource(R.drawable.ts8);
                        speak.setText("今天下北泽的太阳也很好！");
                        break;
                    default:head.setImageResource(R.drawable.ts2);
                        speak.setText("欢迎来到下北泽！");
                        break;
                }
            }
        });
        juqing.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MainActivity2.this,juqing.class);
                startActivity(i1);
            }
        });
    }
}