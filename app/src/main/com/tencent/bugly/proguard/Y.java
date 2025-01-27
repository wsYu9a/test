package com.tencent.bugly.proguard;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes4.dex */
public class Y {

    /* renamed from: a */
    private static Proxy f22681a;

    public static void a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            f22681a = null;
        } else {
            f22681a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i10));
        }
    }

    public static void a(InetAddress inetAddress, int i10) {
        if (inetAddress == null) {
            f22681a = null;
        } else {
            f22681a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i10));
        }
    }

    public static Proxy a() {
        return f22681a;
    }
}
