package com.guo.duoduo.dlnaserver;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{

    private Dlna_MediaServer mediaServer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread()
        {
            public void run()
            {
                mediaServer = new Dlna_MediaServer(getApplicationContext(),"zte");
                mediaServer.start();
            }
        }.start();
    }

    public void onBackPressed()
    {
        moveTaskToBack(true);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mediaServer.stop();
        mediaServer = null;
    }
}
