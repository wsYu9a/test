package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.monitor.ITanxExposureCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_if;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.PlayerListManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxc_do extends com.alimm.tanx.core.ad.base.tanxc_do implements ITanxFeedAd {
    private ITanxFeedInteractionListener tanxc_do;
    private FeedVideoManager tanxc_for;
    private com.alimm.tanx.core.view.feed.tanxc_do tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.tanxc_do$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ ITanxFeedInteractionListener tanxc_do;

        public AnonymousClass1(ITanxFeedInteractionListener iTanxFeedInteractionListener) {
            iTanxFeedInteractionListener = iTanxFeedInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (iTanxFeedInteractionListener != null) {
                if (tanxc_do.this.getAdSlot() == null || tanxc_do.this.getAdSlot().isFeedBackDialog()) {
                    iTanxFeedInteractionListener.onAdDislike();
                    return;
                }
                iTanxFeedInteractionListener.onAdClose();
                InteractionUpload interactionUpload = InteractionUpload.getInstance();
                List<NewTrackItem> eventTrack = tanxc_do.this.getBidInfo().getEventTrack();
                InteractionUpload.getInstance();
                interactionUpload.uploadInteraction(5, eventTrack, 3);
                TanxFeedUt.utClose(tanxc_do.this, 2);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.feed.tanxc_do$2 */
    public class AnonymousClass2 implements ITanxExposureCallback {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposure() {
            ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).isReadyExposure = true;
            tanxc_do.this.doImpExposure();
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void exposureTime(long j10) {
        }

        @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
        public void onMonitor(Map<String, Object> map) {
            TanxMonitorUt.sendFeedMonitor(((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).adSlot, ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).reqId, ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).bidInfo.getTemplateId(), ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).bidInfo.getCreativeId(), map, ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).bidInfo.getSessionId());
        }
    }

    public tanxc_do(TanxAdSlot tanxAdSlot, BidInfo bidInfo, String str, String str2) {
        super(tanxAdSlot, bidInfo, str, str2);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindDislikeView(List<View> list, ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener) {
        if (list == null) {
            return;
        }
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxFeedAd$3
                final /* synthetic */ List val$dislikeList;
                final /* synthetic */ ITanxFeedAd.DislikeOnClickListener val$dislikeOnClickListener;

                public TanxFeedAd$3(List list2, ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener2) {
                    list = list2;
                    dislikeOnClickListener = dislikeOnClickListener2;
                }

                @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
                public void viewClick(View view) {
                    ITanxFeedInteractionListener iTanxFeedInteractionListener;
                    ITanxFeedInteractionListener iTanxFeedInteractionListener2;
                    iTanxFeedInteractionListener = tanxc_do.this.tanxc_do;
                    if (iTanxFeedInteractionListener != null) {
                        iTanxFeedInteractionListener2 = tanxc_do.this.tanxc_do;
                        iTanxFeedInteractionListener2.onAdClose();
                        if (list.size() > 1) {
                            if (list.get(0) == view) {
                                InteractionUpload interactionUpload = InteractionUpload.getInstance();
                                List<NewTrackItem> eventTrack = tanxc_do.this.getBidInfo().getEventTrack();
                                InteractionUpload.getInstance();
                                interactionUpload.uploadInteraction(5, eventTrack, 4);
                                TanxFeedUt.utClose(tanxc_do.this, 0);
                            } else {
                                InteractionUpload interactionUpload2 = InteractionUpload.getInstance();
                                List<NewTrackItem> eventTrack2 = tanxc_do.this.getBidInfo().getEventTrack();
                                InteractionUpload.getInstance();
                                interactionUpload2.uploadInteraction(5, eventTrack2, 5);
                                TanxFeedUt.utClose(tanxc_do.this, 1);
                            }
                        }
                    }
                    ITanxFeedAd.DislikeOnClickListener dislikeOnClickListener2 = dislikeOnClickListener;
                    if (dislikeOnClickListener2 != null) {
                        dislikeOnClickListener2.onClick(view);
                    }
                }
            });
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindFeedAdView(TanxAdView tanxAdView, List<View> list, View view, ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        TanxCommonUt.sendIntoMethod(this.adSlot, this.reqId, this.bidInfo, getAdSlot().isExpressRender() ? "bindTemplateFeedAdView" : "bindFeedAdView", AdUtConstants.INTO_METHOD, null);
        tanxc_do(tanxAdView, list, view, iTanxFeedInteractionListener);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void click(TanxAdView tanxAdView) {
        super.doClickExposure(tanxAdView);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public void destroy() {
        LogUtils.d("TanxFeedAd", "媒体调用destroy（）");
        PlayerListManager.getInstance().clearThis(this);
        super.destroy();
        FeedVideoManager feedVideoManager = this.tanxc_for;
        if (feedVideoManager != null) {
            feedVideoManager.destroy();
        }
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do
    public AdUtConstants getAdClickUtKey() {
        return getBidInfo().getInteractType2FeedSlide() ? AdUtConstants.FLOW_VIEW_INTERACTION_CLICK : AdUtConstants.FLOW_VIEW_CLICK;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public int getAdType() {
        return super.getAdType();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_do, com.alimm.tanx.core.ad.ITanxAd
    public BidInfo getBidInfo() {
        return super.getBidInfo().removeSensitiveData();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public ITanxVideoView getITanxVideoView(Context context) {
        if (this.tanxc_if == null) {
            this.tanxc_if = new com.alimm.tanx.core.view.feed.tanxc_do();
        }
        if (this.tanxc_for == null) {
            this.tanxc_for = new FeedVideoManager(this, this.tanxc_if, context);
            PlayerListManager.getInstance().putFeedVideoManager(this, this.tanxc_for);
        }
        return this.tanxc_for;
    }

    private void tanxc_do(TanxAdView tanxAdView, List<View> list, View view, ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("adView:");
        sb2.append(tanxAdView == null ? "null" : "不为空");
        sb2.append("iTanxFeedInteractionListener:");
        sb2.append(iTanxFeedInteractionListener == null ? "null" : "不为空");
        LogUtils.d("bindView", sb2.toString());
        super.bindAdView(tanxAdView, list, iTanxFeedInteractionListener);
        this.tanxc_do = iTanxFeedInteractionListener;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.tanxc_do.1
                final /* synthetic */ ITanxFeedInteractionListener tanxc_do;

                public AnonymousClass1(ITanxFeedInteractionListener iTanxFeedInteractionListener2) {
                    iTanxFeedInteractionListener = iTanxFeedInteractionListener2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (iTanxFeedInteractionListener != null) {
                        if (tanxc_do.this.getAdSlot() == null || tanxc_do.this.getAdSlot().isFeedBackDialog()) {
                            iTanxFeedInteractionListener.onAdDislike();
                            return;
                        }
                        iTanxFeedInteractionListener.onAdClose();
                        InteractionUpload interactionUpload = InteractionUpload.getInstance();
                        List<NewTrackItem> eventTrack = tanxc_do.this.getBidInfo().getEventTrack();
                        InteractionUpload.getInstance();
                        interactionUpload.uploadInteraction(5, eventTrack, 3);
                        TanxFeedUt.utClose(tanxc_do.this, 2);
                    }
                }
            });
        }
        if (tanxAdView != null) {
            tanxAdView.setAdMonitor(new tanxc_if(tanxAdView, new ITanxExposureCallback() { // from class: com.alimm.tanx.core.ad.ad.feed.tanxc_do.2
                public AnonymousClass2() {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                    ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).isReadyExposure = true;
                    tanxc_do.this.doImpExposure();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j10) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                    TanxMonitorUt.sendFeedMonitor(((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).adSlot, ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).reqId, ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).bidInfo.getTemplateId(), ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).bidInfo.getCreativeId(), map, ((com.alimm.tanx.core.ad.base.tanxc_do) tanxc_do.this).bidInfo.getSessionId());
                }
            }));
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd
    public void bindFeedAdView(TanxAdView tanxAdView, View view, View view2, ITanxFeedInteractionListener iTanxFeedInteractionListener) {
        ArrayList arrayList = new ArrayList();
        if (view != null) {
            arrayList.add(view);
        }
        bindFeedAdView(tanxAdView, arrayList, view2, iTanxFeedInteractionListener);
    }
}
