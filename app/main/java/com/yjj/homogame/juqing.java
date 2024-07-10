package com.yjj.homogame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class juqing extends AppCompatActivity {

    private ImageButton back;
    private ImageButton jq1;
    private View view1;
    private int num1;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView jqb;
    private ImageButton jr;
    private TextView jrp;
    private TextView p1;
    private TextView p2;
    private TextView p3;
    private TextView p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juqing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        back=findViewById(R.id.back);
        jq1=findViewById(R.id.jq1);
        view1=findViewById(R.id.view);
        iv1=findViewById(R.id.jq1p);
        iv2=findViewById(R.id.jq1b);
        jrp=findViewById(R.id.jinrup);
        jr=findViewById(R.id.jinru);
        jqb=findViewById(R.id.jqback);
        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);
        p3=findViewById(R.id.p3);
        p4=findViewById(R.id.p4);
        num1=0;
        jq1.setBackground(null);
        jr.setBackground(null);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(juqing.this, MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        jq1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num1++;
                if(num1%2==1){
                    view.setBackgroundResource(R.drawable.gb);
                    view1.setBackgroundResource(R.drawable.bb);
                    iv1.setImageResource(R.drawable.lqem1);
                    iv2.setImageResource(R.drawable.cp6);
                    jr.setImageResource(R.drawable.gb);
                    jqb.setImageResource(R.drawable.p2);
                    jr.setBackgroundResource(R.drawable.gb);
                    jrp.setText("进入");
                    p1.setText("巨大的林檎恶魔降临于下北泽，摧毁了homo文明");
                    p2.setText("天使真寻使用木毛之力将你传送回过去");
                    p3.setText("你是否能拯救下北泽");
                    jr.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent i1=new Intent(juqing.this,juqinga.class);
                            startActivity(i1);
                        }
                    });
                }
                if(num1%2==0){
                    view.setBackground(null);
                    view1.setBackground(null);
                    iv1.setImageResource(R.drawable.none);
                    iv2.setImageResource(R.drawable.none);
                    jr.setImageResource(R.drawable.none);
                    jr.setBackgroundResource(R.drawable.none);
                    jqb.setImageResource(R.drawable.none);
                    jrp.setText("");
                    p1.setText("");
                    p2.setText("");
                    p3.setText("");
                    jr.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                        }
                    });
                }
                if(num1>=2){
                    num1=0;
                }
            }
        });
    }
}