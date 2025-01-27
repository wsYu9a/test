package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static f f25431a = null;

    /* renamed from: c */
    protected static final b f25432c = new b(c(), c.m, c.f25423g, c.f25424h, c.f25419c, c.f25425i, 10, c.f25421e, c.n);

    /* renamed from: d */
    private static boolean f25433d = false;

    /* renamed from: b */
    protected a f25434b = new a(f25432c);

    private f() {
    }

    public static f a() {
        if (f25431a == null) {
            synchronized (f.class) {
                if (f25431a == null) {
                    f25431a = new f();
                    f25433d = true;
                }
            }
        }
        return f25431a;
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void c(String str, String str2) {
        a().a(4, str, str2, null);
    }

    public static final void d(String str, String str2) {
        a().a(8, str, str2, null);
    }

    public static final void e(String str, String str2) {
        a().a(16, str, str2, null);
    }

    public static final void b(String str, String str2, Throwable th) {
        a().a(16, str, str2, th);
    }

    protected static File c() {
        String str = c.f25420d;
        d.c b2 = d.b.b();
        return b2 != null && (b2.c() > c.f25422f ? 1 : (b2.c() == c.f25422f ? 0 : -1)) > 0 ? new File(Environment.getExternalStorageDirectory(), str) : new File(com.tencent.open.utils.d.c(), str);
    }

    protected void d() {
        a aVar = this.f25434b;
        if (aVar != null) {
            aVar.a();
            this.f25434b.b();
            this.f25434b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f25431a != null) {
                f25431a = null;
            }
        }
    }

    protected void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        if (f25433d) {
            String b2 = com.tencent.open.utils.d.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f25434b == null) {
                    return;
                }
                e.f25430a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f25434b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f25433d = false;
            }
        }
        e.f25430a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f25418b, i2) || (aVar = this.f25434b) == null) {
            return;
        }
        aVar.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
    }
}
