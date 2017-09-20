package org.dijack.broadcastreceiverexercise;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyReceiver mMyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyReceiver = new MyReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMyReceiver, new IntentFilter("org.dijack.broadcastreceiverexercise.CUSTOM_LOCAL_INTENT"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMyReceiver);
    }

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("org.dijack.broadcastreceiverexercise.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    public void broadcastLocalIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("org.dijack.broadcastreceiverexercise.CUSTOM_LOCAL_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
