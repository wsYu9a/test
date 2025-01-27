package com.martian.mibook.b;

import android.app.Activity;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.data.AdSlot;
import com.martian.ads.data.AdSlots;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.activity.j1;
import com.martian.libmars.d.h;
import com.martian.libsupport.k;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.g0;
import com.martian.mibook.application.k0;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.d.q.q0;
import com.martian.mibook.lib.account.request.auth.VideoClickParams;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b extends b.d.a.j.b {
    public static final String A = "信息流";
    public static final String B = "插屏";
    public static final String C = "奖励弹窗";
    public static final String D = "激励视频";
    public static final String E = "作者红包";
    public static final String F = "网页插屏";
    public static final String G = "任务视频";
    public static final String H = "新用户提现";
    public static final String I = "老用户提现";
    public static final String t = "闪屏";
    public static final String u = "书架";
    public static final String v = "奖励详情";
    public static final String w = "阅读Banner";
    public static final String x = "网页Banner";
    public static final String y = "阅读页";
    public static final String z = "阅读文字链";
    private final WeakReference<Activity> J;
    protected final String K;
    protected String[] M;
    protected String[] N;
    protected b.d.a.k.a Q;
    protected b.d.a.k.a R;
    private Handler S;
    private Runnable T;
    private boolean V;
    private List<AppTask> W;
    private int X;
    private int Y;
    private boolean Z;
    protected String a0;
    private Map<String, AppTask> b0;
    private AdSlots c0;
    protected final List<AdConfig> O = new ArrayList();
    protected final List<AdConfig> P = new ArrayList();
    private int U = 1;
    private final boolean L = h.F().U0();

    class a implements com.martian.apptask.e.c {
        a() {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskActivated(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskClick(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskDownload(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskInstalled(AppTask appTask) {
        }
    }

    /* renamed from: com.martian.mibook.b.b$b */
    class C0262b extends q0 {
        C0262b(j1 x0) {
            super(x0);
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(Boolean aBoolean) {
        }
    }

    class c implements b.d.a.k.a {
        c() {
        }

        @Override // b.d.a.k.a
        public void a(AdConfig config) {
            b.this.L(config, AdConfig.ActionString.SHOW);
            if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(config.getType())) {
                config.setShowTime(System.currentTimeMillis());
            }
            b.d.a.k.a aVar = b.this.R;
            if (aVar != null) {
                aVar.a(config);
            }
            b.this.M0();
        }

        @Override // b.d.a.k.a
        public void b(AdConfig config) {
            b.this.L(config, "关闭");
            b.d.a.k.a aVar = b.this.R;
            if (aVar != null) {
                aVar.b(config);
            }
        }

        @Override // b.d.a.k.a
        public void c(AdConfig config) {
            b.this.L(config, "消失");
            b.d.a.k.a aVar = b.this.R;
            if (aVar != null) {
                aVar.c(config);
            }
        }

        @Override // b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            b.d.c.b.c r0 = b.this.r0(appTaskList);
            if (r0 != null) {
                if (b.this.A()) {
                    g0.J(300, appTaskList.getApps().get(0), 10001, 10001, "900", 4);
                }
                g(config, r0);
                return;
            }
            b.this.L(config, AdConfig.ActionString.SUCCESS);
            b.this.L0();
            AppTask appTask = appTaskList.getApps().get(0);
            if (appTask.getEcpm() <= 0) {
                b.d.a.k.a aVar = b.this.R;
                if (aVar != null) {
                    aVar.i(appTask);
                }
            } else if (b.this.W == null || b.this.W.isEmpty()) {
                b.this.W = new ArrayList();
                b.this.W.add(appTask);
            } else {
                AppTask appTask2 = (AppTask) b.this.W.get(0);
                if (appTask2.getEcpm() < appTask.getEcpm()) {
                    b.d.a.k.a aVar2 = b.this.R;
                    if (aVar2 != null) {
                        aVar2.i(appTask2);
                    }
                    b.this.W.remove(0);
                    b.this.W.add(appTask);
                } else {
                    b.d.a.k.a aVar3 = b.this.R;
                    if (aVar3 != null) {
                        aVar3.i(appTask);
                    }
                }
            }
            b.this.c();
        }

        @Override // b.d.a.k.a
        public void e(AdConfig config, boolean verify) {
            b.this.L(config, "视频验证:" + verify);
            b.d.a.k.a aVar = b.this.R;
            if (aVar != null) {
                aVar.e(config, verify);
            }
        }

        @Override // b.d.a.k.a
        public void f(b.d.c.b.c errorResult) {
            b.this.L(null, errorResult.d() + "_" + errorResult.c());
        }

        @Override // b.d.a.k.a
        public void g(AdConfig config, @NonNull b.d.c.b.c errorResult) {
            if (b.this.a0()) {
                b.this.L(config, errorResult.d());
                return;
            }
            b.this.L0();
            if (b.this.A()) {
                b.this.L(config, errorResult.d());
                b.this.c();
                return;
            }
            if (errorResult.c() == 808) {
                b.this.H(errorResult.d());
            } else {
                String str = AdConfig.ActionString.FAIL;
                if (errorResult.c() != -1) {
                    str = AdConfig.ActionString.FAIL + "_" + errorResult.c() + "_" + errorResult.d();
                }
                b.this.L(config, str);
            }
            if (b.this.W == null || b.this.W.isEmpty()) {
                b.this.R();
            } else {
                b.this.c();
            }
        }

        @Override // b.d.a.k.a
        public void h() {
            b.this.L(null, b.this.j() + "-" + AdConfig.ActionString.FAIL);
            b.this.K0();
        }

        @Override // b.d.a.k.a
        public void i(AppTask lossAppTask) {
        }

        @Override // b.d.a.k.a
        public void j(AdConfig config) {
            b.this.L(config, AdConfig.ActionString.CLICK);
            if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(config.getType())) {
                b.this.S(config);
            }
            b.d.a.k.a aVar = b.this.R;
            if (aVar != null) {
                aVar.j(config);
            }
        }
    }

    public static class d {

        /* renamed from: a */
        int f11619a;

        /* renamed from: b */
        int f11620b;

        /* renamed from: c */
        int f11621c;

        /* renamed from: d */
        boolean f11622d;

        /* renamed from: e */
        int f11623e;

        /* renamed from: f */
        String f11624f;

        /* renamed from: g */
        int f11625g;

        /* renamed from: h */
        boolean f11626h;

        public int a() {
            return this.f11620b;
        }

        public String b() {
            return this.f11624f;
        }

        public int c() {
            return this.f11623e;
        }

        public int d() {
            return this.f11619a;
        }

        public int e() {
            return this.f11621c;
        }

        public int f() {
            return this.f11625g;
        }

        public boolean g() {
            return this.f11622d;
        }

        public boolean h() {
            return this.f11626h;
        }

        public d i(int adHeight) {
            this.f11620b = adHeight;
            return this;
        }

        public d j(String adTag) {
            this.f11624f = adTag;
            return this;
        }

        public d k(int adViewId) {
            this.f11623e = adViewId;
            return this;
        }

        public d l(int adWidth) {
            this.f11619a = adWidth;
            return this;
        }

        public d m(boolean chapterEndAd) {
            this.f11622d = chapterEndAd;
            return this;
        }

        public d n(int leftHeight) {
            this.f11621c = leftHeight;
            return this;
        }

        public d o(int linkAdType) {
            this.f11625g = linkAdType;
            return this;
        }

        public void p(boolean portraitAd) {
            this.f11626h = portraitAd;
        }
    }

    public b(Activity activity, String position, String pid) {
        this.K = position;
        this.J = new WeakReference<>(activity);
        this.a0 = pid;
        y0(pid);
        x0();
        P0();
        Q0();
    }

    /* renamed from: A0 */
    public /* synthetic */ void B0() {
        if (!A()) {
            c();
            this.Z = true;
        } else {
            N0();
            c();
            this.Z = true;
        }
    }

    private void C0(List<AdConfig> adConfigs, String gid, String primeRit) {
        AdSlots adSlots = this.c0;
        if (adSlots == null || adSlots.getSlots() == null || this.c0.getSlots().isEmpty()) {
            return;
        }
        for (AdSlot adSlot : this.c0.getSlots()) {
            if (!k.p(adSlot.getAppid()) && adSlot.sourceEnable() && !q0(adSlot)) {
                AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                if (!k.p(gid)) {
                    buildAdConfig.setGid(gid);
                }
                if (!k.p(primeRit) && adSlot.isCsjUnion()) {
                    buildAdConfig.setPrimeRit(primeRit);
                }
                if (adSlot.isVivoUnion()) {
                    buildAdConfig.setWxAppid(k0.f11476d);
                }
                adConfigs.add(buildAdConfig);
            }
        }
    }

    private void D0() {
        E0(0);
    }

    private void E0(int minEcpm) {
        AdSlots adSlots = this.c0;
        if (adSlots == null || adSlots.getSlots() == null || this.c0.getSlots().isEmpty()) {
            return;
        }
        for (AdSlot adSlot : this.c0.getSlots()) {
            if (adSlot.sourceEnable() && !k.p(adSlot.getAppid()) && !q0(adSlot) && adSlot.getEcpm() >= minEcpm) {
                AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                buildAdConfig.setAdLoadType(TTAdLoadType.PRELOAD);
                if (adSlot.isVivoUnion()) {
                    buildAdConfig.setWxAppid(k0.f11476d);
                }
                if (adSlot.getEcpmPercent().doubleValue() > 0.0d) {
                    buildAdConfig.setEcpmPercent(adSlot.getEcpmPercent().doubleValue());
                }
                b(buildAdConfig);
            }
        }
    }

    private void F0(AdConfig.AdInfo adInfo) {
        AdSlots adSlots = this.c0;
        if (adSlots == null || adSlots.getSlots() == null || this.c0.getSlots().isEmpty()) {
            return;
        }
        for (AdSlot adSlot : this.c0.getSlots()) {
            if (adSlot.sourceEnable() && adSlot.isExtraBidding() && !q0(adSlot)) {
                AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                buildAdConfig.setAdLoadType(TTAdLoadType.LOAD);
                if (adSlot.isVivoUnion()) {
                    buildAdConfig.setWxAppid(k0.f11476d);
                }
                if (A() && adInfo != null && buildAdConfig.isBqtAd()) {
                    buildAdConfig.setAdInfo(adInfo);
                }
                if (adSlot.getEcpmPercent().doubleValue() > 0.0d) {
                    buildAdConfig.setEcpmPercent(adSlot.getEcpmPercent().doubleValue());
                }
                b(buildAdConfig);
            }
        }
    }

    private void G0(int minEcpm) {
        AdSlots adSlots = this.c0;
        if (adSlots == null || adSlots.getSlots() == null || this.c0.getSlots().isEmpty()) {
            return;
        }
        for (AdSlot adSlot : this.c0.getSlots()) {
            if (adSlot.sourceEnable() && adSlot.isExtraVideoAd() && !q0(adSlot) && adSlot.getEcpm() >= minEcpm) {
                AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                if (adSlot.getEcpmPercent().doubleValue() > 0.0d) {
                    buildAdConfig.setEcpmPercent(adSlot.getEcpmPercent().doubleValue());
                }
                b(buildAdConfig);
            }
        }
    }

    private void I0(AdConfig adConfig, AppTaskList appTaskList) {
        M0();
        if (!a0()) {
            b.d.a.k.a aVar = this.R;
            if (aVar != null) {
                aVar.d(adConfig, appTaskList);
                return;
            }
            return;
        }
        if (appTaskList == null || appTaskList.getApps() == null || appTaskList.getApps().isEmpty()) {
            return;
        }
        g0.J(250, appTaskList.getApps().get(0), 10001, 2, "100", 2);
    }

    public static void J0(AdConfig config, String event) {
        if (config == null || k.p(event)) {
            return;
        }
        if (AdConfig.isUploadAction(event)) {
            com.martian.libugrowth.b.k().g(config.getAdsId(), config.getAction(event), config.getSource(), config.getGid(), config.getEventEcpm(event));
        }
        if (h.F().J0()) {
            String str = b.d.a.j.b.s;
            StringBuilder sb = new StringBuilder();
            sb.append(config.getSource());
            sb.append("_");
            sb.append(config.getAdsPosition());
            sb.append("_");
            sb.append(config.getType());
            sb.append("_");
            sb.append(event);
            sb.append("_");
            sb.append(config.getAdsId());
            sb.append(config.isBidding() ? "_bidding" : "");
            sb.append("_");
            sb.append(config.getEcpm());
            com.martian.libmars.utils.q0.f(str, sb.toString());
        }
    }

    public void K0() {
        b.d.a.k.a aVar;
        M0();
        if (a0() || (aVar = this.R) == null) {
            return;
        }
        aVar.h();
    }

    public void L0() {
        this.X--;
    }

    public void M0() {
        Handler handler;
        if (this.Y <= 0 || (handler = this.S) == null) {
            return;
        }
        handler.removeCallbacks(this.T);
    }

    private void N0() {
        this.X = 0;
    }

    public boolean a0() {
        return this.Z;
    }

    public static b b0(Activity activity) {
        b bVar = new b(activity, v, b.d.a.j.b.p);
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.CSJ, k0.T, 1000000, 851)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.EXPRESS, AdConfig.UnionType.CSJ, k0.U, 1000, 745)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, "KS", k0.X, 100, 110)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.API, k0.o3, 0, 10)).setUid(MiConfigSingleton.V3().D4()).setApiUrl(h.F().Q0() ? "http://120.25.201.164/testredpaper/dv/get_last_reading_page_ads.do" : "http://api.taoyuewenhua.net/redpaper/dv/get_reading_page_ads.do"));
        bVar.b(AdConfig.buildAdConfig(v0()));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.MI, k0.W, 0, 125)));
        if (MiConfigSingleton.V3().L4.S().size() > 0) {
            bVar.b(AdConfig.buildAdConfig(new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.GAME).setWeight(Integer.valueOf(!MiConfigSingleton.V3().j5() ? 1 : 0)).setEcpm(5)));
        }
        bVar.D0();
        return bVar;
    }

    public static b c0(Activity activity, boolean portrait) {
        b U0 = new b(activity, portrait ? u : A, portrait ? b.d.a.j.b.n : b.d.a.j.b.f4371d).O0().U0(8);
        U0.F0(null);
        return U0;
    }

    public static b d0(Activity activity, int minEcpm, boolean portrait) {
        b U0 = new b(activity, portrait ? u : A, portrait ? b.d.a.j.b.n : b.d.a.j.b.f4371d).U0(8);
        U0.G0(minEcpm);
        return U0;
    }

    public static b e0(Activity activity, String pid, AdConfig.AdInfo adInfo) {
        b U0 = new b(activity, B, pid).O0().U0(5);
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.BQT, k0.c1, 0, 750)).setAppid(k0.p).setBidding(1).setAdInfo(adInfo));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.BQT, k0.V0, 0, 750)).setAppid(k0.p).setBidding(1).setAdInfo(adInfo));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.GDT, k0.e1, 0, 750)).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.GDT, k0.U0, 0, 750)).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, "KS", k0.f1, 0, 750)).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, "OPPO", k0.g1, 0, 750)).setBidding(1));
        U0.F0(adInfo);
        return U0;
    }

    public static b f0(Activity activity) {
        b bVar = new b(activity, C, b.d.a.j.b.m);
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.CSJ, k0.H2, 100000, 434)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.EXPRESS, AdConfig.UnionType.CSJ, k0.G2, 1000, 671)).setWidth(295).setHeight(0));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, "KS", k0.K2, 10, 187)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.EXPRESS, AdConfig.UnionType.GDT, k0.I2, 1, 127)).setAppid(k0.q));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.EXPRESS, AdConfig.UnionType.GDT, k0.J2, 1, org.mozilla.universalchardet.prober.o.a.n)).setAppid(k0.r));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.API, k0.s3, 0, 10)).setUid(MiConfigSingleton.V3().D4()).setApiUrl(h.F().Q0() ? "http://120.25.201.164/testredpaper/dv/get_reading_page_ads.do" : "http://api.taoyuewenhua.net/redpaper/dv/get_reading_page_ads.do"));
        bVar.b(AdConfig.buildAdConfig(v0()));
        return bVar;
    }

    public static b g0(Activity activity, List<AdConfig> adConfigs, int bannerAdLoadSeq, int minEcpm, String adsPosition, String pid, AdConfig.AdInfo adInfo) {
        return h0(activity, adConfigs, bannerAdLoadSeq, minEcpm, true, adsPosition, pid, adInfo, null, 0, 0);
    }

    public static b h0(Activity activity, List<AdConfig> adConfigs, int bannerAdLoadSeq, int minEcpm, boolean isBidding, String adsPosition, String pid, AdConfig.AdInfo adInfo, Map<String, AppTask> cacheWaterfallAppTasks, int topGroup, int topGroupEcpm) {
        b bVar = new b(activity, adsPosition, pid);
        if (adConfigs != null && !adConfigs.isEmpty()) {
            for (AdConfig adConfig : adConfigs) {
                if (minEcpm > 0 && adConfig.getEcpm() < minEcpm) {
                    break;
                }
                if (isBidding) {
                    if (adConfig.isBqtAd()) {
                        adConfig.setAdInfo(adInfo);
                    }
                } else if (topGroupEcpm > 0 && topGroupEcpm > minEcpm && adConfig.getGroup() < topGroup) {
                }
                adConfig.setAdLoadSeq(bannerAdLoadSeq);
                bVar.b(adConfig);
            }
            if (isBidding) {
                bVar.U0(5).O0();
            } else {
                bVar.U0(15).R0(cacheWaterfallAppTasks);
            }
        }
        return bVar;
    }

    public static b i0(Activity activity, String gid) {
        b bVar = new b(activity, z, b.d.a.j.b.l);
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.BQT, k0.M1, 10, 3)).setGid(gid).setAppid(k0.p));
        bVar.D0();
        return bVar;
    }

    public static b j0(Activity activity, int biddingPrice) {
        b bVar = new b(activity, t, "splash");
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", AdConfig.UnionType.CSJ, k0.z, 1, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, biddingPrice)));
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", AdConfig.UnionType.BQT, k0.D, 1, 2800, biddingPrice)).setAppid(k0.p));
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", AdConfig.UnionType.BQT, k0.C, 0, TTAdConstant.STYLE_SIZE_RADIO_3_2, biddingPrice)).setAppid(k0.p));
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", "KS", k0.L, 0, TTAdConstant.STYLE_SIZE_RADIO_3_2, biddingPrice)));
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", "VIVO", k0.M, 0, 1000, biddingPrice)).setWxAppid(k0.f11476d));
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", AdConfig.UnionType.DX, k0.K, 0, 773, biddingPrice)));
        if (!MiConfigSingleton.V3().j5()) {
            bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", "OPPO", k0.N, 0, 1000, biddingPrice)));
        }
        bVar.b(AdConfig.buildAdConfig(bVar.t0("splash", "VIVO", k0.M, 0, 100, biddingPrice)).setWxAppid(k0.f11476d));
        bVar.E0(biddingPrice);
        return bVar;
    }

    public static b k0(Activity activity, boolean showAfterLoad, AdConfig.AdInfo adInfo) {
        b U0 = new b(activity, t, "splash").O0().U0(5);
        U0.b(AdConfig.buildAdConfig(U0.s0("splash", AdConfig.UnionType.BQT, k0.E, 0, 750)).setAppid(k0.p).setBidding(1).setAdInfo(adInfo));
        U0.b(AdConfig.buildAdConfig(U0.s0("splash", AdConfig.UnionType.GDT, k0.F, 0, 100)).setAppid(k0.q).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0("splash", "KS", k0.G, 0, 100)).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0("splash", "VIVO", k0.H, 0, 100)).setBidding(1).setWxAppid(k0.f11476d));
        U0.b(AdConfig.buildAdConfig(U0.s0("splash", "OPPO", k0.I, 0, 750)).setBidding(1));
        if (showAfterLoad) {
            U0.F0(adInfo);
        }
        return U0;
    }

    public static b l0(Activity activity, String pid, AdConfig.AdInfo adInfo) {
        b U0 = new b(activity, D, pid).O0().U0(5);
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.BQT, k0.k2, 0, 750)).setAppid(k0.p).setBidding(1).setAdInfo(adInfo));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.REWARD_VIDEO, AdConfig.UnionType.BQT, k0.l2, 0, 750)).setAppid(k0.p).setBidding(1).setAdInfo(adInfo));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.REWARD_VIDEO, AdConfig.UnionType.GDT, k0.m2, 0, 100)).setAppid(k0.q).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.REWARD_VIDEO, "KS", k0.n2, 1, 100)).setBidding(1));
        U0.b(AdConfig.buildAdConfig(U0.s0(AdConfig.AdType.REWARD_VIDEO, "OPPO", k0.o2, 0, 100)).setBidding(1));
        U0.F0(adInfo);
        return U0;
    }

    public static b m0(Activity activity, String pid, int minEcpm) {
        b bVar = new b(activity, D, pid);
        if (MiConfigSingleton.V3().j5()) {
            return u0(activity);
        }
        bVar.G0(minEcpm);
        return bVar;
    }

    public static b n0(Activity activity, String pid, int minEcpm) {
        b bVar = new b(activity, B, pid);
        bVar.G0(minEcpm);
        return bVar;
    }

    public static b o0(Activity activity) {
        b bVar = new b(activity, F, b.d.a.j.b.r);
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.CSJ, k0.g3, 10000, 1750)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.FULL_VIDEO, AdConfig.UnionType.CSJ, k0.h3, 10000, 1277)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.INTERSTITIAL, AdConfig.UnionType.GDT, k0.i3, 1, 100)).setAppid(k0.q));
        return bVar;
    }

    public static b p0(Activity activity) {
        b bVar = new b(activity, x, b.d.a.j.b.r);
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.CSJ, k0.G0, 100000, 51)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0("banner", AdConfig.UnionType.CSJ, k0.F0, 1000, 75)));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.GDT, k0.H0, 100, 41)).setAppid(k0.q));
        bVar.b(AdConfig.buildAdConfig(bVar.s0("banner", AdConfig.UnionType.GDT, k0.I0, 100, 41)).setAppid(k0.r));
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.NATIVE, AdConfig.UnionType.BQT, k0.J0, 100, 11)).setAppid(k0.p));
        bVar.b(AdConfig.buildAdConfig(v0()));
        return bVar;
    }

    public static boolean q0(AdSlot adSlot) {
        return MiConfigSingleton.V3().U5() ? (adSlot.isCsjUnion() && MiConfigSingleton.V3().e6()) || (adSlot.isGdtUnion() && MiConfigSingleton.V3().Z5()) || ((adSlot.isBqtUnion() && MiConfigSingleton.V3().W5()) || ((adSlot.isDxUnion() && MiConfigSingleton.V3().Y5()) || ((adSlot.isMiUnion() && MiConfigSingleton.V3().c6()) || ((adSlot.isKsUnion() && MiConfigSingleton.V3().b6()) || ((adSlot.isHwUnion() && MiConfigSingleton.V3().a6()) || ((adSlot.isVivoUnion() && MiConfigSingleton.V3().f6()) || ((adSlot.isOppoUnion() && MiConfigSingleton.V3().d6()) || (adSlot.isApiUnion() && MiConfigSingleton.V3().V5())))))))) : (adSlot.isDxUnion() && !MiConfigSingleton.V3().F2()) || (adSlot.isCsjUnion() && !MiConfigSingleton.V3().E2()) || ((adSlot.isMiUnion() && !MiConfigSingleton.V3().K2()) || ((adSlot.isHwUnion() && !MiConfigSingleton.V3().I2()) || ((adSlot.isVivoUnion() && !MiConfigSingleton.V3().P2()) || ((adSlot.isOppoUnion() && !MiConfigSingleton.V3().L2()) || (adSlot.isKsUnion() && !MiConfigSingleton.V3().J2())))));
    }

    private AdSlot s0(String type, String union, String adId, int defaultWeight, int defaultEcpm) {
        return t0(type, union, adId, defaultWeight, defaultEcpm, 0);
    }

    private AdSlot t0(String type, String union, String adId, int defaultWeight, int defaultEcpm, int minEcpm) {
        AdSlot sid = new AdSlot().setType(type).setUnion(union).setWeight(Integer.valueOf(defaultWeight)).setEcpm(Integer.valueOf(defaultEcpm)).setSid(adId);
        if (q0(sid)) {
            sid.setWeight(0);
            return sid;
        }
        AdSlots adSlots = this.c0;
        if (adSlots != null && adSlots.getSlots() != null && !this.c0.getSlots().isEmpty()) {
            Iterator<AdSlot> it = this.c0.getSlots().iterator();
            while (it.hasNext()) {
                AdSlot next = it.next();
                if (adId.equalsIgnoreCase(next.getSid())) {
                    next.setUnion(union);
                    if (next.getEcpm() < minEcpm) {
                        next.setWeight(0);
                    }
                    it.remove();
                    return next;
                }
            }
        }
        return sid;
    }

    private static b u0(Activity activity) {
        b bVar = new b(activity, D, b.d.a.j.b.f4375h);
        bVar.b(AdConfig.buildAdConfig(bVar.s0(AdConfig.AdType.REWARD_VIDEO, AdConfig.UnionType.CSJ, k0.N2, 100000, 5321)));
        return bVar;
    }

    public static AdSlot v0() {
        return new AdSlot().setType(AdConfig.AdType.NATIVE).setUnion(AdConfig.UnionType.DEFAULT).setWeight(Integer.valueOf((MiConfigSingleton.V3().j5() && MiConfigSingleton.V3().X5()) ? 0 : 1)).setEcpm(5);
    }

    private int w0() {
        return this.X;
    }

    private void x0() {
        this.Q = new c();
    }

    private void y0(String pid) {
        AdSlots c2 = MiConfigSingleton.V3().e4().c(pid);
        this.c0 = c2;
        if (c2 != null) {
            S0(c2.getParallel());
        }
    }

    @Override // b.d.a.j.b
    protected boolean A() {
        return this.V;
    }

    @Override // b.d.a.j.b
    protected boolean B(AppTask appTask) {
        return MiBookManager.B2(appTask);
    }

    @Override // b.d.a.j.b
    protected boolean C() {
        return this.L;
    }

    @Override // b.d.a.j.b
    protected boolean G() {
        return false;
    }

    @Override // b.d.a.j.b
    protected void H(String event) {
        Activity activity = getActivity();
        if (activity != null) {
            com.martian.mibook.lib.model.g.b.n(activity, event);
        }
    }

    public void H0(String position, String ttAdsId) {
        Iterator<AdConfig> it = this.O.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdConfig next = it.next();
            if (AdConfig.UnionType.CSJ.equalsIgnoreCase(next.getSource())) {
                next.setAdsPosition(position);
                if (!k.p(ttAdsId)) {
                    next.setAdsId(ttAdsId);
                }
            }
        }
        F();
    }

    @Override // b.d.a.j.b
    protected void I(AppTask appTask) {
        com.martian.libugrowth.b.k().g(appTask.id, AdConfig.Action.ESHOW, appTask.source, appTask.getGid(), appTask.getEcpm());
    }

    @Override // b.d.a.j.b
    protected void K() {
        com.martian.libugrowth.b.k().h(this.a0, AdConfig.Action.REQUEST);
    }

    @Override // b.d.a.j.b
    protected void L(AdConfig config, String event) {
        J0(config, event);
    }

    @Override // b.d.a.j.b
    protected void M(AppTask appTask) {
        Activity activity = getActivity();
        if (activity instanceof j1) {
            TYBookItem tYBookItem = (TYBookItem) appTask.origin;
            com.martian.mibook.lib.model.g.b.w(activity, "信息流-书籍详情");
            s2.U((j1) activity, tYBookItem);
        }
    }

    @Override // b.d.a.j.b
    protected void N(AppTask appTask) {
        Activity activity = getActivity();
        if (activity != null) {
            appTask.rendered = true;
            TYBookItem tYBookItem = (TYBookItem) appTask.origin;
            MiConfigSingleton.V3().l3().I1(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
            com.martian.mibook.lib.model.g.b.w(activity, appTask.adsPosition + "-曝光");
        }
    }

    @Override // b.d.a.j.b
    protected void O(AppTask appTask) {
        Activity activity = getActivity();
        if (activity instanceof j1) {
            s2.A((j1) activity, appTask, new a());
        }
    }

    public b O0() {
        this.V = true;
        return this;
    }

    @Override // b.d.a.j.b
    protected void P() {
        this.Z = false;
        this.W = null;
        if (this.Y > 0) {
            Handler handler = this.S;
            if (handler == null) {
                this.S = new Handler();
            } else {
                handler.removeCallbacks(this.T);
            }
            if (this.T == null) {
                this.T = new Runnable() { // from class: com.martian.mibook.b.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.B0();
                    }
                };
            }
            this.S.postDelayed(this.T, this.Y * 1000);
        }
    }

    protected void P0() {
        this.M = MiConfigSingleton.V3().W3().getBlockAppNameList();
    }

    protected void Q0() {
        this.N = MiConfigSingleton.V3().W3().getBlockAppPkgList();
    }

    public b R0(Map<String, AppTask> cacheWaterfallAppTasks) {
        this.b0 = cacheWaterfallAppTasks;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.d.a.j.b
    protected void S(AdConfig config) {
        if (!MiConfigSingleton.V3().x5() || config == null || config.getShowTime() <= 0 || !(getActivity() instanceof j1)) {
            return;
        }
        C0262b c0262b = new C0262b((j1) getActivity());
        ((VideoClickParams) c0262b.k()).setTid(Long.valueOf(config.getShowTime()));
        c0262b.j();
    }

    public b S0(int size) {
        this.U = size;
        return this;
    }

    public void T0(b.d.a.k.a receiver) {
        this.R = receiver;
    }

    public b U0(int timeout) {
        this.Y = timeout;
        return this;
    }

    @Override // b.d.a.j.b
    protected boolean a(AdConfig adConfig) {
        AppTask remove;
        Map<String, AppTask> map = this.b0;
        if (map == null || map.isEmpty() || (remove = this.b0.remove(adConfig.getAdsId())) == null) {
            return false;
        }
        p();
        this.Q.d(adConfig, new AppTaskList().addAppTask(remove));
        return true;
    }

    @Override // b.d.a.j.b
    public void c() {
        if (w0() <= 0) {
            List<AppTask> list = this.W;
            if (list == null || list.isEmpty()) {
                b.d.a.k.a aVar = this.Q;
                if (aVar != null) {
                    aVar.h();
                    return;
                }
                return;
            }
            AppTask appTask = this.W.get(0);
            AppTaskList appTaskList = new AppTaskList();
            appTaskList.addAppTask(appTask);
            I0(b.d.a.j.b.Q(appTask), appTaskList);
        }
    }

    @Override // b.d.a.j.b
    protected boolean e() {
        return false;
    }

    @Override // b.d.a.j.b
    protected Activity getActivity() {
        WeakReference<Activity> weakReference = this.J;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // b.d.a.j.b
    protected List<AdConfig> h() {
        return this.O;
    }

    @Override // b.d.a.j.b
    protected List<AdConfig> i() {
        return this.P;
    }

    @Override // b.d.a.j.b
    protected String j() {
        return this.K;
    }

    @Override // b.d.a.j.b
    protected String[] k() {
        return this.M;
    }

    @Override // b.d.a.j.b
    protected String[] l() {
        return this.N;
    }

    @Override // b.d.a.j.b
    protected AppTask m(String adsPosition) {
        return MiConfigSingleton.V3().x3(adsPosition);
    }

    @Override // b.d.a.j.b
    protected b.d.a.k.a n() {
        return this.Q;
    }

    @Override // b.d.a.j.b
    protected int o() {
        return this.U;
    }

    @Override // b.d.a.j.b
    protected void p() {
        this.X++;
    }

    @Override // b.d.a.j.b
    protected void q() {
        MiConfigSingleton.V3().Q4();
    }

    @Override // b.d.a.j.b
    protected void r() {
        MiConfigSingleton.V3().R4();
    }

    protected b.d.c.b.c r0(AppTaskList appTaskList) {
        if (appTaskList != null && appTaskList.getApps() != null && !appTaskList.getApps().isEmpty()) {
            AppTask appTask = appTaskList.getApps().get(0);
            if (appTask == null) {
                return null;
            }
            if (k() != null) {
                for (String str : k()) {
                    if (appTask.getName().contains(str)) {
                        return new b.d.c.b.c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + "_" + appTask.getName() + "_" + appTask.id);
                    }
                    if (appTask.getTitle().contains(str)) {
                        return new b.d.c.b.c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + "_" + appTask.getName() + "_" + appTask.getTitle() + "_" + appTask.id);
                    }
                    if (appTask.getDesc().contains(str)) {
                        return new b.d.c.b.c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + "_" + appTask.getName() + "_" + appTask.getDesc() + "_" + appTask.id);
                    }
                }
            }
            if (!k.p(appTask.packageName) && l() != null) {
                for (String str2 : l()) {
                    if (appTask.packageName.equalsIgnoreCase(str2)) {
                        return new b.d.c.b.c(AdConfig.ERROR_CODE_AD_BLOCK, appTask.source + "_" + appTask.packageName + "_" + appTask.id);
                    }
                }
            }
        }
        return null;
    }

    @Override // b.d.a.j.b
    protected void s() {
        MiConfigSingleton.V3().S4();
    }

    @Override // b.d.a.j.b
    protected void t() {
        MiConfigSingleton.V3().T4();
    }

    @Override // b.d.a.j.b
    protected void u() {
        MiConfigSingleton.V3().U4();
    }

    @Override // b.d.a.j.b
    protected void v() {
        MiConfigSingleton.V3().V4();
    }

    @Override // b.d.a.j.b
    protected void w() {
        MiConfigSingleton.V3().X4();
    }

    @Override // b.d.a.j.b
    protected void x() {
        MiConfigSingleton.V3().Z4();
    }

    @Override // b.d.a.j.b
    protected void y() {
        MiConfigSingleton.V3().b5();
    }

    @Override // b.d.a.j.b
    protected boolean z() {
        return MiConfigSingleton.V3().j5();
    }

    public boolean z0() {
        return this.O.isEmpty();
    }
}
