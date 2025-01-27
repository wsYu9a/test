package com.martian.ttbook.b.a.i;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static f f14990a = new f();

    public static f b() {
        return f14990a;
    }

    public int a(String str) {
        String a2 = com.martian.ttbook.b.a.k.f.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public void c(String str, int i2) {
        com.martian.ttbook.b.a.k.f.b().a(str, String.valueOf(i2));
    }
}
