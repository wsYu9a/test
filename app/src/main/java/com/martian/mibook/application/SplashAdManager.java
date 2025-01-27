package com.martian.mibook.application;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import b8.e;
import b8.h;
import com.martian.ads.ad.AdConfig;
import com.martian.ads.ad.BaeAd;
import com.martian.ads.ad.DXAd;
import com.martian.ads.ad.GDTAd;
import com.martian.ads.ad.KsAd;
import com.martian.ads.ad.MentaAd;
import com.martian.ads.ad.SigmobAd;
import com.martian.ads.ad.TTAd;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.mibook.application.SplashAdManager;
import com.martian.mibook.mvvm.utils.SensorHook;
import com.qq.e.ads.splash.SplashAD;
import java.util.HashMap;
import java.util.Map;
import l9.m0;
import xa.p;

/* loaded from: classes3.dex */
public class SplashAdManager {

    /* renamed from: a */
    public final Context f13410a;

    /* renamed from: b */
    public AppTask f13411b;

    /* renamed from: c */
    public d8.b f13412c;

    /* renamed from: d */
    public long f13413d;

    /* renamed from: e */
    public Map<String, AppTask> f13414e;

    /* renamed from: f */
    public AdConfig.AdInfo f13415f;

    /* renamed from: g */
    public final d8.b f13416g = new a();

    public class a extends d8.b {

        /* renamed from: a */
        public boolean f13417a = false;

        /* renamed from: b */
        public boolean f13418b = false;

        public a() {
        }

        @Override // d8.b, d8.a
        public void a() {
            e.A(null, "onFallbackFailed");
            if (SplashAdManager.this.f13412c != null) {
                SplashAdManager.this.f13412c.a();
            }
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (this.f13417a) {
                return;
            }
            this.f13417a = true;
            MiConfigSingleton.b2().H1().y(adConfig);
            SensorHook.INSTANCE.getInstance().enableSensor();
            if (SplashAdManager.this.f13412c != null) {
                SplashAdManager.this.f13412c.b(adConfig);
            }
        }

        @Override // d8.b, d8.a
        public void d(AdConfig adConfig) {
            e.A(adConfig, "close");
            if (SplashAdManager.this.f13412c != null) {
                SplashAdManager.this.f13412c.d(adConfig);
            }
            this.f13417a = false;
            this.f13418b = false;
        }

        @Override // d8.b, d8.a
        public void g(AdConfig adConfig) {
            e.A(adConfig, "onAdDismiss");
            if (SplashAdManager.this.f13412c != null) {
                SplashAdManager.this.f13412c.g(adConfig);
            }
            this.f13417a = false;
            this.f13418b = false;
        }

        @Override // d8.b, d8.a
        public void h(AppTask appTask) {
            SplashAdManager.this.e(appTask);
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            SplashAdManager.this.f13411b = appTaskList.getApps().get(0);
            if (SplashAdManager.this.f13412c != null) {
                SplashAdManager.this.f13412c.i(adConfig, appTaskList);
            }
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (this.f13418b) {
                return;
            }
            this.f13418b = true;
            MiConfigSingleton.b2().H1().x(adConfig);
            if (SplashAdManager.this.f13412c != null) {
                SplashAdManager.this.f13412c.l(adConfig);
            }
        }
    }

    public SplashAdManager(Context context) {
        this.f13410a = context;
    }

    public final void e(AppTask appTask) {
        if (this.f13414e == null) {
            this.f13414e = new HashMap();
        }
        if (com.martian.mibook.application.a.z(this.f13414e.get(appTask.f12000id))) {
            this.f13414e.put(appTask.f12000id, appTask);
        }
    }

    public void f() {
        AppTask appTask = this.f13411b;
        if (appTask != null) {
            appTask.origin = null;
            this.f13411b = null;
        }
        this.f13412c = null;
    }

    public final /* synthetic */ void g(Activity activity, ViewGroup viewGroup) {
        if (this.f13411b == null) {
            ac.a.T(activity, "开屏-广告为空");
            return;
        }
        if (m0.c(activity)) {
            ac.a.T(activity, "开屏-界面销毁");
            return;
        }
        ac.a.T(activity, "开屏-预曝光");
        e.s().j(this.f13411b);
        if (TTAd.isTTSplashAd(this.f13411b)) {
            TTAd.showSplashAd(this.f13411b, viewGroup, this.f13416g);
        } else if (KsAd.isKsSplashAd(this.f13411b)) {
            KsAd.showSplashAd(activity, this.f13411b, viewGroup, this.f13416g);
        } else if (BaeAd.isBaeSplashAd(this.f13411b)) {
            BaeAd.showSplashAd(this.f13411b, viewGroup, this.f13416g);
        } else if (DXAd.isDxSplashAd(this.f13411b)) {
            DXAd.showSplashAd(this.f13411b, viewGroup, this.f13416g);
        } else if (GDTAd.isGdtSplashAd(this.f13411b)) {
            AppTask appTask = this.f13411b;
            GDTAd.showSplashAd((SplashAD) appTask.origin, viewGroup, appTask.isBidding());
        } else if (h.r(this.f13411b)) {
            h.L(this.f13411b, viewGroup);
        } else if (h.n(this.f13411b)) {
            h.I(activity, this.f13411b);
        } else if (MentaAd.isMentaSplashAd(this.f13411b)) {
            MentaAd.showSplashAd(this.f13411b, viewGroup);
        } else if (SigmobAd.isSigmobSplashAd(this.f13411b)) {
            SigmobAd.showSplashAd(this.f13411b, viewGroup, this.f13416g);
        } else if (h.j(this.f13411b)) {
            h.G(this.f13411b, viewGroup, this.f13416g);
        }
        if (MiConfigSingleton.b2().c2().getEnableBaeAdInfo()) {
            if (this.f13415f == null) {
                this.f13415f = new AdConfig.AdInfo();
            }
            this.f13415f.setSource(this.f13411b.source);
            this.f13415f.setEcpm(this.f13411b.getEcpm());
        }
    }

    public void h(Context context, d8.b bVar) {
        this.f13412c = bVar;
        if (!com.martian.mibook.application.a.z(this.f13411b)) {
            if (bVar != null) {
                ac.a.T(context, "预加载成功");
                bVar.i(AdConfig.toAdConfig(this.f13411b), new AppTaskList().addAppTask(this.f13411b));
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f13413d;
        if (currentTimeMillis - j10 < 30000) {
            if (bVar != null) {
                bVar.a();
            }
        } else {
            boolean z10 = j10 <= 0;
            this.f13413d = System.currentTimeMillis() - (z10 ? 30000L : 0L);
            p pVar = new p(context, "splash", this.f13414e, this.f13415f, z10);
            pVar.a1(this.f13416g);
            pVar.F0();
        }
    }

    public void i() {
        this.f13413d = -1L;
    }

    public void j(Activity activity, ViewGroup viewGroup) {
        viewGroup.post(new Runnable() { // from class: ya.l2

            /* renamed from: c */
            public final /* synthetic */ Activity f33301c;

            /* renamed from: d */
            public final /* synthetic */ ViewGroup f33302d;

            public /* synthetic */ l2(Activity activity2, ViewGroup viewGroup2) {
                activity = activity2;
                viewGroup = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SplashAdManager.this.g(activity, viewGroup);
            }
        });
    }
}
