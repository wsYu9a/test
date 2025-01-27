package com.repack.bun.lib;

import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import jh.b;

/* loaded from: classes3.dex */
public class sysParamters {

    /* renamed from: d */
    public static volatile sysParamters f16627d;

    /* renamed from: a */
    public String f16628a;

    /* renamed from: b */
    public String f16629b;

    /* renamed from: c */
    public String f16630c;

    @Keep
    private String sdk_version = "10012";

    @Keep
    private sysParamters() {
    }

    public static sysParamters a() {
        if (f16627d == null) {
            synchronized (sysParamters.class) {
                try {
                    if (f16627d == null) {
                        f16627d = new sysParamters();
                    }
                } finally {
                }
            }
        }
        return f16627d;
    }

    public static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d() {
        ApplicationInfo applicationInfo = b.a().getApplicationInfo();
        return (applicationInfo == null || TextUtils.isEmpty(applicationInfo.packageName)) ? b.a().getPackageName() : applicationInfo.packageName;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f16630c)) {
            return this.f16630c;
        }
        String encode = Uri.encode(Build.MANUFACTURER);
        this.f16630c = encode;
        return encode;
    }

    public final String e() {
        return this.sdk_version;
    }
}
