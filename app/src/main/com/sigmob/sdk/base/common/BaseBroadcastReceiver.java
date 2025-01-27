package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Preconditions;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public String f17628a;

    public BaseBroadcastReceiver(String str) {
        this.f17628a = str;
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, null, str2, 0);
    }

    public abstract IntentFilter a();

    public void b(BroadcastReceiver broadcastReceiver) {
        f0 a10;
        if (broadcastReceiver == null || (a10 = f0.a(com.sigmob.sdk.a.d())) == null) {
            return;
        }
        try {
            a10.a(broadcastReceiver);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, int i10) {
        a(context, str, null, str2, i10);
    }

    public static void a(Context context, String str, Map<String, Object> map, String str2) {
        a(context, str, map, str2, 0);
    }

    public static void a(Context context, String str, Map<String, Object> map, String str2, int i10) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str2);
        Intent intent = new Intent(str2);
        intent.putExtra(Constants.BROADCAST_IDENTIFIER_KEY, str);
        if (map != null) {
            for (String str3 : map.keySet()) {
                try {
                    Object obj = map.get(str3);
                    if (obj instanceof Number) {
                        intent.putExtra(str3, (Number) obj);
                    } else {
                        intent.putExtra(str3, (String) obj);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        f0 a10 = f0.a(context);
        if (a10 != null) {
            try {
                a10.a(intent, i10);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        f0 a10 = f0.a(com.sigmob.sdk.a.d());
        if (a10 != null) {
            try {
                a10.a(broadcastReceiver, a());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public boolean a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        String stringExtra = intent.getStringExtra(Constants.BROADCAST_IDENTIFIER_KEY);
        return !TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(this.f17628a);
    }
}
