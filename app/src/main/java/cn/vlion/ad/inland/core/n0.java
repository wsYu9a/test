package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class n0 implements VlionBiddingLoadListener {

    /* renamed from: a */
    public final /* synthetic */ b f3708a;

    /* renamed from: b */
    public final /* synthetic */ VlionAdapterADConfig f3709b;

    /* renamed from: c */
    public final /* synthetic */ String f3710c;

    /* renamed from: d */
    public final /* synthetic */ BaseAdAdapter f3711d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3712e;

    public n0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3712e = p0Var;
        this.f3708a = bVar;
        this.f3709b = vlionAdapterADConfig;
        this.f3710c = str;
        this.f3711d = baseAdAdapter;
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadFailure(int i10, String str) {
        try {
            if (this.f3708a == null || this.f3709b == null) {
                return;
            }
            LogVlion.e(this.f3712e.f3592c + " " + this.f3710c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3712e.f3721k);
            VlionADEventManager.submitFillFail(this.f3709b, String.valueOf(i10));
            this.f3708a.a(2);
            this.f3708a.b(i10);
            this.f3708a.b(str);
            if (p0.a(this.f3712e, this.f3708a, i10, str)) {
                p0.d(this.f3712e);
                p0.i(this.f3712e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(double d10) {
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
        double d10;
        try {
            if (this.f3708a == null || this.f3709b == null) {
                return;
            }
            if (vlionNativeAdvert == null || vlionNativeAdvert.getVlionNativeAdData() == null) {
                d10 = -1.0d;
            } else {
                d10 = vlionNativeAdvert.getVlionNativeAdData().getPrice();
                vlionNativeAdvert.getVlionNativeAdData().setPrice((int) (this.f3708a.j() * d10));
            }
            LogVlion.e(this.f3712e.f3592c + " " + this.f3710c + "   onAdBiddingSuccess Platform:=" + this.f3708a.h() + " isNotFinished=" + this.f3712e.f3721k + " price=" + (this.f3708a.j() * d10));
            this.f3708a.a(1);
            this.f3708a.a(vlionNativeAdvert);
            this.f3708a.a(d10);
            this.f3712e.a(this.f3708a, this.f3711d);
            VlionADEventManager.submitFillSuccess(this.f3709b, this.f3708a.q());
            if (p0.b(this.f3712e)) {
                p0.d(this.f3712e);
                p0.i(this.f3712e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
