package com.opos.cmn.biz.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static final String f16751a = "e";

    public static class a {

        /* renamed from: a */
        public final String f16752a;

        /* renamed from: b */
        public final boolean f16753b;

        public a(String str, boolean z) {
            this.f16752a = str;
            this.f16753b = z;
        }
    }

    public static a a(Context context, String str, MonitorEvent monitorEvent) {
        String str2 = str;
        for (String str3 : c.f16750a) {
            String b2 = b(context, str3, monitorEvent);
            if (b2 != null) {
                str2 = a(str2, str3, b(b2));
            }
        }
        return new a(str2, a(str));
    }

    public static String a(Context context) {
        String h2 = com.opos.cmn.an.h.c.a.h(context);
        return (com.baidu.mobads.sdk.internal.a.f5472a.equals(h2) || TextUtils.isEmpty(h2)) ? "UNKNOWN" : h2.toUpperCase();
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, -1, false);
    }

    private static String a(String str, String str2, String str3, int i2, boolean z) {
        String str4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str3 == null || i2 == 0) {
            return str;
        }
        if (z) {
            str4 = str.toLowerCase();
            str2 = str2.toLowerCase();
        } else {
            str4 = str;
        }
        int i3 = 0;
        int indexOf = str4.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        int i4 = 64;
        if (i2 < 0) {
            i4 = 16;
        } else if (i2 <= 64) {
            i4 = i2;
        }
        StringBuilder sb = new StringBuilder((i4 * length2) + str.length());
        while (indexOf != -1) {
            sb.append(str.substring(i3, indexOf));
            sb.append(str3);
            i3 = indexOf + length;
            i2--;
            if (i2 == 0) {
                break;
            }
            indexOf = str4.indexOf(str2, i3);
        }
        sb.append(str.substring(i3));
        return sb.toString();
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("mix_in") >= 0;
    }

    public static String b(Context context) {
        String b2 = com.opos.cmn.an.h.e.a.b(context);
        return (com.baidu.mobads.sdk.internal.a.f5472a.equals(b2) || TextUtils.isEmpty(b2)) ? "UNKNOWN" : b2;
    }

    private static String b(Context context, String str, MonitorEvent monitorEvent) {
        String str2;
        String str3;
        int b2;
        str.hashCode();
        switch (str) {
            case "$c$":
                return com.opos.cmn.an.b.b.b();
            case "$h$":
                try {
                    b2 = com.opos.cmn.an.h.f.a.c(context);
                    return String.valueOf(b2);
                } catch (Exception e2) {
                    e = e2;
                    str2 = f16751a;
                    str3 = "get height fail";
                    com.opos.cmn.an.f.a.b(str2, str3, e);
                    return String.valueOf(0);
                }
            case "$m$":
                return com.opos.cmn.an.b.c.a();
            case "$t$":
                return String.valueOf(System.currentTimeMillis());
            case "$w$":
                try {
                    b2 = com.opos.cmn.an.h.f.a.b(context);
                    return String.valueOf(b2);
                } catch (Exception e3) {
                    e = e3;
                    str2 = f16751a;
                    str3 = "get width fail";
                    com.opos.cmn.an.f.a.b(str2, str3, e);
                    return String.valueOf(0);
                }
            case "$as$":
                return monitorEvent.i();
            case "$av$":
                return com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
            case "$bd$":
                return com.opos.cmn.biz.a.b.a(context);
            case "$ca$":
                return b(context);
            case "$ci$":
                b2 = monitorEvent.h();
                return String.valueOf(b2);
            case "$cp$":
                return monitorEvent.f();
            case "$cr$":
                return monitorEvent.g();
            case "$ct$":
            case "$rf$":
                return "";
            case "$dx$":
                b2 = monitorEvent.b();
                return String.valueOf(b2);
            case "$dy$":
                b2 = monitorEvent.c();
                return String.valueOf(b2);
            case "$jr$":
                return monitorEvent.j();
            case "$nt$":
                return a(context);
            case "$os$":
                return BaseWrapper.BASE_PKG_SYSTEM;
            case "$ov$":
                return com.opos.cmn.an.b.c.c();
            case "$rg$":
                return com.opos.cmn.biz.a.d.a(context);
            case "$ua$":
                return c(context);
            case "$ux$":
                b2 = monitorEvent.d();
                return String.valueOf(b2);
            case "$uy$":
                b2 = monitorEvent.e();
                return String.valueOf(b2);
            case "$lan$":
                return com.opos.cmn.an.b.b.a();
            case "$pkg$":
                return context.getPackageName();
            case "$progress$":
                b2 = monitorEvent.a();
                return String.valueOf(b2);
            case "$ckid$":
                return UUID.randomUUID().toString() + System.currentTimeMillis();
            case "__CONTENT__":
                return monitorEvent.k();
            default:
                return null;
        }
    }

    private static String b(String str) {
        if (str != null) {
            if (str.length() <= 0) {
                return str;
            }
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return "";
    }

    private static String c(Context context) {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c(f16751a, "getUA", e2);
            return "";
        }
    }
}
