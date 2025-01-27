package com.bytedance.sdk.openadsdk.c.a.a;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class o implements TTNativeExpressAd {

    /* renamed from: a */
    private final Bridge f8113a;

    public o(Bridge bridge) {
        this.f8113a = bridge == null ? com.bykv.a.a.a.a.b.f7417b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        this.f8113a.call(150105, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        return new h((Bridge) this.f8113a.call(150108, a10.b(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return new d((Bridge) this.f8113a.values().objectValue(150003, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return (View) this.f8113a.values().objectValue(150001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.f8113a.values().intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.f8113a.values().intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.f8113a.values().objectValue(150005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d10, String str, String str2) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(3);
        a10.a(0, d10);
        a10.a(1, str);
        a10.a(2, str2);
        this.f8113a.call(210102, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void registerClickableRects(JSONObject jSONObject) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, jSONObject);
        this.f8113a.call(150115, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f8113a.call(150104, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.a(tTAdInteractionListener));
        this.f8113a.call(210104, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, z10);
        this.f8113a.call(150112, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(2);
        a10.a(0, activity);
        a10.a(1, new com.bytedance.sdk.openadsdk.f.a.a.a.a(dislikeInteractionCallback));
        this.f8113a.call(150106, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, tTDislikeDialogAbstract);
        this.f8113a.call(150107, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.c.a.b.b(tTAppDownloadListener));
        this.f8113a.call(150103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.l.a.a.a.b(expressAdInteractionListener));
        this.f8113a.call(150101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8113a.call(210103, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, i10);
        this.f8113a.call(150110, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.l.a.a.a.c(expressVideoAdListener));
        this.f8113a.call(150111, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, activity);
        this.f8113a.call(150109, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void unRegisterRects() {
        this.f8113a.call(150116, com.bykv.a.a.a.a.b.a(0).b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void uploadDislikeEvent(String str) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, str);
        this.f8113a.call(150114, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d10) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, d10);
        this.f8113a.call(210101, a10.b(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        com.bykv.a.a.a.a.b a10 = com.bykv.a.a.a.a.b.a(1);
        a10.a(0, new com.bytedance.sdk.openadsdk.l.a.a.a.a(adInteractionListener));
        this.f8113a.call(150102, a10.b(), Void.class);
    }
}
