package com.alipay.sdk.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public enum a {
    WapPay("js://wappay"),
    DownLoad("js://download"),
    Submit("submit"),
    Confirm("js://confirm"),
    Alert("js://alert"),
    Update("js://update"),
    Exit("js://exit");


    /* renamed from: h */
    private String f5404h;

    /* renamed from: i */
    private String f5405i;

    /* renamed from: j */
    private String f5406j;
    private JSONObject k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private JSONObject u;

    a(String str) {
        this.f5404h = str;
    }

    public static a[] a(b bVar) {
        if (bVar == null) {
            return new a[]{Submit};
        }
        String str = bVar.f5407a;
        String[] split = TextUtils.isEmpty(str) ? null : str.split(";");
        if (split == null) {
            return new a[]{Submit};
        }
        a[] aVarArr = new a[split.length];
        int i2 = 0;
        for (String str2 : split) {
            a aVar = Submit;
            a[] values = values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                a aVar2 = values[i3];
                if (str2.startsWith(aVar2.f5404h)) {
                    aVar = aVar2;
                    break;
                }
                i3++;
            }
            aVar.f5405i = str2;
            if (TextUtils.isEmpty(bVar.f5408b)) {
                bVar.f5408b = b.b.a.b.a.f4189b;
            }
            aVar.f5406j = bVar.f5408b;
            aVar.k = bVar.e();
            aVar.l = bVar.f5409c;
            aVar.m = bVar.f5410d;
            aVar.n = bVar.f5411e;
            aVar.o = bVar.f5412f;
            aVar.p = bVar.f5413g;
            aVar.q = bVar.f5414h;
            aVar.r = bVar.f5415i;
            aVar.s = bVar.f5416j;
            aVar.t = bVar.k;
            aVar.u = bVar.l;
            aVarArr[i2] = aVar;
            i2++;
        }
        return aVarArr;
    }

    private static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    private JSONObject m() {
        return this.k;
    }

    public final JSONObject a() {
        return this.u;
    }

    public final String b() {
        return this.t;
    }

    public final String c() {
        return this.r;
    }

    public final String d() {
        return this.s;
    }

    public final String e() {
        return this.f5405i;
    }

    public final String f() {
        return this.f5406j;
    }

    public final String g() {
        return this.m;
    }

    public final String h() {
        return this.n;
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.p;
    }

    public final boolean k() {
        return this.q;
    }

    public final String l() {
        return this.l;
    }
}
