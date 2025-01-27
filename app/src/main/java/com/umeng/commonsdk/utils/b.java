package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static HashMap<String, PackageInfo> f26480a = new HashMap<>();

    /* renamed from: b */
    private static Object f26481b = new Object();

    private static class a {

        /* renamed from: a */
        private static final b f26482a = new b();

        private a() {
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f26482a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i2) {
        PackageInfo packageInfo;
        synchronized (f26481b) {
            packageInfo = null;
            if (f26480a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f26480a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f26480a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    f26480a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                }
            }
        }
        return packageInfo;
    }
}
