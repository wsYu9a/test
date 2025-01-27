package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static k f24905a;

    /* renamed from: b */
    private com.tencent.bugly.crashreport.common.strategy.c f24906b;

    /* renamed from: c */
    private com.tencent.bugly.crashreport.common.info.a f24907c;

    /* renamed from: d */
    private e f24908d;

    /* renamed from: e */
    private Context f24909e;

    private k(Context context) {
        h g2 = h.g();
        if (g2 == null) {
            return;
        }
        this.f24906b = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f24907c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f24908d = g2.r;
        this.f24909e = context;
        W.c().a(new i(this));
    }

    public void b() {
        X.a("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.proguard.o");
            this.f24907c.getClass();
            ca.a(cls, "sdkPackageName", "com.tencent.bugly", (Object) null);
            X.a("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            X.c("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    private CrashDetailBean c(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.F = this.f24907c.v();
        crashDetailBean.G = this.f24907c.w();
        crashDetailBean.H = this.f24907c.x();
        crashDetailBean.w = ca.a(this.f24909e, h.f24859e, h.f24862h);
        crashDetailBean.f24788b = i2;
        crashDetailBean.f24791e = this.f24907c.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f24907c;
        crashDetailBean.f24792f = aVar.E;
        crashDetailBean.f24793g = aVar.i();
        crashDetailBean.m = this.f24907c.y();
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        sb.append("");
        sb.append(str);
        crashDetailBean.n = sb.toString();
        crashDetailBean.o = "" + str2;
        if (str3 != null) {
            String[] split = str3.split("\n");
            if (split.length > 0) {
                str4 = split[0];
            }
        } else {
            str3 = "";
        }
        crashDetailBean.p = str4;
        crashDetailBean.q = str3;
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ca.c(crashDetailBean.q.getBytes());
        crashDetailBean.z = ca.a(h.f24860f, false);
        crashDetailBean.A = this.f24907c.f24755h;
        crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.I = this.f24907c.r();
        crashDetailBean.f24794h = this.f24907c.p();
        com.tencent.bugly.crashreport.common.info.a aVar2 = this.f24907c;
        crashDetailBean.N = aVar2.f24751d;
        crashDetailBean.O = aVar2.C();
        if (!h.g().f()) {
            this.f24908d.d(crashDetailBean);
        }
        crashDetailBean.R = this.f24907c.A();
        crashDetailBean.S = this.f24907c.t();
        crashDetailBean.T = this.f24907c.h();
        crashDetailBean.U = this.f24907c.g();
        crashDetailBean.y = ba.b();
        if (crashDetailBean.P == null) {
            crashDetailBean.P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.P.putAll(map);
        }
        return crashDetailBean;
    }

    public static k a(Context context) {
        if (f24905a == null) {
            f24905a = new k(context);
        }
        return f24905a;
    }

    public static void a(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        W.c().a(new j(thread, i2, str, str2, str3, map));
    }

    public void b(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else {
            if (i2 != 8) {
                X.e("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
                return;
            }
            str4 = "H5";
        }
        String str5 = str4;
        X.b("[ExtraCrashManager] %s Crash Happen", str5);
        try {
            if (!this.f24906b.d()) {
                X.e("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c2 = this.f24906b.c();
            if (!c2.f24768f && this.f24906b.d()) {
                X.b("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a(str5, ca.a(), this.f24907c.f24755h, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 != 5 && i2 != 6) {
                if (i2 == 8 && !c2.l) {
                    X.b("[ExtraCrashManager] %s report is disabled.", str5);
                    X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!c2.k) {
                X.b("[ExtraCrashManager] %s report is disabled.", str5);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            CrashDetailBean c3 = c(currentThread, i2 == 8 ? 5 : i2, str, str2, str3, map);
            if (c3 == null) {
                X.b("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            e.a(str5, ca.a(), this.f24907c.f24755h, currentThread.getName(), str + "\n" + str2 + "\n" + str3, c3);
            if (!this.f24908d.c(c3)) {
                this.f24908d.a(c3, 3000L, false);
            }
            X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
