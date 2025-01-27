package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class k implements VlionBiddingLoadListener {

    /* renamed from: a */
    public final /* synthetic */ b f3680a;

    /* renamed from: b */
    public final /* synthetic */ VlionAdapterADConfig f3681b;

    /* renamed from: c */
    public final /* synthetic */ String f3682c;

    /* renamed from: d */
    public final /* synthetic */ BaseAdAdapter f3683d;

    /* renamed from: e */
    public final /* synthetic */ j f3684e;

    public k(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, b bVar, String str) {
        this.f3684e = jVar;
        this.f3680a = bVar;
        this.f3681b = vlionAdapterADConfig;
        this.f3682c = str;
        this.f3683d = baseAdAdapter;
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadFailure(int i10, String str) {
        try {
            if (this.f3680a == null || this.f3681b == null) {
                return;
            }
            LogVlion.e(this.f3684e.f3592c + " " + this.f3682c + " plat=" + this.f3680a.h() + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  ");
            VlionADEventManager.submitFillFail(this.f3681b, String.valueOf(i10));
            this.f3680a.a(2);
            this.f3680a.b(i10);
            this.f3680a.b(str);
            this.f3684e.b(this.f3680a);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(double d10) {
        try {
            if (this.f3680a == null || this.f3681b == null) {
                return;
            }
            LogVlion.e(this.f3684e.f3592c + " " + this.f3682c + " plat=" + this.f3680a.h() + "  onAdBiddingSuccess  price=" + (this.f3680a.j() * d10));
            this.f3680a.a(1);
            this.f3680a.a(d10);
            this.f3684e.a(this.f3680a, this.f3683d);
            VlionADEventManager.submitFillSuccess(this.f3681b, this.f3680a.q());
            j.a(this.f3684e);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
        double d10;
        try {
            if (this.f3680a == null || this.f3681b == null) {
                return;
            }
            if (vlionNativeAdvert == null || vlionNativeAdvert.getVlionNativeAdData() == null) {
                d10 = -1.0d;
            } else {
                d10 = vlionNativeAdvert.getVlionNativeAdData().getPrice();
                vlionNativeAdvert.getVlionNativeAdData().setPrice((int) (this.f3680a.j() * d10));
            }
            LogVlion.e(this.f3684e.f3592c + " " + this.f3682c + " plat=" + this.f3680a.h() + "  onAdBiddingSuccess  price=" + (this.f3680a.j() * d10));
            this.f3680a.a(1);
            this.f3680a.a(vlionNativeAdvert);
            this.f3680a.a(d10);
            this.f3684e.a(this.f3680a, this.f3683d);
            VlionADEventManager.submitFillSuccess(this.f3681b, this.f3680a.q());
            j.a(this.f3684e);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
