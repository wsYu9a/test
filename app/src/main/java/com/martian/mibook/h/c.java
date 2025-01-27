package com.martian.mibook.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.martian.mibook.application.l0;

/* loaded from: classes4.dex */
public class c extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            l0.b().e(context);
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            l0.b().a();
        }
    }
}
