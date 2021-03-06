package com.example.nazaif.msmmess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.animate().alpha(1).setDuration(2000);
        final Intent intent = new Intent(this,MainActivity.class);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finally {
                    finish();
                    startActivity(intent);

                }

            }
        };
        myThread.start();
    }
}
