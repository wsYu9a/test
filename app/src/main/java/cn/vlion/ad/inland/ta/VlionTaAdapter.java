package cn.vlion.ad.inland.ta;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionTaAdapter extends BaseAdAdapter {

    /* renamed from: a */
    public a f4016a;

    /* renamed from: b */
    public f f4017b;

    /* renamed from: c */
    public g f4018c;

    /* renamed from: d */
    public k f4019d;

    /* renamed from: e */
    public n f4020e;

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void destroy() {
        try {
            n nVar = this.f4020e;
            if (nVar != null) {
                nVar.destroy();
                this.f4020e = null;
            }
            k kVar = this.f4019d;
            if (kVar != null) {
                kVar.destroy();
                this.f4019d = null;
            }
            g gVar = this.f4018c;
            if (gVar != null) {
                gVar.destroy();
                this.f4018c = null;
            }
            f fVar = this.f4017b;
            if (fVar != null) {
                fVar.destroy();
                this.f4017b = null;
            }
            a aVar = this.f4016a;
            if (aVar != null) {
                aVar.destroy();
                this.f4016a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final String getNetworkName() {
        return "TA";
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void initialize(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            l.a().a(application, vlionAdapterInitConfig, vlionMediaInitCallback);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadBannerAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadDrawAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadFeedAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            a aVar = new a(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f4016a = aVar;
            aVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadInterstitialAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            f fVar = new f(activity, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f4017b = fVar;
            fVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadNativeAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            g gVar = new g(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f4018c = gVar;
            gVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadRewardVideoAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            k kVar = new k(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f4019d = kVar;
            kVar.loadRewardVideoAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadSplashAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            n nVar = new n(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f4020e = nVar;
            nVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        n nVar;
        try {
            if (this.f4016a == null && this.f4017b == null && this.f4019d == null && (nVar = this.f4020e) != null) {
                nVar.notifyFailPrice(vlionLossBiddingReason);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyWinPrice(boolean z10) {
        try {
            a aVar = this.f4016a;
            if (aVar != null) {
                aVar.renderAD();
                return;
            }
            f fVar = this.f4017b;
            if (fVar != null) {
                fVar.renderAD();
                return;
            }
            k kVar = this.f4019d;
            if (kVar != null) {
                kVar.renderRewardVideoAD();
                return;
            }
            n nVar = this.f4020e;
            if (nVar != null) {
                nVar.renderAD();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        super.setVlionBiddingActionListener(vlionBiddingActionListener);
        n nVar = this.f4020e;
        if (nVar != null) {
            nVar.setVlionBiddingActionListener(vlionBiddingActionListener);
            return;
        }
        a aVar = this.f4016a;
        if (aVar != null) {
            aVar.setVlionBiddingActionListener(vlionBiddingActionListener);
            return;
        }
        f fVar = this.f4017b;
        if (fVar != null) {
            fVar.setVlionBiddingActionListener(vlionBiddingActionListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        super.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
        k kVar = this.f4019d;
        if (kVar != null) {
            kVar.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        super.setVlionNativeActionListener(vlionNativeActionListener);
        g gVar = this.f4018c;
        if (gVar != null) {
            gVar.setVlionNativeActionListener(vlionNativeActionListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showInterstitialAD(Activity activity) {
        try {
            f fVar = this.f4017b;
            if (fVar != null) {
                fVar.showAd(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showRewardVideoAD(Activity activity) {
        try {
            k kVar = this.f4019d;
            if (kVar != null) {
                kVar.showRewardVideoAd(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showSplashAD(ViewGroup viewGroup) {
        n nVar = this.f4020e;
        if (nVar != null) {
            nVar.showAd(viewGroup);
        }
    }
}
