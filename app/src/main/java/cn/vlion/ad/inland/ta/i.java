package cn.vlion.ad.inland.ta;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossBiddingReason;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.natives.VlionNativeADEventListener;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener;
import com.alimm.tanx.core.ad.bean.CreativeItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;

/* loaded from: classes.dex */
public final class i extends VlionNativeAdImpMaterialListener {

    /* renamed from: a */
    public final /* synthetic */ VlionNativeAdData f4046a;

    /* renamed from: b */
    public final /* synthetic */ CreativeItem f4047b;

    /* renamed from: c */
    public final /* synthetic */ g f4048c;

    public class a implements ImageCallback {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
            LogVlion.e("VlionTanxNative loadImage  onFail");
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
            try {
                LogVlion.e("VlionTanxNative loadImage  onSuccess");
                VlionNativeActionListener vlionNativeActionListener = i.this.f4048c.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onAdRenderSuccess();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements ITanxFeedVideoAdListener {
        public b() {
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final View onCustomLoadingIcon() {
            return null;
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final View onCustomPlayIcon() {
            return null;
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onError(TanxError tanxError) {
            try {
                LogVlion.e(" VlionTanxNative onVideoError: ");
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener == null || tanxError == null) {
                    return;
                }
                vlionNativesAdVideoListener.onAdVideoPlayError(tanxError.getMessage());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onProgressUpdate(long j10, long j11) {
            try {
                LogVlion.e(" VlionTanxNative onProgressUpdate:l :" + j10 + "  l1 :" + j11);
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener != null) {
                    vlionNativesAdVideoListener.onProgressUpdate((int) (j11 - j10), (int) j11);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onVideoAdPaused(ITanxFeedAd iTanxFeedAd) {
            try {
                LogVlion.e(" VlionTanxNative onVideoPause: ");
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener != null) {
                    vlionNativesAdVideoListener.onVideoAdPaused();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onVideoAdStartPlay(ITanxFeedAd iTanxFeedAd) {
            LogVlion.e(" VlionTanxNative onRenderingStart:");
            try {
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener != null) {
                    vlionNativesAdVideoListener.onVideoAdStartPlay();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onVideoComplete() {
            try {
                LogVlion.e(" VlionTanxNative onVideoCompleted: ");
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener != null) {
                    vlionNativesAdVideoListener.onVideoAdComplete();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onVideoError(TanxPlayerError tanxPlayerError) {
            try {
                LogVlion.e(" VlionTanxNative onVideoError: ");
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener == null || tanxPlayerError == null) {
                    return;
                }
                vlionNativesAdVideoListener.onAdVideoPlayError(tanxPlayerError.getMessage());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener
        public final void onVideoLoad(ITanxFeedAd iTanxFeedAd) {
            LogVlion.e(" VlionTanxNative onVideoLoad:");
            try {
                VlionNativesAdVideoListener vlionNativesAdVideoListener = i.this.madVideoListener;
                if (vlionNativesAdVideoListener != null) {
                    vlionNativesAdVideoListener.onVideoLoad();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements ITanxFeedInteractionListener {

        /* renamed from: a */
        public final /* synthetic */ VlionNativeADEventListener f4051a;

        public c(VlionNativeADEventListener vlionNativeADEventListener) {
            this.f4051a = vlionNativeADEventListener;
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public final void onAdClicked(TanxAdView tanxAdView, ITanxFeedAd iTanxFeedAd) {
            try {
                LogVlion.e("VlionTanxNative registerNativeView onAdClicked");
                VlionNativeActionListener vlionNativeActionListener = i.this.f4048c.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClick();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f4051a;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
        public final void onAdClose() {
            try {
                LogVlion.e("VlionTanxNative registerNativeView onAdClose");
                VlionNativeActionListener vlionNativeActionListener = i.this.f4048c.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClose();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f4051a;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedInteractionListener
        public final void onAdDislike() {
            try {
                LogVlion.e("VlionTanxNative registerNativeView onAdDislike");
                VlionNativeActionListener vlionNativeActionListener = i.this.f4048c.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onClose();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f4051a;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public final void onAdShow(ITanxFeedAd iTanxFeedAd) {
            try {
                LogVlion.e("VlionTanxNative registerNativeView onAdExposed");
                VlionNativeActionListener vlionNativeActionListener = i.this.f4048c.vlionNativeActionListener;
                if (vlionNativeActionListener != null) {
                    vlionNativeActionListener.onExposure();
                }
                VlionNativeADEventListener vlionNativeADEventListener = this.f4051a;
                if (vlionNativeADEventListener != null) {
                    vlionNativeADEventListener.onExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public i(g gVar, VlionNativeAdData vlionNativeAdData, CreativeItem creativeItem) {
        this.f4048c = gVar;
        this.f4046a = vlionNativeAdData;
        this.f4047b = creativeItem;
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void destroy() {
        super.destroy();
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void notifyWinPrice(double d10, VlionBidderSource vlionBidderSource) {
        LogVlion.e("VlionTanxNative notifyWinPrice");
        VlionNativeActionListener vlionNativeActionListener = this.f4048c.vlionNativeActionListener;
        if (vlionNativeActionListener != null) {
            vlionNativeActionListener.notifyWinPrice(d10, vlionBidderSource);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void notifyWinPriceFailure(double d10, VlionBidderSource vlionBidderSource, VlionLossBiddingReason vlionLossBiddingReason) {
        LogVlion.e("VlionTanxNative notifyWinPriceFailure price=" + d10);
        VlionNativeActionListener vlionNativeActionListener = this.f4048c.vlionNativeActionListener;
        if (vlionNativeActionListener != null) {
            vlionNativeActionListener.notifyWinPriceFailure(d10, vlionBidderSource, vlionLossBiddingReason);
        }
    }

    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    public final void onAdRender(Context context, VlionNativeAdData vlionNativeAdData) {
        ITanxFeedAd iTanxFeedAd;
        ITanxFeedAd iTanxFeedAd2;
        ITanxFeedAd iTanxFeedAd3;
        ITanxFeedAd iTanxFeedAd4;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        ITanxFeedAd unused;
        try {
            iTanxFeedAd = this.f4048c.f4040c;
            if (iTanxFeedAd != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionTanxNative iTanxFeedAdBiddingResult.getAdType()=");
                iTanxFeedAd2 = this.f4048c.f4040c;
                sb2.append(iTanxFeedAd2.getAdType());
                LogVlion.e(sb2.toString());
                iTanxFeedAd3 = this.f4048c.f4040c;
                switch (iTanxFeedAd3.getAdType()) {
                    case 10:
                    case 12:
                        d dVar = new d(this.f4048c.context);
                        dVar.setScaleType(this.f4046a.getImageScale());
                        LogVlion.e("VlionTanxNative loadImage  creativeItem.getImageUrl()=" + this.f4047b.getImageUrl());
                        unused = this.f4048c.f4040c;
                        dVar.a(this.f4047b.getImageUrl(), new a());
                        this.f4048c.f4041d = dVar;
                        break;
                    case 11:
                    case 13:
                        iTanxFeedAd4 = this.f4048c.f4040c;
                        View videoAdView = iTanxFeedAd4.getITanxVideoView(this.f4048c.context).getVideoAdView(new b());
                        o oVar = new o(this.f4048c.context);
                        oVar.a(videoAdView);
                        this.f4048c.f4041d = oVar;
                        VlionNativeActionListener vlionNativeActionListener = this.f4048c.vlionNativeActionListener;
                        if (vlionNativeActionListener != null) {
                            vlionNativeActionListener.onAdRenderSuccess();
                            break;
                        }
                        break;
                }
                g gVar = this.f4048c;
                if (gVar.context != null) {
                    gVar.f4042e = new FrameLayout(this.f4048c.context);
                    frameLayout = this.f4048c.f4042e;
                    if (frameLayout != null) {
                        frameLayout2 = this.f4048c.f4042e;
                        setAdMediaView(frameLayout2);
                    }
                    VlionNativeActionListener vlionNativeActionListener2 = this.f4048c.vlionNativeActionListener;
                    if (vlionNativeActionListener2 != null) {
                        vlionNativeActionListener2.onAdRenderSuccess();
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:27:0x0005, B:29:0x000b, B:4:0x0017, B:6:0x001f, B:7:0x0033, B:9:0x003b, B:11:0x0043, B:13:0x005e, B:15:0x006c, B:16:0x0081), top: B:26:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:27:0x0005, B:29:0x000b, B:4:0x0017, B:6:0x001f, B:7:0x0033, B:9:0x003b, B:11:0x0043, B:13:0x005e, B:15:0x006c, B:16:0x0081), top: B:26:0x0005 }] */
    @Override // cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener, cn.vlion.ad.inland.base.natives.VlionNativeAdMaterialListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void registerNativeView(android.app.Activity r1, android.view.ViewGroup r2, java.util.List<android.view.View> r3, java.util.List<android.view.View> r4, java.util.List<android.view.View> r5, cn.vlion.ad.inland.base.natives.VlionNativeADEventListener r6) {
        /*
            r0 = this;
            super.registerNativeView(r1, r2, r3, r4, r5, r6)
            if (r5 == 0) goto L16
            int r1 = r5.size()     // Catch: java.lang.Throwable -> L13
            if (r1 <= 0) goto L16
            r1 = 0
            java.lang.Object r1 = r5.get(r1)     // Catch: java.lang.Throwable -> L13
            android.view.View r1 = (android.view.View) r1     // Catch: java.lang.Throwable -> L13
            goto L17
        L13:
            r1 = move-exception
            goto L97
        L16:
            r1 = 0
        L17:
            cn.vlion.ad.inland.ta.g r2 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd r2 = cn.vlion.ad.inland.ta.g.a(r2)     // Catch: java.lang.Throwable -> L13
            if (r2 == 0) goto L33
            cn.vlion.ad.inland.ta.g r2 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd r2 = cn.vlion.ad.inland.ta.g.a(r2)     // Catch: java.lang.Throwable -> L13
            cn.vlion.ad.inland.ta.g r4 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r4 = cn.vlion.ad.inland.ta.g.c(r4)     // Catch: java.lang.Throwable -> L13
            cn.vlion.ad.inland.ta.i$c r5 = new cn.vlion.ad.inland.ta.i$c     // Catch: java.lang.Throwable -> L13
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L13
            r2.bindFeedAdView(r4, r3, r1, r5)     // Catch: java.lang.Throwable -> L13
        L33:
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            android.widget.FrameLayout r1 = cn.vlion.ad.inland.ta.g.d(r1)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L9e
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r1 = cn.vlion.ad.inland.ta.g.c(r1)     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L9e
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            android.widget.FrameLayout r1 = cn.vlion.ad.inland.ta.g.d(r1)     // Catch: java.lang.Throwable -> L13
            cn.vlion.ad.inland.ta.g r2 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r2 = cn.vlion.ad.inland.ta.g.c(r2)     // Catch: java.lang.Throwable -> L13
            r1.removeView(r2)     // Catch: java.lang.Throwable -> L13
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r1 = cn.vlion.ad.inland.ta.g.c(r1)     // Catch: java.lang.Throwable -> L13
            android.view.ViewParent r1 = r1.getParent()     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L81
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r1 = cn.vlion.ad.inland.ta.g.c(r1)     // Catch: java.lang.Throwable -> L13
            android.view.ViewParent r1 = r1.getParent()     // Catch: java.lang.Throwable -> L13
            boolean r1 = r1 instanceof android.view.ViewGroup     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L81
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r1 = cn.vlion.ad.inland.ta.g.c(r1)     // Catch: java.lang.Throwable -> L13
            android.view.ViewParent r1 = r1.getParent()     // Catch: java.lang.Throwable -> L13
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1     // Catch: java.lang.Throwable -> L13
            cn.vlion.ad.inland.ta.g r2 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r2 = cn.vlion.ad.inland.ta.g.c(r2)     // Catch: java.lang.Throwable -> L13
            r1.removeView(r2)     // Catch: java.lang.Throwable -> L13
        L81:
            cn.vlion.ad.inland.ta.g r1 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            android.widget.FrameLayout r1 = cn.vlion.ad.inland.ta.g.d(r1)     // Catch: java.lang.Throwable -> L13
            cn.vlion.ad.inland.ta.g r2 = r0.f4048c     // Catch: java.lang.Throwable -> L13
            com.alimm.tanx.core.ad.view.TanxAdView r2 = cn.vlion.ad.inland.ta.g.c(r2)     // Catch: java.lang.Throwable -> L13
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams     // Catch: java.lang.Throwable -> L13
            r4 = -1
            r3.<init>(r4, r4)     // Catch: java.lang.Throwable -> L13
            r1.addView(r2, r3)     // Catch: java.lang.Throwable -> L13
            goto L9e
        L97:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r2 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r2.upLoadCatchException(r1)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ta.i.registerNativeView(android.app.Activity, android.view.ViewGroup, java.util.List, java.util.List, java.util.List, cn.vlion.ad.inland.base.natives.VlionNativeADEventListener):void");
    }
}
