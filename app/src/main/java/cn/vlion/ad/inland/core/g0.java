package cn.vlion.ad.inland.core;

import android.content.Context;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeAdvert;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.natives.VlionNativeADListener;

/* loaded from: classes.dex */
public final class g0 extends d0 {

    /* renamed from: h */
    public VlionNativeADListener f3588h;

    public class a implements VlionNativeADListener {
        public a() {
        }

        @Override // cn.vlion.ad.inland.core.natives.VlionNativeADListener
        public final void onAdLoadFailure(VlionAdError vlionAdError) {
            StringBuilder a10 = f.a("VlionNativeManager onAdFailure  isFinished=");
            a10.append(g0.this.f3576d);
            LogVlion.e(a10.toString());
            g0.this.b();
            if (g0.this.f3588h != null) {
                g0.this.f3588h.onAdLoadFailure(vlionAdError);
            }
        }

        @Override // cn.vlion.ad.inland.core.natives.VlionNativeADListener
        public final void onAdLoadSuccess(VlionNativeAdvert vlionNativeAdvert) {
            if (vlionNativeAdvert != null && vlionNativeAdvert.getVlionNativeAdData() != null) {
                StringBuilder a10 = f.a("VlionNativeManager onAdBiddingSuccess price=");
                a10.append(vlionNativeAdvert.getVlionNativeAdData().getPrice());
                a10.append(" isFinished=");
                a10.append(g0.this.f3576d);
                LogVlion.e(a10.toString());
            }
            g0.this.b();
            if (g0.this.f3588h != null) {
                g0.this.f3588h.onAdLoadSuccess(vlionNativeAdvert);
            }
        }
    }

    public g0(Context context) {
        super(context);
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean) {
        try {
            u uVar = new u(this.f3575c, this.f3574b, placementBean);
            this.f3573a = uVar;
            uVar.a(new a());
            this.f3573a.j();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.core.d0
    public final void a(VlionAdError vlionAdError) {
        VlionNativeADListener vlionNativeADListener = this.f3588h;
        if (vlionNativeADListener != null) {
            vlionNativeADListener.onAdLoadFailure(vlionAdError);
        }
    }

    public final void a(j0 j0Var, VlionNativeADListener vlionNativeADListener) {
        try {
            this.f3574b = j0Var;
            this.f3588h = vlionNativeADListener;
            VlionAdError a10 = e.a(this.f3575c, j0Var);
            if (a10 == null) {
                e();
            } else if (vlionNativeADListener != null) {
                vlionNativeADListener.onAdLoadFailure(a10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
