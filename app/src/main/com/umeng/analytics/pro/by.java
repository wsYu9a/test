package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.net.URL;

/* loaded from: classes4.dex */
public class by {

    /* renamed from: a */
    public static final String f23696a = "resolve.umeng.com";

    /* renamed from: b */
    public static final int f23697b = 15000;

    /* renamed from: c */
    private static cc f23698c = null;

    /* renamed from: d */
    private static volatile int f23699d = -1;

    public static class a {

        /* renamed from: a */
        public static final by f23700a = new by();

        private a() {
        }
    }

    public /* synthetic */ by(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static by a() {
        return a.f23700a;
    }

    private String c() {
        if (f23698c == null) {
            f23698c = cc.b();
        }
        ca caVar = new ca("https://resolve.umeng.com/resolve", ca.a.GET, null, f23698c);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return caVar.a(f23697b, "");
    }

    public synchronized boolean b() {
        try {
            if (f23699d < 0) {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "cj_domain", "0");
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + imprintProperty);
                if ("1".equalsIgnoreCase(imprintProperty)) {
                    f23699d = 1;
                } else {
                    f23699d = 0;
                }
            }
            return f23699d <= 0;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private by() {
    }

    public synchronized String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c();
        String c10 = cc.b().c();
        if (!TextUtils.isEmpty(c10)) {
            str2 = "https://" + c10 + "/" + str;
        }
        return str2;
    }

    private static String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return "https://" + str + "/" + str2;
        }
        return "";
    }

    public static String b(String str) {
        try {
            String c10 = c(str);
            return str.substring(str.indexOf(c10) + c10.length() + 1);
        } catch (Throwable unused) {
            return "";
        }
    }
}
