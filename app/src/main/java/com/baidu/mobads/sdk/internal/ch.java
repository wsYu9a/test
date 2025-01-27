package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class ch {

    /* renamed from: b */
    public static final String f5707b = "404";

    /* renamed from: c */
    protected final bq f5714c = bq.a();

    /* renamed from: g */
    private Context f5715g;

    /* renamed from: a */
    public static final String f5706a = w.f5859b;

    /* renamed from: f */
    private static ch f5710f = new ch();

    /* renamed from: d */
    public static volatile String f5708d = "";

    /* renamed from: e */
    public static volatile String f5709e = "";

    /* renamed from: h */
    private static AtomicBoolean f5711h = new AtomicBoolean(false);

    /* renamed from: i */
    private static String f5712i = "";

    /* renamed from: j */
    private static AtomicBoolean f5713j = new AtomicBoolean(false);
    private static String k = "";

    private ch() {
    }

    public static ch a() {
        return f5710f;
    }

    private String d() {
        String str = ci.f5720e;
        if (!ci.f5719d.equals(str)) {
            return str;
        }
        try {
            double b2 = bw.b(bw.a(this.f5715g));
            return b2 > 0.0d ? String.valueOf(b2) : str;
        } catch (Throwable th) {
            this.f5714c.a(th);
            return str;
        }
    }

    public String b() {
        try {
            if (f5711h.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    f5712i = str;
                }
            }
            return f5712i;
        } catch (Throwable th) {
            this.f5714c.a(th);
            return f5712i;
        }
    }

    public String c() {
        try {
            if (f5713j.get()) {
                return k;
            }
            if (!f5711h.get()) {
                b();
            }
            if (f5712i.equalsIgnoreCase("")) {
                f5713j.set(true);
                return "";
            }
            if (f5713j.compareAndSet(false, true)) {
                String a2 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a2)) {
                    k = a2;
                }
            }
            return k;
        } catch (Throwable th) {
            this.f5714c.a(th);
            return k;
        }
    }

    public void a(Context context) {
        if (this.f5715g == null) {
            this.f5715g = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            a(str, f5707b, hashMap);
        } catch (Exception e2) {
            this.f5714c.a(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter(com.umeng.analytics.pro.am.bd, "9.29").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter("v", "android_" + d() + "_" + ci.f5721f);
            Context context = this.f5715g;
            appendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f5715g)).appendQueryParameter("cuid", a("encodedCUID", this.f5715g)).appendQueryParameter(com.umeng.analytics.pro.am.x, BaseWrapper.BASE_PKG_SYSTEM).appendQueryParameter("osv", bj.a(this.f5715g).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bj.a(this.f5715g).a()).appendQueryParameter("brd", "" + a(bj.a(this.f5715g).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f5714c.a(th);
        }
        am amVar = new am(f5706a, "POST");
        amVar.a(builder);
        amVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c2;
        z a2 = z.a();
        if (a2 == null || (c2 = a2.c()) == null) {
            return "";
        }
        Object remoteParam = c2.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f5714c.a(th);
            return str2;
        }
    }
}
