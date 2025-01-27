package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class t0 implements VlionBiddingLoadListener {

    /* renamed from: a */
    public final /* synthetic */ b f3771a;

    /* renamed from: b */
    public final /* synthetic */ VlionAdapterADConfig f3772b;

    /* renamed from: c */
    public final /* synthetic */ String f3773c;

    /* renamed from: d */
    public final /* synthetic */ BaseAdAdapter f3774d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3775e;

    public t0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3775e = p0Var;
        this.f3771a = bVar;
        this.f3772b = vlionAdapterADConfig;
        this.f3773c = str;
        this.f3774d = baseAdAdapter;
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadFailure(int i10, String str) {
        try {
            if (this.f3771a == null || this.f3772b == null) {
                return;
            }
            LogVlion.e(this.f3775e.f3592c + " " + this.f3773c + " code=" + i10 + " desc=" + str + "   onAdBiddingFailure  isNotFinished=" + this.f3775e.f3721k);
            VlionADEventManager.submitFillFail(this.f3772b, String.valueOf(i10));
            this.f3771a.a(2);
            this.f3771a.b(i10);
            this.f3771a.b(str);
            if (p0.a(this.f3775e, this.f3771a, i10, str)) {
                p0.d(this.f3775e);
                p0.g(this.f3775e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(double d10) {
        try {
            if (this.f3771a == null || this.f3772b == null) {
                return;
            }
            LogVlion.e(this.f3775e.f3592c + " " + this.f3773c + "   onAdBiddingSuccess Platform:=" + this.f3771a.h() + "isNotFinished=" + this.f3775e.f3721k + " price=" + (this.f3771a.j() * d10));
            this.f3771a.a(1);
            this.f3771a.a(d10);
            this.f3775e.a(this.f3771a, this.f3774d);
            VlionADEventManager.submitFillSuccess(this.f3772b, this.f3771a.q());
            if (p0.b(this.f3775e)) {
                p0.d(this.f3775e);
                p0.g(this.f3775e);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener
    public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
    }
}
