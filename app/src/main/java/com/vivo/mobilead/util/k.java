package com.vivo.mobilead.util;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.mobilead.util.n;
import java.util.Locale;

/* loaded from: classes4.dex */
public class k {
    private static k l;

    /* renamed from: a */
    private Context f30663a;

    /* renamed from: b */
    private String f30664b;

    /* renamed from: c */
    private int f30665c;

    /* renamed from: d */
    private int f30666d;

    /* renamed from: e */
    private String f30667e;

    /* renamed from: f */
    private long f30668f;

    /* renamed from: g */
    private String f30669g;

    /* renamed from: h */
    private String f30670h;

    /* renamed from: i */
    private long f30671i;

    /* renamed from: j */
    private int f30672j;
    private String k;

    private k(Context context) {
        this.f30663a = context;
        try {
            this.f30664b = context.getPackageName();
            this.f30665c = n.a.c();
            this.k = n.a.d();
            this.f30666d = j.a(this.f30663a, "com.bbk.appstore");
            this.f30672j = j.a(this.f30663a, "com.vivo.game");
            this.f30667e = String.valueOf(n.f()) + "*" + String.valueOf(n.e());
            this.f30668f = System.currentTimeMillis();
            Locale locale = this.f30663a.getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                language = language + "-" + country;
            }
            this.f30669g = language;
            n.c(context);
            this.f30670h = n.j();
            n.a(context);
            this.f30671i = n.c();
        } catch (Exception e2) {
            x0.a("CommonParamUtils", "CommonParamUtils error", e2);
        }
    }

    public static synchronized k a(Context context) {
        k kVar;
        synchronized (k.class) {
            if (l == null) {
                l = new k(context);
            }
            kVar = l;
        }
        return kVar;
    }

    public int b() {
        return this.f30665c;
    }

    public String c() {
        return this.k;
    }

    public int d() {
        return this.f30666d;
    }

    public String e() {
        return n.a(this.f30663a);
    }

    public long f() {
        return this.f30668f;
    }

    public long g() {
        return this.f30671i;
    }

    public int h() {
        return this.f30672j;
    }

    public String i() {
        return this.f30669g;
    }

    public int j() {
        return n.c(this.f30663a);
    }

    public String k() {
        return this.f30667e;
    }

    public String l() {
        return this.f30670h;
    }

    public String a() {
        return this.f30664b;
    }
}
