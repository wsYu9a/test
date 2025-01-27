package vi;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public String f31539a;

    /* renamed from: b */
    public int f31540b;

    /* renamed from: c */
    public String f31541c;

    public static b a(Context context) {
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
        b bVar = new b();
        bVar.f31539a = packageManager.getApplicationLabel(applicationInfo).toString();
        bVar.f31540b = packageInfo.versionCode;
        bVar.f31541c = packageInfo.versionName;
        return bVar;
    }

    public String b() {
        return this.f31539a;
    }

    public int c() {
        return this.f31540b;
    }

    public String d() {
        return this.f31541c;
    }
}
