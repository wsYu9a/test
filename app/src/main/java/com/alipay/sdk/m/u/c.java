package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import ba.m;
import com.alipay.sdk.m.w.b;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static final String f6590a = "00:00:00:00:00:00";

    /* renamed from: b */
    public static c f6591b;

    public c(Context context) {
    }

    public static String b(Context context) {
        return c(context).a().substring(0, 8);
    }

    public static c c(Context context) {
        if (f6591b == null) {
            f6591b = new c(context);
        }
        return f6591b;
    }

    public static String f(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static g g(Context context) {
        try {
            NetworkInfo a10 = b.a(null, context);
            return (a10 == null || a10.getType() != 0) ? (a10 == null || a10.getType() != 1) ? g.NONE : g.WIFI : g.a(a10.getSubtype());
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    public String a() {
        String str = d() + "|";
        String e10 = e();
        if (TextUtils.isEmpty(e10)) {
            return str + m.f1493b;
        }
        return str + e10;
    }

    public String d() {
        return m.f1493b;
    }

    public String e() {
        return m.f1493b;
    }

    public String h() {
        return f6590a;
    }
}
