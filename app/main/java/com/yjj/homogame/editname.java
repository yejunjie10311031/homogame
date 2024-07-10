package com.yjj.homogame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class editname extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private EditText et;
    private TextView warn;
    private TextView name;
    private int jj;
    private int lq;
    private SharedPreferences p1;

    private void loadname()
    {
        String str1=p1.getString("name","homo");
        if(str1!=null){
            name.setText(str1);
        }
        jj=p1.getInt("jj",-1);
        lq=p1.getInt("lq",-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editname);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        et=findViewById(R.id.et);
        warn=findViewById(R.id.warn);
        name=findViewById(R.id.name);
        p1=getSharedPreferences("config", Context.MODE_PRIVATE);
        loadname();
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String s1=et.getText().toString();
                if(s1.length()<3 || s1.length()>10){
                    warn.setText("名字长度必须在3~10个字符");
                    AlertDialog.Builder alert1=new AlertDialog.Builder(editname.this);
                    alert1.setTitle("提醒");
                    alert1.setMessage("名字长度必须在3~10个字符");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alert1.create();
                    alert1.show();
                }
                else {
                    AlertDialog.Builder alert1 = new AlertDialog.Builder(editname.this);
                    alert1.setTitle("提醒");
                    alert1.setMessage("确定要更改名字吗？这将花费114金金。");
                    alert1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if(jj-114<0){
                                Toast.makeText(editname.this,"金金不足，需要114金金",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                SharedPreferences.Editor editor = p1.edit();
                                editor.putString("name", s1);
                                editor.putInt("jj", jj-114);
                                editor.commit();
                                name.setText(s1);
                                Intent intent = new Intent();
                                intent.setClass(editname.this, MainActivity2.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }
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
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}