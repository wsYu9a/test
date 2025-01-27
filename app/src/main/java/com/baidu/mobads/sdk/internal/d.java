package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.am;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static volatile d f5772a;

    private d() {
    }

    public static d a() {
        if (f5772a == null) {
            synchronized (d.class) {
                if (f5772a == null) {
                    f5772a = new d();
                }
            }
        }
        return f5772a;
    }

    public void a(double d2, am.b bVar) {
        cn a2 = cn.a();
        String c2 = a2.c(w.f5857a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d2);
        hashMap.put(com.umeng.analytics.pro.am.x, BaseWrapper.BASE_PKG_SYSTEM);
        hashMap.put(OapsKey.KEY_TYPE, a(bj.a((Context) null).d()));
        hashMap.put("bdr", a(bj.a((Context) null).b()));
        am amVar = new am(a2.a(c2, hashMap));
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
        return new DexClassLoader(str, str2, str3, classLoader);
    }
}
