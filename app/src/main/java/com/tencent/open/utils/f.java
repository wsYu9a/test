package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static f f25538a;

    /* renamed from: b */
    private volatile WeakReference<SharedPreferences> f25539b = null;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f25538a == null) {
                f25538a = new f();
            }
            fVar = f25538a;
        }
        return fVar;
    }

    public String a(Context context, String str) {
        if (this.f25539b == null || this.f25539b.get() == null) {
            this.f25539b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f25539b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e2) {
            com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e2.getMessage());
            return str;
        }
    }
}
