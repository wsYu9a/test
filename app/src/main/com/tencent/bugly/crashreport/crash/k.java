package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C0870o;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static k f22535a;

    /* renamed from: b */
    private com.tencent.bugly.crashreport.common.strategy.c f22536b;

    /* renamed from: c */
    private com.tencent.bugly.crashreport.common.info.a f22537c;

    /* renamed from: d */
    private e f22538d;

    /* renamed from: e */
    private Context f22539e;

    private k(Context context) {
        h g10 = h.g();
        if (g10 == null) {
            return;
        }
        this.f22536b = com.tencent.bugly.crashreport.common.strategy.c.b();
        this.f22537c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f22538d = g10.f22479r;
        this.f22539e = context;
        W.c().a(new i(this));
    }

    public void b() {
        X.a("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            this.f22537c.getClass();
            ca.a((Class<?>) C0870o.class, "sdkPackageName", "com.tencent.bugly", (Object) null);
            X.a("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            X.c("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    private CrashDetailBean c(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.F = this.f22537c.v();
        crashDetailBean.G = this.f22537c.w();
        crashDetailBean.H = this.f22537c.x();
        crashDetailBean.f22396w = ca.a(this.f22539e, h.f22466e, h.f22469h);
        crashDetailBean.f22375b = i10;
        crashDetailBean.f22378e = this.f22537c.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f22537c;
        crashDetailBean.f22379f = aVar.E;
        crashDetailBean.f22380g = aVar.i();
        crashDetailBean.f22386m = this.f22537c.y();
        StringBuilder sb2 = new StringBuilder();
        String str4 = "";
        sb2.append("");
        sb2.append(str);
        crashDetailBean.f22387n = sb2.toString();
        crashDetailBean.f22388o = "" + str2;
        if (str3 != null) {
            String[] split = str3.split("\n");
            if (split.length > 0) {
                str4 = split[0];
            }
        } else {
            str3 = "";
        }
        crashDetailBean.f22389p = str4;
        crashDetailBean.f22390q = str3;
        crashDetailBean.f22391r = System.currentTimeMillis();
        crashDetailBean.f22394u = ca.c(crashDetailBean.f22390q.getBytes());
        crashDetailBean.f22399z = ca.a(h.f22467f, false);
        crashDetailBean.A = this.f22537c.f22296h;
        crashDetailBean.B = thread.getName() + "(" + thread.getId() + ")";
        crashDetailBean.I = this.f22537c.r();
        crashDetailBean.f22381h = this.f22537c.p();
        com.tencent.bugly.crashreport.common.info.a aVar2 = this.f22537c;
        crashDetailBean.N = aVar2.f22288d;
        crashDetailBean.O = aVar2.C();
        if (!h.g().f()) {
            this.f22538d.d(crashDetailBean);
        }
        crashDetailBean.R = this.f22537c.A();
        crashDetailBean.S = this.f22537c.t();
        crashDetailBean.T = this.f22537c.h();
        crashDetailBean.U = this.f22537c.g();
        crashDetailBean.f22398y = ba.b();
        if (crashDetailBean.P == null) {
            crashDetailBean.P = new LinkedHashMap();
        }
        if (map != null) {
            crashDetailBean.P.putAll(map);
        }
        return crashDetailBean;
    }

    public static k a(Context context) {
        if (f22535a == null) {
            f22535a = new k(context);
        }
        return f22535a;
    }

    public static void a(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        W.c().a(new j(thread, i10, str, str2, str3, map));
    }

    public void b(Thread thread, int i10, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i10 == 4) {
            str4 = "Unity";
        } else if (i10 == 5 || i10 == 6) {
            str4 = "Cocos";
        } else {
            if (i10 != 8) {
                X.e("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i10));
                return;
            }
            str4 = "H5";
        }
        String str5 = str4;
        X.b("[ExtraCrashManager] %s Crash Happen", str5);
        try {
            if (!this.f22536b.d()) {
                X.e("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c10 = this.f22536b.c();
            if (!c10.f22342f && this.f22536b.d()) {
                X.b("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a(str5, ca.a(), this.f22537c.f22296h, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i10 != 5 && i10 != 6) {
                if (i10 == 8 && !c10.f22348l) {
                    X.b("[ExtraCrashManager] %s report is disabled.", str5);
                    X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!c10.f22347k) {
                X.b("[ExtraCrashManager] %s report is disabled.", str5);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            CrashDetailBean c11 = c(currentThread, i10 == 8 ? 5 : i10, str, str2, str3, map);
            if (c11 == null) {
                X.b("[ExtraCrashManager] Failed to package crash data.", new Object[0]);
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            e.a(str5, ca.a(), this.f22537c.f22296h, currentThread.getName(), str + "\n" + str2 + "\n" + str3, c11);
            if (!this.f22538d.c(c11)) {
                this.f22538d.a(c11, 3000L, false);
            }
            X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th2) {
            try {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th3) {
                X.b("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th3;
            }
        }
    }
}
