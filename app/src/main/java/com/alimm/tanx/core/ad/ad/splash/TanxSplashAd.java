package com.alimm.tanx.core.ad.ad.splash;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener;
import com.alimm.tanx.core.ad.base.tanxc_do;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_new;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.ut.impl.TanxSplashUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TanxSplashAd extends tanxc_do implements ITanxSplashAd, NotConfused {
    private int closeType;
    public int fromType;

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$1 */
    public class AnonymousClass1 implements ITanxSplashInteractionListener.ITanxAppInteraction {
        final /* synthetic */ TanxAdView tanxc_do;
        final /* synthetic */ ITanxSplashInteractionListener tanxc_if;

        public AnonymousClass1(TanxAdView tanxAdView, ITanxSplashInteractionListener iTanxSplashInteractionListener) {
            tanxAdView = tanxAdView;
            iTanxSplashInteractionListener = iTanxSplashInteractionListener;
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdClick() {
            if (((tanxc_do) TanxSplashAd.this).hasExposure) {
                TanxSplashAd.this.click(tanxAdView, null, null);
            }
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdError(int i10, String str) {
            TanxSplashUt.utSplashViewError(TanxSplashAd.this, i10, str);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdFinish() {
            ITanxSplashInteractionListener iTanxSplashInteractionListener = iTanxSplashInteractionListener;
            if (iTanxSplashInteractionListener != null) {
                iTanxSplashInteractionListener.onAdClose();
            }
            TanxSplashAd.this.closeType = 2;
            InteractionUpload interactionUpload = InteractionUpload.getInstance();
            List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
            InteractionUpload.getInstance();
            interactionUpload.uploadInteraction(5, eventTrack, 3);
            TanxSplashAd tanxSplashAd = TanxSplashAd.this;
            TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdInteractionClick() {
            InteractionUpload.getInstance().uploadInteraction(2002, TanxSplashAd.this.getBidInfo().getEventTrack());
            TanxSplashUt.utSplashViewInteract(TanxSplashAd.this, 2002);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdInteractionEnd() {
            InteractionUpload.getInstance().uploadInteraction(2003, TanxSplashAd.this.getBidInfo().getEventTrack());
            TanxSplashUt.utSplashViewInteract(TanxSplashAd.this, 2003);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdInteractionStart() {
            InteractionUpload.getInstance().uploadInteraction(2001, TanxSplashAd.this.getBidInfo().getEventTrack());
            TanxSplashUt.utSplashViewInteract(TanxSplashAd.this, 2001);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
        public void onAdSkip() {
            ITanxSplashInteractionListener iTanxSplashInteractionListener = iTanxSplashInteractionListener;
            if (iTanxSplashInteractionListener != null) {
                iTanxSplashInteractionListener.onAdClose();
            }
            TanxSplashAd.this.closeType = 2;
            InteractionUpload interactionUpload = InteractionUpload.getInstance();
            List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
            InteractionUpload.getInstance();
            interactionUpload.uploadInteraction(5, eventTrack, 3);
            TanxSplashAd tanxSplashAd = TanxSplashAd.this;
            TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$2 */
    public class AnonymousClass2 implements ITanxExposureCallback {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
            ((tanxc_do) TanxSplashAd.this).isReadyExposure = true;
            TanxSplashAd.this.doImpExposure();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j10) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(Map<String, Object> map) {
            TanxAdSlot tanxAdSlot = ((tanxc_do) TanxSplashAd.this).adSlot;
            String str = ((tanxc_do) TanxSplashAd.this).reqId;
            String templateId = ((tanxc_do) TanxSplashAd.this).bidInfo.getTemplateId();
            String creativeId = ((tanxc_do) TanxSplashAd.this).bidInfo.getCreativeId();
            TanxSplashAd tanxSplashAd = TanxSplashAd.this;
            TanxMonitorUt.sendSplashMonitor(tanxAdSlot, str, templateId, creativeId, tanxSplashAd.fromType, tanxSplashAd.closeType, map, ((tanxc_do) TanxSplashAd.this).bidInfo.getSessionId());
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$3 */
    public class AnonymousClass3 extends ViewClickListener {
        final /* synthetic */ TanxAdView val$adView;

        public AnonymousClass3(TanxAdView tanxAdView) {
            tanxAdView = tanxAdView;
        }

        @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
        public void viewClick(View view) {
            TanxSplashAd.this.click(tanxAdView, null, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd$4 */
    public class AnonymousClass4 extends ViewClickListener {
        final /* synthetic */ ITanxSplashInteractionListener val$iTanxSplashInteractionListener;

        public AnonymousClass4(ITanxSplashInteractionListener iTanxSplashInteractionListener) {
            iTanxSplashInteractionListener = iTanxSplashInteractionListener;
        }

        @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
        public void viewClick(View view) {
            ITanxSplashInteractionListener iTanxSplashInteractionListener = iTanxSplashInteractionListener;
            if (iTanxSplashInteractionListener != null) {
                iTanxSplashInteractionListener.onAdClose();
            }
            TanxSplashAd.this.closeType = 2;
            InteractionUpload interactionUpload = InteractionUpload.getInstance();
            List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
            InteractionUpload.getInstance();
            interactionUpload.uploadInteraction(5, eventTrack, 3);
            TanxSplashAd tanxSplashAd = TanxSplashAd.this;
            TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
        }
    }

    public TanxSplashAd(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, int i10, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
        this.closeType = 0;
        this.fromType = i10;
    }

    @Override // com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd
    public void bindSplashAdView(TanxAdView tanxAdView, View view, View view2, ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, "bindSplashAdView", AdUtConstants.INTO_METHOD);
        this.tanxInteractionListener = iTanxSplashInteractionListener;
        iTanxSplashInteractionListener.onInteraction(new ITanxSplashInteractionListener.ITanxAppInteraction() { // from class: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.1
            final /* synthetic */ TanxAdView tanxc_do;
            final /* synthetic */ ITanxSplashInteractionListener tanxc_if;

            public AnonymousClass1(TanxAdView tanxAdView2, ITanxSplashInteractionListener iTanxSplashInteractionListener2) {
                tanxAdView = tanxAdView2;
                iTanxSplashInteractionListener = iTanxSplashInteractionListener2;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdClick() {
                if (((tanxc_do) TanxSplashAd.this).hasExposure) {
                    TanxSplashAd.this.click(tanxAdView, null, null);
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdError(int i10, String str) {
                TanxSplashUt.utSplashViewError(TanxSplashAd.this, i10, str);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdFinish() {
                ITanxSplashInteractionListener iTanxSplashInteractionListener2 = iTanxSplashInteractionListener;
                if (iTanxSplashInteractionListener2 != null) {
                    iTanxSplashInteractionListener2.onAdClose();
                }
                TanxSplashAd.this.closeType = 2;
                InteractionUpload interactionUpload = InteractionUpload.getInstance();
                List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
                InteractionUpload.getInstance();
                interactionUpload.uploadInteraction(5, eventTrack, 3);
                TanxSplashAd tanxSplashAd = TanxSplashAd.this;
                TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdInteractionClick() {
                InteractionUpload.getInstance().uploadInteraction(2002, TanxSplashAd.this.getBidInfo().getEventTrack());
                TanxSplashUt.utSplashViewInteract(TanxSplashAd.this, 2002);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdInteractionEnd() {
                InteractionUpload.getInstance().uploadInteraction(2003, TanxSplashAd.this.getBidInfo().getEventTrack());
                TanxSplashUt.utSplashViewInteract(TanxSplashAd.this, 2003);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdInteractionStart() {
                InteractionUpload.getInstance().uploadInteraction(2001, TanxSplashAd.this.getBidInfo().getEventTrack());
                TanxSplashUt.utSplashViewInteract(TanxSplashAd.this, 2001);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener.ITanxAppInteraction
            public void onAdSkip() {
                ITanxSplashInteractionListener iTanxSplashInteractionListener2 = iTanxSplashInteractionListener;
                if (iTanxSplashInteractionListener2 != null) {
                    iTanxSplashInteractionListener2.onAdClose();
                }
                TanxSplashAd.this.closeType = 2;
                InteractionUpload interactionUpload = InteractionUpload.getInstance();
                List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
                InteractionUpload.getInstance();
                interactionUpload.uploadInteraction(5, eventTrack, 3);
                TanxSplashAd tanxSplashAd = TanxSplashAd.this;
                TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
            }
        });
        if (tanxAdView2 != null) {
            tanxAdView2.setAdMonitor(new tanxc_new(tanxAdView2, new ITanxExposureCallback() { // from class: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.2
                public AnonymousClass2() {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                    ((tanxc_do) TanxSplashAd.this).isReadyExposure = true;
                    TanxSplashAd.this.doImpExposure();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j10) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                    TanxAdSlot tanxAdSlot = ((tanxc_do) TanxSplashAd.this).adSlot;
                    String str = ((tanxc_do) TanxSplashAd.this).reqId;
                    String templateId = ((tanxc_do) TanxSplashAd.this).bidInfo.getTemplateId();
                    String creativeId = ((tanxc_do) TanxSplashAd.this).bidInfo.getCreativeId();
                    TanxSplashAd tanxSplashAd = TanxSplashAd.this;
                    TanxMonitorUt.sendSplashMonitor(tanxAdSlot, str, templateId, creativeId, tanxSplashAd.fromType, tanxSplashAd.closeType, map, ((tanxc_do) TanxSplashAd.this).bidInfo.getSessionId());
                }
            }));
        }
        if (view != null) {
            view.setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.3
                final /* synthetic */ TanxAdView val$adView;

                public AnonymousClass3(TanxAdView tanxAdView2) {
                    tanxAdView = tanxAdView2;
                }

                @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
                public void viewClick(View view3) {
                    TanxSplashAd.this.click(tanxAdView, null, null);
                }
            });
        }
        if (view2 != null) {
            view2.setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.splash.TanxSplashAd.4
                final /* synthetic */ ITanxSplashInteractionListener val$iTanxSplashInteractionListener;

                public AnonymousClass4(ITanxSplashInteractionListener iTanxSplashInteractionListener2) {
                    iTanxSplashInteractionListener = iTanxSplashInteractionListener2;
                }

                @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
                public void viewClick(View view3) {
                    ITanxSplashInteractionListener iTanxSplashInteractionListener2 = iTanxSplashInteractionListener;
                    if (iTanxSplashInteractionListener2 != null) {
                        iTanxSplashInteractionListener2.onAdClose();
                    }
                    TanxSplashAd.this.closeType = 2;
                    InteractionUpload interactionUpload = InteractionUpload.getInstance();
                    List<? extends ITrackItem> eventTrack = TanxSplashAd.this.getBidInfo().getMonitorBean().getEventTrack();
                    InteractionUpload.getInstance();
                    interactionUpload.uploadInteraction(5, eventTrack, 3);
                    TanxSplashAd tanxSplashAd = TanxSplashAd.this;
                    TanxSplashUt.utSplashViewClose(tanxSplashAd, tanxSplashAd.fromType);
                }
            });
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd
    public void click(TanxAdView tanxAdView, String str, String str2) {
        if (tanxAdView != null) {
            navigateAndUt(tanxAdView, tanxAdView.getContext(), false, str, str2);
        } else {
            LogUtils.e("TanxSplashAd", "adView点击时为空");
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd
    public void clickUpload() {
        ExposeManager.tanxc_do().tanxc_do(this.bidInfo, this.reqId, this.adSlot.getPid(), AdMonitorType.CLICK, getMonitorList("click"), this.clickExposeCallback);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        super.destroy();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public AdUtConstants getAdClickUtKey() {
        return AdUtConstants.SCREEN_VIEW_CLICK;
    }

    public AdUtConstants getAdShakeUtKey() {
        return AdUtConstants.SHAKE_NAVIGATE;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public int getAdType() {
        return super.getAdType();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        if (super.getBidInfo() != null) {
            return super.getBidInfo().removeSensitiveData();
        }
        return null;
    }

    public void navigateAndUt(TanxAdView tanxAdView, Context context, boolean z10, String str, String str2) {
        ITanxInteractionListener iTanxInteractionListener;
        try {
            if (this.adClickInfo == null) {
                if (z10) {
                    this.closeType = 3;
                    this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdShakeUtKey(), str, str2);
                } else {
                    this.closeType = 1;
                    this.adClickInfo = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.adSlot, this.bidInfo, getAdClickUtKey(), str, str2);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TanxSplashUt.FROM_TYPE, String.valueOf(this.fromType));
            this.adClickInfo.setUtArgs(hashMap);
            com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(context, this.adClickInfo, true);
            if (!z10 && (iTanxInteractionListener = this.tanxInteractionListener) != null) {
                iTanxInteractionListener.onAdClicked(tanxAdView, this);
            }
            clickUpload();
        } catch (Exception e10) {
            LogUtils.e(e10);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "TanxSplashAd", LogUtils.getStackTraceMessage(e10), "");
        }
    }
}
