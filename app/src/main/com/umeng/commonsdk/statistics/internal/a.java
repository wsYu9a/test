package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static Context f24689a;

    /* renamed from: b */
    private String f24690b;

    /* renamed from: c */
    private String f24691c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    public static class C0675a {

        /* renamed from: a */
        private static final a f24692a = new a();

        private C0675a() {
        }
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a(Context context) {
        if (f24689a == null && context != null) {
            f24689a = context.getApplicationContext();
        }
        return C0675a.f24692a;
    }

    private void f(String str) {
        try {
            this.f24690b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/") + "/Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f24689a));
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24689a, th2);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(bt.aW);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith("=")) {
                        substring = substring.replace("=", "");
                    }
                    sb2.append(substring);
                }
            }
            this.f24691c = sb2.toString();
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24689a, th2);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.aO);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.aJ);
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
        this.f24690b = null;
        this.f24691c = null;
    }

    public String b() {
        return this.f24690b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public String a() {
        return this.f24691c;
    }
}
