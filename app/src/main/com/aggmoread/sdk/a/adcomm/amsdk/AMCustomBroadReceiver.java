package com.aggmoread.sdk.a.adcomm.amsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.j.l;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class AMCustomBroadReceiver extends BroadcastReceiver {
    public static final String ACTION_NOTIFICATION_CLICK = "com.ads.sdk.NOTIFICATION_CLICK";
    static final String TAG = "APINFICLCKRIVER";
    static ConcurrentHashMap<String, l> notificationClickListenerMapping = new ConcurrentHashMap<>();

    public static l getListener(String str) {
        l lVar = notificationClickListenerMapping.get(str);
        return lVar == null ? l.f4606a : lVar;
    }

    private void init(Intent intent) {
        d.c(TAG, "init enter");
        if (intent != null) {
            String action = intent.getAction();
            d.c(TAG, "init action = " + action);
            if (ACTION_NOTIFICATION_CLICK.equals(action)) {
                String stringExtra = intent.getStringExtra("apkUrl");
                String stringExtra2 = intent.getStringExtra("apkPath");
                String stringExtra3 = intent.getStringExtra("packageName");
                d.c(TAG, "httpUrl = " + stringExtra + " , apkPath = " + stringExtra2 + " , packageName = " + stringExtra3);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                getListener(stringExtra).a(intent, stringExtra, stringExtra2, stringExtra3);
            }
        }
    }

    public static void register(String str, l lVar) {
        d.c(TAG, "register enter , url = " + str);
        notificationClickListenerMapping.put(str, lVar);
    }

    public static void remove(String str) {
        notificationClickListenerMapping.remove(str);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.c(TAG, "onReceive enter");
        init(intent);
    }
}
