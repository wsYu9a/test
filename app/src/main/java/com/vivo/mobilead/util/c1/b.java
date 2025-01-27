package com.vivo.mobilead.util.c1;

import android.content.Context;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile b f30567a;

    private b() {
    }

    public static b a() {
        if (f30567a == null) {
            synchronized (b.class) {
                if (f30567a == null) {
                    f30567a = new b();
                }
            }
        }
        return f30567a;
    }

    private void d(Context context) {
        int i2;
        boolean z = false;
        try {
            i2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("vivo_ad_version_code", 0);
        } catch (Exception unused) {
            i2 = -1;
        }
        try {
            x0.c("ExceptionCheckSelf", "AndroidManifest声明的版本号:" + i2);
        } catch (Exception unused2) {
            z = true;
            x0.c("ExceptionCheckSelf", "AndroidManifest未声明广告SDK版本号e");
            if (z) {
                return;
            } else {
                return;
            }
        }
        if (z || i2 == 5760) {
            return;
        }
        x0.c("ExceptionCheckSelf", "AndroidManifest写入版本号与广告SDK实际版本号不符,SDK版本号：5760");
        throw new IllegalStateException("AndroidManifest写入版本号与广告SDK实际版本号不符");
    }

    public void b(Context context) {
        a.a(context);
    }

    public void c(Context context) {
        b(context);
        a(context);
        d(context);
    }

    public boolean a(Context context) {
        return a.a(context, "com.vivo.mobilead.web.VivoADSDKWebView");
    }
}
