package cn.vlion.ad.inland.jd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;

/* loaded from: classes.dex */
public final class g extends VlionBaseAdAdapterSplash {

    /* renamed from: a */
    public JADSplash f3837a;

    /* renamed from: b */
    public View f3838b;

    public class a implements JADSplashListener {
        public a() {
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onClick() {
            try {
                LogVlion.e("VlionJdSplash onClick");
                VlionBiddingActionListener vlionBiddingActionListener = g.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onClose() {
            try {
                LogVlion.e("VlionJdSplash onClose");
                VlionBiddingActionListener vlionBiddingActionListener = g.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onExposure() {
            try {
                LogVlion.e("VlionJdSplash onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = g.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onLoadFailure(int i10, String str) {
            try {
                LogVlion.e("VlionJdSplash onLoadFailure:code=" + i10 + " error=" + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = g.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onLoadSuccess() {
            try {
                int price = g.this.getPrice();
                LogVlion.e("VlionJdSplash onLoadSuccess" + price);
                VlionBiddingLoadListener vlionBiddingLoadListener = g.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onRenderFailure(int i10, String str) {
            VlionBiddingActionListener vlionBiddingActionListener;
            try {
                LogVlion.e("VlionJdSplash onRenderFailure:code=" + i10 + " error=" + str + "  isWinPrice=" + g.this.isWinPrice());
                if (!g.this.isAdRenderFailureCallback(i10, str) || (vlionBiddingActionListener = g.this.vlionBiddingActionListener) == null) {
                    return;
                }
                vlionBiddingActionListener.onAdRenderFailure(i10, str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.splash.JADSplashListener
        public final void onRenderSuccess(View view) {
            VlionBiddingActionListener vlionBiddingActionListener;
            try {
                g.this.f3838b = view;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionJdSplash onRenderSuccess (null!=adView)=");
                sb2.append(view != null);
                sb2.append(" isWinPrice=");
                sb2.append(g.this.isWinPrice());
                LogVlion.e(sb2.toString());
                if (!g.this.isAdRenderSuccessCallback() || (vlionBiddingActionListener = g.this.vlionBiddingActionListener) == null) {
                    return;
                }
                vlionBiddingActionListener.onAdRenderSuccess(view);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public g(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3838b = null;
        try {
            JADSlot.Builder builder = new JADSlot.Builder();
            int px2dip = DensityUtil.px2dip(context, this.widthPx);
            int px2dip2 = DensityUtil.px2dip(context, this.heightPx);
            LogVlion.e("VlionJdSplash getSlotID:" + this.slotID + " widthPx=" + this.widthPx + " heightPx" + this.heightPx + " dpWidth=" + px2dip + " dpHeight=" + px2dip2);
            builder.setSlotID(this.slotID).setSize((float) px2dip, (float) px2dip2).setSkipButtonHidden(this.isHideSkip);
            this.f3837a = new JADSplash(context, builder.build());
            LogVlion.e("VlionJdSplash:");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void destroy() {
        try {
            JADSplash jADSplash = this.f3837a;
            if (jADSplash != null) {
                jADSplash.destroy();
                this.f3837a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final int getPrice() {
        int i10 = -1;
        try {
            JADSplash jADSplash = this.f3837a;
            if (jADSplash != null && jADSplash.getJADExtra() != null) {
                i10 = this.f3837a.getJADExtra().getPrice();
            }
            LogVlion.e("VlionJdSplash getPrice price=" + i10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return i10;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        try {
            super.loadAd();
            this.f3838b = null;
            JADSplash jADSplash = this.f3837a;
            if (jADSplash != null) {
                jADSplash.loadAd(new a());
            } else {
                VlionBiddingLoadListener vlionBiddingLoadListener = this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_IS_DESTROY;
                    vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        try {
            super.renderAD();
            LogVlion.e("VlionJdSplash renderAD isHaveLoadStatus=" + isHaveLoadStatus());
            if (isHaveLoadStatus()) {
                LogVlion.e("VlionJdSplash renderAD  isLoadStatusError()=" + isLoadStatusError());
                if (isLoadStatusError()) {
                    VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderFailure(getAdStatusErrorCode(), getAdStatusErrorMessage());
                    }
                } else {
                    VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener2 != null) {
                        vlionBiddingActionListener2.onAdRenderSuccess(this.f3838b);
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterSplash
    public final void showAd(ViewGroup viewGroup) {
        try {
            LogVlion.e("VlionJdSplash showAd");
            if (this.f3838b == null || viewGroup == null) {
                VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.OTHER_AD_SHOW_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
            } else {
                LogVlion.e("VlionJdSplash showAd adView");
                viewGroup.addView(this.f3838b);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
