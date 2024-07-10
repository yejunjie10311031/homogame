package com.yjj.homogame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class jqfinish extends AppCompatActivity {

    private Button qd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jqfinish);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try {
            moban.mpstop();
        } catch (Exception e) {
        }
        qd=findViewById(R.id.qd);
        qd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                juqinga.juqinga_activity.finish();
                Intent i1=new Intent(jqfinish.this,juqinga.class);
                startActivity(i1);
                finish();
            }
        });
    }
}