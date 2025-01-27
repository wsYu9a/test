package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity;
import com.shu.priory.IFLYNativeAd;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.listener.IFLYBaseAdListener;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class k extends VlionBaseAdAdapterInterstitial {

    /* renamed from: a */
    public IFLYNativeAd f3913a;

    /* renamed from: b */
    public NativeDataRef f3914b;

    /* renamed from: c */
    public ImageView f3915c;

    /* renamed from: d */
    public boolean f3916d;

    public class a implements IFLYBaseAdListener<NativeDataRef> {
        public a() {
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdFailed(AdError adError) {
            int errorCode;
            String errorDescription;
            if (adError != null) {
                try {
                    errorCode = adError.getErrorCode();
                    errorDescription = adError.getErrorDescription();
                    LogVlion.e("VlionKdInterstitial onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            LogVlion.e("VlionKdInterstitial:onAdFailed=" + errorCode + " message=" + errorDescription);
            VlionBiddingLoadListener vlionBiddingLoadListener = k.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(NativeDataRef nativeDataRef) {
            NativeDataRef nativeDataRef2 = nativeDataRef;
            try {
                k.this.f3914b = nativeDataRef2;
                k kVar = k.this;
                kVar.price = kVar.getPrice();
                LogVlion.e("VlionKdInterstitial:onAdLoaded=" + k.this.price + " videoDataRef.getPrice()=" + nativeDataRef2.getPrice());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionKdInterstitial:onAdLoaded=");
                sb2.append(VlionKDAdapter.a(nativeDataRef2));
                LogVlion.e(sb2.toString());
                VlionBiddingLoadListener vlionBiddingLoadListener = k.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(r5.price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onCancel() {
            LogVlion.e("VlionKdInterstitial onCancel");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
            LogVlion.e("VlionKdInterstitial onConfirm");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
            LogVlion.e("VlionKdInterstitial onDownloading");
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdInterstitial onShowDownloadDialog");
                WeakReference<VlionKdRewardVideoActivity> weakReference = VlionKdRewardVideoActivity.f3853t;
                if (weakReference == null || weakReference.get() == null) {
                    return true;
                }
                new j(VlionKdRewardVideoActivity.f3853t.get(), downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }
    }

    public class b implements VlionKdRewardVideoActivity.f {
        public b() {
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onAdClose() {
            try {
                LogVlion.e("VlionKdInterstitial onAdClose ");
                VlionBiddingActionListener vlionBiddingActionListener = k.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onClick() {
            try {
                LogVlion.e("VlionKdInterstitial onClick ");
                VlionBiddingActionListener vlionBiddingActionListener = k.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.kd.VlionKdRewardVideoActivity.f
        public final void onExposure() {
            try {
                LogVlion.e("VlionKdInterstitial onExposure ");
                VlionBiddingActionListener vlionBiddingActionListener = k.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public k(Context context, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            this.f3916d = z10;
            LogVlion.e("VlionKdInterstitial :" + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void destroy() {
        try {
            if (this.f3914b != null) {
                this.f3914b = null;
            }
            if (this.f3913a != null) {
                this.f3913a = null;
            }
            WeakReference<VlionKdRewardVideoActivity> weakReference = VlionKdRewardVideoActivity.f3853t;
            if (weakReference != null) {
                weakReference.clear();
                VlionKdRewardVideoActivity.f3853t = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final int getPrice() {
        int i10 = -1;
        try {
            if (this.f3914b == null) {
                return -1;
            }
            LogVlion.e("VlionKdInterstitial interstitialAd.getPrice() " + this.f3914b.getPrice());
            i10 = (int) (this.f3914b.getPrice() * 100.0d);
            LogVlion.e("VlionKdInterstitial getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        IFLYNativeAd iFLYNativeAd;
        String str;
        super.loadAd();
        try {
            LogVlion.e("VlionKdInterstitial:slotID=" + this.slotID);
            IFLYNativeAd iFLYNativeAd2 = new IFLYNativeAd(this.context, this.slotID, new a());
            this.f3913a = iFLYNativeAd2;
            Boolean bool = Boolean.TRUE;
            iFLYNativeAd2.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3913a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3913a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            if (this.vlionAdapterADConfig != null) {
                LogVlion.e("VlionKdInterstitial vlionAdapterADConfig.getSecondPop()=" + this.vlionAdapterADConfig.getSecondPop());
                if (this.vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3913a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3913a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdInterstitial isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3913a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYNativeAd = this.f3913a;
                str = "1";
            } else {
                iFLYNativeAd = this.f3913a;
                str = "0";
            }
            iFLYNativeAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3913a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            NativeDataRef nativeDataRef = this.f3914b;
            if (nativeDataRef != null) {
                nativeDataRef.onBiddingFailure(101, "价格低");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000b, B:9:0x0025, B:10:0x0053, B:11:0x0056, B:13:0x005a, B:14:0x005d, B:16:0x0061, B:20:0x0030, B:22:0x0038, B:24:0x0044, B:25:0x0066, B:27:0x006a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000b, B:9:0x0025, B:10:0x0053, B:11:0x0056, B:13:0x005a, B:14:0x005d, B:16:0x0061, B:20:0x0030, B:22:0x0038, B:24:0x0044, B:25:0x0066, B:27:0x006a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderAD() {
        /*
            r3 = this;
            super.renderAD()
            com.shu.priory.IFLYNativeAd r0 = r3.f3913a     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L66
            com.shu.priory.conn.NativeDataRef r0 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L66
            android.widget.ImageView r0 = new android.widget.ImageView     // Catch: java.lang.Throwable -> L2e
            android.content.Context r1 = r3.context     // Catch: java.lang.Throwable -> L2e
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L2e
            r3.f3915c = r0     // Catch: java.lang.Throwable -> L2e
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch: java.lang.Throwable -> L2e
            r2 = -1
            r1.<init>(r2, r2)     // Catch: java.lang.Throwable -> L2e
            r0.setLayoutParams(r1)     // Catch: java.lang.Throwable -> L2e
            com.shu.priory.conn.NativeDataRef r0 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            java.lang.String r0 = r0.getImgUrl()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L30
            android.widget.ImageView r0 = r3.f3915c     // Catch: java.lang.Throwable -> L2e
            com.shu.priory.conn.NativeDataRef r1 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = r1.getImgUrl()     // Catch: java.lang.Throwable -> L2e
            goto L53
        L2e:
            goto L78
        L30:
            com.shu.priory.conn.NativeDataRef r0 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            java.util.List r0 = r0.getImgList()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L56
            com.shu.priory.conn.NativeDataRef r0 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            java.util.List r0 = r0.getImgList()     // Catch: java.lang.Throwable -> L2e
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L2e
            if (r0 <= 0) goto L56
            android.widget.ImageView r0 = r3.f3915c     // Catch: java.lang.Throwable -> L2e
            com.shu.priory.conn.NativeDataRef r1 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            java.util.List r1 = r1.getImgList()     // Catch: java.lang.Throwable -> L2e
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L2e
        L53:
            cn.vlion.ad.inland.kd.VlionKDAdapter.a(r0, r1)     // Catch: java.lang.Throwable -> L2e
        L56:
            com.shu.priory.conn.NativeDataRef r0 = r3.f3914b     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L5d
            r0.onBiddingSuccess()     // Catch: java.lang.Throwable -> L2e
        L5d:
            cn.vlion.ad.inland.base.bid.VlionBiddingActionListener r0 = r3.vlionBiddingActionListener     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L89
            r1 = 0
            r0.onAdRenderSuccess(r1)     // Catch: java.lang.Throwable -> L2e
            goto L89
        L66:
            cn.vlion.ad.inland.base.bid.VlionBiddingActionListener r0 = r3.vlionBiddingActionListener     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L89
            cn.vlion.ad.inland.base.util.config.VlionAdBaseError r1 = cn.vlion.ad.inland.base.util.config.VlionAdBaseError.OTHER_AD_RENDER_ERROR     // Catch: java.lang.Throwable -> L2e
            int r2 = r1.getErrorCode()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = r1.getErrorMessage()     // Catch: java.lang.Throwable -> L2e
            r0.onAdRenderFailure(r2, r1)     // Catch: java.lang.Throwable -> L2e
            goto L89
        L78:
            cn.vlion.ad.inland.base.bid.VlionBiddingActionListener r0 = r3.vlionBiddingActionListener
            if (r0 == 0) goto L89
            cn.vlion.ad.inland.base.util.config.VlionAdBaseError r1 = cn.vlion.ad.inland.base.util.config.VlionAdBaseError.Exception_CODE_ERROR
            int r2 = r1.getErrorCode()
            java.lang.String r1 = r1.getErrorMessage()
            r0.onAdRenderFailure(r2, r1)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.kd.k.renderAD():void");
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void showAd(Activity activity) {
        try {
            LogVlion.e("VlionKdInterstitial showRewardVideoAd");
            if (this.f3913a == null || this.f3914b == null || this.f3915c == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionKdInterstitial showRewardVideoAd view");
                VlionKdRewardVideoActivity.a(activity, this.f3915c, this.f3914b, this.f3916d, this.vlionAdapterADConfig, new b());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
