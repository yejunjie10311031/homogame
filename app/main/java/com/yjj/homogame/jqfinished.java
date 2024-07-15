package com.yjj.homogame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class jqfinished extends AppCompatActivity {

    private Button qd;
    private static MediaPlayer mp;
    public static void mpstop(){
        mp.stop();
        mp.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jqfinished);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mp=MediaPlayer.create(this,R.raw.m3);
        new Thread(){
            public void run(){
                try {
                    mp.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
        qd=findViewById(R.id.qd);
        qd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mpstop();
                juqinga.juqinga_activity.finish();
                Intent i1=new Intent(jqfinished.this,juqinga.class);
                startActivity(i1);
                finish();
            }
        });
    }
}