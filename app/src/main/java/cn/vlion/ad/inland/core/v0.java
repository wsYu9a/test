package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class v0 implements VlionBiddingLoadListener {

    /* renamed from: a */
    public final /* synthetic */ b f3790a;

    /* renamed from: b */
    public final /* synthetic */ VlionAdapterADConfig f3791b;

    /* renamed from: c */
    public final /* synthetic */ String f3792c;

    /* renamed from: d */
    public final /* synthetic */ BaseAdAdapter f3793d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3794e;

    public v0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3794e = p0Var;
        this.f3790a = bVar;
        this.f3791b = vlionAdapterADConfig;
        this.f3792c = str;
        this.f3793d = baseAdAdapter;
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadFailure(int i10, String str) {
        try {
            if (this.f3790a == null || this.f3791b == null) {
                return;
            }
            LogVlion.e(this.f3794e.f3592c + " " + this.f3792c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3794e.f3721k);
            VlionADEventManager.submitFillFail(this.f3791b, String.valueOf(i10));
            this.f3790a.a(2);
            this.f3790a.b(i10);
            this.f3790a.b(str);
            if (p0.a(this.f3794e, this.f3790a, i10, str)) {
                p0.d(this.f3794e);
                p0.h(this.f3794e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(double d10) {
        try {
            if (this.f3790a == null || this.f3791b == null) {
                return;
            }
            LogVlion.e(this.f3794e.f3592c + " " + this.f3792c + "   onAdBiddingSuccess Platform:=" + this.f3790a.h() + " isNotFinished=" + this.f3794e.f3721k + " price=" + (this.f3790a.j() * d10));
            this.f3790a.a(1);
            this.f3790a.a(d10);
            this.f3794e.a(this.f3790a, this.f3793d);
            VlionADEventManager.submitFillSuccess(this.f3791b, this.f3790a.q());
            if (p0.b(this.f3794e)) {
                p0.d(this.f3794e);
                p0.h(this.f3794e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
    }
}
