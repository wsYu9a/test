package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p0 extends h {

    /* renamed from: k */
    public boolean f3721k;

    /* renamed from: l */
    public int f3722l;

    public class a implements VlionBiddingLoadListener {

        /* renamed from: a */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3723a;

        /* renamed from: b */
        public final /* synthetic */ VlionAdapterADConfig f3724b;

        /* renamed from: c */
        public final /* synthetic */ String f3725c;

        /* renamed from: d */
        public final /* synthetic */ BaseAdAdapter f3726d;

        /* renamed from: e */
        public final /* synthetic */ p0 f3727e;

        public a(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, cn.vlion.ad.inland.core.b bVar, String str) {
            this.f3727e = p0Var;
            this.f3723a = bVar;
            this.f3724b = vlionAdapterADConfig;
            this.f3725c = str;
            this.f3726d = baseAdAdapter;
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadFailure(int i10, String str) {
            try {
                if (this.f3723a == null || this.f3724b == null) {
                    return;
                }
                LogVlion.e(this.f3727e.f3592c + " " + this.f3725c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3727e.f3721k);
                VlionADEventManager.submitFillFail(this.f3724b, String.valueOf(i10));
                this.f3723a.a(2);
                this.f3723a.b(i10);
                this.f3723a.b(str);
                if (p0.a(this.f3727e, this.f3723a, i10, str)) {
                    p0.d(this.f3727e);
                    p0.j(this.f3727e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(double d10) {
            try {
                if (this.f3723a == null || this.f3724b == null) {
                    return;
                }
                LogVlion.e(this.f3727e.f3592c + " " + this.f3725c + "   onAdBiddingSuccess Platform:=" + this.f3723a.h() + "isNotFinished=" + this.f3727e.f3721k + " price=" + (this.f3723a.j() * d10));
                this.f3723a.a(1);
                this.f3723a.a(d10);
                this.f3727e.a(this.f3723a, this.f3726d);
                VlionADEventManager.submitFillSuccess(this.f3724b, this.f3723a.q());
                if (p0.b(this.f3727e)) {
                    p0.d(this.f3727e);
                    p0.j(this.f3727e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
        }
    }

    public class b implements VlionBiddingLoadListener {

        /* renamed from: a */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3728a;

        /* renamed from: b */
        public final /* synthetic */ VlionAdapterADConfig f3729b;

        /* renamed from: c */
        public final /* synthetic */ String f3730c;

        /* renamed from: d */
        public final /* synthetic */ BaseAdAdapter f3731d;

        /* renamed from: e */
        public final /* synthetic */ p0 f3732e;

        public b(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, cn.vlion.ad.inland.core.b bVar, String str) {
            this.f3732e = p0Var;
            this.f3728a = bVar;
            this.f3729b = vlionAdapterADConfig;
            this.f3730c = str;
            this.f3731d = baseAdAdapter;
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadFailure(int i10, String str) {
            try {
                if (this.f3728a == null || this.f3729b == null) {
                    return;
                }
                LogVlion.e(this.f3732e.f3592c + " " + this.f3730c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3732e.f3721k);
                VlionADEventManager.submitFillFail(this.f3729b, String.valueOf(i10));
                this.f3728a.a(2);
                this.f3728a.b(i10);
                this.f3728a.b(str);
                if (p0.a(this.f3732e, this.f3728a, i10, str)) {
                    p0.d(this.f3732e);
                    p0.c(this.f3732e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(double d10) {
            try {
                if (this.f3728a == null || this.f3729b == null) {
                    return;
                }
                LogVlion.e(this.f3732e.f3592c + " " + this.f3730c + "   onAdBiddingSuccess Platform:=" + this.f3728a.h() + " isNotFinished=" + this.f3732e.f3721k + " price=" + (this.f3728a.j() * d10));
                this.f3728a.a(1);
                this.f3728a.a(d10);
                this.f3732e.a(this.f3728a, this.f3731d);
                VlionADEventManager.submitFillSuccess(this.f3729b, this.f3728a.q());
                if (p0.b(this.f3732e)) {
                    p0.d(this.f3732e);
                    p0.c(this.f3732e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
        }
    }

    public class c implements VlionBiddingLoadListener {

        /* renamed from: a */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3733a;

        /* renamed from: b */
        public final /* synthetic */ VlionAdapterADConfig f3734b;

        /* renamed from: c */
        public final /* synthetic */ String f3735c;

        /* renamed from: d */
        public final /* synthetic */ BaseAdAdapter f3736d;

        /* renamed from: e */
        public final /* synthetic */ p0 f3737e;

        public c(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, cn.vlion.ad.inland.core.b bVar, String str) {
            this.f3737e = p0Var;
            this.f3733a = bVar;
            this.f3734b = vlionAdapterADConfig;
            this.f3735c = str;
            this.f3736d = baseAdAdapter;
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadFailure(int i10, String str) {
            try {
                if (this.f3733a == null || this.f3734b == null) {
                    return;
                }
                LogVlion.e(this.f3737e.f3592c + " " + this.f3735c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3737e.f3721k);
                VlionADEventManager.submitFillFail(this.f3734b, String.valueOf(i10));
                this.f3733a.a(2);
                this.f3733a.b(i10);
                this.f3733a.b(str);
                if (p0.a(this.f3737e, this.f3733a, i10, str)) {
                    p0.d(this.f3737e);
                    p0.e(this.f3737e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(double d10) {
            try {
                if (this.f3733a == null || this.f3734b == null) {
                    return;
                }
                LogVlion.e(this.f3737e.f3592c + " " + this.f3735c + "   onAdBiddingSuccess Platform:=" + this.f3733a.h() + "isNotFinished=" + this.f3737e.f3721k + " price=" + (this.f3733a.j() * d10));
                this.f3733a.a(1);
                this.f3733a.a(d10);
                this.f3737e.a(this.f3733a, this.f3736d);
                VlionADEventManager.submitFillSuccess(this.f3734b, this.f3733a.q());
                if (p0.b(this.f3737e)) {
                    p0.d(this.f3737e);
                    p0.e(this.f3737e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
        }
    }

    public class d implements VlionBiddingLoadListener {

        /* renamed from: a */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3738a;

        /* renamed from: b */
        public final /* synthetic */ VlionAdapterADConfig f3739b;

        /* renamed from: c */
        public final /* synthetic */ String f3740c;

        /* renamed from: d */
        public final /* synthetic */ BaseAdAdapter f3741d;

        /* renamed from: e */
        public final /* synthetic */ p0 f3742e;

        public d(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, cn.vlion.ad.inland.core.b bVar, String str) {
            this.f3742e = p0Var;
            this.f3738a = bVar;
            this.f3739b = vlionAdapterADConfig;
            this.f3740c = str;
            this.f3741d = baseAdAdapter;
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadFailure(int i10, String str) {
            try {
                if (this.f3738a == null || this.f3739b == null) {
                    return;
                }
                LogVlion.e(this.f3742e.f3592c + " " + this.f3740c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3742e.f3721k);
                VlionADEventManager.submitFillFail(this.f3739b, String.valueOf(i10));
                this.f3738a.a(2);
                this.f3738a.b(i10);
                this.f3738a.b(str);
                if (p0.a(this.f3742e, this.f3738a, i10, str)) {
                    p0.d(this.f3742e);
                    p0.f(this.f3742e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(double d10) {
            try {
                if (this.f3738a == null || this.f3739b == null) {
                    return;
                }
                LogVlion.e(this.f3742e.f3592c + " " + this.f3740c + "   onAdBiddingSuccess Platform:=" + this.f3738a.h() + "isNotFinished=" + this.f3742e.f3721k + " price=" + (this.f3738a.j() * d10));
                this.f3738a.a(1);
                this.f3738a.a(d10);
                this.f3742e.a(this.f3738a, this.f3741d);
                VlionADEventManager.submitFillSuccess(this.f3739b, this.f3738a.q());
                if (p0.b(this.f3742e)) {
                    p0.d(this.f3742e);
                    p0.f(this.f3742e);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
        public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
        }
    }

    public p0(Context context, Activity activity, ArrayList<cn.vlion.ad.inland.core.b> arrayList, boolean z10) {
        super(context, activity, arrayList, z10);
        this.f3721k = false;
        this.f3722l = 0;
        this.f3592c = p0.class.getName();
    }

    public static void i(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "getNativeAdData plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new w0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    public static void j(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "getRewardVideoPositionAdData plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new o0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    @Override // cn.vlion.ad.inland.core.h
    public final void a() {
        try {
            super.a();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(Activity activity, BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new d(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadInterstitialAD(activity, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void c(BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new n0(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadNativeAD(this.f3590a, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d(BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new a(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadRewardVideoAD(this.f3590a, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void e(BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new t0(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadSplashAD(this.f3590a, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final cn.vlion.ad.inland.core.b f() {
        try {
            LogVlion.e(this.f3592c + " getCurrentSource sdkCurrent=" + this.f3722l + " baseAdSourceDataList.size()=" + this.f3595f.size());
            if (this.f3722l + 1 <= this.f3595f.size()) {
                return this.f3595f.get(this.f3722l);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return null;
    }

    public final synchronized boolean g() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f3592c);
            sb2.append(" (null!=baseAdSourceDataList)=");
            sb2.append(this.f3595f != null);
            LogVlion.e(sb2.toString());
            if (this.f3595f != null && this.f3595f.size() > 0) {
                LogVlion.e(this.f3592c + " isNotFinishedAdapter sdkCurrent=" + this.f3722l + " isNotFinishedAdapter.size=" + this.f3595f.size());
                if (this.f3722l + 1 == this.f3595f.size()) {
                    d();
                    LogVlion.e(this.f3592c + "isNotFinishedAdapter is  last");
                    return false;
                }
            }
        } finally {
            return true;
        }
        return true;
    }

    public final void h() {
        this.f3721k = true;
    }

    public static void c(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "loadDrawAD plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new q0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    public static /* synthetic */ void d(p0 p0Var) {
        p0Var.f3722l++;
    }

    public static void e(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "loadBanner plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new m0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    public static void f(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "getInterstitialAdData plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new r0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    public static void g(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "loadSplash plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new s0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    public static void h(p0 p0Var) {
        cn.vlion.ad.inland.core.b f10 = p0Var.f();
        if (f10 != null) {
            try {
                String str = "loadFeed plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    p0Var.a(c10, str, f10.o(), f10, new u0(c10, f10.n(), p0Var, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            p0Var.a(f10.h());
        }
    }

    public final void a(Activity activity, BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new c(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadBannerAD(activity, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new v0(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadFeedAD(this.f3590a, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static boolean b(p0 p0Var) {
        boolean z10;
        p0Var.getClass();
        try {
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (p0Var.g()) {
            LogVlion.e(p0Var.f3592c + " checkAdapterIsNotFinished not load all");
            z10 = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p0Var.f3592c);
            sb2.append("checkIsContinue  IsNotFinished=");
            sb2.append(z10);
            sb2.append("!isTimeOut=");
            sb2.append(!p0Var.f3721k);
            sb2.append(" !isDestroy=");
            sb2.append(!p0Var.f3597h);
            LogVlion.e(sb2.toString());
            return !z10 ? false : false;
        }
        LogVlion.e(p0Var.f3592c + " checkAdapterIsNotFinished load all  isTimeOut=" + p0Var.f3721k);
        p0Var.a(true);
        z10 = false;
        StringBuilder sb22 = new StringBuilder();
        sb22.append(p0Var.f3592c);
        sb22.append("checkIsContinue  IsNotFinished=");
        sb22.append(z10);
        sb22.append("!isTimeOut=");
        sb22.append(!p0Var.f3721k);
        sb22.append(" !isDestroy=");
        sb22.append(!p0Var.f3597h);
        LogVlion.e(sb22.toString());
        return !z10 ? false : false;
    }

    public final void a(BaseAdAdapter baseAdAdapter, String str, cn.vlion.ad.inland.core.b bVar, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new b(baseAdAdapter, vlionAdapterADConfig, this, bVar, str));
            baseAdAdapter.loadDrawAD(this.f3590a, vlionAdapterADConfig);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "getInterstitialAdData plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new r0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }

    public static boolean a(p0 p0Var, cn.vlion.ad.inland.core.b bVar, int i10, String str) {
        boolean z10;
        p0Var.getClass();
        try {
            p0Var.a(bVar);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (p0Var.g()) {
            LogVlion.e(p0Var.f3592c + " checkFailAdapterIsFinished  not load all code=" + i10 + "  desc=" + str);
            z10 = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p0Var.f3592c);
            sb2.append("checkFailIsContinue  IsNotFinished =");
            sb2.append(z10);
            sb2.append("!isTimeOut=");
            sb2.append(!p0Var.f3721k);
            sb2.append(" !isDestroy=");
            sb2.append(!p0Var.f3597h);
            LogVlion.e(sb2.toString());
            return !z10 ? false : false;
        }
        LogVlion.e(p0Var.f3592c + " checkFailAdapterIsFinished  load all code=" + i10 + "  desc=" + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(p0Var.f3592c);
        sb3.append(" checkFailAdapterIsFinished  load all isTimeOut=");
        sb3.append(p0Var.f3721k);
        LogVlion.e(sb3.toString());
        p0Var.a(false);
        z10 = false;
        StringBuilder sb22 = new StringBuilder();
        sb22.append(p0Var.f3592c);
        sb22.append("checkFailIsContinue  IsNotFinished =");
        sb22.append(z10);
        sb22.append("!isTimeOut=");
        sb22.append(!p0Var.f3721k);
        sb22.append(" !isDestroy=");
        sb22.append(!p0Var.f3597h);
        LogVlion.e(sb22.toString());
        return !z10 ? false : false;
    }

    public final void b(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "loadDrawAD plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new q0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }

    public final void c(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "loadFeed plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new u0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }

    public final void e(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "getNativeAdData plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new w0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }

    public final void f(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "getRewardVideoPositionAdData plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new o0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }

    public final void g(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "loadSplash plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new s0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }

    public final void a(c0 c0Var) {
        this.f3598i = c0Var;
        this.f3722l = 0;
        cn.vlion.ad.inland.core.b f10 = f();
        if (f10 != null) {
            try {
                String str = "loadBanner plat=" + f10.h();
                BaseAdAdapter c10 = f10.c();
                if (c10 != null && f10.m() != null) {
                    a(c10, str, f10.o(), f10, new m0(c10, f10.n(), this, f10, str));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            a(f10.h());
        }
    }
}
