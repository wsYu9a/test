package dh;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import pk.b;

/* loaded from: classes4.dex */
public final class a {
    public static void a(Context context) {
        if (pk.a.f29922a) {
            return;
        }
        b bVar = b.a.f29929a;
        Context a10 = pk.a.a(context);
        bVar.getClass();
        boolean z10 = false;
        try {
            PackageInfo packageInfo = a10.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo != null) {
                if (packageInfo.versionCode >= 1) {
                    z10 = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        pk.a.f29923b = z10;
        pk.a.f29922a = true;
    }
}
