package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener;
import cn.vlion.ad.inland.ad.natives.VlionNativeViewEventManager;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.active.VlionShakeGuideLayout;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativeADEventListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.kd.n;
import com.shu.priory.IFLYNativeAd;
import com.shu.priory.bean.AdImage;
import com.shu.priory.conn.NativeDataRef;
import java.util.List;

/* loaded from: classes.dex */
public final class m extends VlionNativeAdImpMaterialListener {

    /* renamed from: a */
    public VlionNativeViewEventManager f3924a;

    /* renamed from: b */
    public VlionShakeGuideLayout f3925b;

    /* renamed from: c */
    public VlionNativeADEventListener f3926c;

    /* renamed from: d */
    public final /* synthetic */ NativeDataRef f3927d;

    /* renamed from: e */
    public final /* synthetic */ n.a f3928e;

    public class a implements SensorManagerManager.OnShakeListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3929a;

        public a(ViewGroup viewGroup) {
            this.f3929a = viewGroup;
        }

        @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
        public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
            boolean z11;
            VlionSensorBean vlionSensorBean;
            NativeDataRef nativeDataRef;
            NativeDataRef nativeDataRef2;
            try {
                LogVlion.e("VlionKdNative onShake =");
                z11 = n.this.f3940e;
                if (z11) {
                    return;
                }
                n.this.f3940e = true;
                VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                vlionSensorBean = n.this.f3939d;
                vlionSensorManagerHelper.unregisterShakeListener(vlionSensorBean);
                n.this.f3938c = false;
                n.this.f3939d = null;
                if (m.this.f3925b != null) {
                    m.this.f3925b.setVisibility(8);
                    m.this.f3925b.destroy();
                    m.this.f3925b = null;
                }
                nativeDataRef = n.this.f3937b;
                if (nativeDataRef != null) {
                    nativeDataRef2 = n.this.f3937b;
                    LogVlion.e("VlionKdNative onShake isClick=" + nativeDataRef2.onClick(this.f3929a, 2));
                }
                VlionNativeActionListener vlionNativeActionListener = n.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClick();
                }
                VlionNativeADEventListener vlionNativeADEventListener = m.this.f3926c;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3931a;

        public b(ViewGroup viewGroup) {
            this.f3931a = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f3931a == null || m.this.f3925b == null) {
                    return;
                }
                this.f3931a.removeView(m.this.f3925b);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                if (m.this.f3925b.getParent() != null && (m.this.f3925b.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.f3925b.getParent()).removeView(m.this.f3925b);
                }
                this.f3931a.addView(m.this.f3925b, layoutParams);
                m.this.f3925b.startAnimator(true);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements VlionCustomsNativeEventListener {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3933a;

        /* renamed from: b */
        public final /* synthetic */ VlionNativeADEventListener f3934b;

        public c(ViewGroup viewGroup, VlionNativeADEventListener vlionNativeADEventListener) {
            this.f3933a = viewGroup;
            this.f3934b = vlionNativeADEventListener;
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void isResume(boolean z10) {
            boolean z11;
            VlionSensorBean vlionSensorBean;
            boolean z12;
            VlionSensorBean vlionSensorBean2;
            try {
                z11 = n.this.f3938c;
                if (z11) {
                    if (z10) {
                        z12 = n.this.f3940e;
                        if (!z12) {
                            VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                            n nVar = n.this;
                            Context context = nVar.context;
                            vlionSensorBean2 = nVar.f3939d;
                            vlionSensorManagerHelper.registerShakeListener(context, vlionSensorBean2);
                        }
                    } else {
                        VlionSensorManagerHelper vlionSensorManagerHelper2 = VlionSensorManagerHelper.getInstance();
                        vlionSensorBean = n.this.f3939d;
                        vlionSensorManagerHelper2.unregisterShakeListener(vlionSensorBean);
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
            NativeDataRef nativeDataRef;
            NativeDataRef nativeDataRef2;
            try {
                LogVlion.e("VlionKdNative onClick");
                nativeDataRef = n.this.f3937b;
                if (nativeDataRef != null) {
                    nativeDataRef2 = n.this.f3937b;
                    LogVlion.e("VlionKdNative onClick isClick=" + nativeDataRef2.onClick(this.f3933a, 2));
                }
                VlionNativeActionListener vlionNativeActionListener = n.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClick();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f3934b;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClose() {
            try {
                LogVlion.e("VlionKdNative onClose");
                VlionNativeActionListener vlionNativeActionListener = n.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClose();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f3934b;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClose();
                }
                m.this.destroy();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onExposure() {
            NativeDataRef nativeDataRef;
            NativeDataRef nativeDataRef2;
            boolean z10;
            VlionSensorBean vlionSensorBean;
            NativeDataRef nativeDataRef3;
            try {
                LogVlion.e("VlionKdNative onAdExposure ");
                nativeDataRef = n.this.f3937b;
                if (nativeDataRef != null) {
                    nativeDataRef2 = n.this.f3937b;
                    if (!nativeDataRef2.isExposured()) {
                        nativeDataRef3 = n.this.f3937b;
                        LogVlion.e("VlionKdNative onAdExposure isExposure=" + nativeDataRef3.onExposure(this.f3933a));
                        VlionNativeADEventListener vlionNativeADEventListener = this.f3934b;
                        if (vlionNativeADEventListener != null) {
                            vlionNativeADEventListener.onExposure();
                        }
                    }
                    z10 = n.this.f3940e;
                    if (!z10) {
                        VlionSensorManagerHelper vlionSensorManagerHelper = VlionSensorManagerHelper.getInstance();
                        n nVar = n.this;
                        Context context = nVar.context;
                        vlionSensorBean = nVar.f3939d;
                        vlionSensorManagerHelper.registerShakeListener(context, vlionSensorBean);
                    }
                }
                VlionNativeActionListener vlionNativeActionListener = n.this.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public m(n.a aVar, NativeDataRef nativeDataRef) {
        this.f3928e = aVar;
        this.f3927d = nativeDataRef;
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void destroy() {
        NativeDataRef nativeDataRef;
        IFLYNativeAd iFLYNativeAd;
        try {
            nativeDataRef = n.this.f3937b;
            if (nativeDataRef != null) {
                n.this.f3937b = null;
            }
            iFLYNativeAd = n.this.f3936a;
            if (iFLYNativeAd != null) {
                n.this.f3936a = null;
            }
            VlionNativeViewEventManager vlionNativeViewEventManager = this.f3924a;
            if (vlionNativeViewEventManager != null) {
                vlionNativeViewEventManager.destroy();
                this.f3924a = null;
            }
            VlionShakeGuideLayout vlionShakeGuideLayout = this.f3925b;
            if (vlionShakeGuideLayout != null) {
                vlionShakeGuideLayout.destroy();
                this.f3925b = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        try {
            LogVlion.e("VlionKdNative notifyWinPrice");
            NativeDataRef nativeDataRef = this.f3927d;
            if (nativeDataRef != null) {
                nativeDataRef.onBiddingSuccess();
            }
            VlionNativeActionListener vlionNativeActionListener = n.this.vlionNativeActionListener;
            if (vlionNativeActionListener != null) {
                vlionNativeActionListener.notifyWinPrice(d10, vlionBidderSource);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason) {
        try {
            LogVlion.e("VlionKdNative notifyWinPrice");
            NativeDataRef nativeDataRef = this.f3927d;
            if (nativeDataRef != null) {
                nativeDataRef.onBiddingFailure(101, "价格低");
            }
            VlionNativeActionListener vlionNativeActionListener = n.this.vlionNativeActionListener;
            if (vlionNativeActionListener != null) {
                vlionNativeActionListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
        NativeDataRef nativeDataRef;
        boolean z10;
        VlionSensorBean vlionSensorBean;
        n nVar;
        VlionAdapterADConfig vlionAdapterADConfig;
        try {
            nativeDataRef = n.this.f3937b;
            if (nativeDataRef != null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(n.this.context).inflate(R.layout.vlion_cn_kd_ad_native_layout, (ViewGroup) null, true);
                LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.native_3img_ad_container);
                ImageView imageView = (ImageView) viewGroup.findViewById(R.id.img_poster);
                imageView.setScaleType(vlionNativeAdData.getImageScale());
                if (vlionNativeAdData.getVlionNativeType() == 1) {
                    LogVlion.e("VlionKdNative fill  SINGLE_BIG_IMG ");
                    imageView.setVisibility(0);
                    linearLayout.setVisibility(8);
                    NativeDataRef nativeDataRef2 = this.f3927d;
                    if (nativeDataRef2 != null && nativeDataRef2.getAdImg() != null) {
                        VlionKDAdapter.a(imageView, this.f3927d.getAdImg().getUrl());
                    }
                } else if (vlionNativeAdData.getVlionNativeType() == 3) {
                    LogVlion.e("VlionKdNative fill  GROUP_IMG ");
                    ImageView imageView2 = (ImageView) viewGroup.findViewById(R.id.img_1);
                    ImageView imageView3 = (ImageView) viewGroup.findViewById(R.id.img_2);
                    ImageView imageView4 = (ImageView) viewGroup.findViewById(R.id.img_3);
                    imageView2.setScaleType(vlionNativeAdData.getImageScale());
                    imageView3.setScaleType(vlionNativeAdData.getImageScale());
                    imageView4.setScaleType(vlionNativeAdData.getImageScale());
                    NativeDataRef nativeDataRef3 = this.f3927d;
                    if (nativeDataRef3 != null && nativeDataRef3.getAdImgList() != null && this.f3927d.getAdImgList().size() >= 3) {
                        List<AdImage> adImgList = this.f3927d.getAdImgList();
                        if (adImgList.get(0) != null) {
                            VlionKDAdapter.a(imageView2, adImgList.get(0).getUrl());
                        }
                        if (adImgList.get(1) != null) {
                            VlionKDAdapter.a(imageView3, adImgList.get(1).getUrl());
                        }
                        if (adImgList.get(2) != null) {
                            VlionKDAdapter.a(imageView4, adImgList.get(2).getUrl());
                        }
                    }
                    imageView.setVisibility(8);
                    linearLayout.setVisibility(0);
                }
                z10 = n.this.f3938c;
                if (z10) {
                    vlionSensorBean = n.this.f3939d;
                    if (vlionSensorBean == null && (vlionAdapterADConfig = (nVar = n.this).vlionAdapterADConfig) != null) {
                        nVar.f3939d = new VlionSensorBean(vlionAdapterADConfig.getAccelerate(), n.this.vlionAdapterADConfig.getAngle(), n.this.vlionAdapterADConfig.getShakeDuration(), new a(viewGroup));
                    }
                    if (this.f3925b == null) {
                        this.f3925b = new VlionShakeGuideLayout(n.this.context);
                    }
                    viewGroup.post(new b(viewGroup));
                }
                setAdMediaView(viewGroup);
                n.this.vlionNativeActionListener.onAdRenderSuccess();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void registerNativeView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, VlionNativeADEventListener vlionNativeADEventListener) {
        NativeDataRef nativeDataRef;
        try {
            super.registerNativeView(activity, viewGroup, list, list2, list3, vlionNativeADEventListener);
            this.f3926c = vlionNativeADEventListener;
            nativeDataRef = n.this.f3937b;
            if (nativeDataRef != null) {
                this.f3924a = new VlionNativeViewEventManager(activity, viewGroup, list, list3, "", null, new c(viewGroup, vlionNativeADEventListener));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
