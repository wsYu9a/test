package com.martian.apptask.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.martian.apptask.AppTaskManager;
import l9.p0;

/* loaded from: classes3.dex */
public class APKInstallReceiver extends BroadcastReceiver {
    public void a(Context context, String str) {
    }

    public void b(Context context, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        p0.e("INSTALLReceiver", "install finished");
        if (intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        if (dataString.startsWith("package:")) {
            dataString = dataString.substring(8);
        }
        b(context, dataString);
        if (AppTaskManager.y(context, dataString)) {
            AppTaskManager.L(context, dataString);
            a(context, dataString);
        }
    }
}
