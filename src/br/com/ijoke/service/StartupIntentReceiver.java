package br.com.ijoke.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartupIntentReceiver extends BroadcastReceiver {
	
	
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent serviceIntent = new Intent(context, JokePullService.class);
        serviceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(serviceIntent);
    }
}
