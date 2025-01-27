package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.h0;
import cn.vlion.ad.inland.core.natives.VlionNativeADListener;

/* loaded from: classes.dex */
public final class u extends i {

    public class a implements c0 {
        public a() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadNative onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.e(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadNative onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.e(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public class b implements c0 {
        public b() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadRewardVideo onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.f(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadRewardVideo onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.f(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public class c implements c0 {
        public c() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadDraw onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.d(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadDraw onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.d(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public class d implements c0 {
        public d() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadBanner onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.a(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadBanner onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.a(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public class e implements c0 {
        public e() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadInterstitial onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.b(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadInterstitial onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.b(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public class f implements c0 {
        public f() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadSplash onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.c(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadSplash onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.c(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public class g implements c0 {
        public g() {
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void a(double d10) {
            LogVlion.e("VlionLoadAdSourceManager VlionBidAdSource loadFeed onAdLoadSuccess bidPrice=" + d10);
            if (u.this.a(d10)) {
                u.d(u.this);
            } else {
                u.this.e();
            }
        }

        @Override // cn.vlion.ad.inland.core.c0
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = cn.vlion.ad.inland.core.f.a("VlionLoadAdSourceManager VlionBidAdSource loadFeed onAdLoadFailure:");
            a10.append(vlionAdError.getFullErrorInfo());
            LogVlion.e(a10.toString());
            if (u.this.a(l5.c.f27899e)) {
                u.d(u.this);
            } else {
                u.this.a(vlionAdError);
            }
        }
    }

    public u(Activity activity, j0 j0Var, VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        super(activity, j0Var, placementBean);
    }

    public static void c(u uVar) {
        uVar.getClass();
        try {
            LogVlion.e("VlionLoadAdSourceManager isLoadSplashWaterfall  vlionWaterfallAdSource=" + uVar.f3611e);
            p0 p0Var = uVar.f3611e;
            if (p0Var != null) {
                p0Var.g(new a0(uVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void d(u uVar) {
        uVar.getClass();
        try {
            LogVlion.e("VlionLoadAdSourceManager isLoadFeedWaterfall  vlionWaterfallAdSource=" + uVar.f3611e);
            p0 p0Var = uVar.f3611e;
            if (p0Var != null) {
                p0Var.c(new b0(uVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void e(u uVar) {
        uVar.getClass();
        try {
            LogVlion.e("VlionLoadAdSourceManager isLoadNativeWaterfall  vlionWaterfallAdSource=" + uVar.f3611e);
            p0 p0Var = uVar.f3611e;
            if (p0Var != null) {
                p0Var.e(new v(uVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.i
    public final void a() {
        try {
            super.a();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(Activity activity) {
        try {
            LogVlion.e("VlionLoadAdSourceManagerCache showRewardVideo ");
            if (this.f3618l == null || this.f3629w == null) {
                LogVlion.e("VlionLoadAdSourceManagerCache showRewardVideo ad is not ready");
                return;
            }
            LogVlion.e("VlionLoadAdSourceManagerCache showRewardVideo AdAdapter");
            cn.vlion.ad.inland.core.b bVar = this.f3627u;
            if (bVar != null) {
                VlionADEventManager.submitTrigger(bVar.n());
            }
            this.f3629w.showRewardVideoAD(activity);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void f() {
        try {
            this.f3626t = false;
            if (c()) {
                if (b()) {
                    l lVar = this.f3622p;
                    if (lVar != null) {
                        VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_APP_REQUEST_LIMIT;
                        lVar.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage(), "", ""));
                        return;
                    }
                    return;
                }
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                l lVar2 = this.f3622p;
                if (lVar2 != null) {
                    VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    lVar2.a(new VlionAdError(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "loadBanner";
            LogVlion.e("VlionLoadAdSourceManager loadBanner  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.a(new d());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadBannerWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.a(new y(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void g() {
        try {
            this.f3626t = false;
            if (c()) {
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                l lVar = this.f3622p;
                if (lVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    lVar.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "loaDraw";
            LogVlion.e("VlionLoadAdSourceManager loadDraw  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.b(new c());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadDrawWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.b(new x(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void h() {
        try {
            this.f3626t = false;
            if (c()) {
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                l lVar = this.f3622p;
                if (lVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    lVar.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "loadFeed";
            LogVlion.e("VlionLoadAdSourceManager loadFeed  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.c(new g());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadFeedWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.c(new b0(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void i() {
        try {
            this.f3626t = true;
            if (c()) {
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                l lVar = this.f3622p;
                if (lVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    lVar.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "getInterstitialAdData";
            LogVlion.e("VlionLoadAdSourceManager loadInterstitial  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.d(new e());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadInterstitialWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.d(new z(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void j() {
        try {
            if (c()) {
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                VlionNativeADListener vlionNativeADListener = this.f3623q;
                if (vlionNativeADListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    vlionNativeADListener.onAdLoadFailure(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "loadNative";
            LogVlion.e("VlionLoadAdSourceManager loadNative  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.e(new a());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadNativeWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.e(new v(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void k() {
        try {
            this.f3626t = true;
            if (c()) {
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                m mVar = this.f3624r;
                if (mVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    ((h0.a) mVar).a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "loadRewardVideo";
            LogVlion.e("VlionLoadAdSourceManager loadRewardVideo  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.f(new b());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadRewardVideoWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.f(new w(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void l() {
        try {
            this.f3626t = true;
            if (c()) {
                LogVlion.e("VlionLoadAdSourceManager bidSize is empty  and waterfallSize is empty");
                l lVar = this.f3622p;
                if (lVar != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_EMPTY;
                    lVar.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                return;
            }
            this.f3614h = "loadSplash";
            LogVlion.e("VlionLoadAdSourceManager loadSplash  vlionBidAdSource=" + this.f3610d);
            j jVar = this.f3610d;
            if (jVar != null) {
                jVar.g(new f());
                return;
            }
            try {
                LogVlion.e("VlionLoadAdSourceManager isLoadSplashWaterfall  vlionWaterfallAdSource=" + this.f3611e);
                p0 p0Var = this.f3611e;
                if (p0Var != null) {
                    p0Var.g(new a0(this));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public u(Context context, j0 j0Var, VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        super(context, j0Var, placementBean);
    }

    public static void b(u uVar) {
        uVar.getClass();
        try {
            LogVlion.e("VlionLoadAdSourceManager isLoadInterstitialWaterfall  vlionWaterfallAdSource=" + uVar.f3611e);
            p0 p0Var = uVar.f3611e;
            if (p0Var != null) {
                p0Var.d(new z(uVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(Activity activity) {
        try {
            LogVlion.e("VlionLoadAdSourceManagerCache showInterstitial ");
            if (this.f3618l == null || this.f3629w == null) {
                LogVlion.e("VlionLoadAdSourceManagerCache showInterstitial ad is not ready");
                return;
            }
            LogVlion.e("VlionLoadAdSourceManagerCache showInterstitial AdAdapter");
            cn.vlion.ad.inland.core.b bVar = this.f3627u;
            if (bVar != null) {
                VlionADEventManager.submitTrigger(bVar.n());
            }
            this.f3629w.showInterstitialAD(activity);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(ViewGroup viewGroup) {
        String str;
        try {
            LogVlion.e("VlionLoadAdSourceManagerCache showSplash ");
            if (this.f3618l == null || this.f3629w == null) {
                str = "VlionLoadAdSourceManagerCache showSplash ad is not ready";
            } else {
                LogVlion.e("VlionLoadAdSourceManagerCache showSplash AdAdapter");
                cn.vlion.ad.inland.core.b bVar = this.f3627u;
                if (bVar != null) {
                    VlionADEventManager.submitTrigger(bVar.n());
                }
                if (viewGroup != null) {
                    this.f3629w.showSplashAD(viewGroup);
                    return;
                }
                str = "VlionLoadAdSourceManagerCache showSplash viewGroup is null";
            }
            LogVlion.e(str);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(u uVar) {
        uVar.getClass();
        try {
            LogVlion.e("VlionLoadAdSourceManager isLoadBannerWaterfall  vlionWaterfallAdSource=" + uVar.f3611e);
            p0 p0Var = uVar.f3611e;
            if (p0Var != null) {
                p0Var.a(new y(uVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void f(u uVar) {
        uVar.getClass();
        try {
            LogVlion.e("VlionLoadAdSourceManager isLoadRewardVideoWaterfall  vlionWaterfallAdSource=" + uVar.f3611e);
            p0 p0Var = uVar.f3611e;
            if (p0Var != null) {
                p0Var.f(new w(uVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
