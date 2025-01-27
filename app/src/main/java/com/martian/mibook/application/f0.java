package com.martian.mibook.application;

import android.app.Activity;
import android.os.Handler;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.data.AdSlot;
import com.martian.ads.data.AdSlots;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class f0 {

    /* renamed from: a */
    private final WeakReference<ReadingActivity> f11386a;

    /* renamed from: f */
    private List<AdConfig> f11391f;

    /* renamed from: g */
    private List<AdConfig> f11392g;

    /* renamed from: h */
    private b.d.a.a f11393h;

    /* renamed from: i */
    private List<AppTaskList> f11394i;
    private List<AppTask> l;
    private Map<String, AppTask> m;
    private AdSlots n;
    private Map<Integer, Integer> q;

    /* renamed from: j */
    private int f11395j = 1;
    private long k = -1;
    private int o = 0;
    private int p = 0;

    /* renamed from: b */
    private final int f11387b = MiConfigSingleton.V3().f3();

    /* renamed from: c */
    private final int f11388c = MiConfigSingleton.V3().W3().getBannerAdInterval().intValue() * 1000;

    /* renamed from: d */
    private final int f11389d = MiConfigSingleton.V3().W3().getBannerOptimizeBaseEcpm();

    /* renamed from: e */
    private final int f11390e = MiConfigSingleton.V3().W3().getBannerMaxExtraDelay() * 1000;

    class a extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ String f11396a;

        /* renamed from: b */
        final /* synthetic */ boolean f11397b;

        /* renamed from: c */
        final /* synthetic */ AdConfig.AdInfo f11398c;

        a(final String val$adInfo, final boolean val$returnImmediately, final AdConfig.AdInfo val$sourceString) {
            this.f11396a = val$adInfo;
            this.f11397b = val$returnImmediately;
            this.f11398c = val$sourceString;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            f0.this.h(appTask);
            f0.this.x(appTask.getEcpm(), this.f11396a, this.f11397b, AdConfig.ActionString.SUCCESS, this.f11398c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            f0.this.x(0, this.f11396a, this.f11397b, AdConfig.ActionString.FAIL, this.f11398c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            f0.this.h(lossAppTask);
        }
    }

    class b extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ String f11400a;

        /* renamed from: b */
        final /* synthetic */ boolean f11401b;

        /* renamed from: c */
        final /* synthetic */ AdConfig.AdInfo f11402c;

        /* renamed from: d */
        final /* synthetic */ int f11403d;

        b(final String val$winPrice, final boolean val$adInfo, final AdConfig.AdInfo val$returnImmediately, final int val$sourceString) {
            this.f11400a = val$winPrice;
            this.f11401b = val$adInfo;
            this.f11402c = val$returnImmediately;
            this.f11403d = val$sourceString;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            g0.D(f0.this.getActivity(), "Banner-瀑布流-成功");
            AppTask appTask = appTaskList.getApps().get(0);
            f0.this.h(appTask);
            f0.this.A(appTask.getGroup());
            f0.this.v(this.f11400a, this.f11401b, this.f11402c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            g0.D(f0.this.getActivity(), "Banner-瀑布流-失败");
            f0 f0Var = f0.this;
            f0Var.A(f0Var.n(this.f11403d));
            f0.this.v(this.f11400a, this.f11401b, this.f11402c);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            f0.this.y(lossAppTask);
        }
    }

    public f0(ReadingActivity activity) {
        this.f11386a = new WeakReference<>(activity);
    }

    public void A(int successGroup) {
        int bestOffset;
        AdSlots adSlots = this.n;
        if (adSlots == null || adSlots.getBestOffset() <= 0 || successGroup < 0 || (bestOffset = (successGroup - this.o) - this.n.getBestOffset()) == 0) {
            return;
        }
        if (bestOffset > 0) {
            int maxOffset = this.n.getMaxOffset();
            double d2 = bestOffset;
            double downRatio = this.n.getDownRatio();
            Double.isNaN(d2);
            this.o += Math.min(maxOffset, (int) Math.ceil(d2 * downRatio));
        } else {
            int maxOffset2 = this.n.getMaxOffset();
            double abs = Math.abs(bestOffset);
            double upRatio = this.n.getUpRatio();
            Double.isNaN(abs);
            int min = Math.min(maxOffset2, (int) Math.ceil(abs * upRatio));
            int i2 = this.o;
            if (i2 <= min) {
                this.o = 0;
            } else {
                this.o = i2 - min;
            }
        }
        Map<Integer, Integer> map = this.q;
        if (map != null) {
            Integer num = map.get(Integer.valueOf(this.o));
            this.p = num != null ? num.intValue() : 0;
        }
    }

    public ReadingActivity getActivity() {
        WeakReference<ReadingActivity> weakReference = this.f11386a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void h(AppTask appTask) {
        if (appTask == null) {
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList();
        }
        this.l.add(appTask);
    }

    private void j(String sourceString, boolean returnImmediately, AdConfig.AdInfo adInfo) {
        ReadingActivity activity = getActivity();
        if (q() || !com.martian.libmars.utils.n0.C(activity)) {
            return;
        }
        this.k = System.currentTimeMillis();
        g0.D(activity, "Banner-价签-请求");
        if (this.f11391f == null) {
            p(sourceString);
        }
        com.martian.mibook.b.b g0 = com.martian.mibook.b.b.g0(activity, this.f11392g, this.f11395j, 0, com.martian.mibook.b.b.w, b.d.a.j.b.f4369b, adInfo);
        g0.T0(new a(sourceString, returnImmediately, adInfo));
        g0.F();
    }

    private void k(Activity activity, int winPrice, String sourceString, boolean returnImmediately, AdConfig.AdInfo adInfo) {
        com.martian.mibook.b.b h0 = com.martian.mibook.b.b.h0(activity, this.f11391f, this.f11395j, winPrice, false, com.martian.mibook.b.b.w, b.d.a.j.b.f4369b, null, this.m, this.o, this.p);
        h0.T0(new b(sourceString, returnImmediately, adInfo, winPrice));
        g0.D(activity, "Banner-瀑布流-请求");
        this.f11395j++;
        h0.F();
    }

    public int n(int winEcpm) {
        List<AdConfig> list;
        if (winEcpm <= 0 || (list = this.f11391f) == null) {
            return -1;
        }
        for (AdConfig adConfig : list) {
            if (winEcpm >= adConfig.getEcpm()) {
                return adConfig.getGroup();
            }
        }
        return -1;
    }

    private List<AppTaskList> o() {
        if (this.f11394i == null) {
            this.f11394i = new ArrayList();
        }
        return this.f11394i;
    }

    private void p(String gid) {
        AdSlots c2 = MiConfigSingleton.V3().e4().c(b.d.a.j.b.f4369b);
        this.n = c2;
        if (c2 != null && c2.getSlots() != null && !this.n.getSlots().isEmpty()) {
            for (AdSlot adSlot : this.n.getSlots()) {
                if (adSlot.getWeight() > 0 && adSlot.sourceEnable() && !com.martian.mibook.b.b.q0(adSlot) && adSlot.isSupportAd()) {
                    AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                    buildAdConfig.setGid(gid);
                    if (adSlot.isCsjUnion()) {
                        buildAdConfig.setPrimeRit(k0.b0);
                    }
                    if (adSlot.isBqtUnion()) {
                        buildAdConfig.setBaeArticleInfo(this.f11393h);
                    }
                    if (adSlot.isVivoUnion()) {
                        buildAdConfig.setWxAppid(k0.f11476d);
                    }
                    if (adSlot.isBidding()) {
                        if (this.f11392g == null) {
                            this.f11392g = new ArrayList();
                        }
                        this.f11392g.add(buildAdConfig);
                    } else {
                        if (this.f11391f == null) {
                            this.f11391f = new ArrayList();
                        }
                        this.f11391f.add(buildAdConfig);
                    }
                    if (adSlot.getEcpmPercent().doubleValue() > 0.0d) {
                        buildAdConfig.setEcpmPercent(adSlot.getEcpmPercent().doubleValue());
                    }
                }
            }
        }
        List<AdConfig> list = this.f11391f;
        if (list == null) {
            this.f11391f = new ArrayList();
            if (MiConfigSingleton.V3().U5()) {
                this.f11391f.add(AdConfig.buildAdConfig(com.martian.mibook.b.b.v0()));
                return;
            }
            String str = k0.b0;
            this.f11391f.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.BQT).setWeight(1).setEcpm(300).setSid(k0.f0)).setAppid(k0.p).setBaeArticleInfo(this.f11393h).setGid(gid));
            this.f11391f.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(250).setSid(k0.a0)).setPrimeRit(str).setGid(gid));
            this.f11391f.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(Integer.valueOf(TinkerReport.KEY_APPLIED_VERSION_CHECK)).setSid(k0.b0)).setPrimeRit(str).setGid(gid));
            this.f11391f.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.BANNER_TT).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(120).setSid(k0.Y)).setPrimeRit(str).setGid(gid));
            this.f11391f.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(60).setSid(k0.Z)).setPrimeRit(str).setGid(gid));
        } else {
            list.add(AdConfig.buildAdConfig(com.martian.mibook.b.b.v0()));
            Collections.sort(this.f11391f, new Comparator() { // from class: com.martian.mibook.application.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return f0.r((AdConfig) obj, (AdConfig) obj2);
                }
            });
        }
        AdSlots adSlots = this.n;
        int minGroupSlots = adSlots == null ? 2 : adSlots.getMinGroupSlots();
        int ecpm = this.f11391f.get(0).getEcpm();
        if (this.q == null) {
            this.q = new HashMap();
        }
        int i2 = 0;
        int i3 = 0;
        for (AdConfig adConfig : this.f11391f) {
            if (adConfig.getEcpm() != ecpm) {
                ecpm = adConfig.getEcpm();
                if (i2 >= minGroupSlots) {
                    i3++;
                    i2 = 0;
                }
            }
            if (i2 == 0) {
                this.q.put(Integer.valueOf(i3), Integer.valueOf(ecpm));
            }
            i2++;
            adConfig.setGroup(i3);
        }
    }

    private boolean q() {
        return System.currentTimeMillis() - this.k < 3000;
    }

    static /* synthetic */ int r(AdConfig lefInfo, AdConfig rightInfo) {
        return rightInfo.getEcpm() - lefInfo.getEcpm();
    }

    static /* synthetic */ int s(AppTask lefInfo, AppTask rightInfo) {
        return rightInfo.getEcpm() - lefInfo.getEcpm();
    }

    /* renamed from: t */
    public /* synthetic */ void u(final String sourceString, final AdConfig.AdInfo adInfo) {
        j(sourceString, false, adInfo);
    }

    public void v(String sourceString, boolean returnImmediately, AdConfig.AdInfo adInfo) {
        List<AppTask> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.l, new Comparator() { // from class: com.martian.mibook.application.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f0.s((AppTask) obj, (AppTask) obj2);
            }
        });
        AppTaskList appTaskList = new AppTaskList();
        Iterator<AppTask> it = this.l.iterator();
        for (int i2 = 0; it.hasNext() && ((i2 != 1 || this.f11387b > 0) && i2 < 2); i2++) {
            AppTask next = it.next();
            if (i2 != 0 && next.getEcpm() < this.f11387b) {
                break;
            }
            g0.N(next);
            appTaskList.addAppTask(next);
            it.remove();
        }
        w(appTaskList, sourceString, returnImmediately, adInfo);
    }

    private void w(AppTaskList appTaskList, final String sourceString, boolean returnImmediately, final AdConfig.AdInfo adInfo) {
        if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
            g0.D(getActivity(), "Banner-失败");
            return;
        }
        if (!returnImmediately || getActivity() == null) {
            o().add(appTaskList);
        } else {
            getActivity().u7(appTaskList, m(appTaskList.getApps().get(0).getEcpm()));
            if (o().isEmpty()) {
                new Handler().postDelayed(new Runnable() { // from class: com.martian.mibook.application.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        f0.this.u(sourceString, adInfo);
                    }
                }, Math.max(3000, (this.f11388c - 20000) + r6));
            }
        }
        g0.L(appTaskList.getApps().get(0), this.l);
    }

    public void x(int winPrice, String sourceString, boolean returnImmediately, String event, AdConfig.AdInfo adInfo) {
        ReadingActivity activity = getActivity();
        if (com.martian.libmars.utils.n0.C(activity)) {
            g0.D(activity, "Banner-价签-" + event);
            k(activity, winPrice, sourceString, returnImmediately, adInfo);
        }
    }

    public void y(AppTask appTask) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        if (g0.o(this.m.get(appTask.id))) {
            return;
        }
        this.m.put(appTask.id, appTask);
    }

    public void i() {
        if (o().isEmpty()) {
            return;
        }
        Iterator<AppTaskList> it = o().iterator();
        while (it.hasNext()) {
            g0.q(it.next());
        }
    }

    public void l(String sourceString, AdConfig.AdInfo adInfo) {
        if (o().isEmpty()) {
            j(sourceString, true, adInfo);
        } else {
            w(o().remove(0), sourceString, true, adInfo);
        }
    }

    public int m(int ecpm) {
        int i2 = this.f11389d;
        if (i2 <= 0 || ecpm <= i2) {
            return 0;
        }
        int i3 = this.f11388c;
        return Math.min(((ecpm * i3) / i2) - i3, this.f11390e);
    }

    public void z(b.d.a.a baeArticleInfo) {
        this.f11393h = baeArticleInfo;
    }
}
