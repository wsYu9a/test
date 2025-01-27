package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class ck {

    /* renamed from: b */
    public static final String f7038b = "404";

    /* renamed from: c */
    public static final int f7039c = 843;

    /* renamed from: d */
    protected final bt f7047d = bt.a();

    /* renamed from: h */
    private Context f7048h;

    /* renamed from: a */
    public static final String f7037a = z.f7374b;

    /* renamed from: g */
    private static ck f7042g = new ck();

    /* renamed from: e */
    public static volatile String f7040e = "";

    /* renamed from: f */
    public static volatile String f7041f = "";

    /* renamed from: i */
    private static AtomicBoolean f7043i = new AtomicBoolean(false);

    /* renamed from: j */
    private static String f7044j = "";

    /* renamed from: k */
    private static AtomicBoolean f7045k = new AtomicBoolean(false);

    /* renamed from: l */
    private static String f7046l = "";

    private ck() {
    }

    public static ck a() {
        return f7042g;
    }

    private String d() {
        String str = cl.f7053e;
        if (!cl.f7052d.equals(str)) {
            return str;
        }
        try {
            double b10 = bz.b(bz.a(this.f7048h));
            return b10 > l5.c.f27899e ? String.valueOf(b10) : str;
        } catch (Throwable th2) {
            this.f7047d.a(th2);
            return str;
        }
    }

    public String b() {
        try {
            if (f7043i.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", null).invoke(cls, null);
                if (!TextUtils.isEmpty(str)) {
                    f7044j = str;
                }
            }
            return f7044j;
        } catch (Throwable th2) {
            this.f7047d.a(th2);
            return f7044j;
        }
    }

    public String c() {
        try {
            if (f7045k.get()) {
                return f7046l;
            }
            if (!f7043i.get()) {
                b();
            }
            if (f7044j.equalsIgnoreCase("")) {
                f7045k.set(true);
                return "";
            }
            if (f7045k.compareAndSet(false, true)) {
                String a10 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a10)) {
                    f7046l = a10;
                }
            }
            return f7046l;
        } catch (Throwable th2) {
            this.f7047d.a(th2);
            return f7046l;
        }
    }

    public void a(Context context) {
        if (this.f7048h == null) {
            this.f7048h = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            a(str, f7038b, hashMap);
        } catch (Exception e10) {
            this.f7047d.a(e10);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("subtype", String.valueOf(f7039c)).appendQueryParameter(com.umeng.analytics.pro.bt.bl, "9.3711").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter("v", "android_" + d() + hf.e.f26694a + cl.f7054f);
            Context context = this.f7048h;
            appendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f7048h)).appendQueryParameter("cuid", a("encodedCUID", this.f7048h)).appendQueryParameter(com.umeng.analytics.pro.bt.f23628x, "android").appendQueryParameter("osv", bm.a(this.f7048h).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bm.a(this.f7048h).a()).appendQueryParameter("brd", "" + a(bm.a(this.f7048h).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter(MediationConstant.KEY_REASON, str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th2) {
            this.f7047d.a(th2);
        }
        am amVar = new am(f7037a, "POST");
        amVar.a(builder);
        amVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c10;
        aa a10 = aa.a();
        if (a10 != null && (c10 = a10.c()) != null) {
            Object remoteParam = c10.getRemoteParam(str, objArr);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
            return "";
        }
        return "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th2) {
            this.f7047d.a(th2);
            return str2;
        }
    }
}
