package com.martian.mibook.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ya.m0;

/* loaded from: classes3.dex */
public class KeepLiveReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            m0.b().e(context);
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            m0.b().a();
        }
    }
}
