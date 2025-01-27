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
    public static int f22361a = 1000;

    /* renamed from: b */
    private static c f22362b;

    /* renamed from: c */
    private static String f22363c;

    /* renamed from: d */
    private final List<com.tencent.bugly.a> f22364d;

    /* renamed from: e */
    private final W f22365e;

    /* renamed from: f */
    private final StrategyBean f22366f;

    /* renamed from: g */
    private StrategyBean f22367g = null;

    /* renamed from: h */
    private Context f22368h;

    public c(Context context, List<com.tencent.bugly.a> list) {
        this.f22368h = context;
        a(context);
        this.f22366f = new StrategyBean();
        this.f22364d = list;
        this.f22365e = W.c();
    }

    public StrategyBean c() {
        StrategyBean strategyBean = this.f22367g;
        if (strategyBean != null) {
            if (!ca.c(strategyBean.f22353q)) {
                this.f22367g.f22353q = StrategyBean.f22337a;
            }
            if (!ca.c(this.f22367g.f22354r)) {
                this.f22367g.f22354r = StrategyBean.f22338b;
            }
            return this.f22367g;
        }
        if (!ca.b(f22363c) && ca.c(f22363c)) {
            StrategyBean strategyBean2 = this.f22366f;
            String str = f22363c;
            strategyBean2.f22353q = str;
            strategyBean2.f22354r = str;
        }
        return this.f22366f;
    }

    public synchronized boolean d() {
        return this.f22367g != null;
    }

    public StrategyBean e() {
        byte[] bArr;
        List<L> a10 = J.a().a(2);
        if (a10 == null || a10.size() <= 0 || (bArr = a10.get(0).f22634g) == null) {
            return null;
        }
        return (StrategyBean) ca.a(bArr, StrategyBean.CREATOR);
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            cVar = f22362b;
        }
        return cVar;
    }

    public static synchronized c a(Context context, List<com.tencent.bugly.a> list) {
        c cVar;
        synchronized (c.class) {
            try {
                if (f22362b == null) {
                    f22362b = new c(context, list);
                }
                cVar = f22362b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    public void a(long j10) {
        this.f22365e.a(new b(this), j10);
    }

    public void a(StrategyBean strategyBean, boolean z10) {
        X.a("[Strategy] Notify %s", f.class.getName());
        f.a(strategyBean, z10);
        for (com.tencent.bugly.a aVar : this.f22364d) {
            try {
                X.a("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th2) {
                if (!X.b(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ca.b(str) && ca.c(str)) {
            f22363c = str;
        } else {
            X.e("URL user set is invalid.", new Object[0]);
        }
    }

    public void a(sa saVar) {
        if (saVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f22367g;
        if (strategyBean == null || saVar.f22860k != strategyBean.f22351o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f22342f = saVar.f22853d;
            strategyBean2.f22344h = saVar.f22855f;
            strategyBean2.f22343g = saVar.f22854e;
            if (ca.b(f22363c) || !ca.c(f22363c)) {
                if (ca.c(saVar.f22856g)) {
                    X.a("[Strategy] Upload url changes to %s", saVar.f22856g);
                    strategyBean2.f22353q = saVar.f22856g;
                }
                if (ca.c(saVar.f22857h)) {
                    X.a("[Strategy] Exception upload url changes to %s", saVar.f22857h);
                    strategyBean2.f22354r = saVar.f22857h;
                }
            }
            ra raVar = saVar.f22858i;
            if (raVar != null && !ca.b(raVar.f22847a)) {
                strategyBean2.f22355s = saVar.f22858i.f22847a;
            }
            long j10 = saVar.f22860k;
            if (j10 != 0) {
                strategyBean2.f22351o = j10;
            }
            Map<String, String> map = saVar.f22859j;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = saVar.f22859j;
                strategyBean2.f22356t = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f22345i = true;
                } else {
                    strategyBean2.f22345i = false;
                }
                String str2 = saVar.f22859j.get("B3");
                if (str2 != null) {
                    strategyBean2.f22359w = Long.valueOf(str2).longValue();
                }
                long j11 = saVar.f22864o;
                strategyBean2.f22352p = j11;
                strategyBean2.f22358v = j11;
                String str3 = saVar.f22859j.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f22357u = parseInt;
                        }
                    } catch (Exception e10) {
                        if (!X.b(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                String str4 = saVar.f22859j.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.f22347k = true;
                } else {
                    strategyBean2.f22347k = false;
                }
            }
            X.c("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f22342f), Boolean.valueOf(strategyBean2.f22344h), Boolean.valueOf(strategyBean2.f22343g), Boolean.valueOf(strategyBean2.f22345i), Boolean.valueOf(strategyBean2.f22346j), Boolean.valueOf(strategyBean2.f22349m), Boolean.valueOf(strategyBean2.f22350n), Long.valueOf(strategyBean2.f22352p), Boolean.valueOf(strategyBean2.f22347k), Long.valueOf(strategyBean2.f22351o));
            this.f22367g = strategyBean2;
            if (!ca.c(saVar.f22856g)) {
                X.a("[Strategy] download url is null", new Object[0]);
                this.f22367g.f22353q = "";
            }
            if (!ca.c(saVar.f22857h)) {
                X.a("[Strategy] download crashurl is null", new Object[0]);
                this.f22367g.f22354r = "";
            }
            J.a().b(2);
            L l10 = new L();
            l10.f22629b = 2;
            l10.f22628a = strategyBean2.f22340d;
            l10.f22632e = strategyBean2.f22341e;
            l10.f22634g = ca.a(strategyBean2);
            J.a().c(l10);
            a(strategyBean2, true);
        }
    }

    private static void a(Context context) {
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str = com.tencent.bugly.crashreport.common.info.a.a(context).f22293fa;
            if ("oversea".equals(str)) {
                StrategyBean.f22337a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.f22338b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f22337a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.f22338b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
    }
}
