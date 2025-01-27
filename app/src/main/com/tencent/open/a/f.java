package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static f f23164a = null;

    /* renamed from: c */
    protected static final b f23165c = new b(c(), c.f23158m, c.f23152g, c.f23153h, c.f23148c, c.f23154i, 10, c.f23150e, c.f23159n);

    /* renamed from: d */
    private static boolean f23166d = false;

    /* renamed from: b */
    protected a f23167b = new a(f23165c);

    private f() {
    }

    public static f a() {
        if (f23164a == null) {
            synchronized (f.class) {
                try {
                    if (f23164a == null) {
                        f23164a = new f();
                        f23166d = true;
                    }
                } finally {
                }
            }
        }
        return f23164a;
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

    public static final void b(String str, String str2, Throwable th2) {
        a().a(16, str, str2, th2);
    }

    public static File c() {
        String str = c.f23149d;
        d.c b10 = d.b.b();
        return (b10 == null || b10.c() <= c.f23151f) ? new File(com.tencent.open.utils.d.c(), str) : new File(Environment.getExternalStorageDirectory(), str);
    }

    public void d() {
        a aVar = this.f23167b;
        if (aVar != null) {
            aVar.a();
            this.f23167b.b();
            this.f23167b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            try {
                a().d();
                if (f23164a != null) {
                    f23164a = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(int i10, String str, String str2, Throwable th2) {
        a aVar;
        if (f23166d) {
            String b10 = com.tencent.open.utils.d.b();
            if (!TextUtils.isEmpty(b10)) {
                String str3 = b10 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f23167b == null) {
                    return;
                }
                e.f23163a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f23167b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f23166d = false;
            }
        }
        e.f23163a.b(i10, Thread.currentThread(), System.currentTimeMillis(), str, str2, th2);
        if (!d.a.a(c.f23147b, i10) || (aVar = this.f23167b) == null) {
            return;
        }
        aVar.b(i10, Thread.currentThread(), System.currentTimeMillis(), str, str2, th2);
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th2) {
        a().a(2, str, str2, th2);
    }
}
