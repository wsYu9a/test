package com.martian.mibook.application;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.data.AdSlot;
import com.martian.ads.data.AdSlots;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.mibook.activity.reader.ReadingActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a */
    private final WeakReference<ReadingActivity> f11442a;

    /* renamed from: c */
    private List<AdConfig> f11444c;

    /* renamed from: d */
    private List<AdConfig> f11445d;

    /* renamed from: e */
    private b.d.a.a f11446e;

    /* renamed from: h */
    private List<AppTask> f11449h;

    /* renamed from: i */
    private Map<String, AppTask> f11450i;

    /* renamed from: j */
    private AdSlots f11451j;
    private Map<Integer, Integer> m;

    /* renamed from: f */
    private int f11447f = 1;

    /* renamed from: g */
    private long f11448g = -1;
    private int k = 0;
    private int l = 0;

    /* renamed from: b */
    private final int f11443b = MiConfigSingleton.V3().G3();

    class a extends b.d.a.k.b {
        a() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            h0.this.h(appTask);
            h0.this.r(appTask.getEcpm(), AdConfig.ActionString.SUCCESS);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            h0.this.r(0, AdConfig.ActionString.FAIL);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            h0.this.h(lossAppTask);
        }
    }

    class b extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ int f11453a;

        b(final int val$winPrice) {
            this.f11453a = val$winPrice;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            g0.D(h0.this.getActivity(), "阅读页-瀑布流-成功");
            AppTask appTask = appTaskList.getApps().get(0);
            h0.this.h(appTask);
            h0.this.v(appTask.getGroup());
            h0.this.q();
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            g0.D(h0.this.getActivity(), "阅读页-瀑布流-失败");
            h0 h0Var = h0.this;
            h0Var.v(h0Var.l(this.f11453a));
            h0.this.q();
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            h0.this.t(lossAppTask);
        }
    }

    public h0(ReadingActivity activity) {
        this.f11442a = new WeakReference<>(activity);
    }

    public ReadingActivity getActivity() {
        WeakReference<ReadingActivity> weakReference = this.f11442a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void h(AppTask appTask) {
        if (appTask == null) {
            return;
        }
        if (this.f11449h == null) {
            this.f11449h = new ArrayList();
        }
        this.f11449h.add(appTask);
    }

    private void i(AdConfig.AdInfo adInfo) {
        ReadingActivity activity = getActivity();
        if (com.martian.libmars.utils.n0.C(activity)) {
            com.martian.mibook.b.b g0 = com.martian.mibook.b.b.g0(activity, this.f11445d, this.f11447f, 0, com.martian.mibook.b.b.y, b.d.a.j.b.f4370c, adInfo);
            g0.D(activity, "阅读页-价签-请求");
            g0.T0(new a());
            g0.F();
        }
    }

    private void j(Activity activity, int winPrice) {
        com.martian.mibook.b.b h0 = com.martian.mibook.b.b.h0(activity, this.f11444c, this.f11447f, winPrice, false, com.martian.mibook.b.b.y, b.d.a.j.b.f4370c, null, this.f11450i, this.k, this.l);
        g0.D(activity, "阅读页-瀑布流-请求");
        h0.T0(new b(winPrice));
        this.f11447f++;
        h0.F();
    }

    public int l(int winEcpm) {
        List<AdConfig> list;
        if (winEcpm <= 0 || (list = this.f11444c) == null) {
            return -1;
        }
        for (AdConfig adConfig : list) {
            if (winEcpm >= adConfig.getEcpm()) {
                return adConfig.getGroup();
            }
        }
        return -1;
    }

    private void m(String gid) {
        AdSlots c2 = MiConfigSingleton.V3().e4().c(b.d.a.j.b.f4370c);
        this.f11451j = c2;
        if (c2 != null && c2.getSlots() != null && !this.f11451j.getSlots().isEmpty()) {
            for (AdSlot adSlot : this.f11451j.getSlots()) {
                if (adSlot.getWeight() > 0 && adSlot.sourceEnable() && !com.martian.mibook.b.b.q0(adSlot) && adSlot.isSupportAd() && (!adSlot.isShakeStyle() || !MiConfigSingleton.V3().j5())) {
                    AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                    buildAdConfig.setGid(gid);
                    if (adSlot.isCsjUnion()) {
                        buildAdConfig.setPrimeRit(k0.m1);
                    }
                    if (adSlot.isBqtUnion()) {
                        buildAdConfig.setBaeArticleInfo(this.f11446e);
                    }
                    if (adSlot.isShakeStyle()) {
                        buildAdConfig.setShakeStyle(true);
                    }
                    if (adSlot.isVivoUnion()) {
                        buildAdConfig.setWxAppid(k0.f11476d);
                    }
                    if (adSlot.isBidding()) {
                        if (this.f11445d == null) {
                            this.f11445d = new ArrayList();
                        }
                        this.f11445d.add(buildAdConfig);
                    } else {
                        if (this.f11444c == null) {
                            this.f11444c = new ArrayList();
                        }
                        this.f11444c.add(buildAdConfig);
                    }
                    if (adSlot.getEcpmPercent().doubleValue() > 0.0d) {
                        buildAdConfig.setEcpmPercent(adSlot.getEcpmPercent().doubleValue());
                    }
                }
            }
        }
        List<AdConfig> list = this.f11444c;
        if (list == null) {
            this.f11444c = new ArrayList();
            if (MiConfigSingleton.V3().U5()) {
                this.f11444c.add(AdConfig.buildAdConfig(com.martian.mibook.b.b.v0()));
                return;
            }
            String str = k0.m1;
            this.f11444c.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(600).setSid(k0.k1)).setPrimeRit(str).setGid(gid).setShakeStyle(true));
            this.f11444c.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(400).setSid(k0.l1)).setPrimeRit(str).setGid(gid).setShakeStyle(true));
            this.f11444c.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.BQT).setWeight(1).setEcpm(300).setSid(k0.r1)).setAppid(k0.p).setBaeArticleInfo(this.f11446e).setGid(gid));
            this.f11444c.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(120).setSid(k0.n1)).setPrimeRit(str).setGid(gid));
            this.f11444c.add(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.CSJ).setWeight(1).setEcpm(60).setSid(k0.i1)).setPrimeRit(str).setGid(gid));
        } else {
            list.add(AdConfig.buildAdConfig(com.martian.mibook.b.b.v0()));
            Collections.sort(this.f11444c, new Comparator() { // from class: com.martian.mibook.application.i
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return h0.o((AdConfig) obj, (AdConfig) obj2);
                }
            });
        }
        AdSlots adSlots = this.f11451j;
        int minGroupSlots = adSlots == null ? 2 : adSlots.getMinGroupSlots();
        int ecpm = this.f11444c.get(0).getEcpm();
        if (this.m == null) {
            this.m = new HashMap();
        }
        int i2 = 0;
        int i3 = 0;
        for (AdConfig adConfig : this.f11444c) {
            if (adConfig.getEcpm() != ecpm) {
                ecpm = adConfig.getEcpm();
                if (i2 >= minGroupSlots) {
                    i3++;
                    i2 = 0;
                }
            }
            if (i2 == 0) {
                this.m.put(Integer.valueOf(i3), Integer.valueOf(ecpm));
            }
            i2++;
            adConfig.setGroup(i3);
        }
    }

    private boolean n() {
        return System.currentTimeMillis() - this.f11448g < 3000;
    }

    static /* synthetic */ int o(AdConfig lefInfo, AdConfig rightInfo) {
        return rightInfo.getEcpm() - lefInfo.getEcpm();
    }

    static /* synthetic */ int p(AppTask lefInfo, AppTask rightInfo) {
        return rightInfo.getEcpm() - lefInfo.getEcpm();
    }

    public void q() {
        List<AppTask> list = this.f11449h;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.f11449h, new Comparator() { // from class: com.martian.mibook.application.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return h0.p((AppTask) obj, (AppTask) obj2);
            }
        });
        AppTaskList appTaskList = new AppTaskList();
        Iterator<AppTask> it = this.f11449h.iterator();
        for (int i2 = 0; it.hasNext() && ((i2 != 1 || this.f11443b > 0) && i2 < 3); i2++) {
            AppTask next = it.next();
            if (i2 != 0 && next.getEcpm() < this.f11443b) {
                break;
            }
            g0.N(next);
            appTaskList.addAppTask(next);
            it.remove();
        }
        s(appTaskList);
    }

    public void r(int winPrice, String event) {
        ReadingActivity activity = getActivity();
        if (com.martian.libmars.utils.n0.C(activity)) {
            g0.D(activity, "阅读页-价签-" + event);
            j(activity, winPrice);
        }
    }

    private void s(@NonNull AppTaskList appTaskList) {
        if (appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
            g0.D(getActivity(), "阅读页-失败");
            return;
        }
        g0.L(appTaskList.getApps().get(0), this.f11449h);
        if (getActivity() != null) {
            getActivity().S6(appTaskList);
        }
    }

    public void t(AppTask appTask) {
        if (this.f11450i == null) {
            this.f11450i = new HashMap();
        }
        if (g0.o(this.f11450i.get(appTask.id))) {
            return;
        }
        this.f11450i.put(appTask.id, appTask);
    }

    public void v(int successGroup) {
        int bestOffset;
        AdSlots adSlots = this.f11451j;
        if (adSlots == null || adSlots.getBestOffset() <= 0 || successGroup < 0 || (bestOffset = (successGroup - this.k) - this.f11451j.getBestOffset()) == 0) {
            return;
        }
        if (bestOffset > 0) {
            int maxOffset = this.f11451j.getMaxOffset();
            double d2 = bestOffset;
            double downRatio = this.f11451j.getDownRatio();
            Double.isNaN(d2);
            this.k += Math.min(maxOffset, (int) Math.ceil(d2 * downRatio));
        } else {
            int maxOffset2 = this.f11451j.getMaxOffset();
            double abs = Math.abs(bestOffset);
            double upRatio = this.f11451j.getUpRatio();
            Double.isNaN(abs);
            int min = Math.min(maxOffset2, (int) Math.ceil(abs * upRatio));
            int i2 = this.k;
            if (i2 <= min) {
                this.k = 0;
            } else {
                this.k = i2 - min;
            }
        }
        Map<Integer, Integer> map = this.m;
        if (map != null) {
            Integer num = map.get(Integer.valueOf(this.k));
            this.l = num != null ? num.intValue() : 0;
        }
    }

    public void k(String sourceString, AdConfig.AdInfo adInfo) {
        if (n()) {
            return;
        }
        this.f11448g = System.currentTimeMillis();
        if (this.f11444c == null) {
            m(sourceString);
        }
        i(adInfo);
    }

    public void u(b.d.a.a baeArticleInfo) {
        this.f11446e = baeArticleInfo;
    }
}
