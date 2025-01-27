package n3;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b */
    public static b f28776b;

    /* renamed from: a */
    public Context f28777a;

    public static b e() {
        if (f28776b == null) {
            f28776b = new b();
        }
        return f28776b;
    }

    public static boolean f() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i10 = 0; i10 < 10; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }

    public b3.b a() {
        return b3.b.e();
    }

    public void b(Context context) {
        b3.b.e();
        this.f28777a = context.getApplicationContext();
    }

    public Context c() {
        return this.f28777a;
    }

    public String d() {
        return com.alipay.sdk.m.w.b.d(null, this.f28777a);
    }
}
