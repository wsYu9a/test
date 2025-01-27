package com.martian.ttbook.sdk.adcomponents.adsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import b.d.e.c.a.d;
import com.martian.ttbook.b.a.i.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class JhSdkDownloadNotifyClickReceiver extends BroadcastReceiver {
    public static final String ACTION_NOTIFICATION_CLICK = "com.ads.sdk.NOTIFICATION_CLICK";
    static final String TAG = "APINFICLCKRIVER";
    static ConcurrentHashMap<String, l> notificationClickListenerMapping = new ConcurrentHashMap<>();

    public static l getListener(String str) {
        l lVar = notificationClickListenerMapping.get(str);
        return lVar == null ? l.f15005a : lVar;
    }

    private void init(Intent intent) {
        d.k(TAG, "init enter");
        if (intent != null) {
            String action = intent.getAction();
            d.k(TAG, "init action = " + action);
            if (ACTION_NOTIFICATION_CLICK.equals(action)) {
                String stringExtra = intent.getStringExtra("apkUrl");
                String stringExtra2 = intent.getStringExtra("apkPath");
                String stringExtra3 = intent.getStringExtra(DBDefinition.PACKAGE_NAME);
                d.k(TAG, "httpUrl = " + stringExtra + " , apkPath = " + stringExtra2 + " , packageName = " + stringExtra3);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                getListener(stringExtra).a(intent, stringExtra, stringExtra2, stringExtra3);
            }
        }
    }

    public static void register(String str, l lVar) {
        d.k(TAG, "register enter , url = " + str);
        notificationClickListenerMapping.put(str, lVar);
    }

    public static void remove(String str) {
        notificationClickListenerMapping.remove(str);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.k(TAG, "onReceive enter");
        init(intent);
    }
}
