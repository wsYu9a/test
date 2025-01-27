package com.martian.mibook.application;

import android.app.Activity;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.BaseAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.VivoAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.qq.e.ads.splash.SplashAD;
import com.vivo.mobilead.unified.splash.UnifiedVivoSplashAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a */
    private AppTask f11456a;

    /* renamed from: b */
    private List<AppTask> f11457b;

    /* renamed from: c */
    private WeakReference<Activity> f11458c;

    /* renamed from: d */
    private AdConfig.AdInfo f11459d;

    /* renamed from: e */
    private b.d.a.k.a f11460e;

    class a extends b.d.a.k.b {
        a() {
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            super.a(config);
            if (i0.this.f11460e != null) {
                i0.this.f11460e.a(config);
            }
            i0.this.m(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void b(AdConfig config) {
            super.b(config);
            if (i0.this.f11460e != null) {
                i0.this.f11460e.b(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            super.c(config);
            if (i0.this.f11460e != null) {
                i0.this.f11460e.c(config);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            if (appTask != null) {
                i0.this.o(appTask);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void j(AdConfig config) {
            super.j(config);
            if (i0.this.f11460e != null) {
                i0.this.f11460e.j(config);
            }
        }
    }

    class b extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ String f11462a;

        /* renamed from: b */
        final /* synthetic */ boolean f11463b;

        /* renamed from: c */
        final /* synthetic */ b.d.a.k.b f11464c;

        b(final String val$receiver, final boolean val$showAfterLoad, final b.d.a.k.b val$type) {
            this.f11462a = val$receiver;
            this.f11463b = val$showAfterLoad;
            this.f11464c = val$type;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            this.f11464c.a(config);
            i0.this.m(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void b(AdConfig config) {
            this.f11464c.b(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            this.f11464c.c(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            Activity activity = i0.this.getActivity();
            if (com.martian.libmars.utils.n0.C(activity)) {
                g0.D(activity, "开屏-bidding-成功-" + this.f11462a);
                if (!this.f11463b) {
                    i0.this.i(activity, this.f11464c, appTaskList.getApps().get(0));
                    return;
                }
                AppTask appTask = appTaskList.getApps().get(0);
                int j2 = i0.this.j();
                if (appTask.getEcpm() >= j2) {
                    this.f11464c.d(config, appTaskList);
                    i0.this.l(appTaskList.getApps().get(0).getEcpm());
                } else {
                    g0.D(activity, "开屏-冷启-失败-优化ecpm");
                    i0.this.g(appTask);
                    i0.this.l(j2);
                    this.f11464c.h();
                }
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            Activity activity = i0.this.getActivity();
            if (com.martian.libmars.utils.n0.C(activity)) {
                g0.D(activity, "开屏-bidding-失败-" + this.f11462a);
                if (this.f11463b) {
                    this.f11464c.h();
                } else {
                    i0.this.i(activity, this.f11464c, null);
                }
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void i(AppTask lossAppTask) {
            i0.this.g(lossAppTask);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void j(AdConfig config) {
            this.f11464c.j(config);
        }
    }

    class c extends b.d.a.k.b {

        /* renamed from: a */
        final /* synthetic */ AppTask f11466a;

        /* renamed from: b */
        final /* synthetic */ b.d.a.k.b f11467b;

        c(final AppTask val$receiver, final b.d.a.k.b val$biddingAppTask) {
            this.f11466a = val$receiver;
            this.f11467b = val$biddingAppTask;
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void a(AdConfig config) {
            this.f11467b.a(config);
            i0.this.m(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void b(AdConfig config) {
            this.f11467b.b(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void c(AdConfig config) {
            this.f11467b.c(config);
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void d(AdConfig config, AppTaskList appTaskList) {
            AppTask appTask = appTaskList.getApps().get(0);
            i0.this.g(this.f11466a);
            int j2 = i0.this.j();
            if (appTask.getEcpm() < j2) {
                g0.D(i0.this.getActivity(), "开屏-瀑布流-失败-优化ecpm");
                i0.this.l(j2);
                this.f11467b.h();
            } else {
                g0.D(i0.this.getActivity(), "开屏-瀑布流-成功");
                i0.this.l(appTask.getEcpm());
                this.f11467b.d(config, appTaskList);
            }
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void h() {
            if (this.f11466a == null) {
                g0.D(i0.this.getActivity(), "开屏-瀑布流-失败");
                this.f11467b.h();
                return;
            }
            int j2 = i0.this.j();
            if (this.f11466a.getEcpm() < j2) {
                g0.D(i0.this.getActivity(), "开屏-瀑布流-失败-bidding-优化ecpm");
                i0.this.g(this.f11466a);
                i0.this.l(j2);
                this.f11467b.h();
                return;
            }
            g0.D(i0.this.getActivity(), "开屏-瀑布流-失败-用bidding");
            AppTaskList appTaskList = new AppTaskList();
            appTaskList.addAppTask(this.f11466a);
            this.f11467b.d(b.d.a.j.b.Q(this.f11466a), appTaskList);
            i0.this.l(this.f11466a.getEcpm());
        }

        @Override // b.d.a.k.b, b.d.a.k.a
        public void j(AdConfig config) {
            this.f11467b.j(config);
        }
    }

    public void g(AppTask appTask) {
        if (appTask == null || !appTask.isBidding()) {
            return;
        }
        if (this.f11457b == null) {
            this.f11457b = new ArrayList();
        }
        this.f11457b.add(appTask);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f11458c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void h(Activity activity, b.d.a.k.b receiver, boolean showAfterLoad) {
        if (com.martian.libmars.utils.n0.C(activity)) {
            this.f11458c = new WeakReference<>(activity);
            com.martian.mibook.b.b k0 = com.martian.mibook.b.b.k0(activity, showAfterLoad, this.f11459d);
            String str = showAfterLoad ? "冷启" : "热启";
            g0.D(activity, "开屏-bidding-请求-" + str);
            k0.T0(new b(str, showAfterLoad, receiver));
            k0.F();
        }
    }

    public int j() {
        if (MiConfigSingleton.V3().j5()) {
            return 0;
        }
        return MiConfigSingleton.V3().W3().getOptimizeSplashAdEcpm();
    }

    public void l(int winPrice) {
        List<AppTask> list = this.f11457b;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<AppTask> it = this.f11457b.iterator();
        while (it.hasNext()) {
            AppTask next = it.next();
            it.remove();
            Object obj = next.origin;
            if (obj instanceof SplashAd) {
                BaeAd.sendSplashLossNotification((SplashAd) obj);
            } else if (obj instanceof SplashAD) {
                GDTAd.sendSplashLossNotification(winPrice, (SplashAD) obj);
            } else if (obj instanceof KsSplashScreenAd) {
                KsAd.sendSplashLossNotification(winPrice, (KsSplashScreenAd) obj);
            } else if (obj instanceof UnifiedVivoSplashAd) {
                VivoAd.sendSplashLossNotification(winPrice, (UnifiedVivoSplashAd) obj);
            } else if (BaseAd.isOppoSplashAd(next)) {
                BaseAd.sendOppoSplashLossNotification(winPrice, next);
            }
        }
    }

    public void m(AdConfig adConfig) {
        if (adConfig == null || !MiConfigSingleton.V3().W3().getEnableBaeAdInfo()) {
            return;
        }
        if (this.f11459d == null) {
            this.f11459d = new AdConfig.AdInfo();
        }
        this.f11459d.setSource(adConfig.getSource());
        this.f11459d.setEcpm(adConfig.getEcpm());
    }

    public void i(Activity activity, b.d.a.k.b receiver, AppTask biddingAppTask) {
        com.martian.mibook.b.b j0 = com.martian.mibook.b.b.j0(activity, biddingAppTask == null ? 0 : biddingAppTask.getEcpm());
        j0.T0(new c(biddingAppTask, receiver));
        j0.F();
    }

    public AppTask k(Activity activity, b.d.a.k.b receiver) {
        if (!g0.o(this.f11456a) || this.f11456a.exposed) {
            g0.D(activity, "开屏-冷启动");
            h(activity, receiver, true);
            return null;
        }
        g0.D(activity, "开屏-热启动");
        n(receiver);
        return this.f11456a;
    }

    public void n(b.d.a.k.a receiver) {
        this.f11460e = receiver;
    }

    public void o(AppTask newSplashAppTask) {
        this.f11456a = newSplashAppTask;
    }

    public void p(Activity activity) {
        if (MiConfigSingleton.V3().j5() || !MiConfigSingleton.V3().W3().getEnableHotSplash()) {
            return;
        }
        if (!g0.o(this.f11456a) || this.f11456a.exposed) {
            h(activity, new a(), false);
        }
    }
}
