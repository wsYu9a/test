package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.L;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    public static int f24855a = 0;

    /* renamed from: b */
    public static boolean f24856b = false;

    /* renamed from: c */
    public static int f24857c = 2;

    /* renamed from: d */
    public static boolean f24858d = true;

    /* renamed from: e */
    public static int f24859e = 20480;

    /* renamed from: f */
    public static int f24860f = 20480;

    /* renamed from: g */
    public static long f24861g = 604800000;

    /* renamed from: h */
    public static String f24862h = null;

    /* renamed from: i */
    public static boolean f24863i = false;

    /* renamed from: j */
    public static String f24864j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m = false;
    public static String n;
    public static String o;
    private static h p;
    private int A = 31;
    private boolean B = false;
    private final Context q;
    public final e r;
    private final l s;
    private final NativeCrashHandler t;
    public final com.tencent.bugly.crashreport.common.strategy.c u;
    public final W v;
    private final com.tencent.bugly.crashreport.crash.anr.h w;
    public BuglyStrategy.a x;
    public m y;
    private Boolean z;

    protected h(int i2, Context context, W w, boolean z, BuglyStrategy.a aVar, m mVar, String str) {
        f24855a = i2;
        Context a2 = ca.a(context);
        this.q = a2;
        com.tencent.bugly.crashreport.common.strategy.c b2 = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.u = b2;
        this.v = w;
        this.x = aVar;
        this.y = mVar;
        T a3 = T.a();
        J a4 = J.a();
        e eVar = new e(i2, a2, a3, a4, b2, aVar, mVar);
        this.r = eVar;
        com.tencent.bugly.crashreport.common.info.a a5 = com.tencent.bugly.crashreport.common.info.a.a(a2);
        this.s = new l(a2, eVar, b2, a5);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a5, eVar, b2, w, z, str);
        this.t = nativeCrashHandler;
        a5.pa = nativeCrashHandler;
        this.w = com.tencent.bugly.crashreport.crash.anr.h.a(a2, b2, a5, w, a4, eVar, aVar);
    }

    public static synchronized h g() {
        h hVar;
        synchronized (h.class) {
            hVar = p;
        }
        return hVar;
    }

    public void c() {
        this.w.b(false);
    }

    public void d() {
        this.s.b();
    }

    public void e() {
        this.t.setUserOpened(false);
    }

    public boolean f() {
        return this.B;
    }

    public boolean h() {
        Boolean bool = this.z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.m().f24755h;
        List<L> a2 = J.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 == null || a2.size() <= 0) {
            this.z = Boolean.FALSE;
            return false;
        }
        for (L l2 : a2) {
            if (str.equals(l2.f24981c)) {
                this.z = Boolean.TRUE;
                arrayList.add(l2);
            }
        }
        if (arrayList.size() > 0) {
            J.a().a(arrayList);
        }
        return true;
    }

    public boolean i() {
        return this.w.b();
    }

    public boolean j() {
        return (this.A & 8) > 0;
    }

    public boolean k() {
        return (this.A & 16) > 0;
    }

    public boolean l() {
        return (this.A & 2) > 0;
    }

    public boolean m() {
        return (this.A & 1) > 0;
    }

    public boolean n() {
        return (this.A & 4) > 0;
    }

    public synchronized void o() {
        r();
        s();
        p();
    }

    public void p() {
        this.w.b(true);
    }

    public void q() {
        this.t.enableCatchAnrTrace();
    }

    public void r() {
        this.s.a();
    }

    public void s() {
        this.t.setUserOpened(true);
    }

    public synchronized void t() {
        this.w.g();
    }

    public void u() {
        this.t.checkUploadRecordCrash();
    }

    public static synchronized h a(int i2, Context context, boolean z, BuglyStrategy.a aVar, m mVar, String str) {
        h hVar;
        synchronized (h.class) {
            if (p == null) {
                p = new h(i2, context, W.c(), z, aVar, mVar, str);
            }
            hVar = p;
        }
        return hVar;
    }

    public synchronized void b() {
        d();
        e();
        c();
    }

    public void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.a(strategyBean);
        a(3000L);
    }

    public synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    public void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        this.v.a(new f(this, z, thread, th, str, bArr, z2));
    }

    public void a(CrashDetailBean crashDetailBean) {
        this.r.f(crashDetailBean);
    }

    public void a(long j2) {
        W.c().a(new g(this), j2);
    }

    public void a() {
        if (com.tencent.bugly.crashreport.common.info.a.m().f24755h.equals(AppInfo.d(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public void a(int i2) {
        this.A = i2;
    }

    public void a(boolean z) {
        this.B = z;
    }
}
