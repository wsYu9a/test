package cn.vlion.ad.inland.ku;

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
public class VlionKuAdapter extends BaseAdAdapter {

    /* renamed from: a */
    public i f3969a;

    /* renamed from: b */
    public d f3970b;

    /* renamed from: c */
    public f f3971c;

    /* renamed from: d */
    public c f3972d;

    /* renamed from: e */
    public e f3973e;

    /* renamed from: f */
    public b f3974f;

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void destroy() {
        try {
            i iVar = this.f3969a;
            if (iVar != null) {
                iVar.destroy();
                this.f3969a = null;
            }
            d dVar = this.f3970b;
            if (dVar != null) {
                dVar.destroy();
                this.f3970b = null;
            }
            f fVar = this.f3971c;
            if (fVar != null) {
                fVar.destroy();
                this.f3971c = null;
            }
            c cVar = this.f3972d;
            if (cVar != null) {
                cVar.destroy();
                this.f3972d = null;
            }
            e eVar = this.f3973e;
            if (eVar != null) {
                eVar.destroy();
                this.f3973e = null;
            }
            b bVar = this.f3974f;
            if (bVar != null) {
                bVar.destroy();
                this.f3974f = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final String getNetworkName() {
        return "KU";
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void initialize(Application application, VlionAdapterInitConfig vlionAdapterInitConfig, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            g.a().a(application, vlionAdapterInitConfig, vlionMediaInitCallback);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadBannerAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadDrawAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            b bVar = new b(context, vlionAdapterADConfig, this.vlionBiddingListener, this.vlionNativesAdVideoListener);
            this.f3974f = bVar;
            bVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadFeedAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            c cVar = new c(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3972d = cVar;
            cVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadInterstitialAD(Activity activity, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            d dVar = new d(activity, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3970b = dVar;
            dVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadNativeAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            e eVar = new e(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3973e = eVar;
            eVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadRewardVideoAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            f fVar = new f(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3971c = fVar;
            fVar.loadRewardVideoAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void loadSplashAD(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        try {
            i iVar = new i(context, vlionAdapterADConfig, this.vlionBiddingListener);
            this.f3969a = iVar;
            iVar.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            c cVar = this.f3972d;
            if (cVar != null) {
                cVar.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            d dVar = this.f3970b;
            if (dVar != null) {
                dVar.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            f fVar = this.f3971c;
            if (fVar != null) {
                fVar.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            i iVar = this.f3969a;
            if (iVar != null) {
                iVar.notifyFailPrice(vlionLossBiddingReason);
                return;
            }
            b bVar = this.f3974f;
            if (bVar != null) {
                bVar.notifyFailPrice(vlionLossBiddingReason);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void notifyWinPrice(boolean z10) {
        try {
            c cVar = this.f3972d;
            if (cVar != null) {
                cVar.renderAD();
                return;
            }
            d dVar = this.f3970b;
            if (dVar != null) {
                dVar.renderAD();
                return;
            }
            f fVar = this.f3971c;
            if (fVar != null) {
                fVar.renderRewardVideoAD();
                return;
            }
            i iVar = this.f3969a;
            if (iVar != null) {
                iVar.renderAD();
                return;
            }
            b bVar = this.f3974f;
            if (bVar != null) {
                bVar.renderAD();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionListener(VlionBiddingActionListener vlionBiddingActionListener) {
        super.setVlionBiddingActionListener(vlionBiddingActionListener);
        try {
            i iVar = this.f3969a;
            if (iVar != null) {
                iVar.setVlionBiddingActionListener(vlionBiddingActionListener);
                return;
            }
            c cVar = this.f3972d;
            if (cVar != null) {
                cVar.setVlionBiddingActionListener(vlionBiddingActionListener);
                return;
            }
            d dVar = this.f3970b;
            if (dVar != null) {
                dVar.setVlionBiddingActionListener(vlionBiddingActionListener);
                return;
            }
            b bVar = this.f3974f;
            if (bVar != null) {
                bVar.setVlionBiddingActionListener(vlionBiddingActionListener);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionBiddingActionRewardListener(VlionBiddingActionRewardListener vlionBiddingActionRewardListener) {
        super.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
        f fVar = this.f3971c;
        if (fVar != null) {
            fVar.setVlionBiddingActionRewardListener(vlionBiddingActionRewardListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void setVlionNativeActionListener(VlionNativeActionListener vlionNativeActionListener) {
        super.setVlionNativeActionListener(vlionNativeActionListener);
        e eVar = this.f3973e;
        if (eVar != null) {
            eVar.setVlionNativeActionListener(vlionNativeActionListener);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showInterstitialAD(Activity activity) {
        try {
            d dVar = this.f3970b;
            if (dVar == null || activity == null) {
                return;
            }
            dVar.showAd(activity);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showRewardVideoAD(Activity activity) {
        try {
            f fVar = this.f3971c;
            if (fVar != null) {
                fVar.showRewardVideoAd(activity);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.BaseAdAdapter
    public final void showSplashAD(ViewGroup viewGroup) {
        try {
            i iVar = this.f3969a;
            if (iVar != null) {
                iVar.showAd(viewGroup);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
