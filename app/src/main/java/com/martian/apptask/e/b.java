package com.martian.apptask.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.martian.apptask.AppTaskManager;
import com.martian.libmars.utils.q0;

/* loaded from: classes2.dex */
public class b extends BroadcastReceiver {
    protected void a(Context context, String packageName) {
    }

    protected void b(Context context, String packageName) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        q0.i("INSTALLReceiver", "install finished");
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
