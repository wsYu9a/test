package com.martian.mibook.application;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b8.e;
import b8.j;
import ba.m;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.DefaultAd;
import com.martian.ads.data.AdSlot;
import com.martian.ads.data.AdSlots;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import xa.p;
import ya.e0;

/* loaded from: classes3.dex */
public abstract class b {
    public final int A;
    public Long B;
    public c C;
    public final int D;
    public int E;
    public int F;

    /* renamed from: a */
    public final WeakReference<Activity> f13480a;

    /* renamed from: b */
    public int f13481b;

    /* renamed from: d */
    public AdSlots f13483d;

    /* renamed from: e */
    public List<AdConfig> f13484e;

    /* renamed from: f */
    public List<AdConfig> f13485f;

    /* renamed from: g */
    public List<AppTaskList> f13486g;

    /* renamed from: h */
    public Map<String, AppTask> f13487h;

    /* renamed from: k */
    public int f13490k;

    /* renamed from: l */
    public final String f13491l;

    /* renamed from: n */
    public final j f13493n;

    /* renamed from: o */
    public AdConfig.AdInfo f13494o;

    /* renamed from: p */
    public final boolean f13495p;

    /* renamed from: q */
    public boolean f13496q;

    /* renamed from: r */
    public int f13497r;

    /* renamed from: t */
    public final int f13499t;

    /* renamed from: u */
    public final int f13500u;

    /* renamed from: v */
    public final int f13501v;

    /* renamed from: w */
    public final int f13502w;

    /* renamed from: x */
    public final int f13503x;

    /* renamed from: y */
    public final int f13504y;

    /* renamed from: z */
    public final int f13505z;

    /* renamed from: c */
    public int f13482c = 1;

    /* renamed from: i */
    public long f13488i = -1;

    /* renamed from: j */
    public int f13489j = 0;

    /* renamed from: m */
    public int f13492m = 1;

    /* renamed from: s */
    public int f13498s = 10;

    public class a extends d8.b {

        /* renamed from: a */
        public boolean f13506a = false;

        /* renamed from: b */
        public boolean f13507b = false;

        public a() {
        }

        @Override // d8.b, d8.a
        public void a() {
            b.this.L();
            e.A(null, "onFallbackFailed");
            b bVar = b.this;
            bVar.m0(bVar.f13490k);
            b.this.Y(new AppTaskList().addAppTask(b.this.r()));
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (this.f13506a) {
                return;
            }
            this.f13506a = true;
            MiConfigSingleton.b2().H1().y(adConfig);
            MiConfigSingleton.b2().V1().l(EventManager.f13208k, adConfig.getAdNameInfo(), adConfig.getEcpm());
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, x8.c cVar) {
            adConfig.increaseFailTimes();
        }

        @Override // d8.b, d8.a
        public void h(AppTask appTask) {
            b.this.l(appTask);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            adConfig.setFailTimes(0);
            b.this.c0();
            AppTask appTask = appTaskList.getApps().get(0);
            b.this.m0(appTask.isBidding() ? b.this.s(appTask.getEcpm()) : appTask.getGroup());
            if (b.this.f13495p) {
                if (b.this.f13494o == null) {
                    b.this.f13494o = new AdConfig.AdInfo();
                }
                b.this.f13494o.setSource(appTask.source);
                b.this.f13494o.setEcpm(appTask.getEcpm());
            }
            b.this.Y(appTaskList);
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (this.f13507b) {
                return;
            }
            this.f13507b = true;
            MiConfigSingleton.b2().H1().x(adConfig);
            MiConfigSingleton.b2().V1().l(EventManager.f13209l, adConfig.getAdNameInfo(), adConfig.getEcpm());
            b.this.d0();
            b.this.Z();
        }
    }

    /* renamed from: com.martian.mibook.application.b$b */
    public class C0526b implements ReadingInstance.d {

        /* renamed from: a */
        public final /* synthetic */ Activity f13509a;

        /* renamed from: b */
        public final /* synthetic */ String f13510b;

        public C0526b(Activity activity, String str) {
            this.f13509a = activity;
            this.f13510b = str;
        }

        @Override // com.martian.mibook.application.ReadingInstance.d
        public void a() {
            b.this.f13496q = true;
            ac.a.p(this.f13509a, b.this.F() + this.f13510b);
        }

        @Override // com.martian.mibook.application.ReadingInstance.d
        public void onAdExposed() {
            b.this.c0();
        }
    }

    public interface c {
        void a();
    }

    public b(Activity activity, String str, j jVar, boolean z10) {
        this.f13480a = new WeakReference<>(activity);
        this.f13491l = str;
        this.f13495p = z10;
        this.f13493n = jVar;
        N(E());
        this.f13499t = y();
        this.f13500u = D();
        this.f13501v = x();
        this.f13502w = B();
        this.f13503x = w();
        this.f13504y = MiConfigSingleton.b2().c2().getMisClickMaxRate();
        this.f13505z = MiConfigSingleton.b2().c2().getMisClickMinSecondsV2() * 1000;
        this.A = A();
        this.D = C();
        k0();
    }

    public static /* synthetic */ int Q(AdConfig adConfig, AdConfig adConfig2) {
        return adConfig2.getEcpm() - adConfig.getEcpm();
    }

    public abstract int A();

    public abstract int B();

    public abstract int C();

    public abstract int D();

    public abstract String E();

    public abstract String F();

    public List<AppTaskList> G() {
        if (this.f13486g == null) {
            this.f13486g = new ArrayList();
        }
        return this.f13486g;
    }

    public final List<AdConfig> H() {
        if (this.f13485f == null) {
            this.f13485f = new ArrayList();
        }
        return this.f13485f;
    }

    public boolean I(@NonNull AppTask appTask) {
        int v10;
        if (MiConfigSingleton.b2().C2()) {
            return false;
        }
        if (!MiBookManager.V1(appTask) && !DefaultAd.isDefaultAd(appTask)) {
            if (appTask.customView != null || !o(appTask.source) || (v10 = v(appTask.source)) <= 0 || X()) {
                return false;
            }
            r1 = new Random().nextInt(1000) < Math.min(this.f13504y, (this.f13503x * appTask.getEcpm()) / v10);
            if (r1) {
                g0();
                appTask.setWithMisClick(true);
                c cVar = this.C;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
        return r1;
    }

    public void J() {
        this.F++;
    }

    public void K() {
        this.E++;
    }

    public final void L() {
        Activity activity = getActivity();
        if (activity != null) {
            ac.a.p(activity, F() + "-填充失败");
        }
        int i10 = this.f13497r;
        if (i10 < 0) {
            this.f13497r = 4;
            i0(activity, "-暂停请求-再次失败");
            return;
        }
        int i11 = i10 + 1;
        this.f13497r = i11;
        if (i11 >= 4) {
            i0(activity, "-暂停请求");
        }
    }

    public final void M() {
        if (n()) {
            return;
        }
        this.f13490k = 0;
        int minGroupSlots = this.f13483d.getMinGroupSlots();
        int ecpm = H().get(0).getEcpm();
        int i10 = 0;
        for (AdConfig adConfig : H()) {
            if (adConfig.getEcpm() != ecpm) {
                ecpm = adConfig.getEcpm();
                if (i10 >= minGroupSlots) {
                    this.f13490k++;
                    i10 = 0;
                }
            }
            i10++;
            adConfig.setGroup(this.f13490k);
        }
    }

    public final void N(String str) {
        AdSlots f10 = MiConfigSingleton.b2().f2().f(str);
        this.f13483d = f10;
        if (f10 == null) {
            this.f13483d = new AdSlots().setPid(str);
        }
        if (ConfigSingleton.D().w0()) {
            q().add(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, AdConfig.UnionType.MENTA, "P0794", 1, 100).setBidding(1).setGid(this.f13491l).setPid(E()));
            return;
        }
        if (this.f13483d.getSlots() != null && !this.f13483d.getSlots().isEmpty()) {
            for (AdSlot adSlot : this.f13483d.getSlots()) {
                if (adSlot.getWeight() > 0 && !p.K(adSlot) && (TextUtils.isEmpty(adSlot.getScene()) || adSlot.getScene().equalsIgnoreCase(F()))) {
                    AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                    buildAdConfig.setPid(F());
                    buildAdConfig.setEcpmPercent(adSlot.getAutoEcpmPercent());
                    buildAdConfig.setGid(this.f13491l);
                    buildAdConfig.setCoolThreshold(Integer.valueOf(this.f13483d.getCoolThreshold()));
                    buildAdConfig.setCoolDuration(Integer.valueOf(this.f13483d.getCoolDuration()));
                    buildAdConfig.setDynamicUnion(this.f13483d.isDynamicUnion(adSlot.getUnion()));
                    if (j0()) {
                        buildAdConfig.setShakeStyle(adSlot.isShakeStyle());
                        buildAdConfig.setShakeMinEcpm(adSlot.getShakeMinEcpm());
                    }
                    buildAdConfig.setMinEcpm(adSlot.getMinEcpm());
                    if (adSlot.isCsjUnion()) {
                        buildAdConfig.setPrimeRit(this.f13483d.getPid());
                        buildAdConfig.setCoolPlatForm(this.f13483d.coolPlatformCsj());
                        buildAdConfig.setExpress(adSlot.isExpress());
                    } else if (adSlot.isBqtUnion()) {
                        buildAdConfig.setBaeArticleInfo(this.f13493n);
                        buildAdConfig.setAdCompliance(MiConfigSingleton.b2().C2());
                        buildAdConfig.setCoolPlatForm(this.f13483d.coolPlatformBqt());
                    } else if (adSlot.isGdtUnion()) {
                        buildAdConfig.setCoolPlatForm(this.f13483d.coolPlatformGdt());
                    } else if (adSlot.isKsUnion()) {
                        buildAdConfig.setCoolPlatForm(this.f13483d.coolPlatformKs());
                    }
                    if (adSlot.isCoolId()) {
                        buildAdConfig.setCoolPlatForm(true);
                    }
                    if (adSlot.isBidding()) {
                        q().add(buildAdConfig);
                    } else {
                        H().add(buildAdConfig);
                    }
                }
            }
        }
        if (q().isEmpty() && H().isEmpty()) {
            if (MiConfigSingleton.b2().H1().j0()) {
                return;
            }
            q().add(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, AdConfig.UnionType.BQT, e0.D, 1, 750).setBidding(1).setAppid(e0.f33168p).setBaeArticleInfo(this.f13493n).setGid(this.f13491l).setPid(F()));
            q().add(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, AdConfig.UnionType.GDT, e0.E, 1, 100).setBidding(1).setAppid(e0.f33170q).setGid(this.f13491l).setPid(F()));
            q().add(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, "KS", e0.F, 1, 100).setBidding(1).setGid(this.f13491l).setPid(F()));
        } else {
            Collections.sort(H(), new Comparator() { // from class: ya.l0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int Q;
                    Q = com.martian.mibook.application.b.Q((AdConfig) obj, (AdConfig) obj2);
                    return Q;
                }
            });
            M();
        }
    }

    public final boolean O() {
        return System.currentTimeMillis() - this.f13488i < ((long) this.f13498s) * 1000;
    }

    public final boolean P() {
        LocalDate now;
        Instant ofEpochMilli;
        ZoneId systemDefault;
        ZonedDateTime atZone;
        LocalDate localDate;
        boolean equals;
        if (this.f13488i <= 0) {
            return true;
        }
        if (!m.u()) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(this.f13488i);
            return calendar.get(6) == calendar2.get(6);
        }
        now = LocalDate.now();
        ofEpochMilli = Instant.ofEpochMilli(this.f13488i);
        systemDefault = ZoneId.systemDefault();
        atZone = ofEpochMilli.atZone(systemDefault);
        localDate = atZone.toLocalDate();
        equals = now.equals(localDate);
        return equals;
    }

    public void R() {
        if (MiConfigSingleton.b2().K2()) {
            return;
        }
        Activity activity = getActivity();
        if (O() || activity == null || this.f13483d == null || !G().isEmpty()) {
            return;
        }
        this.f13488i = System.currentTimeMillis();
        if (this.f13496q) {
            b0();
            return;
        }
        boolean N0 = ConfigSingleton.D().N0();
        boolean C2 = MiConfigSingleton.b2().C2();
        p pVar = new p(activity, E(), this.f13487h, this.f13481b, u());
        if (!q().isEmpty()) {
            for (AdConfig adConfig : q()) {
                if (this.f13495p && adConfig.isBqtAd()) {
                    adConfig.setAdInfo(this.f13494o);
                }
                if (adConfig.isCsjAd()) {
                    adConfig.setAdLoadSeq(this.f13492m);
                }
                if (!C2 || !adConfig.isShakeStyle()) {
                    if (!adConfig.isMentaAd() || N0) {
                        pVar.G(adConfig);
                    }
                }
            }
        }
        if (!H().isEmpty()) {
            for (AdConfig adConfig2 : H()) {
                if (!C2 || (!adConfig2.isShakeStyle() && AdConfig.AdType.NATIVE.equalsIgnoreCase(adConfig2.getType()) && !adConfig2.isGdtAd())) {
                    if (!adConfig2.isDynamicUnion() || adConfig2.getGroup() >= this.f13489j) {
                        if (!adConfig2.pauseAdRequest() && (!adConfig2.isMentaAd() || N0)) {
                            if (adConfig2.isCsjAd() && AdConfig.AdType.NATIVE.equals(adConfig2.getType())) {
                                adConfig2.setAdLoadSeq(this.f13492m);
                            }
                            pVar.G(adConfig2);
                        }
                    }
                }
            }
        }
        pVar.a1(new a());
        this.f13492m++;
        pVar.F0();
    }

    public boolean S() {
        return (this.D & 4) > 0;
    }

    public boolean T() {
        return (this.D & 1) > 0;
    }

    public boolean U() {
        return (this.D & 2) > 0;
    }

    public boolean V() {
        return (this.D & 8) > 0;
    }

    public boolean W() {
        return (this.D & 16) > 0;
    }

    public final boolean X() {
        return System.currentTimeMillis() < z() || a0();
    }

    public void Y(AppTaskList appTaskList) {
        if (appTaskList == null || appTaskList.isEmpty()) {
            return;
        }
        G().add(appTaskList);
    }

    public void Z() {
    }

    public final boolean a0() {
        int i10 = this.E;
        if (i10 <= 0) {
            return false;
        }
        boolean z10 = (this.F * 1000) / i10 > this.f13504y * 2;
        if (z10) {
            ac.a.n(getActivity(), "误点-点击率超标");
        }
        return z10;
    }

    public final void b0() {
        int i10 = this.f13497r - 1;
        this.f13497r = i10;
        if (i10 <= 0) {
            this.f13496q = false;
            this.f13497r = -1;
        }
    }

    public final void c0() {
        this.f13497r = 0;
        this.f13496q = false;
    }

    public void d0() {
        m0(0);
    }

    public void e0(int i10) {
        this.f13498s = i10;
    }

    public void f0() {
        this.B = Long.valueOf(System.currentTimeMillis() + this.f13505z);
    }

    public final void g0() {
        this.B = Long.valueOf(System.currentTimeMillis() + this.f13505z + this.A);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f13480a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void h0(c cVar) {
        this.C = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i0(Activity activity, String str) {
        if (activity instanceof gd.a) {
            ((gd.a) activity).x0(new C0526b(activity, str));
        }
    }

    public abstract boolean j0();

    public void k0() {
        this.f13481b = t();
    }

    public final void l(AppTask appTask) {
        if (this.f13487h == null) {
            this.f13487h = new HashMap();
        }
        if (com.martian.mibook.application.a.z(this.f13487h.get(appTask.f12000id))) {
            this.f13487h.put(appTask.f12000id, appTask);
        }
    }

    public void l0(int i10) {
        int i11 = this.f13481b;
        if (i11 <= 0) {
            return;
        }
        if (i10 >= i11) {
            if (this.f13482c < u()) {
                this.f13482c++;
            }
        } else {
            int i12 = this.f13482c;
            if (i12 > 1) {
                this.f13482c = i12 - 1;
            }
        }
    }

    public void m() {
        List<AppTaskList> G = G();
        if (!G.isEmpty()) {
            Iterator<AppTaskList> it = G.iterator();
            while (it.hasNext()) {
                com.martian.mibook.application.a.G(it.next());
            }
            G.clear();
        }
        Map<String, AppTask> map = this.f13487h;
        if (map != null && !map.isEmpty()) {
            Iterator<AppTask> it2 = this.f13487h.values().iterator();
            while (it2.hasNext()) {
                com.martian.mibook.application.a.F(it2.next());
            }
            this.f13487h.clear();
        }
        this.C = null;
    }

    public final void m0(int i10) {
        int bestOffset;
        if (n() || (bestOffset = (i10 - this.f13489j) - this.f13483d.getBestOffset()) == 0) {
            return;
        }
        if (bestOffset > 0) {
            this.f13489j += Math.min(this.f13483d.getMaxOffset(), (int) Math.ceil(bestOffset * this.f13483d.getDownRatio()));
            return;
        }
        int min = Math.min(this.f13483d.getMaxOffset(), (int) Math.ceil(Math.abs(bestOffset) * this.f13483d.getUpRatio()));
        int i11 = this.f13489j;
        if (i11 <= min) {
            this.f13489j = 0;
        } else {
            this.f13489j = i11 - min;
        }
    }

    public final boolean n() {
        AdSlots adSlots = this.f13483d;
        return adSlots == null || adSlots.getBestOffset() <= 0 || this.f13483d.getDynamicUnion() <= 0 || H().isEmpty();
    }

    public final boolean o(String str) {
        return AdConfig.UnionType.CSJ.equalsIgnoreCase(str) ? T() : AdConfig.UnionType.GDT.equalsIgnoreCase(str) ? U() : "KS".equalsIgnoreCase(str) ? V() : AdConfig.UnionType.BQT.equalsIgnoreCase(str) ? S() : W();
    }

    public AppTaskList p() {
        if (G().isEmpty()) {
            return null;
        }
        AppTaskList remove = G().remove(0);
        if (!com.martian.mibook.application.a.z(remove.getApps().get(0))) {
            return remove;
        }
        R();
        return null;
    }

    public final List<AdConfig> q() {
        if (this.f13484e == null) {
            this.f13484e = new ArrayList();
        }
        return this.f13484e;
    }

    public abstract AppTask r();

    public final int s(int i10) {
        if (n()) {
            return 0;
        }
        if (i10 > 0) {
            for (AdConfig adConfig : H()) {
                if (i10 >= adConfig.getEcpm()) {
                    return adConfig.getGroup();
                }
            }
        }
        return this.f13490k;
    }

    public abstract int t();

    public abstract int u();

    public final int v(String str) {
        return AdConfig.UnionType.GDT.equalsIgnoreCase(str) ? this.f13500u : "KS".equalsIgnoreCase(str) ? this.f13502w : AdConfig.UnionType.BQT.equalsIgnoreCase(str) ? this.f13501v : this.f13499t;
    }

    public abstract int w();

    public abstract int x();

    public abstract int y();

    public final long z() {
        if (this.B == null) {
            this.B = Long.valueOf(System.currentTimeMillis() + 30000);
        }
        return this.B.longValue();
    }
}
