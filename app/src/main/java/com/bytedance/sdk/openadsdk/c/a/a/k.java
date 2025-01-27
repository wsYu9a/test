package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class k implements TTFeedAd {

    /* renamed from: a */
    private final Bridge f8109a;

    public k(Bridge bridge) {
        this.f8109a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        this.f8109a.call(140114, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.f8109a.values().objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.f8109a.values().objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.f8109a.values().intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.f8109a.values().intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.f8109a.values().intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.f8109a.values().intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.f8109a.values().intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return (String) this.f8109a.values().objectValue(140018, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new c((Bridge) this.f8109a.values().objectValue(140014, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.i.a.a.a.a((Bridge) this.f8109a.values().objectValue(160002, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return (String) this.f8109a.values().objectValue(140004, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        return new h((Bridge) this.f8109a.call(140101, a10.b(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new d((Bridge) this.f8109a.values().objectValue(140013, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new e((Bridge) this.f8109a.values().objectValue(140015, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new m((Bridge) this.f8109a.values().objectValue(140009, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List list = (List) this.f8109a.values().objectValue(140010, List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new m((Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.f8109a.values().intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.f8109a.values().intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f8109a.values().objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return (String) this.f8109a.values().objectValue(140008, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return (String) this.f8109a.values().objectValue(140003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new m((Bridge) this.f8109a.values().objectValue(140001, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.f8109a.values().doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, d10);
        a10.a(1, str);
        a10.a(2, str2);
        this.f8109a.call(210102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, viewGroup);
        a10.a(1, view);
        a10.a(2, new com.bytedance.sdk.openadsdk.k.a.a.a.a(adInteractionListener));
        this.f8109a.call(140103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        this.f8109a.call(140110, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        this.f8109a.call(140109, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f8109a.call(210104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(2);
        a10.a(0, activity);
        a10.a(1, new com.bytedance.sdk.openadsdk.f.a.a.a.a(dislikeInteractionCallback));
        this.f8109a.call(140112, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, tTDislikeDialogAbstract);
        this.f8109a.call(140113, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f8109a.call(140108, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setEasyPlayWidgetListener(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.k.a.a.a.b(easyPlayWidgetListener));
        this.f8109a.call(140119, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.k.a.a.a.c(expressRenderListener));
        this.f8109a.call(140111, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8109a.call(210103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.i.a.a.b.a(videoAdListener));
        this.f8109a.call(160101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(TTFeedAd.VideoRewardListener videoRewardListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.i.a.a.b.b(videoRewardListener));
        this.f8109a.call(160102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        this.f8109a.call(140115, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void uploadDislikeEvent(String str) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, str);
        this.f8109a.call(140118, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8109a.call(210101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, tTDislikeDialogAbstract);
        return new h((Bridge) this.f8109a.call(140102, a10.b(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(4);
        a10.a(0, viewGroup);
        a10.a(1, list);
        a10.a(2, list2);
        a10.a(3, new com.bytedance.sdk.openadsdk.k.a.a.a.a(adInteractionListener));
        this.f8109a.call(140104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(5);
        a10.a(0, viewGroup);
        a10.a(1, list);
        a10.a(2, list2);
        a10.a(3, view);
        a10.a(4, new com.bytedance.sdk.openadsdk.k.a.a.a.a(adInteractionListener));
        this.f8109a.call(140105, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(6);
        a10.a(0, viewGroup);
        a10.a(1, list);
        a10.a(2, list2);
        a10.a(3, list3);
        a10.a(4, view);
        a10.a(5, new com.bytedance.sdk.openadsdk.k.a.a.a.a(adInteractionListener));
        this.f8109a.call(140106, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(7);
        a10.a(0, viewGroup);
        a10.a(1, list);
        a10.a(2, list2);
        a10.a(3, list3);
        a10.a(4, list4);
        a10.a(5, view);
        a10.a(6, new com.bytedance.sdk.openadsdk.k.a.a.a.a(adInteractionListener));
        this.f8109a.call(140107, a10.b(), Void.class);
    }
}
