package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a */
    private static volatile f f7183a;

    private f() {
    }

    public static f a() {
        if (f7183a == null) {
            synchronized (f.class) {
                try {
                    if (f7183a == null) {
                        f7183a = new f();
                    }
                } finally {
                }
            }
        }
        return f7183a;
    }

    public void a(double d10, am.b bVar) {
        cq a10 = cq.a();
        String c10 = a10.c(z.f7362a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d10);
        hashMap.put(com.umeng.analytics.pro.bt.f23628x, "android");
        hashMap.put("tp", a(bm.a((Context) null).d()));
        hashMap.put("bdr", a(bm.a((Context) null).b()));
        am amVar = new am(a10.a(c10, hashMap));
        amVar.a(bVar);
        amVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            file.setReadOnly();
            return new DexClassLoader(str, str2, str3, classLoader);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
