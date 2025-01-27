package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static HashMap<String, PackageInfo> f24819a = new HashMap<>();

    /* renamed from: b */
    private static Object f24820b = new Object();

    public static class a {

        /* renamed from: a */
        private static final b f24821a = new b();

        private a() {
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f24821a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i10) {
        PackageInfo packageInfo;
        synchronized (f24820b) {
            try {
                if (f24819a.containsKey(str)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                    packageInfo = f24819a.get(str);
                } else {
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, i10);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                        f24819a.put(str, packageInfo);
                    } catch (PackageManager.NameNotFoundException unused) {
                        f24819a.put(str, null);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                        packageInfo = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return packageInfo;
    }
}
