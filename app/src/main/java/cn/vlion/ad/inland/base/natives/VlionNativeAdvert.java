package cn.vlion.ad.inland.base.natives;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.u;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class VlionNativeAdvert {
    private Context context;
    private VlionNativeAdData vlionNativeAdData;
    private VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener;
    private WeakReference<Activity> weakReferenceNadActivity;

    public VlionNativeAdvert(Context context, VlionNativeAdData vlionNativeAdData, VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener) {
        this.context = context;
        this.vlionNativeAdData = vlionNativeAdData;
        this.vlionNativeAdImpMaterialListener = vlionNativeAdImpMaterialListener;
    }

    public void destroy() {
        try {
            if (this.vlionNativeAdData != null) {
                this.vlionNativeAdData = null;
            }
            u.b().a();
            VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener = this.vlionNativeAdImpMaterialListener;
            if (vlionNativeAdImpMaterialListener != null) {
                vlionNativeAdImpMaterialListener.destroy();
                this.vlionNativeAdImpMaterialListener = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public View getNativeMediaAdView() {
        try {
            VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener = this.vlionNativeAdImpMaterialListener;
            if (vlionNativeAdImpMaterialListener != null) {
                return vlionNativeAdImpMaterialListener.getMediaView();
            }
            return null;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return null;
        }
    }

    public VlionNativeAdData getVlionNativeAdData() {
        return this.vlionNativeAdData;
    }

    public void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener = this.vlionNativeAdImpMaterialListener;
            if (vlionNativeAdImpMaterialListener != null) {
                vlionNativeAdImpMaterialListener.notifyWinPrice(d10, vlionBidderSource);
                this.vlionNativeAdImpMaterialListener.onAdRender(this.context, this.vlionNativeAdData);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            if (this.vlionNativeAdImpMaterialListener != null) {
                VlionLossBiddingReason vlionLossBiddingReason = new VlionLossBiddingReason();
                vlionLossBiddingReason.setVlionLossReason(vlionLossReason);
                vlionLossBiddingReason.setBiddingPrice((int) d10);
                vlionLossBiddingReason.setBrandName(vlionBidderSource);
                this.vlionNativeAdImpMaterialListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
        try {
            LogVlion.e("VlionNativeAdvert registerNativeView=");
            if (activity == null || this.vlionNativeAdImpMaterialListener == null) {
                LogVlion.e("VlionNativeAdvert activity=null  || null == vlionNativeAdImpMaterialListener ");
            } else {
                WeakReference<Activity> weakReference = new WeakReference<>(activity);
                this.weakReferenceNadActivity = weakReference;
                this.vlionNativeAdImpMaterialListener.registerNativeView(weakReference.get(), viewGroup, list, list2, list3, vlionNativeADEventListener);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        try {
            VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener = this.vlionNativeAdImpMaterialListener;
            if (vlionNativeAdImpMaterialListener != null) {
                vlionNativeAdImpMaterialListener.setAdVideoListener(vlionNativesAdVideoListener);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setClosedVolumePlay(boolean z10) {
        try {
            VlionNativeAdImpMaterialListener vlionNativeAdImpMaterialListener = this.vlionNativeAdImpMaterialListener;
            if (vlionNativeAdImpMaterialListener != null) {
                vlionNativeAdImpMaterialListener.setClosedVolumePlay(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
