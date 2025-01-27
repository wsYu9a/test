package org.codechimp.apprater;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a */
    private String f35373a;

    /* renamed from: b */
    private int f35374b;

    /* renamed from: c */
    private String f35375c;

    private c() {
    }

    public static c a(Context context) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            try {
                packageInfo = packageManager.getPackageInfo(context.getApplicationInfo().packageName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            applicationInfo = null;
        }
        c cVar = new c();
        cVar.f35373a = packageManager.getApplicationLabel(applicationInfo).toString();
        cVar.f35374b = packageInfo.versionCode;
        cVar.f35375c = packageInfo.versionName;
        return cVar;
    }

    public String b() {
        return this.f35373a;
    }

    public int c() {
        return this.f35374b;
    }

    public String d() {
        return this.f35375c;
    }
}
