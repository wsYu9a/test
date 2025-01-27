package cn.vlion.ad.inland.jd;

import android.content.Context;
import android.view.View;
import cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.DensityUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.JADFeedListener;

/* loaded from: classes.dex */
public final class a extends VlionBaseAdAdapterFeed {

    /* renamed from: a */
    public JADFeed f3814a;

    /* renamed from: b */
    public View f3815b;

    /* renamed from: cn.vlion.ad.inland.jd.a$a */
    public class C0031a implements JADFeedListener {
        public C0031a() {
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onClick() {
            try {
                LogVlion.e("VlionJdFeed onClick");
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onClose() {
            try {
                LogVlion.e("VlionJdFeed onClose");
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onExposure() {
            try {
                LogVlion.e("VlionJdFeed onExposure");
                VlionBiddingActionListener vlionBiddingActionListener = a.this.vlionBiddingActionListener;
                if (vlionBiddingActionListener != null) {
                    vlionBiddingActionListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onLoadFailure(int i10, String str) {
            try {
                LogVlion.e("VlionJdFeed onLoadFailure:code=" + i10 + " error=" + str);
                VlionBiddingLoadListener vlionBiddingLoadListener = a.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onLoadSuccess() {
            try {
                int price = a.this.getPrice();
                LogVlion.e("VlionJdFeed onLoadSuccess:" + price);
                VlionBiddingLoadListener vlionBiddingLoadListener = a.this.vlionBiddingLoadListener;
                if (vlionBiddingLoadListener != null) {
                    vlionBiddingLoadListener.onAdLoadSuccess(price);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onRenderFailure(int i10, String str) {
            VlionBiddingActionListener vlionBiddingActionListener;
            try {
                LogVlion.e("VlionJdFeed onRenderFailure:code=" + i10 + " error=" + str + " isWinPrice=" + a.this.isWinPrice());
                if (!a.this.isAdRenderFailureCallback(i10, str) || (vlionBiddingActionListener = a.this.vlionBiddingActionListener) == null) {
                    return;
                }
                vlionBiddingActionListener.onAdRenderFailure(i10, str);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.jd.ad.sdk.feed.JADFeedListener
        public final void onRenderSuccess(View view) {
            a aVar;
            VlionBiddingActionListener vlionBiddingActionListener;
            try {
                a.this.f3815b = view;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionJdFeed onRenderSuccess (null!=adView)=");
                sb2.append(a.this.f3815b != null);
                sb2.append(" isWinPrice=");
                sb2.append(a.this.isWinPrice());
                LogVlion.e(sb2.toString());
                if (!a.this.isAdRenderSuccessCallback() || (vlionBiddingActionListener = (aVar = a.this).vlionBiddingActionListener) == null) {
                    return;
                }
                vlionBiddingActionListener.onAdRenderSuccess(aVar.f3815b);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public a(Context context, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingLoadListener vlionBiddingLoadListener) {
        super(context, vlionAdapterADConfig, vlionBiddingLoadListener);
        this.f3815b = null;
        try {
            JADSlot.Builder builder = new JADSlot.Builder();
            LogVlion.e("VlionJdFeed getSlotID:" + this.slotID + " widthPx=" + this.widthPx + " heightPx" + this.heightPx + " dpWidth=" + DensityUtil.px2dip(context, this.widthPx) + " dpHeight=" + DensityUtil.px2dip(context, this.heightPx));
            builder.setSlotID(this.slotID).setSize((float) DensityUtil.px2dip(context, this.widthPx), (float) DensityUtil.px2dip(context, this.heightPx)).setCloseButtonHidden(this.isHideSkip);
            this.f3814a = new JADFeed(context, builder.build());
            LogVlion.e("VlionJdFeed :");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final void destroy() {
        try {
            JADFeed jADFeed = this.f3814a;
            if (jADFeed != null) {
                jADFeed.destroy();
                this.f3814a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final int getPrice() {
        int i10 = -1;
        try {
            JADFeed jADFeed = this.f3814a;
            if (jADFeed != null && jADFeed.getExtra() != null) {
                i10 = this.f3814a.getExtra().getPrice();
            }
            LogVlion.e("VlionJdFeed getPrice price=" + i10);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return i10;
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void loadAd() {
        try {
            super.loadAd();
            this.f3815b = null;
            JADFeed jADFeed = this.f3814a;
            if (jADFeed != null) {
                jADFeed.loadAd(new C0031a());
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

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterFeed
    public final void notifyFailPrice(VlionLossBiddingReason vlionLossBiddingReason) {
    }

    @Override // cn.vlion.ad.inland.base.adapter.VlionBaseAdAdapterAdLoad
    public final void renderAD() {
        try {
            super.renderAD();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionJdFeed renderAD  (null != adView)");
            sb2.append(this.f3815b != null);
            sb2.append(" isHaveLoadStatus()=");
            sb2.append(isHaveLoadStatus());
            LogVlion.e(sb2.toString());
            if (isHaveLoadStatus()) {
                if (isLoadStatusError()) {
                    VlionBiddingActionListener vlionBiddingActionListener = this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener != null) {
                        vlionBiddingActionListener.onAdRenderFailure(getAdStatusErrorCode(), getAdStatusErrorMessage());
                    }
                } else {
                    LogVlion.e("VlionJdFeed renderAD adView");
                    VlionBiddingActionListener vlionBiddingActionListener2 = this.vlionBiddingActionListener;
                    if (vlionBiddingActionListener2 != null) {
                        vlionBiddingActionListener2.onAdRenderSuccess(this.f3815b);
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
