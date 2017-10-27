package com.tyqtest.data_save;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private Button write;
    private  Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("11",0);
        editor = preferences.edit();
        write = (Button) findViewById(R.id.write);
        read = (Button) findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = preferences.getInt("num",0);
                String a = num+"";
                Toast.makeText(MainActivity.this,a , Toast.LENGTH_SHORT).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("num",(int)(Math.random()*100));
                editor.commit();
                Intent intent = new Intent(MainActivity.this,Shared.class);
                startActivity(intent);
            }
        });

    }
}
