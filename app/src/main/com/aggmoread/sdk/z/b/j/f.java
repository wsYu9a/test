package com.aggmoread.sdk.z.b.j;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private static f f4591a = new f();

    public int a(String str) {
        String a10 = com.aggmoread.sdk.z.b.m.f.a().a(str);
        if (TextUtils.isEmpty(a10)) {
            return 0;
        }
        return Integer.parseInt(a10);
    }

    public static f a() {
        return f4591a;
    }

    public void a(String str, int i10) {
        com.aggmoread.sdk.z.b.m.f.a().a(str, String.valueOf(i10));
    }
}
