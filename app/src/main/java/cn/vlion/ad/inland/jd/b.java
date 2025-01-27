package cn.vlion.ad.inland.jd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b extends VlionBaseAdAdapterInterstitial {

    /* renamed from: a */
    public JADNative f3817a;

    /* renamed from: b */
    public boolean f3818b;

    /* renamed from: c */
    public JADMaterialData f3819c;

    /* renamed from: d */
    public boolean f3820d;

    /* renamed from: e */
    public ViewGroup f3821e;

    /* renamed from: f */
    public VlionAdapterADConfig f3822f;

    public class a implements JADNativeLoadListener {
        public a() {
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public final void onLoadFailure(int i10, String str) {
            VlionBiddingLoadListener vlionBiddingLoadListener = b.this.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                vlionBiddingLoadListener.onAdLoadFailure(i10, str);
            }
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public final void onLoadSuccess() {
            try {
                if (b.this.f3818b || b.this.f3817a == null) {
                    return;
                }
                VlionBiddingLoadListener vlionBiddingLoadListener = b.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(r0.getPrice());
                }
                b.c(b.this);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    /* renamed from: cn.vlion.ad.inland.jd.b$b */
    public class C0032b implements JADNativeInteractionListener {
        public C0032b() {
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionJdInterstitial onADClicked");
                VlionBiddingActionListener vlionBiddingActionListener = b.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
        public final void onClose(View view) {
            try {
                LogVlion.e("VlionJdInterstitial onClose");
                VlionJdinterstitialActivity.a();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
        public final void onExposure() {
            try {
                LogVlion.e("VlionJdInterstitial onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = b.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public b(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3818b = false;
        this.f3820d = false;
        try {
            this.f3822f = vlionAdapterADConfig;
            JADSlot.Builder builder = new JADSlot.Builder();
            LogVlion.e("VlionJdInterstitial getSlotID:" + this.slotID + " widthPx=" + this.widthPx + " heightPx" + this.heightPx + " dpWidth=" + DensityUtil.px2dip(context, this.widthPx) + " dpHeight=" + DensityUtil.px2dip(context, this.heightPx));
            builder.setSlotID(this.slotID).setImageSize((float) DensityUtil.px2dip(context, this.widthPx), (float) DensityUtil.px2dip(context, this.heightPx)).setAdType(4);
            this.f3817a = new JADNative(builder.build());
            LogVlion.e("VlionJdInterstitial :");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void c(b bVar) {
        bVar.getClass();
        try {
            Context context = bVar.context;
            if (context != null) {
                bVar.f3821e = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.activity_vlion_jdinterstitial, (ViewGroup) null);
            }
        } catch (Throwable th2) {
            VlionBiddingLoadListener vlionBiddingLoadListener = bVar.vlionBiddingLoadListener;
            if (vlionBiddingLoadListener != null) {
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void destroy() {
        this.f3818b = true;
        this.f3820d = false;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final int getPrice() {
        int i10 = -1;
        try {
            JADNative jADNative = this.f3817a;
            if (jADNative == null || jADNative.getJADExtra() == null) {
                return -1;
            }
            i10 = this.f3817a.getJADExtra().getPrice();
            LogVlion.e("VlionJdInterstitial getPrice " + i10);
            return i10;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return i10;
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        try {
            super.loadAd();
            LogVlion.e("VlionJdInterstitial loadAd:");
            JADNative jADNative = this.f3817a;
            if (jADNative != null) {
                jADNative.loadAd(new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        VlionBiddingActionListener vlionBiddingActionListener;
        VlionAdBaseError vlionAdBaseError;
        int errorCode;
        ViewGroup viewGroup;
        super.renderAD();
        try {
            JADNative jADNative = this.f3817a;
            if (jADNative != null) {
                JADMaterialData jADMaterialData = jADNative.getDataList().get(0);
                this.f3819c = jADMaterialData;
                if (jADMaterialData == null) {
                    vlionBiddingActionListener = this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener == null) {
                        return;
                    }
                    vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    errorCode = vlionAdBaseError.getErrorCode();
                } else {
                    if (jADMaterialData.getImageUrls() != null && !this.f3819c.getImageUrls().isEmpty() && (viewGroup = this.f3821e) != null) {
                        try {
                            HttpRequestUtil.downloadBitmapNeedCache((ImageView) viewGroup.findViewById(R.id.jad_native_insert_ad_img), this.f3819c.getImageUrls().get(0), new c(this));
                            return;
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                            return;
                        }
                    }
                    vlionBiddingActionListener = this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener == null) {
                        return;
                    }
                    vlionAdBaseError = VlionAdBaseError.OTHER_AD_RENDER_ERROR;
                    errorCode = vlionAdBaseError.getErrorCode();
                }
                vlionBiddingActionListener.onAdRenderFailure(errorCode, vlionAdBaseError.getErrorMessage());
            }
        } catch (Throwable th3) {
            VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
            if (vlionBiddingActionListener2 != null) {
                VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener2.onAdRenderFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterInterstitial
    public final void showAd(Activity activity) {
        try {
            ViewGroup viewGroup = this.f3821e;
            if (viewGroup != null) {
                TextView textView = (TextView) viewGroup.findViewById(R.id.vlion_jd_tv_title);
                TextView textView2 = (TextView) this.f3821e.findViewById(R.id.vlion_jd_ad_des);
                FrameLayout frameLayout = (FrameLayout) this.f3821e.findViewById(R.id.vlion_jad_close);
                JADNative jADNative = this.f3817a;
                if (jADNative != null && jADNative.getDataList() != null && !this.f3817a.getDataList().isEmpty() && this.f3817a.getDataList().get(0) != null) {
                    JADMaterialData jADMaterialData = this.f3819c;
                    if (jADMaterialData != null) {
                        if (!TextUtils.isEmpty(jADMaterialData.getTitle())) {
                            textView.setText(this.f3819c.getTitle());
                        }
                        if (!TextUtils.isEmpty(this.f3819c.getDescription())) {
                            textView2.setText(this.f3819c.getDescription());
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f3821e);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(frameLayout);
                    this.f3817a.registerNativeView(activity, this.f3821e, arrayList, arrayList2, new C0032b());
                }
                VlionJdinterstitialActivity.a(activity, this.f3821e, this.f3822f, this.vlionBiddingActionListener);
            }
        } catch (Throwable th2) {
            VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
            if (vlionBiddingActionListener != null) {
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
