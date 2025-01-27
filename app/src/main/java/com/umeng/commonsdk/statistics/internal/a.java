package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static Context f26364a;

    /* renamed from: b */
    private String f26365b;

    /* renamed from: c */
    private String f26366c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    private static class C0545a {

        /* renamed from: a */
        private static final a f26367a = new a();

        private C0545a() {
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a(Context context) {
        if (f26364a == null && context != null) {
            f26364a = context.getApplicationContext();
        }
        return C0545a.f26367a;
    }

    private void f(String str) {
        try {
            this.f26365b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android/" + Build.DISPLAY + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE + " " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f26364a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26364a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(am.aQ);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb.append(substring);
                }
            }
            this.f26366c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f26364a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(am.aD);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }

    private a() {
        this.f26365b = null;
        this.f26366c = null;
    }

    public String b() {
        return this.f26365b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public String a() {
        return this.f26366c;
    }
}
