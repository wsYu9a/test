package cn.vlion.ad.inland.jd;

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
public class VlionJDAdapter extends BaseAdAdapter {

    /* renamed from: a */
    public g f3805a;

    /* renamed from: b */
    public a f3806b;

    /* renamed from: c */
    public d f3807c;

    /* renamed from: d */
    public b f3808d;

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void destroy() {
        try {
            g gVar = this.f3805a;
            if (gVar != null) {
                gVar.destroy();
                this.f3805a = null;
            }
            a aVar = this.f3806b;
            if (aVar != null) {
                aVar.destroy();
                this.f3806b = null;
            }
            d dVar = this.f3807c;
            if (dVar != null) {
                dVar.destroy();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final String getNetworkName() {
        return "J";
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void initialize(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            e.a().getClass();
            e.a(application, vlionAdapterInitConfig, vlionMediaInitCallback);
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
            this.f3806b = aVar;
            aVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadInterstitialAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            b bVar = new b(activity, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3808d = bVar;
            bVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadNativeAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            d dVar = new d(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3807c = dVar;
            dVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadRewardVideoAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadSplashAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            g gVar = new g(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3805a = gVar;
            gVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyWinPrice(boolean z10) {
        try {
            a aVar = this.f3806b;
            if (aVar != null) {
                aVar.renderAD();
                return;
            }
            b bVar = this.f3808d;
            if (bVar != null) {
                bVar.renderAD();
                return;
            }
            g gVar = this.f3805a;
            if (gVar != null) {
                gVar.renderAD();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        super.setVlionBiddingActionListener(vlionBiddingActionListener);
        g gVar = this.f3805a;
        if (gVar != null) {
            gVar.setVlionBiddingActionListener(vlionBiddingActionListener);
            return;
        }
        a aVar = this.f3806b;
        if (aVar != null) {
            aVar.setVlionBiddingActionListener(vlionBiddingActionListener);
            return;
        }
        b bVar = this.f3808d;
        if (bVar != null) {
            bVar.setVlionBiddingActionListener(vlionBiddingActionListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        super.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        super.setVlionNativeActionListener(vlionNativeActionListener);
        d dVar = this.f3807c;
        if (dVar != null) {
            dVar.setVlionNativeActionListener(vlionNativeActionListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showInterstitialAD(Activity activity) {
        try {
            b bVar = this.f3808d;
            if (bVar != null) {
                bVar.showAd(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showRewardVideoAD(Activity activity) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showSplashAD(ViewGroup viewGroup) {
        try {
            g gVar = this.f3805a;
            if (gVar != null) {
                gVar.showAd(viewGroup);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
