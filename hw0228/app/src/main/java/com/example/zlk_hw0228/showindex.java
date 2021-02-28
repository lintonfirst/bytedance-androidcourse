package com.example.zlk_hw0228;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class showindex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showindex);

        Integer extra = getIntent().getIntExtra("index",0);
        TextView textView = findViewById(R.id.showindex);
        textView.setText("第"+extra.toString()+"行");

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(showindex.this, MainActivity.class);
                startActivity(intent);
                showindex.this.finish();
            }
        });
    }
}