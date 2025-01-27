package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes4.dex */
public class Y {

    /* renamed from: a */
    private static Proxy f25021a;

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            f25021a = null;
        } else {
            f25021a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    public static void a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            f25021a = null;
        } else {
            f25021a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public static Proxy a() {
        return f25021a;
    }
}
