package xa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.core.interstitial.VlionInterstitialAd;
import cn.vlion.ad.inland.core.reward.VlionRewardedVideoAd;
import com.aggmoread.sdk.client.interstitial.AMInterstitialAd;
import com.aggmoread.sdk.client.reward.AMRewardAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.DXAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.MentaAd;
import com.martian.ads.data.AdSlot;
import com.martian.ads.data.AdSlots;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.splash.SplashAD;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import l9.p0;
import ya.e0;

/* loaded from: classes3.dex */
public class p {

    /* renamed from: a */
    public WeakReference<Context> f31971a;

    /* renamed from: b */
    public String f31972b;

    /* renamed from: e */
    public d8.a f31975e;

    /* renamed from: f */
    public d8.a f31976f;

    /* renamed from: g */
    public AppTask f31977g;

    /* renamed from: h */
    public List<AppTask> f31978h;

    /* renamed from: i */
    public Map<String, AppTask> f31979i;

    /* renamed from: j */
    public String[] f31980j;

    /* renamed from: k */
    public String[] f31981k;

    /* renamed from: m */
    public long f31983m;

    /* renamed from: n */
    public long f31984n;

    /* renamed from: o */
    public int f31985o;

    /* renamed from: p */
    public long f31986p;

    /* renamed from: q */
    public int f31987q;

    /* renamed from: r */
    public int f31988r;

    /* renamed from: s */
    public int f31989s;

    /* renamed from: t */
    public int f31990t;

    /* renamed from: u */
    public Handler f31991u;

    /* renamed from: v */
    public Handler f31992v;

    /* renamed from: w */
    public boolean f31993w;

    /* renamed from: c */
    public final List<AdConfig> f31973c = new LinkedList();

    /* renamed from: d */
    public final List<AdConfig> f31974d = new ArrayList();

    /* renamed from: l */
    public int f31982l = 1;

    public class a extends d8.b {
        public a() {
        }

        @Override // d8.b, d8.a
        public void a() {
            p.this.P0();
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            p.this.M0(adConfig);
        }

        @Override // d8.b, d8.a
        public void c(AdConfig adConfig, @NonNull x8.c cVar) {
            p.this.R0();
            if (adConfig.isBidding()) {
                p.this.J();
            } else {
                p.this.e1();
            }
            if (808 == cVar.c()) {
                p.this.G0(cVar.d());
            }
            p.this.K0(adConfig, cVar);
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            p.this.I0(adConfig);
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            p.this.J0(adConfig);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            if (!ConfigSingleton.D().w0() && appTask.getEcpm() <= Math.max(p.this.P(), appTask.getMinEcpm())) {
                p.this.I(appTask);
            } else if (p.this.f31977g == null) {
                p.this.f31977g = appTask;
            } else if (p.this.f31977g.getEcpm() < appTask.getEcpm()) {
                p pVar = p.this;
                pVar.I(pVar.f31977g);
                p.this.f31977g = appTask;
            } else {
                p.this.I(appTask);
            }
            p.this.R0();
            p.this.J();
        }

        @Override // d8.b, d8.a
        public void j(x8.c cVar) {
            p.this.L0(cVar);
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            p.this.Q0(adConfig, z10);
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            p.this.H0(adConfig);
        }
    }

    public p(Context context, String str, Map<String, AppTask> map, AdConfig.AdInfo adInfo) {
        e0(context, str, map, adInfo, 0, true, false);
    }

    public static boolean K(AdSlot adSlot) {
        return MiConfigSingleton.b2().H1().j0() ? (adSlot.isCsjUnion() && MiConfigSingleton.b2().H1().u0()) || (adSlot.isGdtUnion() && MiConfigSingleton.b2().H1().n0()) || ((adSlot.isBqtUnion() && MiConfigSingleton.b2().H1().l0()) || ((adSlot.isDxUnion() && MiConfigSingleton.b2().H1().m0()) || ((adSlot.isMentaUnion() && MiConfigSingleton.b2().H1().q0()) || ((adSlot.isMiUnion() && MiConfigSingleton.b2().H1().r0()) || ((adSlot.isKsUnion() && MiConfigSingleton.b2().H1().p0()) || ((adSlot.isHwUnion() && MiConfigSingleton.b2().H1().o0()) || ((adSlot.isVivoUnion() && MiConfigSingleton.b2().H1().v0()) || ((adSlot.isOppoUnion() && MiConfigSingleton.b2().H1().s0()) || ((adSlot.isSigmobUnion() && MiConfigSingleton.b2().H1().t0()) || (adSlot.isApiUnion() && MiConfigSingleton.b2().H1().k0())))))))))) : (adSlot.isDxUnion() && !MiConfigSingleton.b2().H1().I()) || (adSlot.isMentaUnion() && !MiConfigSingleton.b2().H1().L()) || ((adSlot.isMiUnion() && !MiConfigSingleton.b2().H1().M()) || ((adSlot.isHwUnion() && !MiConfigSingleton.b2().H1().J()) || ((adSlot.isVivoUnion() && !MiConfigSingleton.b2().H1().P()) || ((adSlot.isOppoUnion() && !MiConfigSingleton.b2().H1().N()) || (adSlot.isKsUnion() && !MiConfigSingleton.b2().H1().K())))));
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.f31971a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static /* synthetic */ int p0(AppTask appTask, AppTask appTask2) {
        return appTask2.getEcpm() - appTask.getEcpm();
    }

    public static /* synthetic */ int q0(AppTask appTask, AppTask appTask2) {
        return appTask2.getEcpm() - appTask.getEcpm();
    }

    public static /* synthetic */ int r0(AdConfig adConfig, AdConfig adConfig2) {
        return adConfig2.getEcpm() - adConfig.getEcpm();
    }

    public final /* synthetic */ void A0(AppTask appTask) {
        this.f31976f.h(appTask);
    }

    public final /* synthetic */ void B0() {
        this.f31976f.a();
    }

    public final /* synthetic */ void C0(AdConfig adConfig, boolean z10) {
        this.f31976f.k(adConfig, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026c  */
    /* renamed from: E0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D0(com.martian.ads.ad.AdConfig r8) {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.p.D0(com.martian.ads.ad.AdConfig):void");
    }

    public final boolean F(AdConfig adConfig) {
        Map<String, AppTask> map = this.f31979i;
        if (map == null || map.isEmpty()) {
            return false;
        }
        AppTask remove = this.f31979i.remove(adConfig.getAdsId());
        if (com.martian.mibook.application.a.z(remove)) {
            return false;
        }
        a0();
        O().i(adConfig, new AppTaskList().addAppTask(remove));
        return true;
    }

    public void F0() {
        if (this.f31991u == null || getContext() == null) {
            return;
        }
        this.f31991u.post(new Runnable() { // from class: xa.n
            public /* synthetic */ n() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.s0();
            }
        });
    }

    public void G(@NonNull AdConfig adConfig) {
        String str;
        String str2;
        if (adConfig.getWeight() <= 0) {
            return;
        }
        if (adConfig.isBidding()) {
            L().add(adConfig);
        } else {
            V().add(adConfig);
        }
        if (ConfigSingleton.D().B0()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(adConfig.getSource());
            sb2.append(":");
            sb2.append(adConfig.getPid());
            sb2.append("  id:");
            sb2.append(adConfig.getAdsId());
            if (adConfig.getEcpm() > 0) {
                str = "  ecpm:" + adConfig.getEcpm();
            } else {
                str = "";
            }
            sb2.append(str);
            if (adConfig.isBidding()) {
                str2 = " bidding";
            } else {
                str2 = " group:" + adConfig.getGroup();
            }
            sb2.append(str2);
            p0.c(e0.f33149f0, sb2.toString());
        }
    }

    public final void G0(String str) {
        Context context = getContext();
        if (context != null) {
            ac.a.m(context, str);
        }
    }

    public final void H(String str) {
        str.hashCode();
        switch (str) {
            case "activity_inter":
            case "reader_inters":
                if (!ConfigSingleton.D().w0()) {
                    G(AdConfig.buildAdConfig("interstitial", AdConfig.UnionType.BQT, e0.G, 1, 750).setAppid(e0.f33168p).setBidding(1));
                    G(AdConfig.buildAdConfig("interstitial", AdConfig.UnionType.GDT, e0.H, 1, 750).setBidding(1));
                    G(AdConfig.buildAdConfig("interstitial", "KS", e0.I, 1, 750).setBidding(1));
                    break;
                }
                break;
            case "splash":
                if (!ConfigSingleton.D().w0()) {
                    G(AdConfig.buildAdConfig("splash", AdConfig.UnionType.BQT, e0.A, 1, 750).setAppid(e0.f33168p).setBidding(1));
                    G(AdConfig.buildAdConfig("splash", AdConfig.UnionType.GDT, e0.B, 1, 100).setAppid(e0.f33170q).setBidding(1));
                    G(AdConfig.buildAdConfig("splash", "KS", e0.C, 1, 100).setBidding(1));
                    break;
                }
                break;
            case "reader_feeds":
            case "normal_flow":
            case "reader_banner":
                G(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, AdConfig.UnionType.BQT, e0.D, 1, 750).setAppid(e0.f33168p).setBidding(1));
                G(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, AdConfig.UnionType.GDT, e0.E, 1, 100).setAppid(e0.f33170q).setBidding(1));
                G(AdConfig.buildAdConfig(AdConfig.AdType.NATIVE, "KS", e0.F, 1, 100).setBidding(1));
                break;
            case "rvideo_all":
                if (!ConfigSingleton.D().w0()) {
                    G(AdConfig.buildAdConfig(AdConfig.AdType.REWARD_VIDEO, AdConfig.UnionType.BQT, e0.J, 1, 750).setAppid(e0.f33168p).setBidding(1));
                    G(AdConfig.buildAdConfig(AdConfig.AdType.REWARD_VIDEO, AdConfig.UnionType.GDT, e0.K, 1, 100).setBidding(1));
                    G(AdConfig.buildAdConfig(AdConfig.AdType.REWARD_VIDEO, "KS", e0.L, 1, 100).setBidding(1));
                    break;
                } else {
                    G(AdConfig.buildAdConfig(AdConfig.AdType.REWARD_VIDEO, AdConfig.UnionType.HW, "o3xexk7d07", 1, 150).setBidding(1).setPid(R()));
                    break;
                }
        }
    }

    public final void H0(AdConfig adConfig) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.d

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31952c;

            public /* synthetic */ d(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.t0(adConfig);
            }
        });
    }

    public final void I(AppTask appTask) {
        if (appTask == null) {
            return;
        }
        if (this.f31978h == null) {
            this.f31978h = new ArrayList();
        }
        this.f31978h.add(appTask);
    }

    public final void I0(AdConfig adConfig) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.i

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31958c;

            public /* synthetic */ i(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.u0(adConfig);
            }
        });
    }

    public final void J() {
        if (S() > 0 || this.f31993w) {
            return;
        }
        this.f31993w = true;
        int min = Math.min((int) (System.currentTimeMillis() - this.f31986p), 30000);
        if (this.f31977g == null) {
            b8.e.s().H(this.f31972b, d1() ? AdConfig.Type.TIMEOUT : AdConfig.Type.FAIL, min, this.f31987q);
            X();
        } else {
            b8.e.s().H(this.f31972b, AdConfig.Type.RESPONSE, min, this.f31987q);
            Y();
        }
    }

    public final void J0(AdConfig adConfig) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.e

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31954c;

            public /* synthetic */ e(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.v0(adConfig);
            }
        });
    }

    public final void K0(AdConfig adConfig, x8.c cVar) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.l

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31965c;

            /* renamed from: d */
            public final /* synthetic */ x8.c f31966d;

            public /* synthetic */ l(AdConfig adConfig2, x8.c cVar2) {
                adConfig = adConfig2;
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.w0(adConfig, cVar);
            }
        });
    }

    public final List<AdConfig> L() {
        return this.f31974d;
    }

    public final void L0(x8.c cVar) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.o

            /* renamed from: c */
            public final /* synthetic */ x8.c f31970c;

            public /* synthetic */ o(x8.c cVar2) {
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.x0(cVar);
            }
        });
    }

    public final String[] M() {
        if (this.f31980j == null) {
            this.f31980j = MiConfigSingleton.b2().c2().getBlockAppNameList();
        }
        return this.f31980j;
    }

    public final void M0(AdConfig adConfig) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.k

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31963c;

            public /* synthetic */ k(AdConfig adConfig2) {
                adConfig = adConfig2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.y0(adConfig);
            }
        });
    }

    public final String[] N() {
        if (this.f31981k == null) {
            this.f31981k = MiConfigSingleton.b2().c2().getBlockAppPkgList();
        }
        return this.f31981k;
    }

    public final void N0(AdConfig adConfig, AppTaskList appTaskList) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.c

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31949c;

            /* renamed from: d */
            public final /* synthetic */ AppTaskList f31950d;

            public /* synthetic */ c(AdConfig adConfig2, AppTaskList appTaskList2) {
                adConfig = adConfig2;
                appTaskList = appTaskList2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.z0(adConfig, appTaskList);
            }
        });
    }

    public final d8.a O() {
        if (this.f31975e == null) {
            this.f31975e = new a();
        }
        return this.f31975e;
    }

    public final void O0(AppTask appTask) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.b

            /* renamed from: c */
            public final /* synthetic */ AppTask f31947c;

            public /* synthetic */ b(AppTask appTask2) {
                appTask = appTask2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.A0(appTask);
            }
        });
    }

    public final int P() {
        return this.f31990t;
    }

    public final void P0() {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.m
            public /* synthetic */ m() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.B0();
            }
        });
    }

    public final int Q() {
        return this.f31982l;
    }

    public final void Q0(AdConfig adConfig, boolean z10) {
        if (this.f31976f == null) {
            return;
        }
        S0(new Runnable() { // from class: xa.j

            /* renamed from: c */
            public final /* synthetic */ AdConfig f31960c;

            /* renamed from: d */
            public final /* synthetic */ boolean f31961d;

            public /* synthetic */ j(AdConfig adConfig2, boolean z102) {
                adConfig = adConfig2;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.C0(adConfig, z10);
            }
        });
    }

    public final String R() {
        return this.f31972b;
    }

    public final void R0() {
        this.f31985o--;
    }

    public final int S() {
        return this.f31985o;
    }

    public final void S0(Runnable runnable) {
        Handler handler;
        if (getContext() == null || (handler = this.f31992v) == null) {
            return;
        }
        handler.post(runnable);
    }

    public final long T() {
        return Math.min(this.f31984n, U() - System.currentTimeMillis());
    }

    public final void T0(int i10, String str, AppTask appTask) {
        Object obj = appTask.origin;
        if (obj instanceof ExpressInterstitialAd) {
            BaeAd.sendInterstitialLossNotification(i10, str, (ExpressInterstitialAd) obj);
            return;
        }
        if (obj instanceof RewardVideoAd) {
            BaeAd.sendVideoLossNotification(i10, str, (RewardVideoAd) obj);
            return;
        }
        if (obj instanceof RewardVideoAD) {
            GDTAd.sendVideoLossNotification(i10, (RewardVideoAD) obj);
            return;
        }
        if (obj instanceof UnifiedInterstitialAD) {
            GDTAd.sendInterstitialLossNotification(i10, (UnifiedInterstitialAD) obj);
            return;
        }
        if (obj instanceof KsRewardVideoAd) {
            KsAd.sendVideoLossNotification(i10, (KsRewardVideoAd) obj);
            return;
        }
        if (obj instanceof KsInterstitialAd) {
            KsAd.sendInterstitialLossNotification(i10, (KsInterstitialAd) obj);
            return;
        }
        if (b8.h.o(appTask)) {
            b8.h.y(i10, appTask);
            return;
        }
        if (b8.h.q(appTask)) {
            b8.h.z(i10, appTask);
            return;
        }
        if (b8.h.m(appTask)) {
            b8.h.v(i10, appTask);
            return;
        }
        Object obj2 = appTask.origin;
        if (obj2 instanceof AMInterstitialAd) {
            DXAd.sendInterstitialLossNotification(i10, (AMInterstitialAd) obj2);
            return;
        }
        if (obj2 instanceof AMRewardAd) {
            DXAd.sendVideoLossNotification(i10, (AMRewardAd) obj2);
            return;
        }
        if (obj2 instanceof VlionRewardedVideoAd) {
            MentaAd.sendVideoLossNotification(i10, str, (VlionRewardedVideoAd) obj2);
            return;
        }
        if (obj2 instanceof VlionInterstitialAd) {
            MentaAd.sendInterstitialLossNotification(i10, str, (VlionInterstitialAd) obj2);
        } else if (b8.h.h(appTask) || b8.h.i(appTask)) {
            b8.h.u(i10, str, "", "", appTask);
        }
    }

    public final long U() {
        return this.f31983m;
    }

    public final void U0() {
        List<AppTask> list = this.f31978h;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = this.f31978h.iterator();
        AppTask appTask = this.f31977g;
        String str = appTask == null ? "unknown" : appTask.source;
        int ecpm = appTask == null ? 0 : (int) (appTask.getEcpm() * 1.1d);
        while (it.hasNext()) {
            AppTask next = it.next();
            it.remove();
            if (ecpm < next.getEcpm()) {
                ecpm = (int) (next.getEcpm() * 1.3d);
            }
            V0(ecpm, str, next, BaeAd.BIDDING_FAIL_LOW_PRICE);
        }
    }

    public final List<AdConfig> V() {
        return this.f31973c;
    }

    public final void V0(int i10, String str, AppTask appTask, String str2) {
        if (appTask == null || !appTask.isBidding()) {
            return;
        }
        if (AdConfig.AdType.NATIVE.equalsIgnoreCase(appTask.adsType)) {
            W0(i10, str, appTask, str2);
        } else if ("splash".equalsIgnoreCase(appTask.adsType)) {
            X0(i10, str, appTask);
        } else {
            T0(i10, str, appTask);
        }
    }

    public final int W() {
        AppTask appTask = this.f31977g;
        if (appTask == null) {
            return 0;
        }
        return appTask.getEcpm();
    }

    public final void W0(int i10, String str, AppTask appTask, String str2) {
        String str3;
        String str4;
        if (GDTAd.isGdtFlowAd(appTask)) {
            GDTAd.sendLossNotification(i10, (NativeUnifiedADData) appTask.origin, 1);
        } else if (b8.h.p(appTask)) {
            b8.h.A(i10, appTask, 1);
        } else if (KsAd.isKsFlowAd(appTask)) {
            KsAd.sendLossNotification(this.f31977g, i10, str, (KsNativeAd) appTask.origin);
        } else if (KsAd.isKsDrawAd(appTask)) {
            KsAd.sendDrawLossNotification(i10, (KsDrawAd) appTask.origin);
        } else if (BaeAd.isBaeFlowAd(appTask)) {
            BaeAd.sendLossNotification(i10, str, (NativeResponse) appTask.origin, str2);
        } else if (b8.h.l(appTask)) {
            b8.h.w(i10, appTask, 1);
        } else if (DXAd.isDxFlowAd(appTask)) {
            DXAd.sendLossNotification(i10, str, appTask);
        } else if (MentaAd.isMentaFlowAd(appTask)) {
            MentaAd.sendDrawLossNotification(i10, str, (VlionNativeAdvert) appTask.origin);
        } else if (b8.h.g(appTask)) {
            AppTask appTask2 = this.f31977g;
            if (appTask2 == null || appTask2.getComplianceInfo() == null) {
                str3 = "";
                str4 = "";
            } else {
                str3 = this.f31977g.getComplianceInfo().getAppName();
                str4 = this.f31977g.getComplianceInfo().getPkgName();
            }
            b8.h.u(i10, str, str3, str4, appTask);
        }
        appTask.destroyNativeAd();
    }

    public final void X() {
        P0();
        List<AppTask> list = this.f31978h;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.f31978h, new Comparator() { // from class: xa.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int p02;
                p02 = p.p0((AppTask) obj, (AppTask) obj2);
                return p02;
            }
        });
        AppTask appTask = this.f31978h.get(0);
        if (appTask != null && appTask.getEcpm() > 0) {
            b8.e.s().l(R(), appTask.f12000id, appTask.source, appTask.gid, AdConfig.Type.FILTER, appTask.getEcpm(), 0);
        }
        U0();
    }

    public final void X0(int i10, String str, AppTask appTask) {
        if (BaeAd.isBaeSplashAd(appTask)) {
            BaeAd.sendSplashLossNotification(i10, str, (SplashAd) appTask.origin);
            return;
        }
        if (GDTAd.isGdtSplashAd(appTask)) {
            GDTAd.sendSplashLossNotification(i10, (SplashAD) appTask.origin);
            return;
        }
        if (KsAd.isKsSplashAd(appTask)) {
            KsAd.sendSplashLossNotification(i10, (KsSplashScreenAd) appTask.origin);
            return;
        }
        if (b8.h.r(appTask)) {
            b8.h.B(i10, appTask);
            return;
        }
        if (b8.h.n(appTask)) {
            b8.h.x(i10, appTask);
            return;
        }
        if (DXAd.isDxSplashAd(appTask)) {
            DXAd.sendSplashLossNotification(i10, appTask);
        } else if (MentaAd.isMentaSplashAd(appTask)) {
            MentaAd.sendSplashLossNotification(i10, str, appTask);
        } else if (b8.h.j(appTask)) {
            b8.h.u(i10, str, "", "", appTask);
        }
    }

    public final void Y() {
        AppTaskList addAppTask = new AppTaskList().addAppTask(this.f31977g);
        List<AppTask> list = this.f31978h;
        if (list == null || list.isEmpty()) {
            N0(AdConfig.toAdConfig(this.f31977g), addAppTask);
            return;
        }
        Collections.sort(this.f31978h, new Comparator() { // from class: xa.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int q02;
                q02 = p.q0((AppTask) obj, (AppTask) obj2);
                return q02;
            }
        });
        if (this.f31977g.isBidding()) {
            AppTask appTask = this.f31978h.get(0);
            this.f31977g.setLoseEcpm(appTask.getEcpm());
            this.f31977g.setLoseSource(appTask.source);
            this.f31977g.setLoseIsBidding(appTask.isBidding());
        }
        Iterator<AppTask> it = this.f31978h.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            AppTask next = it.next();
            if (this.f31988r > 0 && next.getEcpm() >= this.f31988r && i10 < this.f31989s) {
                addAppTask.addAppTask(next);
                it.remove();
            } else if (!next.isBidding()) {
                O0(next);
                it.remove();
            }
            i10++;
        }
        U0();
        N0(AdConfig.toAdConfig(this.f31977g), addAppTask);
    }

    public final void Y0(int i10) {
        this.f31990t = i10;
    }

    public final void Z(int i10) {
        this.f31985o += i10;
    }

    public final void Z0(int i10) {
        this.f31982l = i10;
    }

    public final void a0() {
        this.f31985o++;
        this.f31987q++;
    }

    public void a1(d8.a aVar) {
        this.f31976f = aVar;
    }

    public final void b0() {
        b8.e.s().H(this.f31972b, AdConfig.Type.REQUEST, 0, 0);
        this.f31986p = System.currentTimeMillis();
    }

    public void b1(int i10) {
        this.f31984n = i10 * 1000;
    }

    public final void c0(AdSlots adSlots, AdConfig.AdInfo adInfo, int i10, boolean z10) {
        boolean N0 = ConfigSingleton.D().N0();
        for (AdSlot adSlot : adSlots.getSlots()) {
            if (adSlot.getWeight() > 0 && !K(adSlot) && (i10 <= 0 || (!adSlot.isBidding() && adSlot.getEcpm() >= i10))) {
                if (!z10 || !adSlot.isHotStartId()) {
                    if (!adSlot.isMentaUnion() || N0) {
                        AdConfig buildAdConfig = AdConfig.buildAdConfig(adSlot);
                        buildAdConfig.setPid(adSlots.getPid());
                        buildAdConfig.setEcpmPercent(adSlot.getAutoEcpmPercent());
                        buildAdConfig.setMinEcpm(adSlot.getMinEcpm());
                        if (adSlot.isBidding() && buildAdConfig.isBqtAd() && adInfo != null) {
                            buildAdConfig.setAdInfo(adInfo);
                        }
                        G(buildAdConfig);
                    }
                }
            }
        }
        Collections.sort(V(), new Comparator() { // from class: xa.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int r02;
                r02 = p.r0((AdConfig) obj, (AdConfig) obj2);
                return r02;
            }
        });
    }

    public void c1(int i10) {
        this.f31983m = System.currentTimeMillis() + (i10 * 1000);
    }

    public final void d0() {
        MiConfigSingleton.b2().H1().V();
    }

    public final boolean d1() {
        return System.currentTimeMillis() - U() > 0;
    }

    public final void e0(Context context, String str, Map<String, AppTask> map, AdConfig.AdInfo adInfo, int i10, boolean z10, boolean z11) {
        this.f31971a = new WeakReference<>(context);
        this.f31972b = str;
        this.f31979i = map;
        this.f31992v = new Handler(Looper.getMainLooper());
        this.f31991u = b8.e.s().r();
        AdSlots f10 = MiConfigSingleton.b2().f2().f(str);
        if (f10 != null) {
            Z0(f10.getParallel());
            c1(f10.getTimeout());
            Y0(f10.getMinEcpm());
            b1(f10.getSlotTimeout());
        }
        if (z10) {
            if (f10 != null && !MiConfigSingleton.b2().w0()) {
                c0(f10, adInfo, i10, z11);
                return;
            }
            H(str);
            c1(10);
            b1(5);
        }
    }

    public final synchronized void e1() {
        if (V().isEmpty()) {
            J();
            return;
        }
        AdConfig remove = V().remove(0);
        if (remove.getEcpm() <= W()) {
            J();
        } else {
            if (this.f31991u == null) {
                return;
            }
            if (Thread.currentThread() == this.f31991u.getLooper().getThread()) {
                D0(remove);
            } else {
                this.f31991u.post(new Runnable() { // from class: xa.g

                    /* renamed from: c */
                    public final /* synthetic */ AdConfig f31956c;

                    public /* synthetic */ g(AdConfig remove2) {
                        remove = remove2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        p.this.D0(remove);
                    }
                });
            }
        }
    }

    public final void f0() {
        MiConfigSingleton.b2().H1().W();
    }

    public final void g0() {
        MiConfigSingleton.b2().H1().X();
    }

    public final void h0() {
        MiConfigSingleton.b2().H1().Y();
    }

    public final boolean i0() {
        return MiConfigSingleton.b2().H1().Z();
    }

    public final void j0() {
        MiConfigSingleton.b2().H1().a0();
    }

    public final void k0() {
        MiConfigSingleton.b2().H1().b0();
    }

    public final void l0() {
        MiConfigSingleton.b2().H1().d0();
    }

    public final void m0() {
        MiConfigSingleton.b2().H1().f0();
    }

    public final void n0() {
        MiConfigSingleton.b2().H1().g0();
    }

    public final void o0() {
        MiConfigSingleton.b2().H1().h0();
    }

    public final /* synthetic */ void s0() {
        if (V().isEmpty() && L().isEmpty()) {
            O().a();
            return;
        }
        b0();
        Z(L().size());
        Iterator<AdConfig> it = L().iterator();
        while (it.hasNext()) {
            D0(it.next());
        }
        for (int i10 = 0; i10 < Math.min(V().size(), Q()); i10++) {
            e1();
        }
    }

    public final /* synthetic */ void t0(AdConfig adConfig) {
        this.f31976f.l(adConfig);
    }

    public final /* synthetic */ void u0(AdConfig adConfig) {
        this.f31976f.d(adConfig);
    }

    public final /* synthetic */ void v0(AdConfig adConfig) {
        this.f31976f.g(adConfig);
    }

    public final /* synthetic */ void w0(AdConfig adConfig, x8.c cVar) {
        this.f31976f.c(adConfig, cVar);
    }

    public final /* synthetic */ void x0(x8.c cVar) {
        this.f31976f.j(cVar);
    }

    public final /* synthetic */ void y0(AdConfig adConfig) {
        this.f31976f.b(adConfig);
    }

    public final /* synthetic */ void z0(AdConfig adConfig, AppTaskList appTaskList) {
        this.f31976f.i(adConfig, appTaskList);
        b8.e.A(adConfig, "竞胜");
    }

    public p(Context context, String str, Map<String, AppTask> map, AdConfig.AdInfo adInfo, boolean z10) {
        e0(context, str, map, adInfo, 0, true, z10);
        if (z10) {
            return;
        }
        c1(30);
    }

    public p(Context context, String str, Map<String, AppTask> map, int i10, int i11) {
        this.f31988r = i10;
        this.f31989s = i11;
        e0(context, str, map, null, 0, false, false);
    }

    public p(Context context, String str, Map<String, AppTask> map, int i10) {
        e0(context, str, map, null, i10, true, false);
    }
}
