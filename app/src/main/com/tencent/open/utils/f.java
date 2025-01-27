package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static f f23272a;

    /* renamed from: b */
    private volatile WeakReference<SharedPreferences> f23273b = null;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f23272a == null) {
                    f23272a = new f();
                }
                fVar = f23272a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    public String a(Context context, String str) {
        if (this.f23273b == null || this.f23273b.get() == null) {
            this.f23273b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f23273b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e10) {
            com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e10.getMessage());
            return str;
        }
    }
}
