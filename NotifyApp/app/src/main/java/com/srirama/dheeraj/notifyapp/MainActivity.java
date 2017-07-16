package com.srirama.dheeraj.notifyapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    NotificationManager nm;
    public   final int UniqId=132834;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        PendingIntent  pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
        String body = "Hello!You Got a message";
        String title = "Dheeraj";
        Notification n = new Notification.Builder(MainActivity.this)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentIntent(pi).getNotification();
        n.defaults = Notification.DEFAULT_SOUND;
        n.flags = Notification.FLAG_AUTO_CANCEL;
        nm.notify(0,n);
    }
}
