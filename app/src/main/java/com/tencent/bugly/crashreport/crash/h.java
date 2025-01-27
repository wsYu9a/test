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
    public static int f22462a = 0;

    /* renamed from: b */
    public static boolean f22463b = false;

    /* renamed from: c */
    public static int f22464c = 2;

    /* renamed from: d */
    public static boolean f22465d = true;

    /* renamed from: e */
    public static int f22466e = 20480;

    /* renamed from: f */
    public static int f22467f = 20480;

    /* renamed from: g */
    public static long f22468g = 604800000;

    /* renamed from: h */
    public static String f22469h = null;

    /* renamed from: i */
    public static boolean f22470i = false;

    /* renamed from: j */
    public static String f22471j = null;

    /* renamed from: k */
    public static int f22472k = 5000;

    /* renamed from: l */
    public static boolean f22473l = true;

    /* renamed from: m */
    public static boolean f22474m = false;

    /* renamed from: n */
    public static String f22475n;

    /* renamed from: o */
    public static String f22476o;

    /* renamed from: p */
    private static h f22477p;
    private int A = 31;
    private boolean B = false;

    /* renamed from: q */
    private final Context f22478q;

    /* renamed from: r */
    public final e f22479r;

    /* renamed from: s */
    private final l f22480s;

    /* renamed from: t */
    private final NativeCrashHandler f22481t;

    /* renamed from: u */
    public final com.tencent.bugly.crashreport.common.strategy.c f22482u;

    /* renamed from: v */
    public final W f22483v;

    /* renamed from: w */
    private final com.tencent.bugly.crashreport.crash.anr.h f22484w;

    /* renamed from: x */
    public BuglyStrategy.a f22485x;

    /* renamed from: y */
    public m f22486y;

    /* renamed from: z */
    private Boolean f22487z;

    public h(int i10, Context context, W w10, boolean z10, BuglyStrategy.a aVar, m mVar, String str) {
        f22462a = i10;
        Context a10 = ca.a(context);
        this.f22478q = a10;
        com.tencent.bugly.crashreport.common.strategy.c b10 = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f22482u = b10;
        this.f22483v = w10;
        this.f22485x = aVar;
        this.f22486y = mVar;
        T a11 = T.a();
        J a12 = J.a();
        e eVar = new e(i10, a10, a11, a12, b10, aVar, mVar);
        this.f22479r = eVar;
        com.tencent.bugly.crashreport.common.info.a a13 = com.tencent.bugly.crashreport.common.info.a.a(a10);
        this.f22480s = new l(a10, eVar, b10, a13);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a10, a13, eVar, b10, w10, z10, str);
        this.f22481t = nativeCrashHandler;
        a13.f22313pa = nativeCrashHandler;
        this.f22484w = com.tencent.bugly.crashreport.crash.anr.h.a(a10, b10, a13, w10, a12, eVar, aVar);
    }

    public static synchronized h g() {
        h hVar;
        synchronized (h.class) {
            hVar = f22477p;
        }
        return hVar;
    }

    public void c() {
        this.f22484w.b(false);
    }

    public void d() {
        this.f22480s.b();
    }

    public void e() {
        this.f22481t.setUserOpened(false);
    }

    public boolean f() {
        return this.B;
    }

    public boolean h() {
        Boolean bool = this.f22487z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.m().f22296h;
        List<L> a10 = J.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a10 == null || a10.size() <= 0) {
            this.f22487z = Boolean.FALSE;
            return false;
        }
        for (L l10 : a10) {
            if (str.equals(l10.f22630c)) {
                this.f22487z = Boolean.TRUE;
                arrayList.add(l10);
            }
        }
        if (arrayList.size() > 0) {
            J.a().a(arrayList);
        }
        return true;
    }

    public boolean i() {
        return this.f22484w.b();
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
        this.f22484w.b(true);
    }

    public void q() {
        this.f22481t.enableCatchAnrTrace();
    }

    public void r() {
        this.f22480s.a();
    }

    public void s() {
        this.f22481t.setUserOpened(true);
    }

    public synchronized void t() {
        this.f22484w.g();
    }

    public void u() {
        this.f22481t.checkUploadRecordCrash();
    }

    public static synchronized h a(int i10, Context context, boolean z10, BuglyStrategy.a aVar, m mVar, String str) {
        h hVar;
        synchronized (h.class) {
            try {
                if (f22477p == null) {
                    f22477p = new h(i10, context, W.c(), z10, aVar, mVar, str);
                }
                hVar = f22477p;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    public synchronized void b() {
        d();
        e();
        c();
    }

    public void a(StrategyBean strategyBean) {
        this.f22480s.a(strategyBean);
        this.f22481t.onStrategyChanged(strategyBean);
        this.f22484w.a(strategyBean);
        a(3000L);
    }

    public synchronized void a(boolean z10, boolean z11, boolean z12) {
        this.f22481t.testNativeCrash(z10, z11, z12);
    }

    public void a(Thread thread, Throwable th2, boolean z10, String str, byte[] bArr, boolean z11) {
        this.f22483v.a(new f(this, z10, thread, th2, str, bArr, z11));
    }

    public void a(CrashDetailBean crashDetailBean) {
        this.f22479r.f(crashDetailBean);
    }

    public void a(long j10) {
        W.c().a(new g(this), j10);
    }

    public void a() {
        if (com.tencent.bugly.crashreport.common.info.a.m().f22296h.equals(AppInfo.d(this.f22478q))) {
            this.f22481t.removeEmptyNativeRecordFiles();
        }
    }

    public void a(int i10) {
        this.A = i10;
    }

    public void a(boolean z10) {
        this.B = z10;
    }
}
