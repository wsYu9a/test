package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alipay.sdk.app.AuthTask;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static final int f5440a = 73;

    /* renamed from: b */
    public static final Object f5441b = AuthTask.class;

    /* renamed from: c */
    private static boolean f5442c;

    public static String a(Activity activity, String str) {
        StringBuilder sb;
        String str2;
        if (!b(activity)) {
            return c(activity, str);
        }
        if (activity.getRequestedOrientation() == 0) {
            activity.setRequestedOrientation(1);
            f5442c = true;
        }
        g gVar = new g(activity);
        if (!str.contains("bizcontext=")) {
            if (str.contains("\"")) {
                sb = new StringBuilder();
                sb.append(str);
                str2 = b.b.a.b.a.q;
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = b.b.a.b.a.r;
            }
            sb.append(str2);
            str = sb.toString();
        }
        String c2 = gVar.c(str);
        if (TextUtils.equals(c2, g.f5460a)) {
            if (f5442c) {
                activity.setRequestedOrientation(0);
                f5442c = false;
            }
            return c(activity, str);
        }
        if (TextUtils.isEmpty(c2)) {
            return com.alipay.sdk.app.d.a();
        }
        if (f5442c) {
            activity.setRequestedOrientation(0);
            f5442c = false;
        }
        return c2;
    }

    private static boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 73;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static String c(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) com.alipay.sdk.app.a.class);
        intent.putExtra("params", str);
        activity.startActivity(intent);
        Object obj = f5441b;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
            }
        }
        String str2 = com.alipay.sdk.app.d.f5308a;
        return TextUtils.isEmpty(str2) ? com.alipay.sdk.app.d.a() : str2;
    }
}
