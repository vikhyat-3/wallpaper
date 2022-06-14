package com.example.a180_wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    int i=0;
    Boolean running=false;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener( this);
    }
    @Override
    public void onClick(View v){

        if(!running){
            new Timer().schedule(new MyTimer(),0,3000);
            running=false;
        }
    }
    class MyTimer extends TimerTask{
        public void run(){
            try{
                WallpaperManager wm=WallpaperManager.getInstance(getBaseContext());
                if(i==0){
                    wm.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rcb));
                    i=1;
                }
                else if(i==1){
                    wm.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bfc));
                    i=0;
                }
            }
            catch(Exception e){

            }
        }
    }


}
