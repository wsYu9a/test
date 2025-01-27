package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener;
import cn.vlion.ad.inland.ad.natives.VlionNativeViewEventManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionPrivateInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.shu.priory.IFLYNativeAd;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.listener.IFLYBaseAdListener;

/* loaded from: classes.dex */
public final class a extends VlionBaseAdAdapterBanner {

    /* renamed from: a */
    public IFLYNativeAd f3870a;

    /* renamed from: b */
    public NativeDataRef f3871b;

    /* renamed from: c */
    public Activity f3872c;

    /* renamed from: d */
    public VlionNativeViewEventManager f3873d;

    /* renamed from: e */
    public boolean f3874e;

    /* renamed from: f */
    public VlionSensorBean f3875f;

    /* renamed from: g */
    public boolean f3876g;

    /* renamed from: cn.vlion.ad.inland.kd.a$a */
    public class C0035a implements IFLYBaseAdListener<NativeDataRef> {
        public C0035a() {
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdFailed(AdError adError) {
            int errorCode;
            String errorDescription;
            if (adError != null) {
                try {
                    errorCode = adError.getErrorCode();
                    errorDescription = adError.getErrorDescription();
                    LogVlion.e("VlionKdBanner onAdFailed:code=" + errorCode + " error=" + errorDescription);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                    return;
                }
            } else {
                errorDescription = "";
                errorCode = -1;
            }
            LogVlion.e("VlionKdBanner:onAdFailed=" + errorCode + " message=" + errorDescription);
            VlionBiddingLoadListener vlionBiddingLoadListener = a.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(errorCode, errorDescription);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public final void onAdLoaded(NativeDataRef nativeDataRef) {
            NativeDataRef nativeDataRef2 = nativeDataRef;
            try {
                a.this.f3871b = nativeDataRef2;
                a aVar = a.this;
                aVar.price = aVar.getPrice();
                LogVlion.e("VlionKdBanner:onAdLoaded=" + a.this.price + " videoDataRef.getPrice()=" + nativeDataRef2.getPrice());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionKdBanner:onAdLoaded=");
                sb2.append(VlionKDAdapter.a(nativeDataRef2));
                LogVlion.e(sb2.toString());
                VlionBiddingLoadListener vlionBiddingLoadListener = a.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(r5.price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onCancel() {
            LogVlion.e("VlionKdBanner onCancel");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onConfirm() {
            LogVlion.e("VlionKdBanner:onConfirm");
        }

        @Override // com.shu.priory.download.DialogListener
        public final void onDownloading() {
            LogVlion.e("VlionKdBanner onDownloading");
        }

        @Override // com.shu.priory.download.DialogListener
        public final boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            try {
                LogVlion.e("VlionKdBanner onShowDownloadDialog");
                new j(a.this.context, downloadDialogInfo, downLoadDialogCallback).show();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3878a;

        public b(ViewGroup viewGroup) {
            this.f3878a = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionKdBanner action click");
                if (a.this.f3871b != null) {
                    LogVlion.e("VlionKdBanner action click isClick=" + a.this.f3871b.onClick(this.f3878a, 2));
                }
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3880a;

        public c(ViewGroup viewGroup) {
            this.f3880a = viewGroup;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionKdBanner adview click");
                if (a.this.f3871b != null) {
                    LogVlion.e("VlionKdBanner adview click isClick=" + a.this.f3871b.onClick(this.f3880a, 2));
                }
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionKdBanner vlion_img_close");
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class e implements VlionCustomsNativeEventListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3883a;

        public e(ViewGroup viewGroup) {
            this.f3883a = viewGroup;
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void isResume(boolean z10) {
            try {
                LogVlion.e("VlionKdBanner isResume=" + z10 + " isShake=" + a.this.f3874e + " isReadyShake=" + a.this.f3876g);
                if (a.this.f3874e) {
                    if (!z10) {
                        VlionSensorManagerHelper.getInstance().unregisterShakeListener(a.this.f3875f);
                    } else if (!a.this.f3876g) {
                        VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                        a aVar = a.this;
                        vlionSensorManagerHelper.registerShakeListener(aVar.context, aVar.f3875f);
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onAdEnter() {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClick(VlionADClickType vlionADClickType) {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClose() {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onExposure() {
            try {
                VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                a aVar = a.this;
                vlionSensorManagerHelper.registerShakeListener(aVar.context, aVar.f3875f);
                LogVlion.e("VlionKdBanner onAdExposure isReadyExposure=");
                if (a.this.f3871b == null || a.this.f3871b.isExposured()) {
                    return;
                }
                if (a.this.f3871b != null) {
                    LogVlion.e("VlionKdBanner onAdExposure isExposure=" + a.this.f3871b.onExposure(this.f3883a));
                }
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
                if (a.this.f3876g) {
                    return;
                }
                VlionSensorManagerHelper vlionSensorManagerHelper2 = VlionSensorManagerHelper.getInstance();
                a aVar2 = a.this;
                vlionSensorManagerHelper2.registerShakeListener(aVar2.context, aVar2.f3875f);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public a(Activity activity, VlionAdapterADConfig vlionAdapterADConfig, boolean z10, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(activity, vlionAdapterADConfig, vlionBiddingLoadListener);
        try {
            this.f3872c = activity;
            this.f3874e = z10;
            if (vlionAdapterADConfig != null && vlionAdapterADConfig.getAccelerate() == 0 && vlionAdapterADConfig.getAngle() == 0 && vlionAdapterADConfig.getShakeDuration() == 0) {
                this.f3874e = false;
            }
            LogVlion.e("VlionKdBanner:" + this.slotID);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner
    public final void destroy() {
        try {
            if (this.f3871b != null) {
                this.f3871b = null;
            }
            if (this.f3870a != null) {
                this.f3870a = null;
            }
            VlionNativeViewEventManager vlionNativeViewEventManager = this.f3873d;
            if (vlionNativeViewEventManager != null) {
                vlionNativeViewEventManager.destroy();
                this.f3873d = null;
            }
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3875f);
            this.f3875f = null;
            this.f3874e = false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner
    public final int getPrice() {
        try {
            if (this.f3871b == null) {
                return 0;
            }
            LogVlion.e("VlionKdBanner nativeDataRef.getPrice() " + this.f3871b.getPrice());
            return (int) (this.f3871b.getPrice() * 100.0d);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return 0;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        IFLYNativeAd iFLYNativeAd;
        String str;
        super.loadAd();
        try {
            LogVlion.e("VlionKdBanner:slotID=" + this.slotID);
            IFLYNativeAd iFLYNativeAd2 = new IFLYNativeAd(this.context, this.slotID, new C0035a());
            this.f3870a = iFLYNativeAd2;
            Boolean bool = Boolean.TRUE;
            iFLYNativeAd2.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
            this.f3870a.setParameter(AdKeys.OAID, VlionPrivateInfo.getOaid());
            this.f3870a.setParameter(AdKeys.DEBUG_MODE, Boolean.valueOf(VlionSDkManager.getInstance().isEnableLog()));
            if (this.vlionAdapterADConfig != null) {
                LogVlion.e("VlionKdBanner vlionAdapterADConfig.getSecondPop()=" + this.vlionAdapterADConfig.getSecondPop());
                if (this.vlionAdapterADConfig.getSecondPop() == 0) {
                    this.f3870a.setParameter(AdKeys.DOWNLOAD_ALERT, bool);
                }
                this.f3870a.setParameter(AdKeys.HTTP_REQUEST_TIMEOUT, Float.valueOf(this.vlionAdapterADConfig.getTolerateTime() * 1000.0f));
            }
            LogVlion.e("VlionKdBanner isBid=" + this.isBid + " bidFloorPrice=" + this.bidFloorPrice);
            if (this.isBid) {
                this.f3870a.setParameter(AdKeys.BID_FLOOR, String.valueOf(this.bidFloorPrice));
                iFLYNativeAd = this.f3870a;
                str = "1";
            } else {
                iFLYNativeAd = this.f3870a;
                str = "0";
            }
            iFLYNativeAd.setParameter(AdKeys.SETTLE_TYPE, str);
            this.f3870a.loadAd();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterBanner
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            NativeDataRef nativeDataRef = this.f3871b;
            if (nativeDataRef != null) {
                nativeDataRef.onBiddingFailure(101, "价格低");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0101 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:7:0x0010, B:9:0x008b, B:10:0x0097, B:12:0x00af, B:13:0x00d7, B:14:0x00da, B:16:0x0101, B:17:0x0104, B:19:0x0108, B:24:0x00b6, B:26:0x00be, B:28:0x00ca), top: B:6:0x0010, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0108 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:7:0x0010, B:9:0x008b, B:10:0x0097, B:12:0x00af, B:13:0x00d7, B:14:0x00da, B:16:0x0101, B:17:0x0104, B:19:0x0108, B:24:0x00b6, B:26:0x00be, B:28:0x00ca), top: B:6:0x0010, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void renderAD() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.kd.a.renderAD():void");
    }

    public final void a(ViewGroup viewGroup, VlionDownloadProgressBar vlionDownloadProgressBar) {
        VlionAdapterADConfig vlionAdapterADConfig;
        try {
            if (!this.f3874e || this.f3876g || (vlionAdapterADConfig = this.vlionAdapterADConfig) == null) {
                return;
            }
            this.f3875f = new VlionSensorBean(vlionAdapterADConfig.getAccelerate(), this.vlionAdapterADConfig.getAngle(), this.vlionAdapterADConfig.getShakeDuration(), new cn.vlion.ad.inland.kd.b(this, vlionDownloadProgressBar, viewGroup));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
