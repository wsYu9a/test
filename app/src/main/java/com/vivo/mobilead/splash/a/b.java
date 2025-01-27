package com.vivo.mobilead.splash.a;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    private static volatile b f29659b = new b();

    /* renamed from: a */
    private HashMap<String, a> f29660a = new HashMap<>();

    private b() {
    }

    public static b a() {
        return f29659b;
    }

    public a a(String str) {
        if (this.f29660a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f29660a.get(str);
    }

    public void a(String str, String str2) {
        a a2 = a(str);
        if (a2 != null) {
            a2.a(str2, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
