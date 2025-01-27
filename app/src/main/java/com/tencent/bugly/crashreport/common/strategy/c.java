package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.f;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.L;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ra;
import com.tencent.bugly.proguard.sa;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static int f24774a = 1000;

    /* renamed from: b */
    private static c f24775b;

    /* renamed from: c */
    private static String f24776c;

    /* renamed from: d */
    private final List<com.tencent.bugly.a> f24777d;

    /* renamed from: e */
    private final W f24778e;

    /* renamed from: f */
    private final StrategyBean f24779f;

    /* renamed from: g */
    private StrategyBean f24780g = null;

    /* renamed from: h */
    private Context f24781h;

    protected c(Context context, List<com.tencent.bugly.a> list) {
        this.f24781h = context;
        a(context);
        this.f24779f = new StrategyBean();
        this.f24777d = list;
        this.f24778e = W.c();
    }

    public StrategyBean c() {
        StrategyBean strategyBean = this.f24780g;
        if (strategyBean != null) {
            if (!ca.c(strategyBean.q)) {
                this.f24780g.q = StrategyBean.f24763a;
            }
            if (!ca.c(this.f24780g.r)) {
                this.f24780g.r = StrategyBean.f24764b;
            }
            return this.f24780g;
        }
        if (!ca.b(f24776c) && ca.c(f24776c)) {
            StrategyBean strategyBean2 = this.f24779f;
            String str = f24776c;
            strategyBean2.q = str;
            strategyBean2.r = str;
        }
        return this.f24779f;
    }

    public synchronized boolean d() {
        return this.f24780g != null;
    }

    public StrategyBean e() {
        byte[] bArr;
        List<L> a2 = J.a().a(2);
        if (a2 == null || a2.size() <= 0 || (bArr = a2.get(0).f24985g) == null) {
            return null;
        }
        return (StrategyBean) ca.a(bArr, StrategyBean.CREATOR);
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            cVar = f24775b;
        }
        return cVar;
    }

    public static synchronized c a(Context context, List<com.tencent.bugly.a> list) {
        c cVar;
        synchronized (c.class) {
            if (f24775b == null) {
                f24775b = new c(context, list);
            }
            cVar = f24775b;
        }
        return cVar;
    }

    public void a(long j2) {
        this.f24778e.a(new b(this), j2);
    }

    protected void a(StrategyBean strategyBean, boolean z) {
        X.a("[Strategy] Notify %s", f.class.getName());
        f.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f24777d) {
            try {
                X.a("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ca.b(str) && ca.c(str)) {
            f24776c = str;
        } else {
            X.e("URL user set is invalid.", new Object[0]);
        }
    }

    public void a(sa saVar) {
        if (saVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f24780g;
        if (strategyBean == null || saVar.k != strategyBean.o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f24768f = saVar.f25149d;
            strategyBean2.f24770h = saVar.f25151f;
            strategyBean2.f24769g = saVar.f25150e;
            if (ca.b(f24776c) || !ca.c(f24776c)) {
                if (ca.c(saVar.f25152g)) {
                    X.a("[Strategy] Upload url changes to %s", saVar.f25152g);
                    strategyBean2.q = saVar.f25152g;
                }
                if (ca.c(saVar.f25153h)) {
                    X.a("[Strategy] Exception upload url changes to %s", saVar.f25153h);
                    strategyBean2.r = saVar.f25153h;
                }
            }
            ra raVar = saVar.f25154i;
            if (raVar != null && !ca.b(raVar.f25143a)) {
                strategyBean2.s = saVar.f25154i.f25143a;
            }
            long j2 = saVar.k;
            if (j2 != 0) {
                strategyBean2.o = j2;
            }
            Map<String, String> map = saVar.f25155j;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = saVar.f25155j;
                strategyBean2.t = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f24771i = true;
                } else {
                    strategyBean2.f24771i = false;
                }
                String str2 = saVar.f25155j.get("B3");
                if (str2 != null) {
                    strategyBean2.w = Long.valueOf(str2).longValue();
                }
                long j3 = saVar.o;
                strategyBean2.p = j3;
                strategyBean2.v = j3;
                String str3 = saVar.f25155j.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.u = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!X.b(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = saVar.f25155j.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.k = true;
                } else {
                    strategyBean2.k = false;
                }
            }
            X.c("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f24768f), Boolean.valueOf(strategyBean2.f24770h), Boolean.valueOf(strategyBean2.f24769g), Boolean.valueOf(strategyBean2.f24771i), Boolean.valueOf(strategyBean2.f24772j), Boolean.valueOf(strategyBean2.m), Boolean.valueOf(strategyBean2.n), Long.valueOf(strategyBean2.p), Boolean.valueOf(strategyBean2.k), Long.valueOf(strategyBean2.o));
            this.f24780g = strategyBean2;
            if (!ca.c(saVar.f25152g)) {
                X.a("[Strategy] download url is null", new Object[0]);
                this.f24780g.q = "";
            }
            if (!ca.c(saVar.f25153h)) {
                X.a("[Strategy] download crashurl is null", new Object[0]);
                this.f24780g.r = "";
            }
            J.a().b(2);
            L l = new L();
            l.f24980b = 2;
            l.f24979a = strategyBean2.f24766d;
            l.f24983e = strategyBean2.f24767e;
            l.f24985g = ca.a(strategyBean2);
            J.a().c(l);
            a(strategyBean2, true);
        }
    }

    private static void a(Context context) {
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str = com.tencent.bugly.crashreport.common.info.a.a(context).fa;
            if ("oversea".equals(str)) {
                StrategyBean.f24763a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f24764b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f24763a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f24764b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
    }
}
