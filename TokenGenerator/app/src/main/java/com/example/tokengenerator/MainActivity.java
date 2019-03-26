package com.example.tokengenerator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    static {
       IntentFilter s_intentFilter = new IntentFilter();
       s_intentFilter.addAction(Intent.ACTION_TIME_TICK);
       s_intentFilter.addAction(Intent.ACTION_TIME_CHANGED);
    }

    private final BroadcastReceiver m_timeChangedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if(action.equals(Intent.ACTION_TIME_TICK)){

            }
        }
    };

    private int generateNum(){
        Random rand = new Random();
        int num = rand.nextInt(100000);

        return num;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] storedTokens = new int[50];



        Button historyBtn = findViewById(R.id.historyBtn);
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, History.class);
                //Add stored tokens here
                startActivity(i);
            }
        });
    }
}
