package com.vivo.mobilead.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == null || !intent.getAction().equals("android.intent.action.PACKAGE_ADDED") || intent.getData() == null) {
            return;
        }
        c.d().b(intent.getData().getSchemeSpecificPart());
    }
}
