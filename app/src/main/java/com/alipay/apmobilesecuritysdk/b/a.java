package com.alipay.apmobilesecuritysdk.b;

import k2.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b */
    public static a f6436b = new a();

    /* renamed from: a */
    public int f6437a = 0;

    public static a a() {
        return f6436b;
    }

    public final int b() {
        return this.f6437a;
    }

    public final String c() {
        String str;
        String a10 = d.a();
        if (t3.a.f(a10)) {
            return a10;
        }
        int i10 = this.f6437a;
        if (i10 == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else {
            if (i10 == 2) {
                return "https://mobilegwpre.alipay.com/mgw.htm";
            }
            if (i10 == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else {
                if (i10 != 4) {
                    return "https://mobilegw.alipay.com/mgw.htm";
                }
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a("http", str);
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public final void a(int i10) {
        this.f6437a = i10;
    }
}
